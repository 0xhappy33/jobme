package com.happycity.project.jobme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.happycity.project.jobme.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseRoleActivity extends AppCompatActivity {

    @BindView(R.id.btnLookingForAJob)
    Button btnLookingForAJob;

    @BindView(R.id.btnLookingForAStaff)
    Button btnLookingForAStaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_role);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLookingForAStaff)
    public void onClickButtonStaff(){
        switchToLoginScreen();
    }
    @OnClick(R.id.btnLookingForAJob)
    public void onClickButtonJob(){
        switchToLoginScreen();
    }

    private void switchToLoginScreen(){
        Intent loginIntent = new Intent(ChooseRoleActivity.this, LoginActivity.class);
        startActivity(loginIntent);
    }
}
