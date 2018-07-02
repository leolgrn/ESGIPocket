package data.mainapi;

import data.dto.EAuthentification;
import data.dto.ETopic;
import data.model.LoginCredentials;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.ArrayList;
import java.util.List;

public interface ESGIPocketService {

    @POST("login")
    Call<EAuthentification> postLogIn(@Body LoginCredentials loginCredentials);

    @GET("topics")
    Call<ArrayList<ETopic>> getTopics();
}
