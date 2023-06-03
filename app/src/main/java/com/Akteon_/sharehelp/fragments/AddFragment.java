package com.Akteon_.sharehelp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.Akteon_.sharehelp.R;
import com.Akteon_.sharehelp.controller.AuthController;
import com.Akteon_.sharehelp.data.DiscussionEntity;
import com.Akteon_.sharehelp.data.UserEntity;
import com.Akteon_.sharehelp.databinding.FragmentAddBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddFragment extends Fragment {

    private FragmentAddBinding binding;
    private DatabaseReference database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(inflater, container, false);
        AuthController controller = new AuthController();
        database = FirebaseDatabase.getInstance("https://sharehelp-c8e9e-default-rtdb.firebaseio.com/").getReference();

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

        binding.travelling.setOnClickListener(v -> binding.chosenTag.setText("Путешествия"));

        binding.add.setOnClickListener(v -> {
            String topicString = binding.topic.getText().toString();
            String tagString = binding.chosenTag.getText().toString();
            String problemString = binding.problem.getText().toString();
            if (topicString.equals("")) Toast.makeText(this.getContext(), "Отсутствует тема обсуждения!", Toast.LENGTH_SHORT).show();
            else if (problemString.equals("")) Toast.makeText(this.getContext(), "Отсутствует описание проблемы!", Toast.LENGTH_SHORT).show();
            else if (tagString.equals("Выберите тег")) Toast.makeText(this.getContext(), "Не выбран тег!", Toast.LENGTH_SHORT).show();
            else {
                String uidString = controller.getUser().getUid();
                DiscussionEntity discussionEntity = new DiscussionEntity(topicString, uidString, tagString, problemString);
                String pushId = database.child("discussions").push().getKey();
                database.child("discussions").child(pushId).setValue(discussionEntity);
                database.child("users").child(controller.getUser().getUid()).get().addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                    } else {
                        UserEntity userEntity = task.getResult().getValue(UserEntity.class);
                        assert userEntity != null;
                        userEntity.discussions.add(pushId);
                        database.child("users").child(controller.getUser().getUid()).setValue(userEntity);
                    }
                });
            }
        });

        return binding.getRoot();
    }
}