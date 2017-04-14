package wxb.com.app_mvvm;


import android.app.Application;
import android.content.Context;

import rx.Scheduler;
import rx.schedulers.Schedulers;
import wxb.com.app_mvvm.model.GitHubService;

/**
 * Created by 黑月 on 2017/3/31.
 */

public class MyApplication extends Application {
    private GitHubService githubService;
    private Scheduler defaultSubscribeScheduler;

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    public GitHubService getGithubService() {
        if (githubService == null) {
            githubService = GitHubService.Factory.create();
        }
        return githubService;
    }

    //For setting mocks during testing
    public void setGithubService(GitHubService githubService) {
        this.githubService = githubService;
    }

    public Scheduler defaultSubscribeScheduler() {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io();
        }
        return defaultSubscribeScheduler;
    }

    //User to change scheduler from tests
    public void setDefaultSubscribeScheduler(Scheduler scheduler) {
        this.defaultSubscribeScheduler = scheduler;
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
