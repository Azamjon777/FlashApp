package com.example.fonarik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnFlash;
    private FlashClass flashClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init(){
        btnFlash = findViewById(R.id.btn1);
        flashClass = new FlashClass(this);
    }

    public void onClick(View view) {
        if (flashClass.isFlashStatus()) {
            flashClass.flashOff();
            btnFlash.setText(R.string.on);
            btnFlash.setBackgroundResource(R.drawable.circle_green);
        } else {
            flashClass.flashOn();
            btnFlash.setText(R.string.off);
            btnFlash.setBackgroundResource(R.drawable.circle_red);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (flashClass.isFlashStatus()){
            flashClass.flashOff();
        }
    }
}





