package com.Akteon_.sharehelp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Akteon_.sharehelp.DiscussionActivity;
import com.Akteon_.sharehelp.R;
import com.Akteon_.sharehelp.adapter.DiscussionAdapter;
import com.Akteon_.sharehelp.controller.AuthController;
import com.Akteon_.sharehelp.data.DiscussionEntity;
import com.Akteon_.sharehelp.data.UserEntity;
import com.Akteon_.sharehelp.databinding.FragmentChatBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class ChatFragment extends Fragment {

    private FragmentChatBinding binding;
    private DatabaseReference database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChatBinding.inflate(inflater, container, false);
        AuthController controller = new AuthController();
        database = FirebaseDatabase.getInstance("https://sharehelp-c8e9e-default-rtdb.firebaseio.com/").getReference();

        database.child("users").child(controller.getUser().getUid()).get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.e("firebase", "Error getting data", task.getException());
            } else {
                ArrayList<String> discussionIds = Objects.requireNonNull(task.getResult().getValue(UserEntity.class)).discussions;
                DiscussionEntity[] discussions = new DiscussionEntity[discussionIds.size()];
                DiscussionAdapter adapter = new DiscussionAdapter(this.getLayoutInflater(), discussions);
                binding.messageRecycler.setAdapter(adapter);
                int i = 0;
                for (String discussionId : discussionIds) {
                    database.child("discussions").child(discussionId).get().addOnCompleteListener(task1 -> {
                        if (!task1.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task1.getException());
                        } else {
                            discussions[i] = task1.getResult().getValue(DiscussionEntity.class);
                        }
                    });
                }
            }
        });

        return binding.getRoot();
    }
}