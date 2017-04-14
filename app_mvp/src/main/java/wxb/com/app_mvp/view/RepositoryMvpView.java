package wxb.com.app_mvp.view;


import wxb.com.app_mvp.bean.User;

public interface RepositoryMvpView extends MvpView {

    void showOwner(final User owner);

}
