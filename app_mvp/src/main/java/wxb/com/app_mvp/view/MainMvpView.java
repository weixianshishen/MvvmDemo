package wxb.com.app_mvp.view;

import java.util.List;

import wxb.com.app_mvp.bean.Repository;


public interface MainMvpView extends MvpView {

    void showRepositories(List<Repository> repositories);

    void showMessage(int stringId);

    void showProgressIndicator();
}
