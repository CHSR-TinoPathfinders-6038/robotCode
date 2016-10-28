package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by shashank on 10/27/16.
 */
@Autonomous(name = "Servo Test", group = "Concept")
public class ServoTest extends LinearOpMode {

    private Servo servo;

    @Override
    public void runOpMode() throws InterruptedException {
        servo = hardwareMap.servo.get("s");

        waitForStart();

        while (opModeIsActive()) {
            servo.setPosition(1);
        }
    }

}
