package org.usfirst.frc293.TheKicker;

import org.usfirst.frc293.TheKicker.commands.AutonomousCommand;
import org.usfirst.frc293.TheKicker.subsystems.DriveBase;
import org.usfirst.frc293.TheKicker.subsystems.Kicker;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	Command autonomousCommand;

	public static OI oi;
	public static DriveBase driveBase;
	public static Kicker kicker;

	public void robotInit() {
		driveBase = new DriveBase();
		kicker = new Kicker();
		oi = new OI();

		autonomousCommand = new AutonomousCommand();

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
