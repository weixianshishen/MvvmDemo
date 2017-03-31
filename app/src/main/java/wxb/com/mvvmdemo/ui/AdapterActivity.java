package wxb.com.mvvmdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import wxb.com.mvvmdemo.R;
import wxb.com.mvvmdemo.databinding.ActivityAdapterBinding;
import wxb.com.mvvmdemo.ui.adapter.UserAdapter;


public class AdapterActivity extends AppCompatActivity {

    public static void newInstance(Context context) {
        context.startActivity(new Intent(context, AdapterActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAdapterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new UserAdapter());

    }
}
