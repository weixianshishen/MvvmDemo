package wxb.com.app_mvp.presenter;

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

}
