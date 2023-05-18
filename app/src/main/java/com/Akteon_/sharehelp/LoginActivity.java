package com.Akteon_.sharehelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.Akteon_.sharehelp.controller.AuthController;
import com.Akteon_.sharehelp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AuthController controller = new AuthController();

        binding.enter.setOnClickListener(view -> {
            String emailString = binding.email.getText().toString();
            String passwordString = binding.password.getText().toString();
            controller.enterUser(emailString, passwordString, task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(this, "Вход прошёл успешно!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });

        binding.forgotPassword.setOnClickListener(v -> Toast.makeText(this, "Надо было записывать", Toast.LENGTH_SHORT).show());

        binding.register.setOnClickListener(view -> {
            startActivity(new Intent(this, RegisterActivity.class));
            finish();
        });
    }
}