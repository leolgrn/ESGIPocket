package interfaces;

import data.dto.*;
import data.model.LoginCredentials;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;

public interface ESGIPocketService {


    @Headers("Content-Type: application/json")
    @POST("login")
    Call<EAuthentification> postLogIn(@Body LoginCredentials loginCredentials);

    @Headers("Content-Type: application/json")
    @GET("users")
    Call<ArrayList<EUser>> getUsers();

    @Headers("Content-Type: application/json")
    @GET("topics")
    Call<ArrayList<ETopic>> getTopics();

    @Headers("Content-Type: application/json")
    @GET("classes")
    Call<ArrayList<EClass>> getClasses();

    @Headers("Content-Type: application/json")
    @GET("topics/{id}/courses")
    Call<ArrayList<ECourse>> getCourses(@Path("id") String id);
}
