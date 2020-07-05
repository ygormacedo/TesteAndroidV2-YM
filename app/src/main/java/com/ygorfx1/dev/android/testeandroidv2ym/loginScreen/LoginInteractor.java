package com.ygorfx1.dev.android.testeandroidv2ym.loginScreen;

import com.ygorfx1.dev.android.testeandroidv2ym.R;
import com.ygorfx1.dev.android.testeandroidv2ym.helpers.Validator;
import com.ygorfx1.dev.android.testeandroidv2ym.models.ResponseLoginUser;
import com.ygorfx1.dev.android.testeandroidv2ym.network.ApiConfig;
import com.ygorfx1.dev.android.testeandroidv2ym.network.Login;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor implements LoginContract.Presenter {

    private LoginContract.View view;

    public LoginInteractor(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void login(final String user, String password) {

        Boolean resultUser = Validator.userValidator(user);
        Boolean resultPassword = Validator.passwordValidator(password);

        if (!resultUser) {
            view.loginError(R.string.error_user_login);
            return;
        } else if (!resultPassword) {
            view.loginError(R.string.error_password_login);
            return;
        } else {
            //Call conection to DataBase
            HashMap loginDataObject = new HashMap();
            loginDataObject.put("user", user);
            loginDataObject.put("password", password);

            Login loginClient = ApiConfig.create(Login.class);
            Call<ResponseLoginUser> call = loginClient.login(loginDataObject);
            call.enqueue(new Callback<ResponseLoginUser>() {
                @Override
                public void onResponse(Call<ResponseLoginUser> call, Response<ResponseLoginUser> response) {
                    ResponseLoginUser responseLoginCall = response.body();
                    if (response.isSuccessful() && responseLoginCall.getError().getCode() == 0) {
                        view.loginOK(user, responseLoginCall.getUserInfo());
                    } else {
                        view.loginError(responseLoginCall.getError().getCode());
                    }
                }

                @Override
                public void onFailure(Call<ResponseLoginUser> call, Throwable t) {
                    view.loginError(null);
                }
            });
        }

    }
}
