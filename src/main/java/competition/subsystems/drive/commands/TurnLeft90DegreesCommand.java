package competition.subsystems.drive.commands;

import javax.inject.Inject;

import edu.wpi.first.math.geometry.Rotation2d;
import xbot.common.command.BaseCommand;
import competition.subsystems.drive.DriveSubsystem;
import competition.subsystems.pose.PoseSubsystem;

//import java.lang.annotation.Target;

public class TurnLeft90DegreesCommand extends BaseCommand {

    DriveSubsystem drive;
    PoseSubsystem pose;



    public double Position;

    public double oldPose;

    public double TargetPose;

    public double velocity;







    @Inject
    public TurnLeft90DegreesCommand(DriveSubsystem driveSubsystem, PoseSubsystem pose) {
        this.drive = driveSubsystem;
        this.pose = pose;
    }

    public void initialize(double Position) {
        pose.getCurrentHeading().getDegrees();

    }

    @Override
    public void initialize(){

    }


    @Override
    public void execute() {

        double CurrentPose = pose.getCurrentHeading().getDegrees();
        double error = TargetPose - CurrentPose;
        double power = -.2922 * error - .2890 * velocity;
        drive.arcadeDrive(power , -power);



        oldPose = CurrentPose;
        velocity = oldPose;
    }


    @Override public boolean isFinished()
    {
        if (TargetPose < pose.getPosition())
        {
            return true;
        }

        return false;

    }}

