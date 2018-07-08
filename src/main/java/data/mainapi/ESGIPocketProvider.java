package data.mainapi;

import data.dto.*;
import data.dto.mapper.*;
import data.model.*;
import data.model.Class;
import interfaces.ApiListener;
import interfaces.ESGIPocketService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;

public class ESGIPocketProvider {

    private static final String BASE_URL = "https://esgipocket-staging.herokuapp.com/";

    private ESGIPocketService esgiPocketService;

    public ESGIPocketProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient(null))
                .build();
        esgiPocketService = retrofit.create(ESGIPocketService.class);
    }

    public ESGIPocketProvider(String token) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient(token))
                .build();
        esgiPocketService = retrofit.create(ESGIPocketService.class);
    }

    private OkHttpClient createOkHttpClient(final String token) {
        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
                if(token != null){
                    okBuilder.addInterceptor(new Interceptor() {
                            public okhttp3.Response intercept(Chain chain) throws IOException {
                                Request.Builder ongoing = chain.request().newBuilder();
                                ongoing.addHeader("Authorization", token);
                                return chain.proceed(ongoing.build());
                    }});
                }
        return okBuilder.build();
    }

    public void postLogIn(LoginCredentials loginCredentials, final ApiListener<Authentification> listener) {
        esgiPocketService
                .postLogIn(loginCredentials)
                .enqueue(new Callback<EAuthentification>() {
            public void onResponse(Call<EAuthentification> call, Response<EAuthentification> response) {
                if(listener != null){
                    // Authentication Singleton creation
                    System.out.println(response);
                    AuthentificationMapper authentificationMapper = new AuthentificationMapper();
                    Authentification authentification = authentificationMapper.map(response.body());
                    listener.onSuccess(authentification);
                }
            }

            public void onFailure(Call<EAuthentification> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void getUsers(final ApiListener<ArrayList<User>> listener){
        esgiPocketService.getUsers().enqueue(new Callback<ArrayList<EUser>>() {
            @Override
            public void onResponse(Call<ArrayList<EUser>> call, Response<ArrayList<EUser>> response) {
                if(listener != null){
                    UserListMapper userListMapper = new UserListMapper();
                    ArrayList<User> userArrayList = userListMapper.map(response.body());
                    listener.onSuccess(userArrayList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EUser>> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }


    public void getTopics(final ApiListener<ArrayList<Topic>> listener){
       esgiPocketService.getTopics().enqueue(new Callback<ArrayList<ETopic>>() {
           @Override
           public void onResponse(Call<ArrayList<ETopic>> call, Response<ArrayList<ETopic>> response) {
                if(listener != null){
                    TopicListMapper topicListMapper = new TopicListMapper();
                    ArrayList<Topic> topicArrayList = topicListMapper.map(response.body());
                    listener.onSuccess(topicArrayList);
                }
           }

           @Override
           public void onFailure(Call<ArrayList<ETopic>> call, Throwable throwable) {
               if (listener != null) listener.onError(throwable);
           }
       });
    }

    public void getCourses(String id, final ApiListener<ArrayList<Course>> listener){
        esgiPocketService.getCourses(id).enqueue(new Callback<ArrayList<ECourse>>() {
            @Override
            public void onResponse(Call<ArrayList<ECourse>> call, Response<ArrayList<ECourse>> response) {
                if(listener != null){
                    CourseListMapper courseListMapper = new CourseListMapper();
                    ArrayList<Course> courseArrayList = courseListMapper.map(response.body());
                    listener.onSuccess(courseArrayList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ECourse>> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });

    }

    public void getClasses(final ApiListener<ArrayList<Class>> listener){
        esgiPocketService.getClasses().enqueue(new Callback<ArrayList<EClass>>() {
            @Override
            public void onResponse(Call<ArrayList<EClass>> call, Response<ArrayList<EClass>> response) {
                if(listener != null){
                    System.out.println(response);
                    ClassListMapper classListMapper = new ClassListMapper();
                    ArrayList<Class> classArrayList = classListMapper.map(response.body());
                    listener.onSuccess(classArrayList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EClass>> call, Throwable throwable) {
                    throwable.printStackTrace();
            }
        });
    }
}