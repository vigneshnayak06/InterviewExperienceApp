package com.example.hp.homedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Student_list extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String company[][]={{"Nikhil Sharma","Ashish Agarwal"},{"Rahul","John K","Shanice","Wasim"},{"Rishi","Gaurav","Prajikta"}};
    ListView lv;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studenytlist);
        Intent i =getIntent();
        Bundle b=i.getExtras();
        lv=(ListView)findViewById(R.id.lv);
        int index=b.getInt("name");
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,company[index]);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String pdf=adapter.getItem(i).toString();
        Intent in=new Intent(this,respective_exp.class);
        pdf+=".pdf";
        in.putExtra("pdf_name",pdf);
        startActivity(in);
    }
}
