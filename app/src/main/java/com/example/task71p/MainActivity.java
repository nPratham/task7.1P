package com.example.task71p;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button createAdvertBtn, showItemsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAdvertBtn = findViewById(R.id.button);
        showItemsBtn = findViewById(R.id.button2);

        createAdvertBtn.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, FormActivity.class))
        );

        showItemsBtn.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ViewDataActivity.class))
        );
    }
}



