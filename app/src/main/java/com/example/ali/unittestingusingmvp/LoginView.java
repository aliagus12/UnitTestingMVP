package com.example.ali.unittestingusingmvp;

/**
 * Created by ali on 20/11/17.
 */

interface LoginView {
    String getUsername();

    String getPassword();

    void showEmptyPassword();

    void showEmptyUsername();

    void showEmptyUsernameAndPassword();

    void goToWellcome();
}
