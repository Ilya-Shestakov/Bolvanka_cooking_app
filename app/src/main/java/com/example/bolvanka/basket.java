package com.example.bolvanka;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class basket extends AppCompatActivity {

    ConstraintLayout take_zakaz, prinyat_zakaz;
    TextView text_basket, itogSum, walletSum;
    ImageView btn_my_acc_from_basket, btn_home_from_basket, btn_basket_menu_from_basket;
    Dialog dialogTakeZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        text_basket = findViewById(R.id.text_basket);
        btn_my_acc_from_basket = findViewById(R.id.btn_my_acc_from_basket);
        btn_home_from_basket = findViewById(R.id.btn_home_from_basket);
        take_zakaz = findViewById(R.id.take_zakaz);

        dialogTakeZ = new Dialog(basket.this);

        btn_my_acc_from_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(person_acc.class);
            }
        });

        btn_home_from_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(MainActivity.class);
            }
        });

        take_zakaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialTakeZakaz();
            }
        });

        text_basket.setText(getIntent().getStringExtra("Basket"));

    }

    private void dialTakeZakaz() {
        dialogTakeZ.setContentView(R.layout.activity_dialog_take_z);
        dialogTakeZ.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialogTakeZ.show();

        itogSum = dialogTakeZ.findViewById(R.id.itogSum);
        walletSum = dialogTakeZ.findViewById(R.id.walletSum);
        prinyat_zakaz = dialogTakeZ.findViewById(R.id.prinyat_zakaz);

        itogSum.setText("Итог: 2341");
        walletSum.setText("Ваш счёт: 10000");

        prinyat_zakaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(basket.this, "Заказ оформлен", Toast.LENGTH_SHORT).show();
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