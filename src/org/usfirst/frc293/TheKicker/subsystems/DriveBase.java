package org.usfirst.frc293.TheKicker.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class DriveBase extends Subsystem {

	private final SpeedController leftMotor;
	private final SpeedController rightMotor;
	private final RobotDrive robotDrive;
	private final Encoder rightEncoder;
	private final Encoder leftEncoder;

  private static final double WHEEL_DIMATER = 0.1522;

	public DriveBase() {
		leftMotor = new Talon(0);
		LiveWindow.addActuator("driveBase", "frontLeftMotor", (Talon) leftMotor);

		rightMotor = new Talon(1);
		LiveWindow.addActuator("driveBase", "frontRightMotor", (Talon) rightMotor);

		robotDrive = new RobotDrive(leftMotor, rightMotor);
		robotDrive.setInvertedMotor(MotorType.kFrontLeft, false);
		robotDrive.setInvertedMotor(MotorType.kRearLeft, false);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);

		robotDrive.setSafetyEnabled(true);
		robotDrive.setExpiration(0.1);
		robotDrive.setSensitivity(0.5);
		robotDrive.setMaxOutput(1.0);

		rightEncoder = new Encoder(0, 1, false, EncodingType.k4X);
		rightEncoder.setDistancePerPulse((WHEEL_DIMATER * Math.PI) / 365);
		rightEncoder.setPIDSourceType(PIDSourceType.kRate);
		LiveWindow.addSensor("driveBase", "rightEncoder", rightEncoder);

		leftEncoder = new Encoder(2, 3, false, EncodingType.k4X);
		leftEncoder.setDistancePerPulse((WHEEL_DIMATER * Math.PI) / 365);
		leftEncoder.setPIDSourceType(PIDSourceType.kRate);
		LiveWindow.addSensor("driveBase", "leftEncoder", leftEncoder);
	}

	public void initDefaultCommand() {
	}

	public void tankDrive(Joystick joystick){
		double left = joystick.getRawAxis(0);
		double right = joystick.getRawAxis(1);
		robotDrive.tankDrive(left, right);
	}

	public void stop() {
		robotDrive.stopMotor();
	}

	public void tankDrive(double leftValue, double rightValue) {
		robotDrive.tankDrive(leftValue, rightValue);

	}

	public double leftEncoderDistance() {
		return leftEncoder.getDistance();
	}

	public double rightEncoderDistance() {
		return rightEncoder.getDistance();
	}
}
