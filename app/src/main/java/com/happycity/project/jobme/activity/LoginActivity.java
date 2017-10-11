package com.happycity.project.jobme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.happycity.project.jobme.R;
import com.happycity.project.jobme.data.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edtEmailAddress)
    EditText edtEmailAddress;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(R.id.btnSignIn)
    Button btnSignIn;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference userDataLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        initialFirebaseDatabase();
        signInToDatabase();
    }

    private void signInToDatabase() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(edtEmailAddress.getText().toString(), edtPassword.getText().toString());
            }
        });
    }

    private void signIn(final String email,final String password) {
        userDataLogin.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(email).exists()){
                    // check email is empty or not
                    if(!email.isEmpty()){
                        User userLogin = dataSnapshot.child(email).getValue(User.class);
                        if(userLogin.getPassword().equals(password)){
                            Toast.makeText(LoginActivity.this, "Login Ok haha", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Email is not exists", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void initialFirebaseDatabase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        userDataLogin = firebaseDatabase.getReference("Users");
    }


}
