package org.usfirst.frc293.TheKicker;

import org.usfirst.frc293.TheKicker.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc293.TheKicker.subsystems.*;


public class OI {
    public JoystickButton kickButton;
    public Joystick joystick;

    public OI() {
        joystick = new Joystick(0);

        kickButton = new JoystickButton(joystick, 1);
        kickButton.whenPressed(new Kick());
    }

    public Joystick getjoystick() {
        return joystick;
    }
}

