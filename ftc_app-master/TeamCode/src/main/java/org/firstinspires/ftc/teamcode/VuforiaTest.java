package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import com.qualcomm.ftcrobotcontroller.R;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.RobotLog;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import java.util.ArrayList;
import java.util.List;


@Autonomous(name="Concept: VuforiaTest", group ="Concept")
public class VuforiaTest extends LinearOpMode {

    public static final String TAG = "Vuforia Sample";

    private static final String VUF_KEY = "AYTw69n/////AAAAGZROJBAVpEdKsT+9hnUy9dKDbkeZvkq2zplnloGCaGhc3v2g9MGSpLgnuI9kSxR2LHZBgLwuZ8a/vZe0sGDNwHeBjw4sOnG3ufrVA1Ba9JJ8K+fesVu6VKWXV7AKjzOZLDAi3lGwDnWhxpaisRIwgHZrQjNOfj8jLm11aFhPG5ZEWTUptuafiwOX9TlCsNsLxj4dYjLKwGascBPznV+zCo3s7601GM4Tv92pXCmzm0slzVjx355dWbb53ZsYEGCY4cAl3ofHXKOye2oWR6UAswtXAEseJsDUP6Iu0tUIGtI6/dao5kB47nlJ4XFK3sGtK3o1HjzGRHauZX8fXNx38FwJRC8J05toQ825c1KvcDn7";

    OpenGLMatrix lastLocation = null;
    VuforiaLocalizer vuforia;

    @Override public void runOpMode() throws InterruptedException {
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        parameters.vuforiaLicenseKey = VUF_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables visionTargets = this.vuforia.loadTrackablesFromAsset("FTC_2016-17");
        VuforiaTrackable target = visionTargets.get(0);
        target.setName("Target");

        List<VuforiaTrackable> allTrackables = new ArrayList<>();
        allTrackables.addAll(visionTargets);
        float mmPerInch        = 25.4f;
        float mmBotWidth       = 18 * mmPerInch;
        float mmFTCFieldWidth  = (12*12 - 2) * mmPerInch;
        OpenGLMatrix redTargetLocationOnField = OpenGLMatrix
                .translation(-mmFTCFieldWidth/2, 0, 0)
                .multiplied(Orientation.getRotationMatrix(
                        AxesReference.EXTRINSIC, AxesOrder.XZX,
                        AngleUnit.DEGREES, 90, 90, 0));
        target.setLocation(redTargetLocationOnField);

        RobotLog.ii(TAG, "Red Target=%s", format(redTargetLocationOnField));
        OpenGLMatrix phoneLocationOnRobot = OpenGLMatrix
                .translation(mmBotWidth/2,0,0)
                .multiplied(Orientation.getRotationMatrix(
                        AxesReference.EXTRINSIC, AxesOrder.YZY,
                        AngleUnit.DEGREES, -90, 0, 0));

        RobotLog.ii(TAG, "phone=%s", format(phoneLocationOnRobot));
        ((VuforiaTrackableDefaultListener)target.getListener()).setPhoneInformation(phoneLocationOnRobot, parameters.cameraDirection);
        telemetry.addData(">", "Press Play to start tracking");
        telemetry.update();

        waitForStart();

        visionTargets.activate();

        while (opModeIsActive()) {
            int count = 0;
            for (VuforiaTrackable trackable : allTrackables) {
                switch(count) {
                    case 0:
                        trackable.setName("Wheels");
                        break;
                    case 1:
                        trackable.setName("Tools");
                        break;
                    case 2:
                        trackable.setName("Legos");
                        break;
                    case 3:
                        trackable.setName("Gears");
                        break;
                    default:
                        trackable.setName("fasdfsdfdsfcasd");
                        break;

                }
                telemetry.addData(trackable.getName(), ((VuforiaTrackableDefaultListener)trackable.getListener()).isVisible() ? "Visible" : "Not Visible");    //

                OpenGLMatrix robotLocationTransform = ((VuforiaTrackableDefaultListener)trackable.getListener()).getUpdatedRobotLocation();
                if (robotLocationTransform != null) {
                    lastLocation = robotLocationTransform;
                }
                count++;
            }
            if (lastLocation != null) {
                telemetry.addData("Pos", format(lastLocation));
            } else {
                telemetry.addData("Pos", "Unknown");
            }
            
            telemetry.update();
            idle();
        }
    }

    String format(OpenGLMatrix transformationMatrix) {
        return transformationMatrix.formatAsTransform();
    }
}