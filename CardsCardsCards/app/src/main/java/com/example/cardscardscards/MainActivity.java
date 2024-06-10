package com.example.cardscardscards;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button NewCol = findViewById(R.id.text3);
        NewCol.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CardsProection.class);
            startActivity(intent);
        });

    }


}