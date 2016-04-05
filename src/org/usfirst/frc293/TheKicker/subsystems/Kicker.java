package org.usfirst.frc293.TheKicker.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Kicker extends Subsystem {

    private final SpeedController motor;
    private final AnalogPotentiometer pot;

    public Kicker(){
        motor = new Talon(5);
        LiveWindow.addActuator("Kicker", "motor", (Talon) motor);
        
        pot = new AnalogPotentiometer(2, 1.0, 0.0);
        LiveWindow.addSensor("Kicker", "pot", pot);
    }

	@Override
	protected void initDefaultCommand() {
		
	}
}

