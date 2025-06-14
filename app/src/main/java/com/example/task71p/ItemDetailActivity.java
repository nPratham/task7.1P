package com.example.task71p;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    TextView nameTextView, dateTextView, locationTextView;
    Button deleteButton;
    DatabaseHelper dbHelper;
    String itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.removeitem);

        nameTextView = findViewById(R.id.Name);
        dateTextView = findViewById(R.id.Date);
        locationTextView = findViewById(R.id.Location);
        deleteButton = findViewById(R.id.buttonDelete);

        dbHelper = new DatabaseHelper(this);

        Intent intent = getIntent();
        itemId = intent.getStringExtra("ITEM_ID");
        String itemName = intent.getStringExtra("ITEM_NAME");
        String itemStatus = intent.getStringExtra("ITEM_STATUS");
        String itemDate = intent.getStringExtra("ITEM_DATE");
        String itemLocation = intent.getStringExtra("ITEM_LOCATION");

        nameTextView.setText("Item: " + itemName + " (" + itemStatus + ")");
        dateTextView.setText("Date: " + itemDate);
        locationTextView.setText("Location: " + itemLocation);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean deleted = dbHelper.deleteItem(itemId);
                if (deleted) {
                    Toast.makeText(ItemDetailActivity.this, "Item deleted successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ItemDetailActivity.this, "Failed to delete item.", Toast.LENGTH_SHORT).show();
                }

                Intent resultIntent = new Intent();
                resultIntent.putExtra("ITEM_DELETED", true);
                resultIntent.putExtra("DELETED_ITEM_ID", itemId);
                setResult(RESULT_OK, resultIntent);
                finish();


            }
        });
    }
}

