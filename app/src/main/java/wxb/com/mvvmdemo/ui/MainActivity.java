package wxb.com.mvvmdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import wxb.com.mvvmdemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openBasic(View view) {
        BasicActivity.newInstance(this);
    }

    public void openCollection(View view) {
        CollectionActivity.newInstance(this);
    }

    public void openAdapter(View view) {
        AdapterActivity.newInstance(this);
    }

    public void openInclude(View view) {
        IncludeActivity.newInstance(this);
    }

    public void openObservable(View view) {
        ObservableActivity.newInstance(this);
    }

    public void openViewStub(View view) {
        ViewStubActivity.newInstance(this);
    }

}
