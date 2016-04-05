package org.usfirst.frc293.TheKicker;

import org.usfirst.frc293.TheKicker.commands.DriveUntilDistance;
import org.usfirst.frc293.TheKicker.commands.Kick;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends CommandGroup {

	public AutonomousCommand() {
		addSequential(new DriveUntilDistance(1));
		addSequential(new Kick());
	}

}
