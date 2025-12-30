package com.example.gpproject_member1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MaintenanceActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editService, editMileage;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);

        myDb = new DatabaseHelper(this);
        editService = findViewById(R.id.editText_service);
        editMileage = findViewById(R.id.editText_mileage);
        btnAddData = findViewById(R.id.button_add);

        btnAddData.setOnClickListener(v -> {
            boolean isInserted = myDb.insertData(editService.getText().toString(),
                    editMileage.getText().toString());
            if(isInserted)
                Toast.makeText(MaintenanceActivity.this, "Log Saved Offline!", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MaintenanceActivity.this, "Error Saving Log", Toast.LENGTH_LONG).show();
        });
    }
}
