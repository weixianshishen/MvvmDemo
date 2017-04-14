package wxb.com.mvvmdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import wxb.com.mvvmdemo.R;
import wxb.com.mvvmdemo.bean.ObservableUser;
import wxb.com.mvvmdemo.bean.PlainUser;
import wxb.com.mvvmdemo.databinding.ActivityObservableBinding;

public class ObservableActivity extends AppCompatActivity {

    public static void newInstance(Context context) {
        context.startActivity(new Intent(context, ObservableActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityObservableBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_observable);
        ObservableUser observableUser = new ObservableUser();
        observableUser.setFirstName("AAAAAAA");
        observableUser.setLastName("ZZZZZZZZZZZ");
        binding.setObserUser(observableUser);

        PlainUser plainUser = new PlainUser();
        plainUser.age.set(11);
        plainUser.lastName.set("AAAA");
        plainUser.firstName.set("BBBB");
        binding.setPlainUser(plainUser);


        ObservableArrayMap userMap = new ObservableArrayMap();
        userMap.put("firstName", "6666");
        userMap.put("lastName", "8888");
        binding.setUserMap(userMap);


    }
}
