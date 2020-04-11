package com.example.hack1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Contact extends AppCompatActivity {
    TextView marquee;
TextView tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        marquee=(TextView)findViewById(R.id.textcontact);
        marquee.setSelected(true);
        tt=(TextView)findViewById(R.id.tt);
        tt.setText("https://api.whatsapp.com/send?phone=919013151515&text=&source=&data=&app_absent=");
    }
}

