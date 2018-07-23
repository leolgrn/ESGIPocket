package data.fileuploader;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.event.ProgressEventType;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;
import data.mainapi.post.ESGIPocketProviderPost;
import data.model.Authentification;
import data.model.Course;
import data.model.User;
import data.model.credentials.CourseCredentials;
import interfaces.ApiListener;


import java.io.File;


public class FileUpload {

    private static final String BUCKET_NAME = "esgipocket";
    private static final String BUCKET_ADDRESS = "https://s3.eu-west-3.amazonaws.com/esgipocket/";

    public boolean findFile(String fileName) {
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        try {
            return s3.doesObjectExist(BUCKET_NAME, fileName);
        }
        catch (AmazonServiceException e) {
            return false;
        }
    }

    public void upload(String filePath, String fileName, String fileFullName, String topicId) {
        File f = new File(filePath);
        if (f != null) {

            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_WEST_3).build();
            TransferManager xfer_mgr = TransferManagerBuilder.standard().withS3Client(s3Client).build();

            try {

                Upload xfer = xfer_mgr.upload(BUCKET_NAME,  Authentification.getInstance().getUser().getId() + "/" + fileFullName, f);
                xfer.addProgressListener((ProgressListener) progressEvent -> {
                    if (progressEvent.getEventType() == ProgressEventType.TRANSFER_COMPLETED_EVENT) {
                        addFileToDatabase(fileName, fileFullName, topicId);
                    }
                    else if (progressEvent.getEventType() == ProgressEventType.TRANSFER_FAILED_EVENT) {
                        return;
                    }
                });
            } catch (AmazonServiceException e) {
                e.printStackTrace();
            } catch (SdkClientException e) {
                e.printStackTrace();
            }

        }

    }

    public void addFileToDatabase(String fileName, String fileFullName, String topicId) {
        User currentUser = Authentification.getInstance().getUser();
        CourseCredentials courseCredentials = new CourseCredentials(fileName, topicId, false, null, BUCKET_ADDRESS + currentUser.getId() + "/" + fileFullName, currentUser.getClasse().getId(), currentUser.getId());

        ESGIPocketProviderPost esgiPocketProviderPost = new ESGIPocketProviderPost(Authentification.getInstance().getToken());
        esgiPocketProviderPost.postCourse(courseCredentials, new ApiListener<Course>() {
            @Override
            public void onSuccess(Course response) {
                return;
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
