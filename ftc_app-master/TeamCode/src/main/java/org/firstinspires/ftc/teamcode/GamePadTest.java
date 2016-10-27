package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

//Need to do manager.register("Gamepad Drive Tele-Op", GamepadDriveTeleOp.class);
//need import respective classes
public class GamePadTest extends OpMode {
	
	
	DcMotor leftWheel, rightWheel;
	double leftWheelPower, rightWheelPower;
	
	@Override
	public void init(){
		leftWheel = hardwareMap.dcMotor.get("left_wheel");
		rightWheel = hardwareMap.dcMotor.get("right_wheel");
	
		
		leftWheel.setDirection(DcMotor.Direction.REVERSE);
	
	}
	
	@Override
	public void loop(){
		//gamepad return value is stored as the opposite
		leftWheelPower = gamepad1.left_stick_y;
		rightWheelPower = gamepad1.right_stick_y;
		
		leftWheel.setPower(leftWheelPower);
		rightWheel.setPower(rightWheelPower);
	}
	
	
	
}
