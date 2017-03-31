package wxb.com.mvvmdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;

import wxb.com.mvvmdemo.R;
import wxb.com.mvvmdemo.bean.User;
import wxb.com.mvvmdemo.databinding.ActivityViewStubBinding;
import wxb.com.mvvmdemo.databinding.ItemUserBinding;

public class ViewStubActivity extends AppCompatActivity {


    private ActivityViewStubBinding mBinding;

    public static void newInstance(Context context) {
        context.startActivity(new Intent(context, ViewStubActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_stub);
        mBinding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub viewStub, View view) {
                ItemUserBinding bind = DataBindingUtil.bind(view);
                User user = new User("AA", "BB", "VV", 123);
                bind.setUser(user);

            }
        });
    }

    public void inflateViewStub(View view) {
        if (!mBinding.viewStub.isInflated()) {
            mBinding.viewStub.getViewStub().inflate();
        }
    }

}
