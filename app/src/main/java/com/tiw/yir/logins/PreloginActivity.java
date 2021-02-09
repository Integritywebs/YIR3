package com.tiw.yir.logins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.shobhitpuri.custombuttons.GoogleSignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.tiw.yir.R;
import com.tiw.yir.activity.MainActivity;
import com.tiw.yir.helper.Common;
import com.tiw.yir.helper.SaveSharedPreference;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class PreloginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButtonFacebook;
    GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 100;
    private CallbackManager callbackManager;
    private LoginManager loginManager;
    private Button btnSignUp,btnLogin ;
    GoogleSignInButton signInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printHashKey();
        FacebookSdk.sdkInitialize(PreloginActivity.this);
        callbackManager = CallbackManager.Factory.create();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        facebookLogin();
        if (Common.isInternetAvailable(this)) {
            setContentView(R.layout.activity_prelogin);
            inIt();
        } else {
            setContentView(R.layout.error_layout);
        }
        if (SaveSharedPreference.getLoggedStatus(this)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void inIt() {
        btnSignUp=findViewById(R.id.btnSignUp);
        btnLogin=findViewById(R.id.btnLogin);
        signInButton = findViewById(R.id.signInButton);
        mButtonFacebook =findViewById(R.id.button_facebook);
        btnSignUp.setOnClickListener(this::onClick);
        btnLogin.setOnClickListener(this::onClick);
        mButtonFacebook.setOnClickListener(this::onClick);
        signInButton.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View view) {
        int vId=view.getId();

        if (vId==R.id.btnSignUp){
            Intent intent=new Intent(this,RegistrationActivity.class);
            startActivity(intent);
            finish();
        }else if(vId==R.id.signInButton){
            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        }
        else if(vId==R.id.button_facebook){
            loginManager.logInWithReadPermissions(
                    PreloginActivity.this,
                    Arrays.asList(
                            "email",
                            "public_profile",
                            "user_birthday"));
        }
        else if (vId==R.id.btnLogin){
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("Message",e.toString());

        }
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode,
                                 Intent data)
    {

        // add this line
        callbackManager.onActivityResult(
                requestCode,
                resultCode,
                data);

        super.onActivityResult(requestCode,
                resultCode,
                data);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    public void facebookLogin()
    {

        loginManager
                = LoginManager.getInstance();
        callbackManager
                = CallbackManager.Factory.create();

        loginManager
                .registerCallback(
                        callbackManager,
                        new FacebookCallback<LoginResult>() {

                            @Override
                            public void onSuccess(LoginResult loginResult)
                            {
                                GraphRequest request = GraphRequest.newMeRequest(

                                        loginResult.getAccessToken(),

                                        new GraphRequest.GraphJSONObjectCallback() {

                                            @Override
                                            public void onCompleted(JSONObject object,
                                                                    GraphResponse response)
                                            {

                                                if (object != null) {
                                                    try {
                                                        String name = object.getString("name");
                                                        String email = object.getString("email");
                                                        String fbUserID = object.getString("id");

                                                        disconnectFromFacebook();

                                                        // do action after Facebook login success
                                                        // or call your API
                                                    }
                                                    catch (JSONException | NullPointerException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                        });

                                Bundle parameters = new Bundle();
                                parameters.putString(
                                        "fields",
                                        "id, name, email, gender, birthday");
                                request.setParameters(parameters);
                                request.executeAsync();
                            }
                            public void disconnectFromFacebook()
                            {
                                if (AccessToken.getCurrentAccessToken() == null) {
                                    return; // already logged out
                                }

                                new GraphRequest(
                                        AccessToken.getCurrentAccessToken(),
                                        "/me/permissions/",
                                        null,
                                        HttpMethod.DELETE,
                                        new GraphRequest
                                                .Callback() {
                                            @Override
                                            public void onCompleted(GraphResponse graphResponse)
                                            {
                                                LoginManager.getInstance().logOut();
                                            }
                                        })
                                        .executeAsync();
                            }

                            @Override
                            public void onCancel()
                            {

                                  Log.v("LoginScreen", "---onCancel");
                            }

                            @Override
                            public void onError(FacebookException error)
                            {
                                // here write code when get error
                                Log.v("LoginScreen", "----onError: "
                                        + error.getMessage());
                            }
                        });
    }
    public void
    printHashKey()
    {

        // Add code to print out the key hash
        try {

            PackageInfo info
                    = getPackageManager().getPackageInfo(
                    "com.android.facebookloginsample",
                    PackageManager.GET_SIGNATURES);

            for (Signature signature : info.signatures) {

                MessageDigest md
                        = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:",
                        Base64.encodeToString(
                                md.digest(),
                                Base64.DEFAULT));
            }
        }

        catch (PackageManager.NameNotFoundException e) {
        }

        catch (NoSuchAlgorithmException e) {
        }
    }
}