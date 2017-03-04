package org.usfirst.frc4089.Stealth2017.commands;

import org.usfirst.frc4089.Stealth2017.Constants;
import org.usfirst.frc4089.Stealth2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveDistance extends Command {

	private double errorAvg;
	private double errorLeft;
	private double errorRight;
	
	//public double distance;
	private double distanceRight;
	private double distanceLeft;
	
    public AutoDriveDistance(double distance) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.drive);
    	distanceLeft = distance;
    	distanceRight = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	errorLeft = distanceLeft - Robot.drive.leftEncoder.getDistance();
    	errorRight = distanceRight - Robot.drive.rightEncoder.getDistance();
    	errorAvg = (errorLeft + errorRight)/2;
    	if (Constants.defaultAutoSpeed * Constants.kP * errorAvg >= Constants.defaultAutoSpeed) {
			Robot.drive.tankDrive(Constants.defaultAutoSpeed, Constants.defaultAutoSpeed);
    	
		} else {
			Robot.drive.tankDrive(Constants.defaultAutoSpeed * Constants.kP * errorAvg, Constants.defaultAutoSpeed * Constants.kP * errorAvg);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Math.abs(errorAvg) <= Constants.kTolerance) || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
