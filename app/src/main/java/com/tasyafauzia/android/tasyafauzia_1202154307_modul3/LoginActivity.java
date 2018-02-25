package com.tasyafauzia.android.tasyafauzia_1202154307_modul3;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(LoginActivity.this,ListMenu.class);
                intent.putExtra("username",username.getText().toString());
                intent.putExtra("password", password.getText().toString());
                startActivity(intent);

                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if(usernameKey.equals("admin") && passwordKey.equals("MOBILE") || (usernameKey.equals("EAD") && passwordKey.equals("MOBILE"))){
                    Toast.makeText(getApplicationContext(), ";Login Sukses...!", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Username atau Password Anda Salah....!")
                            .setNegativeButton("Retry...", null).create().show();
                }

            }
        });
    }
}