package com.example.creditwahana.Activity;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.creditwahana.API.APIRequestData;
import com.example.creditwahana.API.RetroServer;
import com.example.creditwahana.Activity.Leader.LeaderMainActivity;
import com.example.creditwahana.Activity.Leasing.LeasingMainActivity;
import com.example.creditwahana.Activity.Leasing.LeasingReadActivity;
import com.example.creditwahana.Activity.Sales.SalesMainActivity;
import com.example.creditwahana.Model.Login.Login;
import com.example.creditwahana.Model.Login.LoginData;
import com.example.creditwahana.R;
import com.example.creditwahana.SessionManager;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etUsername, etPassword;
    Button btnLogin;
    String Username, Password;
    APIRequestData apiRequestData;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                Username = etUsername.getText().toString();
                Password = etPassword.getText().toString();
                login(Username,Password);
                break;
        }
    }

    private void login(String username, String password) {

        apiRequestData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<Login> loginCall = apiRequestData.LoginResponse(username, password);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){

                    sessionManager = new SessionManager(LoginActivity.this);
                    LoginData loginData = response.body().getLoginData();
                    sessionManager.createLoginSession(loginData);

                    if (sessionManager.isLoggedIn() && sessionManager.getJabatan().equals("sales")){
                        startActivity(new Intent(getApplicationContext(),SalesMainActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
                        finish();
                    } else if (sessionManager.isLoggedIn() && sessionManager.getJabatan().equals("leader")){
                        startActivity(new Intent(getApplicationContext(),LeaderMainActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
                        finish();
                    } else if (sessionManager.isLoggedIn() && sessionManager.getJabatan().equals("leasing")){
                        startActivity(new Intent(getApplicationContext(),LeasingMainActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
                        finish();
                    } else {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
                        finish();
                    }

                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}