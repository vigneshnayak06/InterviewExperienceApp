package com.example.hp.homedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth firebaseAuth;

    private CardView bankcard,ideascard,wificard,linkscard,addcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bankcard=(CardView)findViewById(R.id.bank_card);
        ideascard=(CardView)findViewById(R.id.ideas_card);
        wificard=(CardView)findViewById(R.id.wifi_card);
        linkscard=(CardView)findViewById(R.id.links_card);
        addcard=(CardView)findViewById(R.id.add_card);
        bankcard.setOnClickListener(this);
        ideascard.setOnClickListener(this);
        wificard.setOnClickListener(this);
        linkscard.setOnClickListener(this);
        addcard.setOnClickListener(this);

        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        FirebaseUser user=firebaseAuth.getCurrentUser();
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId())
        {
            case R.id.bank_card : i = new Intent(this,Bank.class); startActivity(i);break;
            case R.id.ideas_card : i = new Intent(this,Ideas.class); startActivity(i);break;
            case R.id.wifi_card : i = new Intent(this,support.class); startActivity(i);break;
            case R.id.links_card : i = new Intent(this,Links.class); startActivity(i);break;
            case R.id.add_card : i = new Intent(this,Add.class); startActivity(i);break;
            default:break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
