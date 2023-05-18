package com.Akteon_.sharehelp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Akteon_.sharehelp.R;
import com.Akteon_.sharehelp.databinding.FragmentAddBinding;

public class AddFragment extends Fragment {

    private FragmentAddBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(inflater, container, false);

        binding.tag.setOnClickListener(v -> {
            int visibility = (binding.sports.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            binding.sports.setVisibility(visibility);
            binding.games.setVisibility(visibility);
            binding.music.setVisibility(visibility);
            binding.programming.setVisibility(visibility);
        });

        binding.sports.setOnClickListener(v -> binding.chosenTag.setText("Спорт"));

        binding.games.setOnClickListener(v -> binding.chosenTag.setText("Игры"));

        binding.music.setOnClickListener(v -> binding.chosenTag.setText("Музыка"));

        binding.programming.setOnClickListener(v -> binding.chosenTag.setText("Программирование"));

        return binding.getRoot();
    }
}