package competition.subsystems.drive.commands;

import javax.inject.Inject;

//import competition.operator_interface.OperatorInterface;
import xbot.common.command.BaseCommand;
import competition.subsystems.drive.DriveSubsystem;
import competition.subsystems.pose.PoseSubsystem;

//import java.util.Currency;

//import static java.lang.invoke.MethodHandles.loop;

/*
import java.lang.annotation.Target;

//import java.lang.annotation.Target;

 */

public class DriveToPositionCommand extends BaseCommand {

    DriveSubsystem drive;
    PoseSubsystem pose;

    public double TargetPose;

    public double oldPose;



    @Inject
    public DriveToPositionCommand(DriveSubsystem driveSubsystem, PoseSubsystem pose)  {
        this.drive = driveSubsystem;
        this.pose = pose;

    }   //5 = TargetPose
        // 2 = current Pose

    public void setTargetPosition(double position) {
        // This method will be called by the test, and will give you a goal distance.
        // You'll need to remember this target position and use it in your calculations.
        this.TargetPose = position;
    }

    @Override
    public void initialize() {
        pose.getPosition();

    }

    @Override
    public void execute() {
        double CurrentPose = pose.getPosition();
        double error = TargetPose - CurrentPose;
        double power = error * .02;
        drive.arcadeDrive(power , power);
        double speed = CurrentPose - oldPose;
        double velocity = 0;

        power= 2 * error - 1 * velocity;

        oldPose = CurrentPose;
        velocity = oldPose;


    }
    @Override public boolean isFinished()
    {
        if (TargetPose == pose.getPosition())
        {
            return true;
        }
        return false;
    }
}





// Here you'll need to figure out a technique that:
// - Gets the robot to move to the target position
// - Hint: use pose.getPosition() to find out where you are
// - Gets the robot stop (or at least be moving really,really slowly) at the
// target position
// How you do this is up to you. If you get stuck, ask a mentor or student for
// some hints!