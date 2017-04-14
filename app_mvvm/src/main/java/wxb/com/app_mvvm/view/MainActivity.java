package wxb.com.app_mvvm.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.inputmethod.InputMethodManager;

import java.util.List;

import wxb.com.app_mvvm.R;
import wxb.com.app_mvvm.RepositoryAdapter;
import wxb.com.app_mvvm.databinding.ActivityMainBinding;
import wxb.com.app_mvvm.model.Repository;
import wxb.com.app_mvvm.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity implements MainViewModel.DataListener {

    private ActivityMainBinding mBinding;
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainViewModel = new MainViewModel(this,this);
        mBinding.setViewModel(mMainViewModel);
        setSupportActionBar(mBinding.toolbar);
        setUpRecyclerView(mBinding.reposRecyclerView);

    }

    private void setUpRecyclerView(RecyclerView reposRecyclerView) {
        RepositoryAdapter adapter = new RepositoryAdapter();
        reposRecyclerView.setAdapter(adapter);
        reposRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onRepositoriesChanged(List<Repository> repositories) {
        RepositoryAdapter adapter =
                (RepositoryAdapter) mBinding.reposRecyclerView.getAdapter();
        adapter.setRepositories(repositories);
        adapter.notifyDataSetChanged();
        hideSoftKeyboard();
    }
    private void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mBinding.editTextUsername.getWindowToken(), 0);
    }

}
