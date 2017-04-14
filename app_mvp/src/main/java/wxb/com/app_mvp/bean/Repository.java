package wxb.com.app_mvp.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Repository implements Parcelable {
    public long id;
    public String name;
    public String description;
    public int forks;
    public int watchers;
    @SerializedName("stargazers_count")
    public int stars;
    public String language;
    public String homepage;
    public User owner;
    public boolean fork;

    public boolean hasHomepage() {
        return homepage != null && !homepage.isEmpty();
    }

    public boolean hasLanguage() {
        return language != null && !language.isEmpty();
    }

    public boolean isFork() {
        return fork;
    }

    protected Repository(Parcel in) {
        id = in.readLong();
        name = in.readString();
        description = in.readString();
        forks = in.readInt();
        watchers = in.readInt();
        stars = in.readInt();
        language = in.readString();
        homepage = in.readString();
        owner = in.readParcelable(User.class.getClassLoader());
        fork = in.readByte() != 0;
    }

    public static final Creator<Repository> CREATOR = new Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel in) {
            return new Repository(in);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(forks);
        dest.writeInt(watchers);
        dest.writeInt(stars);
        dest.writeString(language);
        dest.writeString(homepage);
        dest.writeParcelable(owner, flags);
        dest.writeByte((byte) (fork ? 1 : 0));
    }
}
