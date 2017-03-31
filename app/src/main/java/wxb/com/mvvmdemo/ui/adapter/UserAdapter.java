package wxb.com.mvvmdemo.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import wxb.com.mvvmdemo.R;
import wxb.com.mvvmdemo.bean.User;
import wxb.com.mvvmdemo.databinding.ItemUserBinding;

/**
 * Created by 黑月 on 2017/3/30.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    private static final int USER_COUNT = 10;
    private List<User> mUsers;

    public UserAdapter() {
        mUsers = new ArrayList<>(10);
        for (int i = 0; i < USER_COUNT; i++) {
            User user = new User("A" + i, "B" + i, "C" + i, i);
            mUsers.add(user);
        }
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);

        return new UserHolder(contentView);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        holder.bind(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    class UserHolder extends RecyclerView.ViewHolder {
        private ItemUserBinding mBinding;

        public UserHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        public void bind(User user) {
            mBinding.setUser(user);
        }

    }

}
