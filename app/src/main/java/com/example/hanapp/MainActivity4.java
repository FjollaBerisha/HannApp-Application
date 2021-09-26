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
import org.jetbrains.annotations.NotNull;

public class MainActivity4 extends AppCompatActivity {
    public EditText Email,Password;
    public Button btnsign;
    public TextView Signup;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mFirebaseAuth=FirebaseAuth.getInstance();
        Email=findViewById(R.id.EmailAddress);
        Password=findViewById(R.id.Password);
        btnsign=findViewById(R.id.btnSignin);
        Signup =findViewById(R.id.txtSignup);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull @org.jetbrains.annotations.NotNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser=mFirebaseAuth.getCurrentUser();



            }
        };
        btnsign.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(MainActivity4.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty()&& pw.isEmpty()))
                {
                    mFirebaseAuth.signInWithEmailAndPassword(email,pw).addOnCompleteListener(MainActivity4.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull  Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity4.this, "LogIn Error!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Intent intHome=new Intent(MainActivity4.this,Home_Activity.class);
                                startActivity(intHome);
                            }
                        }

                    });
                }
                else
                {
                    Toast.makeText(MainActivity4.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity4.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
    protected  void  onStart()
    {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener );

    }
    }
