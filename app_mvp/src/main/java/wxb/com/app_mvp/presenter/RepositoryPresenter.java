package wxb.com.app_mvp.presenter;

import android.util.Log;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import wxb.com.app_mvp.MyApplication;
import wxb.com.app_mvp.bean.User;
import wxb.com.app_mvp.model.GitHubService;
import wxb.com.app_mvp.view.RepositoryMvpView;


public class RepositoryPresenter implements Presenter<RepositoryMvpView> {

    private static final String TAG = "RepositoryPresenter";

    private RepositoryMvpView repositoryMvpView;
    private Subscription subscription;

    @Override
    public void attachView(RepositoryMvpView view) {
        this.repositoryMvpView = view;
    }

    @Override
    public void detachView() {
        this.repositoryMvpView = null;
        if (subscription != null) subscription.unsubscribe();
    }

    public void loadOwner(String userUrl) {
        MyApplication application = MyApplication.get(repositoryMvpView.getContext());
        GitHubService githubService = application.getGithubService();
        subscription = githubService.userFromUrl(userUrl)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(application.defaultSubscribeScheduler())
                .subscribe(new Action1<User>() {
                    @Override
                    public void call(User user) {
                        Log.i(TAG, "Full user data loaded " + user);
                        repositoryMvpView.showOwner(user);
                    }
                });
    }
}
