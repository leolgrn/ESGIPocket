package data.mainapi.post;

import data.dto.*;
import data.dto.mapper.*;
import data.mainapi.ESGIPocketProvider;
import data.model.*;
import data.model.Class;
import data.model.credentials.ClassCredentials;
import data.model.credentials.TopicCredentials;
import data.model.credentials.TwoFieldsCredentials;
import interfaces.ApiListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ESGIPocketProviderPost extends ESGIPocketProvider {

    public ESGIPocketProviderPost(String token) {
        super(token);
    }

    public void postYear(TwoFieldsCredentials twoFieldsCredentials, final ApiListener<Year> listener){
        getEsgiPocketService().postYear(twoFieldsCredentials).enqueue(new Callback<EYear>() {
            @Override
            public void onResponse(Call<EYear> call, Response<EYear> response) {
                if(listener != null){
                    System.out.println(response.toString());
                    YearMapper yearMapper = new YearMapper();
                    Year year = yearMapper.map(response.body());
                    listener.onSuccess(year);
                }
            }

            @Override
            public void onFailure(Call<EYear> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void postSpeciality(TwoFieldsCredentials twoFieldsCredentials, final ApiListener<Speciality> listener){
        getEsgiPocketService().postSpeciality(twoFieldsCredentials).enqueue(new Callback<ESpeciality>() {
            @Override
            public void onResponse(Call<ESpeciality> call, Response<ESpeciality> response) {
                if(listener != null){
                    SpecialityMapper specialityMapper = new SpecialityMapper();
                    Speciality speciality = specialityMapper.map(response.body());
                    listener.onSuccess(speciality);
                }
            }

            @Override
            public void onFailure(Call<ESpeciality> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void postGroup(TwoFieldsCredentials twoFieldsCredentials, final ApiListener<Group> listener){
        getEsgiPocketService().postGroup(twoFieldsCredentials).enqueue(new Callback<EGroup>() {
            @Override
            public void onResponse(Call<EGroup> call, Response<EGroup> response) {
                if(listener != null){
                    GroupMapper groupMapper = new GroupMapper();
                    Group group = groupMapper.map(response.body());
                    listener.onSuccess(group);
                }
            }

            @Override
            public void onFailure(Call<EGroup> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void postClass(ClassCredentials classCredentials, final ApiListener<Class> listener){
        getEsgiPocketService().postClass(classCredentials).enqueue(new Callback<EClass>() {
            @Override
            public void onResponse(Call<EClass> call, Response<EClass> response) {
                if(listener != null){
                    System.out.println(response.toString());
                    ClassMapper classMapper = new ClassMapper();
                    Class classe = classMapper.map(response.body());
                    listener.onSuccess(classe);
                }
            }

            @Override
            public void onFailure(Call<EClass> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void postTopic(TopicCredentials topicCredentials, final ApiListener<Topic> listener){
        getEsgiPocketService().postTopic(topicCredentials).enqueue(new Callback<ETopic>() {
            @Override
            public void onResponse(Call<ETopic> call, Response<ETopic> response) {
                if(listener != null){
                    TopicMapper topicMapper = new TopicMapper();
                    Topic topic = topicMapper.map(response.body());
                    listener.onSuccess(topic);
                }
            }

            @Override
            public void onFailure(Call<ETopic> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }
}
