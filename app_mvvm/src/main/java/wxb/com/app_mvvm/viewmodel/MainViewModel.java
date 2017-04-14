package wxb.com.app_mvvm.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import java.util.List;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import wxb.com.app_mvvm.MyApplication;
import wxb.com.app_mvvm.R;
import wxb.com.app_mvvm.model.GitHubService;
import wxb.com.app_mvvm.model.Repository;

/**
 * Created by 黑月 on 2017/4/11.
 */

public class MainViewModel implements ViewModel {

    public static final String TAG = "MainViewModel";

    public ObservableInt infoMessageVisibility;
    public ObservableInt progressVisibility;
    public ObservableInt recyclerViewVisibility;
    public ObservableInt searchButtonVisibility;
    public ObservableField<String> infoMessage;
    private DataListener dataListener;
    String editTextUsernameValue;
    private Context mContext;
    private List<Repository> repositories;
    @Override
    public void destroy() {

    }

    public MainViewModel(Context context, DataListener dataListener) {
        this.mContext = context;
        this.dataListener = dataListener;
        infoMessageVisibility = new ObservableInt(View.VISIBLE);
        progressVisibility = new ObservableInt(View.INVISIBLE);
        recyclerViewVisibility = new ObservableInt(View.INVISIBLE);
        searchButtonVisibility = new ObservableInt(View.GONE);
        infoMessage = new ObservableField<>(context.getString(R.string.default_info_message));

    }

    public void onClickSearch(View view) {
        loadGithubRepos(editTextUsernameValue);
    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            String username = v.getText().toString();
            if (username.length() > 0) loadGithubRepos(username);
            return true;
        }
        return false;
    }

    public TextWatcher getUsernameWatcher() {

        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextUsernameValue = s.toString();
                searchButtonVisibility.set(s.length() > 0 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

    }

    private void loadGithubRepos(String username) {
        progressVisibility.set(View.VISIBLE);
        recyclerViewVisibility.set(View.INVISIBLE);
        infoMessageVisibility.set(View.INVISIBLE);
        MyApplication myApplication = MyApplication.get(mContext);
        GitHubService githubService = myApplication.getGithubService();
        githubService.publicRepositories(username)
                .subscribeOn(myApplication.defaultSubscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Repository>>() {
                    @Override
                    public void onCompleted() {
                        if (dataListener != null) dataListener.onRepositoriesChanged(repositories);
                        progressVisibility.set(View.INVISIBLE);
                        if (!repositories.isEmpty()) {
                            recyclerViewVisibility.set(View.VISIBLE);
                        } else {
                            infoMessage.set(mContext.getString(R.string.text_empty_repos));
                            infoMessageVisibility.set(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onError(Throwable error) {
                        progressVisibility.set(View.INVISIBLE);
                        if (isHttp404(error)) {
                            infoMessage.set(mContext.getString(R.string.error_username_not_found));
                        } else {
                            infoMessage.set(mContext.getString(R.string.error_loading_repos));
                        }
                        infoMessageVisibility.set(View.VISIBLE);
                    }

                    @Override
                    public void onNext(List<Repository> repositories) {
                        MainViewModel.this.repositories = repositories;

                    }
                });

    }

    private static boolean isHttp404(Throwable error) {
        return error instanceof HttpException && ((HttpException) error).code() == 404;
    }

    public interface DataListener {
        void onRepositoriesChanged(List<Repository> repositories);
    }
}
