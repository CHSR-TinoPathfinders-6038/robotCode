package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

@Autonomous (name="Concept: Auto v1", group = "Concept")
public class AutonomousVersionOne extends LinearOpMode{

    public final static double MAX_POWER = 0.65;

    private DcMotor motorLeft, motorRight;

    private OpticalDistanceSensor distance;

    private GyroSensor gyro;

    @Override
    public void runOpMode() throws InterruptedException {
        motorLeft = hardwareMap.dcMotor.get("ml");
        motorRight = hardwareMap.dcMotor.get("mr");
        distance = hardwareMap.opticalDistanceSensor.get("d");
        gyro = hardwareMap.gyroSensor.get("g");

        waitForStart();

        while (!frontDistance(60)) {
            goForward();
        }
    }

    private void goForward() {
        motorRight.setPower(MAX_POWER);
        motorLeft.setPower(MAX_POWER);
    }

    private boolean frontDistance(double distance) {
        return true;
    }

}
