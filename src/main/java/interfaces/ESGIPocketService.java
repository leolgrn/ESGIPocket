package interfaces;

import data.dto.*;
import data.model.LoginCredentials;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;

public interface ESGIPocketService {

    // GET Method

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
    @GET("courses")
    Call<ArrayList<ECourse>> getCourses();

    @Headers("Content-Type: application/json")
    @GET("groups")
    Call<ArrayList<EGroup>> getGroups();

    @Headers("Content-Type: application/json")
    @GET("years")
    Call<ArrayList<EYear>> getYears();

    @Headers("Content-Type: application/json")
    @GET("specialities")
    Call<ArrayList<ESpeciality>> getSpecialities();

    @Headers("Content-Type: application/json")
    @GET("topics/{id}/courses")
    Call<ArrayList<ECourse>> getCoursesById(@Path("id") String id);

    // POST Method

    @Headers("Content-Type: application/json")
    @POST("login")
    Call<EAuthentification> postLogIn(@Body LoginCredentials loginCredentials);


}
