package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;


public class GyroSensorTest extends OpMode{

    private GyroSensor gyro;
    private final static String KEY = "";

    @Override
    public void init() {
        gyro = hardwareMap.gyroSensor.get("<configured-string>");
    }

    @Override
    public void loop() {
        telemetry.addData(KEY, Integer.toString(gyro.rawX()));
        telemetry.addData(KEY, Integer.toString(gyro.rawY()));
        telemetry.addData(KEY, Integer.toString(gyro.rawZ()));
    }
}
