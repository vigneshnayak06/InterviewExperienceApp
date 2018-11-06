package com.example.hp.homedb;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseMainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button b;
    private EditText et1,et2;
    private TextView tv;
    private ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_main);

        progressDialog=new ProgressDialog(this);
        firebaseAuth= FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),Home.class));
        }

        b=(Button)findViewById(R.id.br);
        et1=(EditText)findViewById(R.id.em);
        et2=(EditText)findViewById(R.id.ep);
        tv=(TextView)findViewById(R.id.tv);

        b.setOnClickListener(this);
        tv.setOnClickListener(this);

    }

    private void registerUser()
    {
        String email=et1.getText().toString().trim();
        String password=et2.getText().toString().trim();

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"Please enter the mail id",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Please enter the password",Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Registering User...");
        progressDialog.show();


        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(),Home.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Failed..Please try again",Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }


    @Override
    public void onClick(View view) {
        if (view==b)
        {
            registerUser();
        }
        if(view==tv)
        {
            startActivity(new Intent(this,LoginActivity.class));
        }

    }
}
