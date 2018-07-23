package data.mainapi.put;

import data.dto.*;
import data.dto.mapper.*;
import data.mainapi.ESGIPocketProvider;
import data.model.*;
import data.model.Class;
import data.model.credentials.*;
import interfaces.ApiListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ESGIPocketProviderPut extends ESGIPocketProvider {

    public ESGIPocketProviderPut(String token) {
        super(token);
    }

    public void updateUser(UserCredentials userCredentials, String id, final ApiListener<User> listener){
        getEsgiPocketService().updateUser(userCredentials, id).enqueue(new Callback<EUser>() {
            @Override
            public void onResponse(Call<EUser> call, Response<EUser> response) {
                if(listener != null){
                    UserMapper userMapper = new UserMapper();
                    User user = userMapper.map(response.body());
                    listener.onSuccess(user);
                }
            }

            @Override
            public void onFailure(Call<EUser> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void updateCourse(CourseCredentials courseCredentials, String id, final ApiListener<Course> listener){
        getEsgiPocketService().updateCourse(courseCredentials, id).enqueue(new Callback<ECourse>() {
            @Override
            public void onResponse(Call<ECourse> call, Response<ECourse> response) {
                if(listener != null){
                    CourseMapper courseMapper = new CourseMapper();
                    Course course = courseMapper.map(response.body());
                    listener.onSuccess(course);
                }
            }

            @Override
            public void onFailure(Call<ECourse> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void updateClass(ClassCredentials classCredentials, String id, final ApiListener<Class> listener){
        getEsgiPocketService().updateClass(classCredentials, id).enqueue(new Callback<EClass>() {
            @Override
            public void onResponse(Call<EClass> call, Response<EClass> response) {
                if(listener != null){
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

    public void updateTopic(TopicCredentials topicCredentials, String id, final ApiListener<Topic> listener){
        getEsgiPocketService().updateTopic(topicCredentials, id).enqueue(new Callback<ETopic>() {
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

    public void updateYear(TwoFieldsCredentials twoFieldsCredentials, String id, final ApiListener<Year> listener){
        getEsgiPocketService().updateYear(twoFieldsCredentials, id).enqueue(new Callback<EYear>() {
            @Override
            public void onResponse(Call<EYear> call, Response<EYear> response) {
                if(listener != null){
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

    public void updateGroup(GroupCredentials groupCredentials, String id, final ApiListener<Group> listener){
        getEsgiPocketService().updateGroup(groupCredentials, id).enqueue(new Callback<EGroup>() {
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

    public void updateSpeciality(TwoFieldsCredentials twoFieldsCredentials, String id, final ApiListener<Speciality> listener){
        getEsgiPocketService().updateSpeciality(twoFieldsCredentials, id).enqueue(new Callback<ESpeciality>() {
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

    public void updateQuiz(QuizCredentials quizCredentials, String id, final ApiListener<Quiz> listener){
        getEsgiPocketService().updateQuiz(quizCredentials, id).enqueue(new Callback<EQuiz>() {
            @Override
            public void onResponse(Call<EQuiz> call, Response<EQuiz> response) {
                if(listener != null){
                    QuizzMapper quizMapper = new QuizzMapper();
                    Quiz quiz = quizMapper.map(response.body());
                    listener.onSuccess(quiz);
                }
            }

            @Override
            public void onFailure(Call<EQuiz> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void updateQuestion(QuestionCredentials questionCredentials, String id, final ApiListener<Question> listener){
        getEsgiPocketService().updateQuestion(questionCredentials, id).enqueue(new Callback<EQuestion>() {
            @Override
            public void onResponse(Call<EQuestion> call, Response<EQuestion> response) {
                if(listener != null){
                    QuestionMapper questionMapper = new QuestionMapper();
                    Question question = questionMapper.map(response.body());
                    listener.onSuccess(question);
                }
            }

            @Override
            public void onFailure(Call<EQuestion> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void updateAnswer(AnswerCredentials answerCredentials, String id, final ApiListener<Answer> listener){
        getEsgiPocketService().updateAnswer(answerCredentials, id).enqueue(new Callback<EAnswer>() {
            @Override
            public void onResponse(Call<EAnswer> call, Response<EAnswer> response) {
                if(listener != null){
                    AnswerMapper answerMapper = new AnswerMapper();
                    Answer answer = answerMapper.map(response.body());
                    listener.onSuccess(answer);
                }
            }

            @Override
            public void onFailure(Call<EAnswer> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }
}
