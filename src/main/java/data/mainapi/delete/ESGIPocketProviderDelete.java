package data.mainapi.delete;

import data.mainapi.ESGIPocketProvider;
import interfaces.ApiListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ESGIPocketProviderDelete extends ESGIPocketProvider {

    public ESGIPocketProviderDelete(String token) {
        super(token);
    }

    public void deleteYear(String id, final ApiListener<String> listener){
        getEsgiPocketService().deleteYear(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(listener != null){ listener.onSuccess("item deleted");}
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void deleteUser(String id, final ApiListener<String> listener){
        getEsgiPocketService().deleteUser(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(listener != null){ listener.onSuccess("item deleted");}
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void deleteTopic(String id, final ApiListener<String> listener){
        getEsgiPocketService().deleteTopic(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(listener != null){ listener.onSuccess("item deleted");}
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void deleteSpeciality(String id, final ApiListener<String> listener){
        getEsgiPocketService().deleteSpeciality(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(listener != null){ listener.onSuccess("item deleted");}
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void deleteGroup(String id, final ApiListener<String> listener){
        getEsgiPocketService().deleteGroup(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(listener != null){ listener.onSuccess("item deleted");}
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void deleteCourse(String id, final ApiListener<String> listener){
        getEsgiPocketService().deleteCourse(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(listener != null){ listener.onSuccess("item deleted");}
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void deleteClass(String id, final ApiListener<String> listener){
        getEsgiPocketService().deleteClass(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(listener != null){ listener.onSuccess("item deleted");}
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void deleteQuiz(String id, final ApiListener<String> listener){
        getEsgiPocketService().deleteQuiz(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(listener != null){ listener.onSuccess("item deleted");}
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void deleteQuestion(String id, final ApiListener<String> listener){
        getEsgiPocketService().deleteQuestion(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(listener != null){ listener.onSuccess("item deleted");}
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void deleteAnswer(String id, final ApiListener<String> listener){
        getEsgiPocketService().deleteAnswer(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(listener != null){ listener.onSuccess("item deleted");}
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }
}
