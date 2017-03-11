package org.usfirst.frc4089.Stealth2017.commands;

import org.usfirst.frc4089.Stealth2017.Constants;
import org.usfirst.frc4089.Stealth2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurn extends Command {
	
	private double errorAvg;
	private double errorLeft;
	private double errorRight;

	private double distanceRight;
	private double distanceLeft;

    public AutoTurn(double angle, double radius) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.drive);
    	
    	double radiusRight;
    	double radiusLeft;
    	
    	if(angle < 0){
    		radiusRight = radius + 2.35;
        	radiusLeft = radius;
    	}else{
    		radiusRight = radius;
        	radiusLeft = radius + 2.35;
    	}
    	
    	distanceRight = (float) (2 * Math.PI * radiusRight * (angle/360));
    	distanceLeft = (float) (2 * Math.PI * radiusLeft * (angle/360));
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	errorLeft = distanceLeft - Robot.drive.leftMotor1.getEncPosition();
    	errorRight = distanceRight - Robot.drive.rightMotor1.getEncPosition();
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
