package interfaces;

import data.dto.*;
import data.model.credentials.ClassCredentials;
import data.model.credentials.LoginCredentials;
import data.model.credentials.TopicCredentials;
import data.model.credentials.TwoFieldsCredentials;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;

public interface ESGIPocketService {

    // GET Methods

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

    // POST Methods

    @Headers("Content-Type: application/json")
    @POST("login")
    Call<EAuthentification> postLogIn(@Body LoginCredentials loginCredentials);

    @Headers("Content-Type: application/json")
    @POST("years")
    Call<EYear> postYear(@Body TwoFieldsCredentials twoFieldsCredentials);

    @Headers("Content-Type: application/json")
    @POST("specialities")
    Call<ESpeciality> postSpeciality(@Body TwoFieldsCredentials twoFieldsCredentials);

    @Headers("Content-Type: application/json")
    @POST("groups")
    Call<EGroup> postGroup(@Body TwoFieldsCredentials twoFieldsCredentials);

    @Headers("Content-Type: application/json")
    @POST("topics")
    Call<ETopic> postTopic(@Body TopicCredentials topicCredentials);

    @Headers("Content-Type: application/json")
    @POST("topics")
    Call<EClass> postClass(@Body ClassCredentials classCredentials);

    // DELETE Methods

    @Headers("Content-Type: application/json")
    @DELETE("users/{id}")
    Call<Void> deleteUser(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @DELETE("topics/{id}")
    Call<Void> deleteTopic(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @DELETE("classes/{id}")
    Call<Void> deleteClass(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @DELETE("courses/{id}")
    Call<Void> deleteCourse(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @DELETE("groups/{id}")
    Call<Void> deleteGroup(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @DELETE("years/{id}")
    Call<Void> deleteYear(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @DELETE("specialities/{id}")
    Call<Void> deleteSpeciality(@Path("id") String id);


}
