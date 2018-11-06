package com.example.hp.homedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Bank extends AppCompatActivity {
    List<DataItem> lstData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lstData=new ArrayList<>();
        lstData.add(new DataItem(R.drawable.nx,"Nutanix"));
        lstData.add(new DataItem(R.drawable.v,"VMWare"));
        lstData.add(new DataItem(R.drawable.i,"Informatica"));
        lstData.add(new DataItem(R.drawable.m,"MScripts"));
        lstData.add(new DataItem(R.drawable.n,"Netskope"));
        lstData.add(new DataItem(R.drawable.sh,"Siemens Healthineers"));
        lstData.add(new DataItem(R.drawable.g,"Global Delight"));
        lstData.add(new DataItem(R.drawable.si,"Siemens Technology"));
        lstData.add(new DataItem(R.drawable.aq,"Analytics Quotient"));
        lstData.add(new DataItem(R.drawable.a,"Accenture"));
        lstData.add(new DataItem(R.drawable.infy,"Infosys"));


        ListView listView=(ListView)findViewById(R.id.listView);
        CustomAdapter adapter=new CustomAdapter(this,R.layout.itemrow,lstData);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0)
                {
                    Intent intent=new Intent(view.getContext(),Student_list.class);//nutanix
                    intent.putExtra("name",0);
                    startActivityForResult(intent,0);
                }
                else if(position==1)
                {
                    Intent intent=new Intent(view.getContext(),Student_list.class);//vmware
                    intent.putExtra("name",1);
                    startActivityForResult(intent,1);
                }
                else if(position==2)
                {
                    Intent intent=new Intent(view.getContext(),Student_list.class);//informatica4
                    intent.putExtra("name",2);
                    startActivityForResult(intent,2);
                }
                else
                {
                    Intent intent=new Intent(view.getContext(),message_soon.class);//vmware
                    startActivityForResult(intent,3);
                }
               /* if(position==3)
                {
                    Intent intent=new Intent(view.getContext(),VMWare.class);//vmware
                    startActivityForResult(intent,3);
                }
                if(position==4)
                {
                    Intent intent=new Intent(view.getContext(),message_soon.class);//netskope
                    startActivityForResult(intent,4);
                }
                if(position==5)
                {
                    Intent intent=new Intent(view.getContext(),SiemensH.class);//healthcare
                    startActivityForResult(intent,5);
                }
                if(position==6)
                {
                    Intent intent=new Intent(view.getContext(),GlobalDelight.class);//gd
                    startActivityForResult(intent,6);
                }
                if(position==7)
                {
                    Intent intent=new Intent(view.getContext(),respective_exp.class);//seimens
                    startActivityForResult(intent,7);
                }
                if(position==8)
                {
                    Intent intent=new Intent(view.getContext(),AnalyticsQ.class);//analtycs
                    startActivityForResult(intent,8);
                }
                if(position==9)
                {
                    Intent intent=new Intent(view.getContext(),Accenture.class);//accenture
                    startActivityForResult(intent,9);
                }
                if(position==10)
                {
                    Intent intent=new Intent(view.getContext(),Infosys.class);//infosys
                    startActivityForResult(intent,10);
                }*/



            }
        });
    }
}
