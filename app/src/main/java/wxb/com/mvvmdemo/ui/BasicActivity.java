package wxb.com.mvvmdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import wxb.com.mvvmdemo.R;
import wxb.com.mvvmdemo.bean.User;
import wxb.com.mvvmdemo.databinding.ActivityBasicBinding;

public class BasicActivity extends AppCompatActivity {

    public static void newInstance(Context context) {
        context.startActivity(new Intent(context, BasicActivity.class));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBasicBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_basic);
        User user = new User("小强", "小明", "小东", 17);
        binding.setUser(user);

    }

}
