package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.LightSensor;


public class LightSensorTest extends OpMode {

    private LightSensor light;

    private final static String KEY = "";

    @Override
    public void init() {
        light = hardwareMap.lightSensor.get("<configured-string>");
    }

    @Override
    public void loop() {
        telemetry.addData(KEY, "your message");
        telemetry.addData(KEY, "light" + light.getLightDetected());
        if(light.getLightDetected() <= 0.25) {
            telemetry.addData(KEY, "white");
        } else if(light.getLightDetected() >= 0.75){
            telemetry.addData(KEY, "black");
        } else if(light.getLightDetected() <= 0.5){
            telemetry.addData(KEY, "blue");
        } else {
            telemetry.addData(KEY, "red");
        }
    }
}