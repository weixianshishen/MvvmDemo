package wxb.com.app_mvvm;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import wxb.com.app_mvvm.databinding.ItemRepoBinding;
import wxb.com.app_mvvm.model.Repository;
import wxb.com.app_mvvm.viewmodel.ItemRepoViewModel;

/**
 * Created by 黑月 on 2017/4/12.
 */

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryHolder> {

    private List<Repository> repositories;

    public RepositoryAdapter() {
        this.repositories = Collections.emptyList();
    }


    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public RepositoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRepoBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_repo,
                parent,
                false);
        return new RepositoryHolder(binding);
    }

    @Override
    public void onBindViewHolder(RepositoryHolder holder, int position) {
        holder.bindRepository(repositories.get(position));
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    class RepositoryHolder extends RecyclerView.ViewHolder {
        ItemRepoBinding binding;

        public RepositoryHolder(ItemRepoBinding itemView) {
            super(itemView.cardView);
            this.binding = itemView;
        }

        public void bindRepository(Repository repository) {
            if (binding.getViewModel() == null) {
                binding.setViewModel(new ItemRepoViewModel(itemView.getContext(), repository));
            } else {
                binding.getViewModel().setRepository(repository);
            }
            binding.executePendingBindings();
        }

    }

}
