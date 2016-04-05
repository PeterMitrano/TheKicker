package org.usfirst.frc293.TheKicker.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class DriveBase extends Subsystem {

	private final SpeedController frontLeftMotor;
	private final SpeedController frontRightMotor;
	private final SpeedController backLeftMotor;
	private final SpeedController backRightMotor;
	private final RobotDrive robotDrive;
	private final Encoder rightEncoder;
	private final Encoder leftEncoder;

	public DriveBase() {
		frontLeftMotor = new Talon(1);
		LiveWindow.addActuator("driveBase", "frontLeftMotor", (Talon) frontLeftMotor);

		frontRightMotor = new Talon(3);
		LiveWindow.addActuator("driveBase", "frontRightMotor", (Talon) frontRightMotor);

		backLeftMotor = new Talon(2);
		LiveWindow.addActuator("driveBase", "backLeftMotor", (Talon) backLeftMotor);

		backRightMotor = new Talon(4);
		LiveWindow.addActuator("driveBase", "backRightMotor", (Talon) backRightMotor);

		robotDrive = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);

		robotDrive.setSafetyEnabled(true);
		robotDrive.setExpiration(0.1);
		robotDrive.setSensitivity(0.5);
		robotDrive.setMaxOutput(1.0);

		rightEncoder = new Encoder(0, 1, true, EncodingType.k4X);
		rightEncoder.setDistancePerPulse(1.0);
		rightEncoder.setPIDSourceType(PIDSourceType.kRate);
		LiveWindow.addSensor("driveBase", "rightEncoder", rightEncoder);
		
		leftEncoder = new Encoder(2, 3, false, EncodingType.k4X);
		leftEncoder.setDistancePerPulse(1.0);
		leftEncoder.setPIDSourceType(PIDSourceType.kRate);
		LiveWindow.addSensor("driveBase", "leftEncoder", leftEncoder);
	}

	public void initDefaultCommand() {
	}

	public void stop() {
		robotDrive.stopMotor();
	}
}
