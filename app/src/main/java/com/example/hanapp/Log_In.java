package com.example.hanapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Log_In extends AppCompatActivity {
    public EditText Email,Password;
    public Button Sign;
    public TextView Signup;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mFirebaseAuth=FirebaseAuth.getInstance();
        Email=findViewById(R.id.EmailAddress);
        Password=findViewById(R.id.Password);
        Sign =findViewById(R.id.SignUp);
        Signup =findViewById(R.id.txtSignin);

        mAuthStateListener = firebaseAuth -> {
            FirebaseUser mFirebaseUser=mFirebaseAuth.getCurrentUser();
            if (mFirebaseUser !=null)
            {
                Toast.makeText(Log_In.this, "Sign in Successful!", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Log_In.this,Home_Activity.class);
                startActivity(i);

            }
            else
            {
                Toast.makeText(Log_In.this, "Please Sign In", Toast.LENGTH_SHORT).show();
            }


        };
        Sign.setOnClickListener(view -> {
            String email=Email.getText().toString();
            String pw=Password.getText().toString();
            if (email.isEmpty())
            {
                Email.setError("Please fill in your Email!");
                Email.requestFocus();
            }
            else if(pw.isEmpty())
            {
                Password.setError("Please fill in your Password!");
                Password.requestFocus();
            }
            else if((email.isEmpty()&& pw.isEmpty()))
            {
                Toast.makeText(Log_In.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
            }
            else if(!(email.isEmpty()&& pw.isEmpty()))
            {
                mFirebaseAuth.signInWithEmailAndPassword(email,pw).addOnCompleteListener(Log_In.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull  Task<AuthResult> task)
                    {
                            if (!task.isSuccessful())
                            {
                                Toast.makeText(Log_In.this, "Log In Error,Please Login Again", Toast.LENGTH_SHORT).show();

                            }
                            else
                                {
                                    Intent intHome=new Intent(Log_In.this,Home_Activity.class);
                                    startActivity(intHome);

                                }


                    }
                });

                    }
            else
                {

                    Toast.makeText(Log_In.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                }

            });
          Signup.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent IntSignUp=new Intent(Log_In.this,MainActivity.class);
                  startActivity(IntSignUp);
              }
          });



    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);


    }
}