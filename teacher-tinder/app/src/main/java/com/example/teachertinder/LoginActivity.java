package com.example.teachertinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

/** Activity to login. **/
public class LoginActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private TextView Signup;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Creating the objects and linking them to their corresponding
        // screen elements

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvinfo);
        Login = (Button) findViewById(R.id.btlogin);
        Signup = (TextView) findViewById(R.id.tvsignup);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

        String text = "Sign-up";

        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        };

        ss.setSpan(clickableSpan1, 0,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Signup.setText(ss);
        Signup.setMovementMethod(LinkMovementMethod.getInstance());

    }

    /* This function checks whether the passwords entered is correct
        Parameters: userName, userPassword
        Returns: nothing
    */
    private void validate(String userName, String userPassword){
        // TODO: implement authentication with database
        if ((userName.equals("Admin") ) && (userPassword.equals("1234"))){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else{
            counter--;

            Info.setText(getString(R.string.blank, counter));
            if (counter == 0){
                Login.setEnabled(false);
            }

        }
    }
}

