package com.example.pz2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean isBlue = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        LinearLayout backround = findViewById(R.id.back);
        backround.setBackgroundColor(Color.BLUE);
        TextView seek = findViewById(R.id.valueSeekBar);
        TextView hard = findViewById(R.id.valueComplexity);

        Bundle arguments = getIntent().getExtras();

        Settings settings;
        if(arguments!=null){
            settings = (Settings) arguments.getSerializable(Settings.class.getSimpleName());
            seek.setText("Sound: " + String.valueOf(settings.getSound()));
            hard.setText("Complexity: " + settings.getComplexity());
            backround.setBackgroundColor(settings.getColor());
        }



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), MainActivity2.class);
                intent.putExtra("COLOR", isBlue);
                mStartForResult.launch(intent);
            }
        });
    }
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {


                }
            });




}