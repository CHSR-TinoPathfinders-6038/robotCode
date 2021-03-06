package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Concept: MotorTest", group ="Concept")
public class MotorTest extends LinearOpMode {

  private DcMotor motor;
  
  @Override
  public void runOpMode ()  throws InterruptedException {
    motor = hardwareMap.dcMotor.get("m");
    
    waitForStart ();
    
    motor.setPower(0.15);
    
    while (opModeIsActive()) {
      telemetry.addData("Text", "Run at Power");
      telemetry.addData("Power", motor.getPower());
      telemetry.addData("Position", motor.getCurrentPosition());
    }
  }

}
