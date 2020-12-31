package com.example.technologyassessment.ui.listing;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.technologyassessment.R;
import com.example.technologyassessment.data.network.response.Articles;
import com.example.technologyassessment.databinding.FragmentListBinding;
import com.example.technologyassessment.di.component.FragmentComponent;
import com.example.technologyassessment.ui.base.BaseFragment;
import com.example.technologyassessment.ui.details.DetailsFragment;

import java.util.Objects;

import javax.inject.Inject;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class ListingFragment extends BaseFragment implements MainContract.View {

    @Inject
    ListingAdapter adapter;

    @Inject
    ListingPresenter presenter;

    @Inject
    Bundle bundle;

    @Inject
    StaggeredGridLayoutManager layoutManager;

    @Inject
    DetailsFragment fragment;

    private FragmentListBinding binding;
    private Articles articles;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        initRecycler();
        presenter.getArticles();
        return binding.getRoot();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_list;
    }

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected void attachView() {
        presenter.attachView(this);
    }

    @Override
    protected void detachPresenter() {
        presenter.detachView();
    }

    @Override
    public void showArticles(Articles articles) {
        this.articles = articles;
        adapter.setList(articles.getResults());
    }

    @Override
    public void showProgress(boolean show) {
        if (show)
            binding.progressBar.setVisibility(View.VISIBLE);
        else
            binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(Throwable error) {
        Log.d("Afrin", "showError: " + error.getMessage());
        Toast.makeText(getContext(), Objects.requireNonNull(getContext()).getResources().getString(R.string.error_internet_connection), Toast.LENGTH_SHORT).show();
    }

    public void initRecycler() {
        binding.recyclerview.setLayoutManager(layoutManager);
        binding.recyclerview.setAdapter(adapter);

        adapter.setOnitemclicklistener(new ListingAdapter.Onitemclicklistener() {
            @Override
            public void OnArticalClick(int position) {
                detailsArtical(position);
            }
        });
    }

    private void detailsArtical(int position) {
        bundle.putSerializable("artical", this.articles.getResults().get(position));

        String url;
        if (this.articles.getResults().get(position).getMedia().size() > 0)
            url = this.articles.getResults().get(position)
                    .getMedia().get(0).getMedia_metadata()
                    .get(0).getUrl();
        else url = "Non";

        bundle.putString("url", url);
        bundle.putString("copy", this.articles.getCopyright());

        fragment.setArguments(bundle);
        assert getFragmentManager() != null;
        getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.right_to_left, R.anim.exit_right_to_left, R.anim.left_to_right, R.anim.exit_left_to_right)
                .replace(R.id.frameLayout, fragment)
                .addToBackStack("DetailsFragment")
                .commit();
    }
}