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

public class MainActivity extends AppCompatActivity {

public EditText Email,Password;
public Button Signup;
public TextView SignIn;
FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth=FirebaseAuth.getInstance();

        Email=findViewById(R.id.EmailAddress);
        Password=findViewById(R.id.Password);
        Signup=findViewById(R.id.SignUp);
        SignIn=findViewById(R.id.txtSignin);


        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                else if(email.isEmpty()&& pw.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty()&& pw.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pw).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull  Task<AuthResult> task)
                        {
                            if (!task.isSuccessful())
                            {
                                Toast.makeText(MainActivity.this, "SignUp Unsuccessful!", Toast.LENGTH_SHORT).show();

                            }
                            else
                            {
                                startActivity(new Intent(MainActivity.this,Home_Activity.class));
                            }

                        }
                    });
                }
                else
                    {
                        Toast.makeText(MainActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                    }

            }
        });
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,MainActivity4.class);
                startActivity(i);
            }
        });





    }
}