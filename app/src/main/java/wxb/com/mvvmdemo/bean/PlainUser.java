package wxb.com.mvvmdemo.bean;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by 黑月 on 2017/3/30.
 */

public class PlainUser {
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
}
