package data.dto;

import com.google.gson.annotations.SerializedName;

public class ESignedFile {

    @SerializedName("signedRequest") private String signedRequest;
    @SerializedName("url") private String url;

    public String getSignedRequest() {
        return signedRequest;
    }

    public void setSignedRequest(String signedRequest) {
        this.signedRequest = signedRequest;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
