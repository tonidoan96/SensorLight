package sensor.example.hienthanh.sensor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnShowSensor;
    private Button btnShowAccelerometer;
    private Button btnShowProximity;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowSensor = (Button) findViewById(R.id.buttonShowListSensor);
        btnShowSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sensor_Light.class);
                startActivity(intent);
            }
        });
        btnShowAccelerometer = (Button) findViewById(R.id.buttonShowAccelerometer);
        btnShowAccelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sensor_Accelerometer.class);
                startActivity(intent);
            }
        });
        btnShowProximity = (Button) findViewById(R.id.buttonShowProximity);
        btnShowProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sensor_Proximity.class);
                startActivity(intent);
            }
        });
    }


}
