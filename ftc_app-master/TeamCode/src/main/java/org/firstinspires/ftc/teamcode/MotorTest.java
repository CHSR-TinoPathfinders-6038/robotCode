public class MRI_Motor_Power extends LinearOpMode (

  DcMotor motor; 
  
  @Override
  public void runOpMode ()  throws InterruptedException (
    motor = hardwareMap.dcMotor.get("m");
    motor.setMode(DcMtorController.RunMode.RUN_WITHOUT_ENCODERS) ;
    
    waitForStart ();
    
    motor.setPower(0.15);
    
    while (opModeIsActive()) {
      telemetry.addData("Text", "Run at Power");
      telemetry.addData("Power", motor.getPower());
      telemetry.addData("Position", motor.getCurrentPosition());
      
      waitOneFullHardwareCycle();
    }
  }
}