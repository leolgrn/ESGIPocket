package data.mainapi;

import data.dto.*;
import data.dto.mapper.*;
import data.model.*;
import data.model.Class;
import data.model.credentials.LoginCredentials;
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

    // private static final String BASE_URL = "https://esgipocket-staging.herokuapp.com/";
    private static final String BASE_URL = "http://127.0.0.1:3000/";

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

    public ESGIPocketService getEsgiPocketService() {
        return esgiPocketService;
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

    // POST methods

    public void postLogIn(LoginCredentials loginCredentials, final ApiListener<Authentification> listener) {
        esgiPocketService
                .postLogIn(loginCredentials)
                .enqueue(new Callback<EAuthentification>() {
            public void onResponse(Call<EAuthentification> call, Response<EAuthentification> response) {
                if(listener != null){
                    if(response.code() == 200){
                        AuthentificationMapper authentificationMapper = new AuthentificationMapper();
                        Authentification authentification = authentificationMapper.map(response.body());
                        listener.onSuccess(authentification);
                    } else if(response.code() == 401){
                        listener.onSuccess(null);
                    }
                }
            }

            public void onFailure(Call<EAuthentification> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    // GET Methods

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

    public void getCoursesById(String id, final ApiListener<ArrayList<Course>> listener){
        esgiPocketService.getCoursesById(id).enqueue(new Callback<ArrayList<ECourse>>() {
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

    public void getCourses(final ApiListener<ArrayList<Course>> listener){
        esgiPocketService.getCourses().enqueue(new Callback<ArrayList<ECourse>>() {
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
                    ClassListMapper classListMapper = new ClassListMapper();
                    ArrayList<Class> classArrayList = classListMapper.map(response.body());
                    listener.onSuccess(classArrayList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EClass>> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void getGroups(final ApiListener<ArrayList<Group>> listener){
        esgiPocketService.getGroups().enqueue(new Callback<ArrayList<EGroup>>() {
            @Override
            public void onResponse(Call<ArrayList<EGroup>> call, Response<ArrayList<EGroup>> response) {
                if(listener != null){
                    GroupListMapper groupListMapper = new GroupListMapper();
                    ArrayList<Group> groupArrayList = groupListMapper.map(response.body());
                    listener.onSuccess(groupArrayList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EGroup>> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void getYears(final ApiListener<ArrayList<Year>> listener){
        esgiPocketService.getYears().enqueue(new Callback<ArrayList<EYear>>() {
            @Override
            public void onResponse(Call<ArrayList<EYear>> call, Response<ArrayList<EYear>> response) {
                if(listener != null){
                    YearListMapper yearListMapper = new YearListMapper();
                    ArrayList<Year> yearArrayList = yearListMapper.map(response.body());
                    listener.onSuccess(yearArrayList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EYear>> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void getSpecialities(final ApiListener<ArrayList<Speciality>> listener){
        esgiPocketService.getSpecialities().enqueue(new Callback<ArrayList<ESpeciality>>() {
            @Override
            public void onResponse(Call<ArrayList<ESpeciality>> call, Response<ArrayList<ESpeciality>> response) {
                if(listener != null){
                    SpecialityListMapper specialityListMapper = new SpecialityListMapper();
                    ArrayList<Speciality> specialityArrayList = specialityListMapper.map(response.body());
                    listener.onSuccess(specialityArrayList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ESpeciality>> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void getQuizzes(final ApiListener<ArrayList<Quiz>> listener){
        esgiPocketService.getQuizzes().enqueue(new Callback<ArrayList<EQuiz>>() {
            @Override
            public void onResponse(Call<ArrayList<EQuiz>> call, Response<ArrayList<EQuiz>> response) {
                if(listener != null){
                    QuizListMapper quizListMapper = new QuizListMapper();
                    ArrayList<Quiz> quizArrayList = quizListMapper.map(response.body());
                    listener.onSuccess(quizArrayList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EQuiz>> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void getQuestions(final ApiListener<ArrayList<Question>> listener){
        esgiPocketService.getQuestions().enqueue(new Callback<ArrayList<EQuestion>>() {
            @Override
            public void onResponse(Call<ArrayList<EQuestion>> call, Response<ArrayList<EQuestion>> response) {
                if(listener != null){
                    QuestionListMapper questionListMapper = new QuestionListMapper();
                    ArrayList<Question> questionArrayList = questionListMapper.map(response.body());
                    listener.onSuccess(questionArrayList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EQuestion>> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void getAnswers(final ApiListener<ArrayList<Answer>> listener){
        esgiPocketService.getAnswers().enqueue(new Callback<ArrayList<EAnswer>>() {
            @Override
            public void onResponse(Call<ArrayList<EAnswer>> call, Response<ArrayList<EAnswer>> response) {
                if(listener != null){
                    AnswerListMapper answerListMapper = new AnswerListMapper();
                    ArrayList<Answer> answerArrayList = answerListMapper.map(response.body());
                    listener.onSuccess(answerArrayList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EAnswer>> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void getCourseStudentByCourseId(String id, final ApiListener<CourseStudent> listener){
        esgiPocketService.getCourseStudentByCourseId(id).enqueue(new Callback<ECourseStudent>() {
            @Override
            public void onResponse(Call<ECourseStudent> call, Response<ECourseStudent> response) {
                if(listener != null) {
                    if (response.body() == null){
                        listener.onSuccess(null);
                    } else {
                        CourseStudentMapper courseStudentMapper = new CourseStudentMapper();
                        CourseStudent courseStudent = courseStudentMapper.map(response.body());
                        listener.onSuccess(courseStudent);
                    }
                }
            }

            @Override
            public void onFailure(Call<ECourseStudent> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void getCourseLikedByUser(final ApiListener<ArrayList<Course>> listener){
        esgiPocketService.getCourseLikedByUser().enqueue(new Callback<ArrayList<ECourseStudent>>() {
            @Override
            public void onResponse(Call<ArrayList<ECourseStudent>> call, Response<ArrayList<ECourseStudent>> response) {
                if(listener != null){
                    ArrayList<Course> courseArrayList = new ArrayList<>();
                    CourseStudentListMapper courseStudentListMapper = new CourseStudentListMapper();
                    ArrayList<CourseStudent> courseStudentArrayList = courseStudentListMapper.map(response.body());
                    for (CourseStudent courseStudent: courseStudentArrayList){
                        Course course = courseStudent.getCourse();
                        courseArrayList.add(course);
                    }
                    listener.onSuccess(courseArrayList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ECourseStudent>> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void getCourseUserContribution(String id, final ApiListener<Integer> listener){
        esgiPocketService.getCourseUserContribution(id).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if(listener != null){
                    listener.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void getQuizUserContribution(String id, final ApiListener<Integer> listener){
        esgiPocketService.getQuizUserContribution(id).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if(listener != null){
                    listener.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void getNextCourse(final ApiListener<NextCourse> listener){
        esgiPocketService.getNextCourse().enqueue(new Callback<ENextCourse>() {
            @Override
            public void onResponse(Call<ENextCourse> call, Response<ENextCourse> response) {
                if(listener != null){
                    System.out.println();
                    if(response.body() == null){
                        listener.onSuccess(null);
                    } else {
                        NextCourseMapper nextCourseMapper = new NextCourseMapper();
                        NextCourse nextCourse = nextCourseMapper.map(response.body());
                        listener.onSuccess(nextCourse);
                    }
                }
            }

            @Override
            public void onFailure(Call<ENextCourse> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }

    public void getSignedFile(String fileName, String fileType, final ApiListener<SignedFile> listener) {
        esgiPocketService.getSignedFile(fileName, fileType).enqueue(new Callback<ESignedFile>() {
            @Override
            public void onResponse(Call<ESignedFile> call, Response<ESignedFile> response) {
                if (listener != null) {
                    SignedFileMapper signedFileMapper = new SignedFileMapper();
                    SignedFile signedFile = signedFileMapper.map(response.body());
                    listener.onSuccess(signedFile);
                }
            }

            @Override
            public void onFailure(Call<ESignedFile> call, Throwable throwable) {
                if (listener != null) listener.onError(throwable);
            }
        });
    }
}