package com.happycity.project.jobme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.happycity.project.jobme.R;
import com.happycity.project.jobme.activity.register.RegisterActivity;
import com.happycity.project.jobme.data.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edtUserID)
    EditText edtUserID;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    private CheckBox chkSavingUsername;
    private Button btnSignIn;
    // Sets up a image button is register button.
    private ImageButton imgBtnRegister;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Mapped.
        addControls();
        // Solve events.
        addEvents();
        ButterKnife.bind(this);
    }

    private void addEvents() {
        imgBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        signInToDatabase();
    }

    private void signInToDatabase() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = edtUserID.getText().toString();
                String password = edtPassword.getText().toString();
                if (userID.isEmpty()) {
                    edtUserID.setError("Bạn chưa nhập email!");
                }
                if (password.isEmpty()) {
                    edtPassword.setError("Bạn chưa nhập mật khẩu");
                }
                signIn(userID, password);
            }
        });
    }

    private void signIn(final String userID, final String password) {
        // Read from your database.
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(userID).exists()) {
                    User user = dataSnapshot.child(userID).getValue(User.class);
                    if (user.getPassword().equals(password)) {
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Tài khoản không đúng", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value.
            }
        });
    }

    private void addControls() {
        chkSavingUsername = (CheckBox) findViewById(R.id.chkSavingUsername);
        imgBtnRegister = (ImageButton) findViewById(R.id.imgBtnRegister);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        // Retrieve an instance of your database using getInstance().
        firebaseDatabase = FirebaseDatabase.getInstance();
        // Reference the location you want to write to.
        databaseReference = firebaseDatabase.getReference("Users");
    }
}
