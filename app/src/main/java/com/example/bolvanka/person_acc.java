package com.example.bolvanka;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class person_acc extends AppCompatActivity {

    EditText edit_text_with_username;
    ConstraintLayout block_save;
    ImageView btn_my_acc_from_profil, btn_home_from_profil, btn_basket_menu_from_profil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_acc);

        edit_text_with_username = findViewById(R.id.edit_text_with_username);
        btn_home_from_profil = findViewById(R.id.btn_home_from_profil);
        btn_basket_menu_from_profil = findViewById(R.id.btn_basket_menu_from_profil);
        block_save = findViewById(R.id.block_save);


        block_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference Users = FirebaseDatabase.getInstance().getReference(edit_text_with_username.getText().toString());
                Users.push().setValue("123123");
            }
        });

        btn_home_from_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(MainActivity.class);
            }
        });

        btn_basket_menu_from_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(basket.class);
            }
        });

    }

    private void intent(Class class1){

        Intent intent = new Intent(this, class1);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}