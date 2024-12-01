package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etPassword, etConfirm;
    private Switch switchGeolocation;
    private CheckBox cbTerms;
    private Button btnRegister, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.etConfirm);
        switchGeolocation = findViewById(R.id.switchGeolocation);
        cbTerms = findViewById(R.id.cbTerms);
        btnRegister = findViewById(R.id.btnRegister);
        btnReset = findViewById(R.id.btnReset);

        // Listeners
        btnRegister.setOnClickListener(v -> {
            if (cbTerms.isChecked()) {
                String name = etName.getText().toString();
                String password = etPassword.getText().toString();
                String confirm = etConfirm.getText().toString();

                if (!password.equals(confirm)) {
                    Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Welcome " + name, Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please accept terms and conditions!", Toast.LENGTH_SHORT).show();
            }
        });

        btnReset.setOnClickListener(v -> {
            etName.setText("");
            etPassword.setText("");
            etConfirm.setText("");
            switchGeolocation.setChecked(false);
            cbTerms.setChecked(false);
        });
    }
}