package com.salinas.news_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class ProgressActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_news);

        // Esperar 3 segundos y luego iniciar MainActivity
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(ProgressActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 300); // 3000 ms = 3 segundos
    }
}
