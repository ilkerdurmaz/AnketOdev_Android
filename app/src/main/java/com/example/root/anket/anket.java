package com.example.root.anket;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class anket extends AppCompatActivity {

    Button b;
    EditText e;
    RadioButton r1,r2;
    CheckBox[] c;
    AlertDialog.Builder sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anket);

        b=findViewById(R.id.bt);
        c=new CheckBox[5];
        e=findViewById(R.id.et);

        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);

        c[0]=findViewById(R.id.c1);
        c[1]=findViewById(R.id.c2);
        c[2]=findViewById(R.id.c3);
        c[3]=findViewById(R.id.c4);
        c[4]=findViewById(R.id.c5);

        sonuc=new AlertDialog.Builder(anket.this);
        sonuc.setTitle("SONUÇ");
        sonuc.setNegativeButton("Ağla", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=YyFIKj6yH5Q"));
                startActivity(browserIntent);
            }
        });
        sonuc.setPositiveButton("Kaderini kabullen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=61MR7LuTUIQ"));
                startActivity(browserIntent);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dert;
                int sayac=0;

                for(int i=0;i<5;i++)
                {
                    if(c[i].isChecked())
                        sayac++;
                }

                if(sayac<3)
                    dert="Az";
                else
                    dert="Çok";

                if(r1.isChecked())
                {
                    sonuc.setMessage("Afyonlu, "+dert+" Dertli, "+e.getText()+" kişisiniz.");
                }
                else
                    sonuc.setMessage(dert+" Dertli, "+e.getText()+" Bir Kişisiniz.");

                sonuc.show();
            }
        });
    }
}
