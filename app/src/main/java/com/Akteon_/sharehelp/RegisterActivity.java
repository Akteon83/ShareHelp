package com.Akteon_.sharehelp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.Akteon_.sharehelp.controller.AuthController;
import com.Akteon_.sharehelp.data.UserEntity;
import com.Akteon_.sharehelp.databinding.ActivityRegisterBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AuthController controller = new AuthController();
        database = FirebaseDatabase.getInstance("https://sharehelp-c8e9e-default-rtdb.firebaseio.com/").getReference();

        binding.register.setOnClickListener(view -> {
            String emailString = binding.email.getText().toString();
            String passwordString = binding.password.getText().toString();
            String usernameString = binding.username.getText().toString();
            controller.registerUser(emailString, passwordString, task -> {
                if (task.isSuccessful()) {
                    UserEntity userEntity = new UserEntity(usernameString, emailString);
                    database.child("users").child(controller.getUser().getUid()).setValue(userEntity);

                    Toast.makeText(this, "Регистрация прошла успешно!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });

        binding.login.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}