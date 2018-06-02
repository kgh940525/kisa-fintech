package com.kisa.kgh.kisa_fintech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kisa.kgh.kisa_fintech.network.RetrofitManager;
import com.kisa.kgh.kisa_fintech.network.module.ResponseModule;
import com.kisa.kgh.kisa_fintech.utils.LoginInstance;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SOHYUN on 2018-06-02.
 */

public class LoginActivity extends AppCompatActivity {
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    EditText Email, Password;
    Button Login;
    TextView Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        RetrofitManager.getInstance().init();

        Email = findViewById(R.id.edtEmail);
        Password = findViewById(R.id.edtPassword);
        Signup = findViewById(R.id.btnSignup);
        Login = findViewById(R.id.btnLogIn);
    }

    private boolean isLogin;

    public void onLoginClicked(View v) {     // 로그인 버튼 클릭

        ResponseModule module = new ResponseModule(Email.getText().toString().trim(), Password.getText().toString().trim());

        RetrofitManager.getRetrofitMethod().signInCheck(module)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseModule>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ResponseModule responseModule) {
                        String code = responseModule.getCode();

                        Log.e("Code",code+"");
                        if (code.equals("2100")) {
                            LoginInstance.getInstance().setId(Email.getText().toString().trim());
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            isLogin = true;
                        } else {
                            Toast.makeText(getApplicationContext(), "로그인 정보가 잘못됐습니다.", Toast.LENGTH_SHORT).show();
                            isLogin = false;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Login Error", e.toString());
                    }

                    @Override
                    public void onComplete() {
                        if(isLogin) {
                            finish();
                        }
                    }
                });

    }

    protected void onSignUpClicked(View v) {    // 회원가입 버튼 클릭
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivityForResult(intent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == RESULT_OK) {
            Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
            Email.setText(data.getStringExtra("email"));
        }
    }
}
