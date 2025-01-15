package com.example.bolvanka;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter adapter;
    ConstraintLayout btn_backet;
    LinearLayout btn_open_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_list_prod);
        btn_backet = findViewById(R.id.btn_backet);
        btn_open_menu = findViewById(R.id.btn_open_menu);

        btn_backet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ещё не сделал", Toast.LENGTH_SHORT).show();
            }
        });

        btn_open_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ещё не сделал", Toast.LENGTH_SHORT).show();
            }
        });

        // 2. Создаём список продуктов (можете заполнять его динамически или из другого источника)
        List<ProductAdapter.Product> productList = createProductList();

        // 3. Создаём адаптер и передаем контекст и список продуктов
        adapter = new ProductAdapter(this, productList);

        // 4. Устанавливаем адаптер на RecyclerView
        recyclerView.setAdapter(adapter);

        // 5. Устанавливаем LayoutManager (обязательно!)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    // Метод для создания списка продуктов (замените на свои данные)
    private List<ProductAdapter.Product> createProductList() {
        List<ProductAdapter.Product> productList = new ArrayList<>();
        productList.add(new ProductAdapter.Product("Тортик", R.drawable.image1));
        productList.add(new ProductAdapter.Product("ЭклЭр", R.drawable.image2));
        productList.add(new ProductAdapter.Product("Мржне", R.drawable.image3));
        // Добавьте другие элементы сюда

        return productList;
    }
}