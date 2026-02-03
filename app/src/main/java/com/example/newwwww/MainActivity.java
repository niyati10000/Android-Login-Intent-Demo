package com.example.newwwww;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2; // e1 = email, e2 = password
    TextView t1, t2;
    RadioGroup rg1;
    RadioButton r1, r2;
    CheckBox c1;
    String s1 = "", s2 = "", s3 = "";
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Linking views
        t1 = findViewById(R.id.textView);
        t2 = findViewById(R.id.textView2);

        e1 = findViewById(R.id.editTextTextEmailAddress); // email
        e2 = findViewById(R.id.editTextNumberPassword);   // password

        rg1 = findViewById(R.id.rg1);
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);

        c1 = findViewById(R.id.checkBox);

        b1 = findViewById(R.id.button);

        // Login button click
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = e1.getText().toString().trim(); // email
                s2 = e2.getText().toString().trim(); // password
                s3 = "";

                // Get selected radio button
                int selectedId = rg1.getCheckedRadioButtonId();
                if (selectedId == R.id.radioButton) {
                    s3 = "user";
                } else if (selectedId == R.id.radioButton2) {
                    s3 = "admin";
                }

                // Check login credentials
                if (s1.equals("Niyatibansal626@gmail.com") && s2.equals("123456") && !s3.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("email", s1);
                    intent.putExtra("acc", s3);
                    intent.putExtra("rem", c1.isChecked());
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Forget password click
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotIntent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(forgotIntent);
            }
        });
    }
}
