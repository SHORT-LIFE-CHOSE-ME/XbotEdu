package injection.components;

import javax.inject.Singleton;

import competition.injection.components.BaseRobotComponent;
import competition.injection.modules.SimulatedRobotModule;
import competition.subsystems.drive.commands.ArcadeDriveWithJoysticksCommand;
import dagger.Component;
import xbot.common.injection.modules.MockControlsModule;
import xbot.common.injection.modules.MockDevicesModule;
import xbot.common.injection.modules.UnitTestModule;

@Singleton
@Component(modules = { UnitTestModule.class, MockDevicesModule.class, MockControlsModule.class, SimulatedRobotModule.class })
public abstract class CompetitionTestComponent extends BaseRobotComponent {

    public abstract ArcadeDriveWithJoysticksCommand arcadeDriveWithJoysticksCommand();


}
