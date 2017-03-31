package wxb.com.mvvmdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import wxb.com.mvvmdemo.R;
import wxb.com.mvvmdemo.bean.User;
import wxb.com.mvvmdemo.databinding.ActivityIncludeBinding;
import wxb.com.mvvmdemo.ui.adapter.OnClickListener;

public class IncludeActivity extends AppCompatActivity implements OnClickListener{

    public static void newInstance(Context context) {
        context.startActivity(new Intent(context, IncludeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityIncludeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_include);

        binding.setOkStr("点击");
        binding.setListener(this);
        binding.etInput.etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                User user = new User(charSequence+"AA","AA","AA",1);
                    binding.setUser(user);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }




    @Override
    public void OnClick(View view) {
        Toast.makeText(IncludeActivity.this, "点击了", Toast.LENGTH_SHORT).show();
    }
}
