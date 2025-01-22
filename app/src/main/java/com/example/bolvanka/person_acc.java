package com.example.bolvanka;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class person_acc extends AppCompatActivity {

    EditText edit_text_with_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_acc);

        edit_text_with_username = findViewById(R.id.edit_text_with_username);

        Drawable drawable = edit_text_with_username.getBackground();
        drawable.mutate().setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        edit_text_with_username.setBackground(drawable);

    }
}