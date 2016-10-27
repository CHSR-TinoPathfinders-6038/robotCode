package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Concept: GamePadTest", group ="Concept")
public class GamePadTest extends OpMode {

	private DcMotor leftWheel, rightWheel;
	private double leftWheelPower, rightWheelPower;
	
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
