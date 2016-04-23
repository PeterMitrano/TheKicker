package org.usfirst.frc293.TheKicker.commands;

import org.usfirst.frc293.TheKicker.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Reload extends Command {

  public Reload(){
    requires(Robot.kicker);
  }

  @Override
  protected void initialize() {
    Robot.kicker.reload();
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
    end();
  }

}
