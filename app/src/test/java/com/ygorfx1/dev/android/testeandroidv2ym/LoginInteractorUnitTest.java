package com.ygorfx1.dev.android.testeandroidv2ym;

import com.ygorfx1.dev.android.testeandroidv2ym.helpers.Validator;
import com.ygorfx1.dev.android.testeandroidv2ym.loginScreen.LoginContract;
import com.ygorfx1.dev.android.testeandroidv2ym.loginScreen.LoginInteractor;
import com.ygorfx1.dev.android.testeandroidv2ym.models.UserInfo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;


public class LoginInteractorUnitTest {

    LoginContract.Presenter presenter;

    @Mock
    private LoginContract.View view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginInteractor(view);
    }

    /*ErrorUser Test*/
    @Test
    public void errorInvalidUserLoginFail() {
        String user = "testUser";
        presenter.login(user, "p@SSW0RD");
        verify(view, Mockito.never()).loginOK(anyString(), (UserInfo) Mockito.any());
        Assert.assertFalse(Validator.userValidator(user));
    }

    /*ErrorPassword Test*/
    @Test
    public void errorInvalidPasswordLoginFail() {
        String password = "aaaBBBccc";
        presenter.login("example@gmail.com", password);
        verify(view, Mockito.never()).loginOK(anyString(), (UserInfo) Mockito.any());
        Assert.assertFalse(Validator.passwordValidator(password));
    }

    /*ErrorPassword Test*/
    @Test
    public void errorEmptyUserLoginFail() {
        Boolean validUser = Validator.userValidator("");
        Assert.assertFalse(validUser);
    }

    /*ErrorPassword Test*/
    @Test
    public void errorEmptyPasswordLoginFail() {
        Boolean validPassword = Validator.userValidator("");
        Assert.assertFalse(validPassword);
    }

    @Test
    public void WhenLoginIsSuccess() {
        Boolean validUser = Validator.userValidator("ygor@gmail.com");
        Boolean validPassword = Validator.passwordValidator("p@SSW0RD");

        Assert.assertEquals(true, validUser);
        Assert.assertEquals(true, validPassword);
    }
}