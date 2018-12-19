package com.example.root.anket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class kayit extends AppCompatActivity{


    Button bkayit;
    EditText etid2,etpass2;
    String id,pass;
    CheckBox cbkabul;
    Intent donus;
    HashMap db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        donus=getIntent();
        etid2=findViewById(R.id.etid2);
        etpass2=findViewById(R.id.etpass2);
        bkayit=findViewById(R.id.bkayit);
        cbkabul=findViewById(R.id.cbkabul);
        db=(HashMap) donus.getSerializableExtra("db");

        bkayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etid2.getText().length()>0&&etpass2.getText().length()>0)
                {
                    if(cbkabul.isChecked())
                    {
                        if(!db.containsKey(etid2.getText().toString()))
                        {
                            donus.putExtra("id",etid2.getText().toString());
                            donus.putExtra("pass",etpass2.getText().toString());
                            Toast.makeText(getApplicationContext(),"Başarıyla kayıt oldunuz, şimdi giriş yapabilirsiniz!",Toast.LENGTH_SHORT).show();
                            setResult(RESULT_OK,donus);
                            finish();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Böyle bir kullanıcı bulunmaktadır!",Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Sözleşmeyi kabul etmelisiniz!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Alanlar boş olamaz!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
