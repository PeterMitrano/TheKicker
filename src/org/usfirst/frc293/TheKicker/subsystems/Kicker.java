package org.usfirst.frc293.TheKicker.subsystems;

import org.usfirst.frc293.TheKicker.commands.Reload;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Kicker extends Subsystem {

    private final SpeedController motor;

    public Kicker(){
        motor = new Talon(2);
        LiveWindow.addActuator("Kicker", "motor", (Talon) motor);
    }

	@Override
	protected void initDefaultCommand() {
    this.setDefaultCommand(new Reload());
	}

	public void reload() {
    motor.set(-1);
	}

	public void kick() {
    motor.set(1);
	}
}

