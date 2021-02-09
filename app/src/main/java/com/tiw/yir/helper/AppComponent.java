package com.tiw.yir.helper;



import com.tiw.yir.logins.LoginActivity;
import com.tiw.yir.logins.PreloginActivity;
import com.tiw.yir.logins.RegistrationActivity;
import com.tiw.yir.logins.SplashActivity;

import javax.inject.Singleton;

@Singleton
public interface AppComponent {
    void inject(AppModule appModule);
    void inject(SplashActivity splashScreenActivity);
    void inject(RegistrationActivity registrationActivity);
    void inject(PreloginActivity preloginActivity);
    void inject(LoginActivity loginActivity);
}