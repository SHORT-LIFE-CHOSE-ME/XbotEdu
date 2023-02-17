package competition.subsystems.drive.commands;

import javax.inject.Inject;


import competition.operator_interface.OperatorInterface;
import xbot.common.command.BaseCommand;
import competition.subsystems.drive.DriveSubsystem;

public class ArcadeDriveWithJoysticksCommand extends BaseCommand {

        DriveSubsystem drive;
        OperatorInterface operatorInterface;

    @Inject
    public ArcadeDriveWithJoysticksCommand(DriveSubsystem driveSubsystem, OperatorInterface oi) {
        drive = driveSubsystem;
        operatorInterface = oi;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

        double leftValueX = operatorInterface.gamepad.getLeftVector().x * -1;
        double rightValueY = operatorInterface.gamepad.getLeftVector().y;
        if (leftValueX == 0) {
            drive.arcadeDrive(rightValueY,rightValueY);
        }
        else {
           drive.arcadeDrive(leftValueX + rightValueY,rightValueY - leftValueX );
        }





    }

}
