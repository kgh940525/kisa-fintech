package com.kisa.kgh.kisa_fintech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SOHYUN on 2018-06-02.
 */

public class LoginActivity extends AppCompatActivity {

    EditText Email, Password;
    Button Login;
    TextView Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.edtEmail);
        Password = findViewById(R.id.edtPassword);
        Signup = findViewById(R.id.btnSignup);
        Login = findViewById(R.id.btnLogIn);
    }

    protected void onLoginClicked(View v) {     // 로그인 버튼 클릭
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

    protected void onSignUpClicked(View v) {    // 회원가입 버튼 클릭
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivityForResult(intent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1000 && resultCode == RESULT_OK) {
            Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
            Email.setText(data.getStringExtra("email"));
        }
    }
}
