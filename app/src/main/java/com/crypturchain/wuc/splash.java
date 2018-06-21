package com.crypturchain.wuc;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class splash extends AppCompatActivity {
    EditText mobile, cCode;
    Button button;
    String url, cc;
    String numchk = "[0-9]{10}";
    String ccchk = "[0-9]{2}";
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mobile = (EditText) findViewById(R.id.mobText);
        cCode = (EditText) findViewById(R.id.ccText);
        button = (Button) findViewById(R.id.sendBtn);




    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);

}

    public void open(View view)

    {
        url = mobile.getText().toString();
        cc = cCode.getText().toString();

        if (mobile.getText().toString().matches(numchk) && cCode.getText().toString().matches(ccchk)) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=" + cc + url));
            startActivity(i);
        } else {
            Toast.makeText(splash.this, "Enter a valid mobile number", Toast.LENGTH_LONG).show();
        }
    }
}
