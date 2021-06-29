package com.example.dancefrafic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isGoing = false;
    private int sleepTime = 200;

    private Button btn;
    private TextView b1, b2, b3, b4, b5, b6, b7, b8, b9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
    }

    public void onClick(View v) {
        if (!isGoing) {
            isGoing = true;
            btn.setText("Выключить");
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            while (isGoing) {
                                try {
                                    turnOnLamp();
                                    Thread.sleep(sleepTime);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
            ).start();
        } else {
            isGoing = false;
            turnOffLapm();
            btn.setText("Включить");
        }
    }

    private void turnOnLamp() {
        int randomLamp = getRandomNum(1, 10);
        turnOffLapm();

        switch (randomLamp) {
            case 1: {
                b1.setBackgroundResource(R.color.b1);
                break;
            }

            case 2: {
                b2.setBackgroundResource(R.color.b2);
                break;
            }

            case 3: {
                b3.setBackgroundResource(R.color.b3);
                break;
            }

            case 4: {
                b4.setBackgroundResource(R.color.b4);
                break;
            }

            case 5: {
                b5.setBackgroundResource(R.color.b5);
                break;
            }

            case 6: {
                b6.setBackgroundResource(R.color.b6);
                break;
            }


            case 7: {
                b7.setBackgroundResource(R.color.b7);
                break;
            }

            case 8: {
                b8.setBackgroundResource(R.color.b8);
                break;
            }

            case 9: {
                b9.setBackgroundResource(R.color.b9);
                break;
            }
        }
    }

    private void turnOffLapm() {
        b1.setBackgroundResource(R.color.grey);
        b2.setBackgroundResource(R.color.grey);
        b3.setBackgroundResource(R.color.grey);
        b4.setBackgroundResource(R.color.grey);
        b5.setBackgroundResource(R.color.grey);
        b6.setBackgroundResource(R.color.grey);
        b7.setBackgroundResource(R.color.grey);
        b8.setBackgroundResource(R.color.grey);
        b9.setBackgroundResource(R.color.grey);
    }

    private int getRandomNum(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    @Override
    protected void onDestroy() {
        isGoing = false;
        super.onDestroy();
    }
}
