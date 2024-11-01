package com.example.pz2;

import static java.security.AccessController.getContext;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class MainActivity2 extends AppCompatActivity {

    boolean isBlue = true;
    Integer checkedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String[] complexities = {"Легко", "Нормально", "Сложно"};

        Button btn2 = findViewById(R.id.button2);
        RadioButton blue = findViewById(R.id.blueButton);
        RadioButton red = findViewById(R.id.redButton);
        RadioButton green = findViewById(R.id.greenButton);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, complexities);
        SeekBar seekBar = findViewById(R.id.seekBar);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        RadioGroup radios = findViewById(R.id.radioGroup);
        // обработка переключения состояния переключателя
        radios.setOnCheckedChangeListener((radiogroup, id)-> {

            // получае выбранную кнопку
            RadioButton radio = findViewById(id);
            switch (radio.getText().toString()) {
                case "Blue":
                    checkedColor = 1;
                    break;
                case "Red":
                    checkedColor = 3;

                    break;
                case "Green":
                    checkedColor = 2;

                    break;
                default:
                    break;
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Settings settings = new Settings(seekBar.getProgress(), spinner.getSelectedItemPosition(), checkedColor);
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra(Settings.class.getSimpleName(), settings);
                startActivity(intent);
            }
        });

    }

}