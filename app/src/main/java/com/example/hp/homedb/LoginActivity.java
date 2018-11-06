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

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bs;
    private EditText e1,e2;
    private TextView tv;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),Home.class));
        }

        bs=(Button)findViewById(R.id.bs);
        e1=(EditText)findViewById(R.id.em1);
        e2=(EditText)findViewById(R.id.ep1);
        tv=(TextView)findViewById(R.id.tv);

        bs.setOnClickListener(this);
        tv.setOnClickListener(this);
    }

    private void userLogin()
    {

        String email=e1.getText().toString().trim();
        String password=e2.getText().toString().trim();
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
        progressDialog.setMessage("Logging in User...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful())
                {
                    finish();
                    startActivity(new Intent(getApplicationContext(),Home.class));
                }

            }
        });




    }

    @Override
    public void onClick(View view) {
        if(view==bs)
        {
            userLogin();
        }
        if(view==tv)
        {
            finish();
            startActivity(new Intent(this,FirebaseMainActivity.class));
        }
    }
}
