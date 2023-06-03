package com.Akteon_.sharehelp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.Akteon_.sharehelp.databinding.ActivityDiscussionBinding;

public class DiscussionActivity extends AppCompatActivity {

    private ActivityDiscussionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDiscussionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(v -> {
            finish();
        });
    }
}