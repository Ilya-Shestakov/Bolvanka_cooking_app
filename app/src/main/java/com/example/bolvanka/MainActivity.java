package com.example.bolvanka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ConstraintLayout btn_save_backet;
    ItemAdapter adapter;
    ImageView btn_my_acc, btn_home, btn_basket_menu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_my_acc = findViewById(R.id.btn_my_acc);
        btn_basket_menu = findViewById(R.id.btn_basket_menu);

        btn_my_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentMain(person_acc.class);
            }
        });


        btn_basket_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentMain(basket.class);
            }
        });

        recyclerView = findViewById(R.id.recycler_view_list_prod);
        btn_save_backet = findViewById(R.id.btn_save_backet);

        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            List<ItemModel> items = new ArrayList<>();
            items.add(new ItemModel("tortic", 0, R.drawable.image1));
            items.add(new ItemModel("ecler", 0, R.drawable.image2));
            items.add(new ItemModel("morojenoe", 0, R.drawable.image3));

            adapter = new ItemAdapter(items);
            recyclerView.setAdapter(adapter);
        }
        btn_save_backet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBacketInfo();
            }
        });
    }

    private void showBacketInfo() {
        if (adapter == null) {
            Toast.makeText(this, "Корзина пуста", Toast.LENGTH_SHORT).show();
            return;
        }
        List<ItemModel> items = adapter.getItems();
        if (items.isEmpty()) {
            Toast.makeText(this, "Корзина пуста", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuilder backetInfo = new StringBuilder();
        for (ItemModel item : items) {
            if(item.getCounter() > 0){
                backetInfo.append(item.getName()).append(": ").append(item.getCounter()).append(", ");
            }
        }
        if (backetInfo.length() > 0) {
            backetInfo.setLength(backetInfo.length() - 2); // Удаляем последнюю запятую и пробел
//            Toast.makeText(this, backetInfo.toString(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, basket.class);
            intent.putExtra("Basket", backetInfo.toString());
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Корзина пуста", Toast.LENGTH_SHORT).show();
        }
    }

    public void intentMain(Class class1){

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