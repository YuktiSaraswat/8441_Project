package com.example.hack1;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class F1 extends Fragment {

    TextView t1,t2,t3,t4,t5;
    ImageButton i;
    TextToSpeech textToSpeech;
    public F1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_f1, container, false);
        i = (ImageButton)v.findViewById(R.id.i);
        t1 = (TextView)v.findViewById(R.id.t1);
        t2 = (TextView)v.findViewById(R.id.t2);
        t3 = (TextView)v.findViewById(R.id.t3);
        t4 = (TextView)v.findViewById(R.id.t4);
        t5 = (TextView)v.findViewById(R.id.t5);
        textToSpeech=new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                    int lang=textToSpeech.setLanguage(Locale.forLanguageTag("hin"));
                }
            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=t1.getText().toString()+"."+t2.getText().toString()+"..."+t3.getText().toString()+".."+t4.getText().toString()+"..."+t5.getText().toString();
                int speech1=textToSpeech.speak(s1,TextToSpeech.QUEUE_FLUSH,null);
                /*String s2=t2.getText().toString();
                int speech2=textToSpeech.speak(s2,TextToSpeech.QUEUE_FLUSH,null);
                String s3=t3.getText().toString();
                int speech3=textToSpeech.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
                String s4=t4.getText().toString();
                int speech4=textToSpeech.speak(s4,TextToSpeech.QUEUE_FLUSH,null);
                String s5=t5.getText().toString();
                int speech=textToSpeech.speak(s5,TextToSpeech.QUEUE_FLUSH,null);*/
            }
        });



        return v;
    }
    public void link(View view){
        Intent i=new Intent(Intent.ACTION_VIEW);
        String url="https://hi.wikipedia.org/wiki/%E0%A5%A8%E0%A5%A6%E0%A5%A8%E0%A5%A6_%E0%A4%AD%E0%A4%BE%E0%A4%B0%E0%A4%A4_%E0%A4%AE%E0%A5%87%E0%A4%82_%E0%A4%95%E0%A5%8B%E0%A4%B0%E0%A5%8B%E0%A4%A8%E0%A4%BE%E0%A4%B5%E0%A4%BE%E0%A4%AF%E0%A4%B0%E0%A4%B8_%E0%A4%AE%E0%A4%B9%E0%A4%BE%E0%A4%AE%E0%A4%BE%E0%A4%B0%E0%A5%80";
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    public void onDestroyView() {
        if(textToSpeech!=null)
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroyView();
    }
}
