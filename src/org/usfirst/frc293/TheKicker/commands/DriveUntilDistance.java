package org.usfirst.frc293.TheKicker.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc293.TheKicker.Robot;

public class DriveUntilDistance extends Command {

	int distance, currentDisplacement;
	
	public DriveUntilDistance(int distance) {
		this.distance = distance;
		this.currentDisplacement = 0;
	}

	protected void initialize() {
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return currentDisplacement < distance;
	}

	protected void end() {
		Robot.driveBase.stop();
	}

	protected void interrupted() {
	}
}
