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

public class MainActivity2 extends AppCompatActivity {
    public EditText Email,Password;
    public Button Sign;
    public TextView Signup;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mFirebaseAuth=FirebaseAuth.getInstance();
        Email=findViewById(R.id.EmailAddress);
        Password=findViewById(R.id.Password);
        Sign =findViewById(R.id.SignUp);
        Signup =findViewById(R.id.txtSignin);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull @org.jetbrains.annotations.NotNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser=mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser !=null)
                {
                    Toast.makeText(MainActivity2.this, "You're logged in!", Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(MainActivity2.this,Home_Activity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity2.this, "Please Log In!", Toast.LENGTH_SHORT).show();
                }


            }
        };
        Sign.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(MainActivity2.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty()&& pw.isEmpty()))
                {
                    mFirebaseAuth.signInWithEmailAndPassword(email,pw).addOnCompleteListener(MainActivity2.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity2.this, "LogIn Error!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Intent intHome=new Intent(MainActivity2.this,Home_Activity.class);
                                startActivity(intHome);
                            }
                        }

                    });
                }
                else
                {
                    Toast.makeText(MainActivity2.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity2.this,MainActivity.class);
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
