package com.example.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv0, tv1, tv2;
    int mode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv0 = findViewById(R.id.textView0);
        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);

        registerForContextMenu(tv0);
        registerForContextMenu(tv1);
        registerForContextMenu(tv2);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if (v.getId() == R.id.textView0) {
            mode = 1;
        } else if (v.getId() == R.id.textView1) {
            mode = 2;
        } else {
            mode = 3;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tv0.setText("DBS");
            tv1.setText("OCBC");
            tv2.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tv0.setText("星展银行");
            tv1.setText("华侨银行");
            tv2.setText("大华银行");
            return true;
        } else {
            tv0.setText("Error translation");
            tv1.setText("Error translation");
            tv2.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (mode == 1) {
            if (id == 0) {
                Intent intentDBS = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentDBS);
            } else if (id == 1) {
                Intent intentCalldbs = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + 1111111));
                startActivity(intentCalldbs);
            }
        }
        if (mode == 2) {
            if (id == 0) {
                Intent intentOCBC = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentOCBC);
            }
            else if (id == 1) {
                Intent intentCallOCBC = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + 3633333));
                startActivity(intentCallOCBC); }}
                if (mode == 3) {
                if (id == 0) {
                    Intent intentUOB = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                    startActivity(intentUOB);
                } else if (id == 1) {
                    Intent intentCallUOB = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + 2222121));
                    startActivity(intentCallUOB);
                }
            }

            return super.onContextItemSelected(item);


    }
}
