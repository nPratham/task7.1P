package com.example.task71p;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    RadioButton rbLost, rbFound;
    EditText nameInput, phoneInput, descriptionInput, dateInput, locationInput;
    Button saveButton;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lostitemandfound);

        rbLost = findViewById(R.id.found);
        rbFound = findViewById(R.id.rbFound);
        nameInput = findViewById(R.id.Name);
        phoneInput = findViewById(R.id.Phone);
        descriptionInput = findViewById(R.id.Description);
        dateInput = findViewById(R.id.Date);
        locationInput = findViewById(R.id.Location);
        saveButton = findViewById(R.id.Savebutton);

        dbHelper = new DatabaseHelper(this);

        saveButton.setOnClickListener(v -> {
            String type = rbLost.isChecked() ? "Lost" : "Found";
            boolean saved = dbHelper.insertData(
                    type,
                    nameInput.getText().toString(),
                    phoneInput.getText().toString(),
                    descriptionInput.getText().toString(),
                    dateInput.getText().toString(),
                    locationInput.getText().toString()
            );
            Toast.makeText(this, saved ? "Saved!" : "Failed!", Toast.LENGTH_SHORT).show();
            if (saved) finish();
        });
    }
}

