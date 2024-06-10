package com.example.cardscardscards;

import static android.text.TextUtils.indexOf;
import static java.lang.String.valueOf;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CardsProection extends AppCompatActivity {

    //data
    int running_card_counter = 0;
    int flag = 0;
    NewColod NC = new NewColod();
    //elements ui
    EditText EditQue;
    EditText EditBack;
    EditText save_text;
    ArrayList<NewColod.Card> newcolod = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_proection);

        EditQue = findViewById(R.id.newcolodque);
        EditBack = findViewById(R.id.newcolodback);
        save_text = findViewById(R.id.save_text);




        Button Back_to_menu = findViewById(R.id.back_to_main_menu);
        Back_to_menu.setOnClickListener(v -> {
            Intent intent = new Intent(CardsProection.this, MainActivity.class);
            startActivity(intent);

        });

        Button AddCard = findViewById(R.id.addcard);
        AddCard.setOnClickListener(v -> {
            running_card_counter += 1;

            NC.cards.add(new NewColod.Card(String.valueOf(EditQue.getText()), String.valueOf(EditBack.getText())));

            EditQue.setText("");
            EditBack.setText("");

        });
        Button last = findViewById(R.id.previous_card);
        last.setOnClickListener(v -> {
            if (running_card_counter == 0) {
                EditQue = findViewById(R.id.newcolodque);
                EditBack = findViewById(R.id.newcolodback);
                NC.cards.set(running_card_counter, new NewColod.Card(String.valueOf(EditQue.getText()), String.valueOf(EditBack.getText())));

                running_card_counter = NC.cards.size() - 1;
            }
            else if(valueOf(EditQue.getText()).isEmpty() | valueOf(EditBack.getText()).isEmpty()){
                running_card_counter = NC.cards.size() - 1;
            }
            else {
                EditQue = findViewById(R.id.newcolodque);
                EditBack = findViewById(R.id.newcolodback);
                NC.cards.set(running_card_counter, new NewColod.Card(String.valueOf(EditQue.getText()), String.valueOf(EditBack.getText())));

                running_card_counter -= 1;
            }
            EditBack.setText(NC.cards.get(running_card_counter).back);
            EditQue.setText(NC.cards.get(running_card_counter).que);

        });
        Button next = findViewById(R.id.next_card);
        next.setOnClickListener(v -> {
            if (running_card_counter == NC.cards.size() - 1) {
                EditQue = findViewById(R.id.newcolodque);
                EditBack = findViewById(R.id.newcolodback);
                NC.cards.set(running_card_counter, new NewColod.Card(String.valueOf(EditQue.getText()), String.valueOf(EditBack.getText())));

                running_card_counter = 0;
            }
            else if(valueOf(EditQue.getText()).isEmpty() | valueOf(EditBack.getText()).isEmpty()){
                running_card_counter = 0;
            }
            else {
                EditQue = findViewById(R.id.newcolodque);
                EditBack = findViewById(R.id.newcolodback);
                NC.cards.set(running_card_counter, new NewColod.Card(String.valueOf(EditQue.getText()), String.valueOf(EditBack.getText())));

                running_card_counter += 1;
            }
            EditBack.setText(NC.cards.get(running_card_counter).back);
            EditQue.setText(NC.cards.get(running_card_counter).que);
        });
        Button remove = findViewById(R.id.deliter);
        remove.setOnClickListener(v -> {
            NC.cards.remove(running_card_counter);
            EditBack.setText("");
            EditQue.setText("");
            running_card_counter -= 1;
        });
        Button save = findViewById(R.id.save);
        save.setOnClickListener(v ->{
            showInfo("Сейчас вы пройдёте тестирование по колоде  " + save_text.getText().toString());
            flag+=1;
            Back_to_menu.setEnabled(false);
            last.setEnabled(false);
            next.setEnabled(false);
            remove.setEnabled(false);

            showInfo("Нажимайте на Добавить карту чтобы узнать ответ или продолжить");

        });

    }


    private void showInfo(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
