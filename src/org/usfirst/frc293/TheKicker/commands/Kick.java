package org.usfirst.frc293.TheKicker.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc293.TheKicker.Robot;

public class Kick extends Command {

    public Kick() {
        requires(Robot.kicker);
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
