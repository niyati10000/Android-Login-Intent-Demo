package com.example.newwwww;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView t3, t4, t5, t6; // t3 = page title, t4 = email, t5 = account type, t6 = remember me
    Button b2; // Logout button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Linking views with IDs
        t3 = findViewById(R.id.textView3); // Title
        t4 = findViewById(R.id.textView4); // Email
        t5 = findViewById(R.id.textView5); // Account type
        t6 = findViewById(R.id.textView6); // Remember Me
        b2 = findViewById(R.id.button2);   // Logout

        // Get data from MainActivity
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String accountType = intent.getStringExtra("acc");
        boolean rememberMe = intent.getBooleanExtra("rem", false);

        // Show received data
        t4.setText("Email: " + email);
        t5.setText("Account Type: " + accountType);
        t6.setText("Remember Me: " + (rememberMe ? "Yes" : "No"));

        // Logout button click
        b2.setOnClickListener(v -> {
            Toast.makeText(MainActivity2.this, "Logged out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity2.this, MainActivity.class));
            finish();
        });
    }
}
