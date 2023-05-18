package com.Akteon_.sharehelp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Akteon_.sharehelp.R;
import com.Akteon_.sharehelp.adapter.SwipeAdapter;
import com.Akteon_.sharehelp.databinding.FragmentAddBinding;
import com.Akteon_.sharehelp.databinding.FragmentHomeBinding;
import com.Akteon_.sharehelp.views.DiscussionPreview;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private SwipeAdapter adapter;
    private List<Integer> list;
    DiscussionPreview preview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        list = new ArrayList<>();
        adapter = new SwipeAdapter(this.getContext(), list);
        binding.koloda.setAdapter(adapter);
        return binding.getRoot();
    }
}