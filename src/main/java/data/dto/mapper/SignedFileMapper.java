package data.dto.mapper;

import data.dto.ESignedFile;
import data.model.SignedFile;

public class SignedFileMapper {

    public SignedFile map(ESignedFile eSignedFile) {
        SignedFile signedFile = new SignedFile();
        signedFile.setSignedRequest(eSignedFile.getSignedRequest());
        signedFile.setUrl(eSignedFile.getUrl());
        return signedFile;

    }
}
