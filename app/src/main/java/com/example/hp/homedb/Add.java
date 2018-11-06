package com.example.hp.homedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class Add extends AppCompatActivity {

    private EditText feed;
    private EditText ename;
    private EditText email;
    private RatingBar rb;
    private TextView tvRateCount,tvRateMessage;
    private float ratedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ename=findViewById(R.id.EditTextName);
        email=findViewById(R.id.EditTextEmail);
        feed=findViewById(R.id.EditTextFeedbackBody);
        rb=findViewById(R.id.rb);
        tvRateCount = (TextView) findViewById(R.id.tvRateCount);
        tvRateMessage = (TextView) findViewById(R.id.tvRateMessage);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar,float rating,boolean fromUser) {
                ratedValue = ratingBar.getRating();
                tvRateCount.setText("Your Rating : " + ratedValue + "/5.");

                if(ratedValue<1){
                    tvRateMessage.setText("Oops...");

                }else if(ratedValue<2){
                    tvRateMessage.setText("Ok.");

                }else if(ratedValue<3){
                    tvRateMessage.setText("Not bad.");

                }else if(ratedValue<4){
                    tvRateMessage.setText("Nice");

                }else if(ratedValue<5){
                    tvRateMessage.setText("Very Nice");

                }else if(ratedValue==5){
                    tvRateMessage.setText("Thank you..!!!");
                }
            }
        });

        Button buttonSend=findViewById(R.id.button_send2);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });

    }
    private void sendMail()
    {
        String[] recipientList = new String[]{"vigneshnayak06@gmail.com"};
        String subject=("Feedback Application");
        String message = "From:  "+ename.getText().toString() + "\n" +
                        "Email:  "+email.getText().toString()+"\n" +
                        "Feedback Details:  "+feed.getText().toString()+"\n" +
                        tvRateCount.getText().toString() +"\n" +
                        "Rate message:  "+tvRateMessage.getText().toString();


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipientList);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
    }

