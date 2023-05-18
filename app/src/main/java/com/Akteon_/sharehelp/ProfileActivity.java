package com.Akteon_.sharehelp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.Akteon_.sharehelp.controller.AuthController;
import com.Akteon_.sharehelp.data.UserEntity;
import com.Akteon_.sharehelp.databinding.ActivityProfileBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AuthController controller = new AuthController();
        database = FirebaseDatabase.getInstance("https://sharehelp-c8e9e-default-rtdb.firebaseio.com/").getReference();

        database.child("users").child(controller.getUser().getUid()).get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.e("firebase", "Error getting data", task.getException());
            } else {
                UserEntity userEntity = task.getResult().getValue(UserEntity.class);
                assert userEntity != null;
                binding.username.setInputText(userEntity.getUsername());
                binding.email.setInputText(userEntity.getEmail());
                binding.character.setInputText(userEntity.getCharacter());
            }
        });

        ActivityResultLauncher<Intent> galleryResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                try {
                    assert data != null;
                    binding.profileImage.setImageBitmap(BitmapFactory.decodeStream(
                            getContentResolver().openInputStream(data.getData())));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        binding.profileImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            galleryResultLauncher.launch(intent);
        });

        binding.logOff.setOnClickListener(v -> {
            controller.signOut();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}