package com.example.teachertinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

        final DBHelper dbHelper = new DBHelper(this);

        final Button saveButton = findViewById(R.id.btSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO: implement IDs
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(experienceEditText.getWindowToken(), 0);
                dbHelper.updateTeacherData("1", experienceEditText.getText().toString(),
                        subjectsEditText.getText().toString(),
                        regionEditText.getText().toString(),
                        certificatesEditText.getText().toString(),
                        bioEditText.getText().toString());
                Toast.makeText(getApplicationContext(), "Account information saved",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

}


