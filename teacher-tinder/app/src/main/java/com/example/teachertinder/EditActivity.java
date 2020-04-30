package com.example.teachertinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/** Activity to edit a user's profile. **/
public class EditActivity extends AppCompatActivity{

    // These will eventually be used.
    private EditText experienceEditText;
    private EditText subjectsEditText;
    private EditText regionEditText;
    private EditText certificatesEditText;
    private EditText bioEditText;

    /** This method is run when the Activity is opened in the app. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_account_activity);
        // Creating the objects and linking them to their corresponding
        // screen elements
        experienceEditText = (EditText)findViewById(R.id.tvExperience);
        subjectsEditText = (EditText)findViewById(R.id.tvSubjectsTaught);
        regionEditText = (EditText) findViewById(R.id.tvRegion);
        certificatesEditText = (EditText) findViewById(R.id.tvCertficates);
        bioEditText = (EditText) findViewById(R.id.tvBio);

        final Button saveButton = findViewById(R.id.btSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO: implement saving account info to database
                Toast.makeText(getApplicationContext(), "Account information saved",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

}


