package interfaces;

import data.dto.EAuthentification;
import data.dto.ECourse;
import data.dto.ETopic;
import data.dto.EUser;
import data.model.LoginCredentials;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.ArrayList;
import java.util.List;

public interface ESGIPocketService {

    @POST("login")
    Call<EAuthentification> postLogIn(@Body LoginCredentials loginCredentials);

    @GET("users")
    Call<ArrayList<EUser>> getUsers();

    @GET("topics")
    Call<ArrayList<ETopic>> getTopics();

    @GET("topics/{id}/courses")
    Call<ArrayList<ECourse>> getCourses(@Path("id") String id);
}
