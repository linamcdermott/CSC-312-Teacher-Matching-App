package com.example.teachertinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.dashboard_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                Intent intent = new Intent(context, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }


}
