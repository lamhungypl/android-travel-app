package com.example.endtermandroid.ui.login;

public interface LoginView {
    void openMainActivity();
    void showLoading();
    void dismissLoading();
    void getPermissions();
    void showNetworkError();
    void rememberUserInfo(String email);

    void showMessage(String message);

    void emuSplat(String email,String password);
    void onLoginClick(String email, String password);

    void onGoogleLoginClick();

    void onFacebookLoginClick();
}
