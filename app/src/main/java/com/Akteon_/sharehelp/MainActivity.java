package com.Akteon_.sharehelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.Akteon_.sharehelp.controller.AuthController;
import com.Akteon_.sharehelp.databinding.ActivityMainBinding;
import com.Akteon_.sharehelp.fragments.AddFragment;
import com.Akteon_.sharehelp.fragments.ChatFragment;
import com.Akteon_.sharehelp.fragments.HomeFragment;
import com.Akteon_.sharehelp.fragments.NotificationsFragment;
import com.Akteon_.sharehelp.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    AddFragment addFragment = new AddFragment();
    ChatFragment chatFragment = new ChatFragment();
    NotificationsFragment notificationsFragment = new NotificationsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_ShareHelp);
        super.onCreate(savedInstanceState);
        AuthController controller = new AuthController();
        if (!controller.isAuth()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bottomNavigationView = binding.bottomNavigation;

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        binding.profileImage.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            item.setChecked(true);
            switch (item.getItemId()) {
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                    binding.pageTitle.setText("Рекомендации");
                    break;
                case R.id.search:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, searchFragment).commit();
                    binding.pageTitle.setText("Поиск");
                    break;
                case R.id.add:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, addFragment).commit();
                    binding.pageTitle.setText("Создать обсуждение");
                    break;
                case R.id.chat:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, chatFragment).commit();
                    binding.pageTitle.setText("Обсуждения");
                    break;
                case R.id.notifications:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, notificationsFragment).commit();
                    binding.pageTitle.setText("Уведомления");
                    break;
            }
            return false;
        });

        binding.settings.setOnClickListener(v -> {
            binding.logOff.setVisibility((binding.logOff.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE);
        });

        binding.logOff.setOnClickListener(v -> {
            controller.signOut();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
//            startActivity(new Intent(this, DiscussionActivity.class));
        });
    }
}