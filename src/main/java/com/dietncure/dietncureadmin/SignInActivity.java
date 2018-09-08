package com.dietncure.dietncureadmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dietncure.dietncureadmin.utils.Tools;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText etEmailID, etPassword;
    String email, password;
    AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().setTitle("Sign In");
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {

            Log.d("UID", user.getUid());
            Log.d("Email", user.getEmail());
        }
        etEmailID = findViewById(R.id.editSignInYourEmail);
        etPassword = findViewById(R.id.editSignInPassword);

        /**
         * Button for Sign In and its Fuctionality
         */
        findViewById(R.id.butSignin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = etEmailID.getText().toString().trim();
                password = etPassword.getText().toString().trim();
                if (Tools.validateNormalText(etEmailID) && Tools.validateNormalText(etPassword)) {
                    ad = Tools.getDialog("Logging In...", SignInActivity.this);
                    ad.show();
                    signIn(email, password);
                } else {
                    Tools.initCustomToast(SignInActivity.this, "Empty fields not allowed!");
                }


            }
        });
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        ad.dismiss();
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Successfull signin", "signInWithEmail:success");

                            FirebaseUser user = mAuth.getCurrentUser();
                            Log.d("UID", user.getUid());
                            Log.d("Email", user.getEmail());
                            //TODO: Check for shared pref
                            startActivity(new Intent(SignInActivity.this, MainActivity.class));
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Signin Failed", "signInWithEmail:failure", task.getException());
                            Toast.makeText(SignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

}
