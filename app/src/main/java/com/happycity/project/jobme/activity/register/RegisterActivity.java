package com.happycity.project.jobme.activity.register;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.happycity.project.jobme.R;
import com.happycity.project.jobme.activity.LoginActivity;
import com.happycity.project.jobme.data.model.User;

public class RegisterActivity extends AppCompatActivity {
    // Initiate back arrow button.
    private ImageButton imgBtnBackArrow;
    // Part of name.
    private LinearLayout llName;
    private EditText edtFirstName;
    private EditText edtLastName;
    private ImageButton imgBtnNext1;
    // Part of account.
    private LinearLayout llAccount;
    private EditText edtUsername;
    private EditText edtPassword;
    private ImageButton imgBtnNext2;
    private ImageButton imgBtnBack2;
    // Part of phone.
    private LinearLayout llPhone;
    private EditText edtEmal;
    private EditText edtPhone;
    private Button btnCreate;
    private ImageButton imgBtnBack3;
    // Sets up firebase.
    private FirebaseDatabase firebaseDatabase;
    // To read or write data from the database.
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Mapped.
        addControls();
        // Solve events.
        addEvents();
    }

    private void addEvents() {
        imgBtnBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        // Next page or back page.
        move();
    }

    private void move() {
        // Move next page.
        imgBtnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llName.setVisibility(View.GONE);
                llAccount.setVisibility(View.VISIBLE);
                llPhone.setVisibility(View.GONE);
            }
        });

        imgBtnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llName.setVisibility(View.GONE);
                llAccount.setVisibility(View.GONE);
                llPhone.setVisibility(View.VISIBLE);
            }
        });
        // Move back previous page.
        imgBtnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llName.setVisibility(View.VISIBLE);
                llAccount.setVisibility(View.GONE);
                llPhone.setVisibility(View.GONE);
            }
        });
        imgBtnBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llName.setVisibility(View.GONE);
                llAccount.setVisibility(View.VISIBLE);
                llPhone.setVisibility(View.GONE);
            }
        });
        // Task here: Sending a message comes phone to confirm.
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Getting contents are entered.
                String firstName = edtFirstName.getText().toString();
                String lastName = edtLastName.getText().toString();
                String email = edtEmal.getText().toString();
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                String phone = edtPhone.getText().toString();
                // Add a user.
                signUp(username, firstName, lastName, email, password, phone);
                // Intent intent = new Intent(RegisterActivity.this, VerifyPhoneNumber.class);
                // startActivity(intent);
            }
        });
    }
    // Add a user.
    // I put "final" because "onComplete" is a method belong to inner class.
    // What is inner class???
    private void signUp(final String username, final String firstName, final String lastName,
                        final String email, final String password, final String phone) {
        // Using setValue() to save data to a specified reference.
        // addOnCompleteListener: Add data to realtime database.
        databaseReference.child("Users").setValue(username).addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Tạo tài khoản thành công",
                                    Toast.LENGTH_SHORT).show();
                            User user = new User(firstName, lastName, email, password, phone);
                            databaseReference.child(username).setValue(user);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Tạo tài khoản thất bại",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void addControls() {
        imgBtnBackArrow = (ImageButton) findViewById(R.id.imgBtnBackArrow);

        llName = (LinearLayout) findViewById(R.id.llName);
        edtFirstName = (EditText) findViewById(R.id.edtFirstName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);
        imgBtnNext1 = (ImageButton) findViewById(R.id.imgBtnNext1);

        llAccount = (LinearLayout) findViewById(R.id.llAccount);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        imgBtnNext2 = (ImageButton) findViewById(R.id.imgBtnNext2);
        imgBtnBack2 = (ImageButton) findViewById(R.id.imgBtnBack2);

        llPhone = (LinearLayout) findViewById(R.id.llPhone);
        edtEmal = (EditText) findViewById(R.id.edtEmail);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        imgBtnBack3 = (ImageButton) findViewById(R.id.imgBtnBack3);
        // Retrieve an instance of your database using getInstance().
        firebaseDatabase = FirebaseDatabase.getInstance();
        // Reference the location you want to write to.
        databaseReference = firebaseDatabase.getReference("Users");
    }
}
