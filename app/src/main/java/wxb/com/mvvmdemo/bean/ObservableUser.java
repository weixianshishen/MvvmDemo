package wxb.com.mvvmdemo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import wxb.com.mvvmdemo.BR;

/**
 * Created by 黑月 on 2017/3/30.
 */

public class ObservableUser extends BaseObservable {
    private String firstName;
    private String lastName;

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.firstName);
    }
}
