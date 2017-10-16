package com.happycity.project.jobme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.happycity.project.jobme.R;

public class MainActivity extends AppCompatActivity {

    // private static final String TAG = "EmailPassword";

    private EditText editTextFullname;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextPhoneNumber;
    private Button buttonSend;

    // private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
    }

    private void addControls() {
        editTextFullname = (EditText) findViewById(R.id.editTextFullName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
        buttonSend = (Button) findViewById(R.id.buttonSend);

        // mAuth = FirebaseAuth.getInstance();
    }
/*
    @Override
    private void onStart() {
        super.onStart();
    }
    // Checking field is empty?
    private boolean validateForm() {
        boolean valid = true;

        String email = editTextEmail.getText().toString();
        if (TextUtils.isEmpty(email) {
            editTextEmail.setError("Bắt buộc nhập.");
            valid = false;
        } else {
            editTextEmail.setError(null);
        }

        String password = editTextPassword.getText().toString();
        if (TextUtils.isEmpty(password) {
            editTextPassword.setError("Bắt buộc nhập.");
            valid = false;
        } else {
            editTextPassword.setError(null);
        }
    }

    private void createAccount(String fullName, String email, String password, String phoneNumber) {
        Log.d(TAG, "createAccount: " + email);
        if (!validateForm) {
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        });
    }

    private void sendEmailVerification() {
        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });
    }
*/
}
