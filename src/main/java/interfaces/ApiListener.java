package interfaces;

public interface ApiListener<T> {
    void onSuccess(T response);

    void onError(Throwable throwable);
}
