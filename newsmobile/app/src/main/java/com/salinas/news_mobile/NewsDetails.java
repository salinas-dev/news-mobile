package com.salinas.news_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class NewsDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_details);

        // Obtener los datos de la noticia seleccionada
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author"); // Obtener el autor del Intent
        String description = intent.getStringExtra("description");
        String publishedAt = intent.getStringExtra("publishedAt");
        String content = intent.getStringExtra("content");
        String urlToImage = intent.getStringExtra("urlToImage");

        // Mostrar los datos en las vistas correspondientes
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView authorTextView = findViewById(R.id.authorTextView); // TextView para el autor
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        TextView publishedAtTextView = findViewById(R.id.publishedAtTextView);
        TextView contentTextView = findViewById(R.id.contentTextView);
        ImageView imageView = findViewById(R.id.imageView);

        titleTextView.setText(title);
        authorTextView.setText(author); // Establecer el autor en el TextView correspondiente
        descriptionTextView.setText(description);
        publishedAtTextView.setText(publishedAt);
        contentTextView.setText(content);

        // Cargar la imagen de la noticia usando Glide
        Glide.with(this).load(urlToImage).into(imageView);
    }
}
