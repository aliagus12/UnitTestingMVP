package com.example.ali.unittestingusingmvp;

/**
 * Created by ali on 20/11/17.
 */

class Presenter {
    private LoginView view;

    public Presenter(LoginView view) {
        this.view = view;
    }

    public void onLogin() {
        String username1 = view.getUsername();
        String password1 = view.getPassword();
        if(!username1.isEmpty() && password1.isEmpty()){
            view.showEmptyPassword();
        } else if(username1.isEmpty() && !password1.isEmpty()){
            view.showEmptyUsername();
        } else if(username1.isEmpty() && password1.isEmpty()){
            view.showEmptyUsernameAndPassword();
        } else if(username1.equals("ali") && password1.equals("12345")){
            view.goToWellcome();
        }
    }
}
