package sensor.example.hienthanh.sensor;

import android.annotation.TargetApi;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class ListSensor extends AppCompatActivity {
    private TextView txtViewListSensor;
    private TextView txtViewLight;
    private float lightValue = 0.5f;
    private WindowManager.LayoutParams layoutParams;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sensor);
        txtViewListSensor = (TextView) findViewById(R.id.textViewListSensor);
        SensorManager sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        StringBuilder stringBuilder = new StringBuilder(2048);
        layoutParams = getWindow().getAttributes();
        txtViewListSensor.setText(stringBuilder);
        txtViewLight = (TextView) findViewById(R.id.textViewLight);
        setBright(lightValue);
        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (lightSensor == null) {
            Toast.makeText(ListSensor.this, "No Light Sensor show", Toast.LENGTH_SHORT).show();

        } else {
            float max = lightSensor.getMaximumRange();
            Log.v("Bright", "Bright max: " + String.valueOf(max));
            sensorManager.registerListener(lightSensorEvenListener, lightSensor, sensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    private HashMap<Integer, String> sensorType = new HashMap<Integer, String>();

    {
        sensorType.put(Sensor.TYPE_ACCELEROMETER, "Type_Accelerometer");
        sensorType.put(Sensor.TYPE_AMBIENT_TEMPERATURE, "Type_Ambient_Temperature");

    }

    SensorEventListener lightSensorEvenListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
                float currentLight = event.values[0];
                txtViewLight.setText("Độ sáng hiện tại của thiết bị: " + String.valueOf(currentLight));

            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    public void setBright(float lightValue) {
        if (lightValue > 0 && lightValue <= 1) {
            layoutParams.screenBrightness = lightValue;
            getWindow().setAttributes(layoutParams);
        }

    }
}
