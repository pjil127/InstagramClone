package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CreateActivity extends AppCompatActivity {

        public static final String TAG = "CreateActivity";
        private EditText etNewUsername;
        private EditText etNewPassword;
        private Button btnSignUp;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_create);

            if(ParseUser.getCurrentUser() != null){
                goMainActivity();
            }

            etNewUsername = findViewById(R.id.newUsername);
            etNewPassword = findViewById(R.id.newPassword);
            btnSignUp = findViewById(R.id.btnSignUp);
            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "onClick Sign Up button");
                    String username = etNewUsername.getText().toString();
                    String password = etNewPassword.getText().toString();
                    createUser(username, password);
                }
            });
        }

        private void createUser(String username, String password) {
            Log.i(TAG, "Attempting to create user " + username);

            ParseUser user = new ParseUser();
            // Set core properties
            user.setUsername(etNewUsername.getText().toString());
            user.setPassword(etNewPassword.getText().toString());

            // Invoke signUpInBackground
            user.signUpInBackground(new SignUpCallback() {
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(CreateActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                        goMainActivity();
                    } else {
                        // Sign up didn't succeed. Look at the ParseException
                        // to figure out what went wrong
                        Toast.makeText(CreateActivity.this, "Failed to Create Account", Toast.LENGTH_SHORT).show();
                        goLoginActivity();
                    }
                }
            });
        }

        private void goMainActivity() {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }

        private void goLoginActivity() {
            Intent i = new Intent(this, com.example.instagramclone.LoginActivity.class);
            startActivity(i);
            finish();
        }

}
