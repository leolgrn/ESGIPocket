package data.fileuploader;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressEventType;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

import java.io.File;


public class FileUpload {

    private static final String BUCKET_NAME = "BUCKET  NAME";
    private static final String KEY_NAME = "BUCKET  NAME";

    public void upload(String filePath) {
        File f = new File(filePath);
        TransferManager xfer_mgr = TransferManagerBuilder.standard().build();
        try {
            Upload xfer = xfer_mgr.upload(BUCKET_NAME, KEY_NAME, f);
            xfer.addProgressListener((ProgressListener) progressEvent -> {
                if (progressEvent.getEventType() == ProgressEventType.TRANSFER_COMPLETED_EVENT) {

                }
            });
            XferMgrProgress.showTransferProgress(xfer);
            XferMgrProgress.waitForCompletion(xfer);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }
}
