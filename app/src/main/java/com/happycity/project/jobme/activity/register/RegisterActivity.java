package com.happycity.project.jobme.activity.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.happycity.project.jobme.R;
import com.happycity.project.jobme.activity.LoginActivity;

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
    private EditText edtEmal;
    private EditText edtPassword;
    private ImageButton imgBtnNext2;
    private ImageButton imgBtnBack2;

    // Part of phone.
    private LinearLayout llPhone;
    private EditText edtPhone;
    private ImageButton imgBtnNext3;
    private ImageButton imgBtnBack3;

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
        // Send email to confirm.
        imgBtnNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, VerifyPhoneNumber.class);
                startActivity(intent);
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
    }

    private void addControls() {
        imgBtnBackArrow = (ImageButton) findViewById(R.id.imgBtnBackArrow);

        llName = (LinearLayout) findViewById(R.id.llName);
        edtFirstName = (EditText) findViewById(R.id.edtFirstName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);
        imgBtnNext1 = (ImageButton) findViewById(R.id.imgBtnNext1);

        llAccount = (LinearLayout) findViewById(R.id.llAccount);
        edtEmal = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        imgBtnNext2 = (ImageButton) findViewById(R.id.imgBtnNext2);
        imgBtnBack2 = (ImageButton) findViewById(R.id.imgBtnBack2);

        llPhone = (LinearLayout) findViewById(R.id.llPhone);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        imgBtnNext3 = (ImageButton) findViewById(R.id.imgBtnNext3);
        imgBtnBack3 = (ImageButton) findViewById(R.id.imgBtnBack3);
    }
}
