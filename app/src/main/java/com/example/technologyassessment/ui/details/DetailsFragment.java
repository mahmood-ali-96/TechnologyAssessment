package com.example.technologyassessment.ui.details;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.technologyassessment.R;
import com.example.technologyassessment.data.network.response.Articles;
import com.example.technologyassessment.data.network.response.Results;
import com.example.technologyassessment.databinding.FragmentDetailsBinding;
import com.example.technologyassessment.di.component.FragmentComponent;
import com.example.technologyassessment.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends BaseFragment {

    private FragmentDetailsBinding binding;

    @Inject
    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        getArticalFromArguments();
        return binding.getRoot();
    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected void attachView() {

    }

    @Override
    protected void detachPresenter() {

    }

    private void getArticalFromArguments() {
        assert getArguments() != null;

        binding.setResulte((Results) getArguments().getSerializable("artical"));
        binding.setCopy(getArguments().getString("copy"));
        binding.setUrl(getArguments().getString("url"));
    }
}