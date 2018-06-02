package com.kisa.kgh.kisa_fintech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by SOHYUN on 2018-06-02.
 */

public class SignUpActivity extends AppCompatActivity {

    EditText edtName, edtEmail, edtPassword, edtPasswordConfirm;
    Button btnSignUpDone;
    RadioGroup rgGender;
    RadioButton btnNongbu, btnInvestor;
    ImageView ic_warning1, ic_warning2, ic_warning3, ic_warning4, ic_warning5;
    TextView warning1_text, warning2_text, warning3_text, warning4_text, warning5_text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtPasswordConfirm = findViewById(R.id.edtPasswordConfirm);
        btnSignUpDone = findViewById(R.id.btnSignUpDone);

        ic_warning1 = findViewById(R.id.ic_warning1);
        ic_warning2 = findViewById(R.id.ic_warning2);
        ic_warning3 = findViewById(R.id.ic_warning3);
        ic_warning4 = findViewById(R.id.ic_warning4);
        ic_warning5 = findViewById(R.id.ic_warning5);

        warning1_text = findViewById(R.id.warning1_text);
        warning2_text = findViewById(R.id.warning2_text);
        warning3_text = findViewById(R.id.warning3_text);
        warning4_text = findViewById(R.id.warning4_text);
        warning5_text = findViewById(R.id.warning5_text);

        // 이름 입력 검사
        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name = edtName.getText().toString();
                if((name.length() == 0) || (edtName.getText().toString().length() > 8)) {
                    ic_warning1.setVisibility(View.VISIBLE);
                    warning1_text.setVisibility(View.VISIBLE);
                    return;
                } else {
                    ic_warning1.setVisibility(View.INVISIBLE);
                    warning1_text.setVisibility(View.INVISIBLE);
                    return;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // 사용자구분 검사
        rgGender = findViewById(R.id.rgGender);
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.btnNongbu:
                        Toast.makeText(getApplicationContext(), "사업자 선택", Toast.LENGTH_SHORT).show();
                        ic_warning2.setVisibility(View.INVISIBLE);
                        warning2_text.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.btnInvestor:
                        Toast.makeText(getApplicationContext(), "투자자 선택", Toast.LENGTH_SHORT).show();
                        ic_warning2.setVisibility(View.INVISIBLE);
                        warning2_text.setVisibility(View.INVISIBLE);
                        break;
                }

            }
        });

        // 이메일 유효성 검사
        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if((edtEmail.getText().toString().length() == 0) || !Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,6}$", edtEmail.getText().toString())) {
                    ic_warning3.setVisibility(View.VISIBLE);
                    warning3_text.setVisibility(View.VISIBLE);
                    return;
                } else {
                    ic_warning3.setVisibility(View.INVISIBLE);
                    warning3_text.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        // 비밀번호 유효성 검사
        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if((edtPassword.getText().toString().length() == 0) || !Pattern.matches("^(?=.*[a-zA-Z])(?=.*[0-9]).{9,14}$", edtPassword.getText().toString())) {
                    ic_warning4.setVisibility(View.VISIBLE);
                    warning4_text.setVisibility(View.VISIBLE);
                    return;
                } else {
                    ic_warning4.setVisibility(View.INVISIBLE);
                    warning4_text.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        //비밀번호 일치 검사
        edtPasswordConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
                String password = edtPassword.getText().toString();
                String confirm = edtPasswordConfirm.getText().toString();

                if(password.equals(confirm)) {
                    ic_warning5.setVisibility(View.INVISIBLE);
                    warning5_text.setVisibility(View.INVISIBLE);
                } else {
                    ic_warning5.setVisibility(View.VISIBLE);
                    warning5_text.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });



        // 가입하기 버튼
        btnSignUpDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 이름 입력 했는지
                if (edtName.getText().toString().length() == 0) {
                    ic_warning1.setVisibility(View.VISIBLE);
                    warning1_text.setVisibility(View.VISIBLE);
                    return;
                }
//                //사용자구분 체크 했는지 //오류남
//                if (!(btnNongbu.isChecked()) && !(btnInvestor.isChecked())) {
//                    ic_warning2.setVisibility(View.VISIBLE);
//                    warning2_text.setVisibility(View.VISIBLE);
//                    return;
//                }
                // 이메일 입력 했는지
                if (edtEmail.getText().toString().length() == 0) {
                    ic_warning3.setVisibility(View.VISIBLE);
                    warning3_text.setVisibility(View.VISIBLE);
                    return;
                }
                // 비밀번호 입력 했는지
                if (edtPassword.getText().toString().length() == 0) {
                    ic_warning4.setVisibility(View.VISIBLE);
                    warning4_text.setVisibility(View.VISIBLE);
                    return;
                }
                // 비밀번호확인 입력했는지
                if (edtPasswordConfirm.getText().toString().length() == 0) {
                    ic_warning5.setVisibility(View.VISIBLE);
                    warning5_text.setVisibility(View.VISIBLE);
                    return;
                }


                Intent result = new Intent();
                result.putExtra("email", edtEmail.getText().toString());

                setResult(RESULT_OK, result);
                finish();


            }
        });

    }
}
