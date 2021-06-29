package com.example.traficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout green, yellow, red;
    private Button btn;
    private String nextColor = "green";

    private boolean isGoing = false;

    final int sleepTime = 1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        green = (LinearLayout) findViewById(R.id.green);
        yellow = (LinearLayout) findViewById(R.id.yellow);
        red = (LinearLayout) findViewById(R.id.red);

        btn = (Button) findViewById(R.id.button);

    }

    public void click(View v) {
            if (!isGoing) {
                isGoing = true;
                btn.setText("Stop");

                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                while (isGoing) {
                                    try {
                                        switch (nextColor) {

                                            // for green
                                            case "green": {
                                                red.setBackgroundResource(R.color.grey);
                                                green.setBackgroundResource(R.color.green);
                                                nextColor = "yellow";
                                                break;
                                            }

                                            // for yellow
                                            case "yellow": {
                                                green.setBackgroundResource(R.color.grey);
                                                yellow.setBackgroundResource(R.color.yellow);
                                                nextColor = "red";
                                                break;
                                            }

                                            // for red
                                            case "red": {
                                                yellow.setBackgroundResource(R.color.grey);
                                                red.setBackgroundResource(R.color.red);
                                                nextColor = "green";
                                                break;
                                            }

                                        }
                                        Thread.sleep(sleepTime);

                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                ).start();
            } else {
                btn.setText("Start");
                isGoing = false;
                nextColor="green";

                green.setBackgroundResource(R.color.grey);
                yellow.setBackgroundResource(R.color.grey);
                red.setBackgroundResource(R.color.grey);

            }
    }


    @Override
    protected void onDestroy() {
        isGoing = false;
        super.onDestroy();
    }


}