package com.example.hp.homedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class respective_exp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_exp);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        String n=b.getString("pdf_name");
       // Toast.makeText(this,n,Toast.LENGTH_SHORT).show();
        PDFView pdfV= (PDFView)findViewById(R.id.pdfView);
        pdfV.fromAsset(n).load();
    }
}
