package data.mainapi;

import data.dto.EAuthentification;
import data.dto.ETopic;
import data.dto.mapper.AuthentificationMapper;
import data.dto.mapper.TopicListMapper;
import data.model.Authentification;
import data.model.LoginCredentials;
import data.model.Topic;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ESGIPocketProvider {

    private static final String BASE_URL = "https://esgipocket.herokuapp.com/";

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
}