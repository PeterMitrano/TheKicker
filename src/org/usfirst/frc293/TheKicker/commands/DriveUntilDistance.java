package org.usfirst.frc293.TheKicker.commands;

import org.usfirst.frc293.TheKicker.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveUntilDistance extends Command {

	double distance, currentDisplacement;

	public DriveUntilDistance(double distance) {
		this.distance = distance;
		this.currentDisplacement = 0;
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.driveBase.tankDrive(0.2, 0.2);
		double l = Robot.driveBase.leftEncoderDistance();
		double r = Robot.driveBase.rightEncoderDistance();
		currentDisplacement = (l + r) / 2.0;
	}

	protected boolean isFinished() {
		return currentDisplacement > distance;
	}

	protected void end() {
		Robot.driveBase.stop();
	}

	protected void interrupted() {
	}
}
