package com.example.ali.unittestingusingmvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginView{

    private Button login;
    private EditText username;
    private EditText password;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        presenter = new Presenter(this);
    }

    public void Login(View view){
        presenter.onLogin();
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void showEmptyPassword() {
        Toast.makeText(getApplicationContext(), " password is empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmptyUsername() {
        Toast.makeText(getApplicationContext(), "username is empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmptyUsernameAndPassword() {
        Toast.makeText(getApplicationContext(), "username and password is empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToWellcome() {
        Intent intent = new Intent(this, Wellcome.class);
        startActivity(intent);
    }
}
