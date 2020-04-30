package com.example.teachertinder;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.Button;
        import android.widget.EditText;

/** Activity to edit Users Profile. **/
public class EditActivity extends AppCompatActivity{

    private EditText Experience;
    private EditText Subjects;
    private EditText Region;
    private EditText Certificates;
    private EditText Bio;
    private Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_account_activity);
        // Creating the objects and linking them to their corresponding
        // screen elements

        Experience = (EditText)findViewById(R.id.tvExperience);
        Subjects = (EditText)findViewById(R.id.tvSubjectsTaught);
        Region = (EditText) findViewById(R.id.tvRegion);
        Certificates = (EditText) findViewById(R.id.tvCertficates);
        Bio = (EditText) findViewById(R.id.tvBio);

        Save = (Button) findViewById(R.id.btSave);
    }

}


