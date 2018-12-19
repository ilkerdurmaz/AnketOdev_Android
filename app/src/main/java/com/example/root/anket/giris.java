package com.example.root.anket;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class giris extends AppCompatActivity {

    Button bgiris;
    EditText etid,etpass;
    Intent kayit,anket,giris;
    HashMap db;
    String id,pass;
    AlertDialog.Builder hata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        kayit=new Intent(getApplicationContext(),kayit.class);
        anket=new Intent(getApplicationContext(),anket.class);
        bgiris=findViewById(R.id.bgiris);
        etid=findViewById(R.id.etid);
        etpass=findViewById(R.id.etpass);
        db=new HashMap();

        giris=getIntent();
        db.put(giris.getStringExtra("id"),giris.getStringExtra("pass"));
        db.put("admin","admin");

        hata=new AlertDialog.Builder(giris.this);
        hata.setTitle("GİRİŞ HATASI");


        hata.setPositiveButton("Kayıt Ol", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                kayit.putExtra("db",db);
                startActivityForResult(kayit,1);
            }
        });

        hata.setNegativeButton("Tekrar Dene", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        bgiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etid.getText().length()>0&&etpass.getText().length()>0)
                {
                    id=etid.getText().toString();
                    pass=etpass.getText().toString();

                    if(db.containsKey(id))
                    {
                        if(pass.equals(db.get(id).toString()))
                        {
                            Toast.makeText(getApplicationContext(),"Başarıyla giriş yaptınız!",Toast.LENGTH_SHORT).show();
                            startActivity(anket);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Şifrenizi yanlış girdiniz!",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        hata.setMessage(id+" adında kayıtlı bir kullanıcı bulunmamaktadır.");
                        hata.show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Alanlar boş olamaz!",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent donen) {
        if (requestCode == 1 && resultCode == RESULT_OK && donen != null) {
            db.put(donen.getStringExtra("id"),donen.getStringExtra("pass"));
        }
    }
}
