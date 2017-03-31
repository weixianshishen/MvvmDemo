package wxb.com.mvvmdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import wxb.com.mvvmdemo.R;
import wxb.com.mvvmdemo.databinding.ActivityCollectionBinding;

public class CollectionActivity extends AppCompatActivity {

    public static void newInstance(Context context) {
        context.startActivity(new Intent(context, CollectionActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollectionBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_collection);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add("AAA" + i);
        }
        String key = "a";
        int index = 0;
        Map<String, String> map = new HashMap<>();
        map.put("a", "AAA");
        map.put("b", "BBB");
        binding.setKey(key);
        binding.setIndex(index);
        binding.setList(list);
        binding.setMap(map);

    }
}
