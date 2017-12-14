package sensor.example.hienthanh.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Sensor_Accelerometer extends AppCompatActivity implements SensorEventListener {
    private TextView txtvAccelerometer;
    private SensorManager sensorManager;
    private Sensor sensorAccelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor__accelerometer);
        txtvAccelerometer = (TextView) findViewById(R.id.textViewAccelerometer);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x, y, z;
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];
        txtvAccelerometer.append("\n" + "Value of X: " + x + "\n" + "Value of Y: " + y + "\n" + "Value of Z: " + z);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
