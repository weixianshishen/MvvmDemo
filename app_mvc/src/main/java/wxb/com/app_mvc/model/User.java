package wxb.com.app_mvc.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {
    public long id;
    public String name;
    public String url;
    public String email;
    public String login;
    public String location;
    @SerializedName("avatar_url")
    public String avatarUrl;

    public User() {
    }

    public boolean hasEmail() {
        return email != null && !email.isEmpty();
    }

    public boolean hasLocation() {
        return location != null && !location.isEmpty();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeString(this.email);
        dest.writeString(this.login);
        dest.writeString(this.location);
        dest.writeString(this.avatarUrl);
    }

    protected User(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.url = in.readString();
        this.email = in.readString();
        this.login = in.readString();
        this.location = in.readString();
        this.avatarUrl = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

}
