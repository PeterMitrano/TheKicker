package org.usfirst.frc293.TheKicker.commands;

import org.usfirst.frc293.TheKicker.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Kick extends Command {

    public Kick() {
        requires(Robot.kicker);
    }

    protected void initialize() {
      setTimeout(1);
      Robot.kicker.kick();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
      end();
    }
}
