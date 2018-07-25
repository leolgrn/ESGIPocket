package interfaces;

import data.dto.*;
import data.model.credentials.*;
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
    @GET("quizzes")
    Call<ArrayList<EQuiz>> getQuizzes();

    @Headers("Content-Type: application/json")
    @GET("questions")
    Call<ArrayList<EQuestion>> getQuestions();

    @Headers("Content-Type: application/json")
    @GET("answers")
    Call<ArrayList<EAnswer>> getAnswers();

    @Headers("Content-Type: application/json")
    @GET("topics/{id}/courses")
    Call<ArrayList<ECourse>> getCoursesById(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @GET("coursesStudent/{id}/courses")
    Call<ECourseStudent> getCourseStudentByCourseId(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @GET("coursesStudent/likedByUser")
    Call<ArrayList<ECourseStudent>> getCourseLikedByUser();

    @Headers("Content-Type: application/json")
    @GET("courses/{id}/userContribution")
    Call<Integer> getCourseUserContribution(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @GET("quizzes/{id}/userContribution")
    Call<Integer> getQuizUserContribution(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @GET("plannings//mine/next-course")
    Call<ENextCourse> getNextCourse();

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
    @POST("classes")
    Call<EClass> postClass(@Body ClassCredentials classCredentials);

    @Headers("Content-Type: application/json")
    @POST("courses")
    Call<ECourse> postCourse(@Body CourseCredentials courseCredentials);

    @Headers("Content-Type: application/json")
    @POST("quizzes")
    Call<EQuiz> postQuiz(@Body QuizCredentials quizCredentials);

    @Headers("Content-Type: application/json")
    @POST("questions")
    Call<EQuestion> postQuestion(@Body String question);

    @Headers("Content-Type: application/json")
    @POST("answers")
    Call<EAnswer> postAnswer(@Body AnswerCredentials answerCredentials);

    @Headers("Content-Type: application/json")
    @POST("coursesStudent")
    Call<ECourseStudent> postCourseStudent(@Body CourseStudentCredentials courseStudentCredentials);

    // PUT Methods

    @Headers("Content-Type: application/json")
    @PUT("users/{id}")
    Call<EUser> updateUser(@Body UserCredentials userCredentials, @Path("id") String id);

    @Headers("Content-Type: application/json")
    @PUT("courses/{id}")
    Call<ECourse> updateCourse(@Body CourseCredentials courseCredentials, @Path("id") String id);

    @Headers("Content-Type: application/json")
    @PUT("years/{id}")
    Call<EYear> updateYear(@Body TwoFieldsCredentials twoFieldsCredentials, @Path("id") String id);

    @Headers("Content-Type: application/json")
    @PUT("specialities/{id}")
    Call<ESpeciality> updateSpeciality(@Body TwoFieldsCredentials twoFieldsCredentials, @Path("id") String id);

    @Headers("Content-Type: application/json")
    @PUT("groups/{id}")
    Call<EGroup> updateGroup(@Body GroupCredentials groupCredentials, @Path("id") String id);

    @Headers("Content-Type: application/json")
    @PUT("topics/{id}")
    Call<ETopic> updateTopic(@Body TopicCredentials topicCredentials, @Path("id") String id);

    @Headers("Content-Type: application/json")
    @PUT("classes/{id}")
    Call<EClass> updateClass(@Body ClassCredentials classCredentials, @Path("id") String id);

    @Headers("Content-Type: application/json")
    @PUT("quizzes/{id}")
    Call<EQuiz> updateQuiz(@Body QuizCredentials quizCredentials, @Path("id") String id);

    @Headers("Content-Type: application/json")
    @PUT("questions/{id}")
    Call<EQuestion> updateQuestion(@Body String question, @Path("id") String id);

    @Headers("Content-Type: application/json")
    @PUT("answers/{id}")
    Call<EAnswer> updateAnswer(@Body AnswerCredentials answerCredentials, @Path("id") String id);

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

    @Headers("Content-Type: application/json")
    @DELETE("quizzes/{id}")
    Call<Void> deleteQuiz(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @DELETE("questions/{id}")
    Call<Void> deleteQuestion(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @DELETE("answers/{id}")
    Call<Void> deleteAnswer(@Path("id") String id);

    @GET("courses/signFile/{fileName}/{fileType}")
    Call<ESignedFile> getSignedFile(@Path("fileName") String fileName, @Path("fileType") String fileType);
}
