package com.ygorfx1.dev.android.testeandroidv2ym.loginScreen;

import com.ygorfx1.dev.android.testeandroidv2ym.models.UserInfo;

public interface LoginInteractor {

    interface View {
        void loginOK(String user, UserInfo userInfo);

        void loginError(Error error);

        void loginError(int error);
    }

    interface Presenter {
        void login(String user, String password);
    }
}
