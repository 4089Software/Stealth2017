package org.usfirst.frc4089.Stealth2017.commands;

import org.usfirst.frc4089.Stealth2017.AutoOptions;

import org.usfirst.frc4089.Stealth2017.Constants;
import org.usfirst.frc4089.Stealth2017.Robot;
import org.usfirst.frc4089.Stealth2017.RobotMap;
import org.usfirst.frc4089.Stealth2017.subsystems.Climber;
import org.usfirst.frc4089.Stealth2017.subsystems.Collector;
import org.usfirst.frc4089.Stealth2017.subsystems.Drive;
import org.usfirst.frc4089.Stealth2017.subsystems.Ellevator;
import org.usfirst.frc4089.Stealth2017.subsystems.Shooter;
import org.usfirst.frc4089.Stealth2017.subsystems.ShooterDoor;
import org.usfirst.frc4089.Stealth2017.subsystems.Utilities;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class AutoDriveDistance extends Command {

	private double errorAvg;
	private double errorLeft;
	private double errorRight;
	//private boolean stopAuto;
	//public double distance;
	private double distanceRight;
	private double distanceLeft;
	
	
	/*public void stopAutos(){
		stopAuto = true;
	}*/
    public AutoDriveDistance(double distance) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.drive);
    	distanceLeft = distance;
    	distanceRight = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.stopAuto = false;
    	Robot.drive.resetEncoders();
    	setTimeout(3.0);
    	System.out.println("AUTO-INIT");
    	
  
    	
    	/*Robot.drive = null;
        Robot.collector = null;
        Robot.shooter = null;
        Robot.ellevator = null;
        Robot.climber = null;
        Robot.utilities = null;
        Robot.shooterDoor = null;
        Robot.autoOptions = null;
    	*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//if(timeSinceInitialized() < 3000){
    	System.out.println("preauto??");
	    if(Robot.stopAuto = true){System.out.println("exit"); return;}	
    	errorLeft = distanceLeft + RobotMap.driveLeftMotor1.getEncPosition();
    	errorRight = distanceRight - RobotMap.driveRightMotor1.getEncPosition();
    	errorAvg = (errorLeft + errorRight)/2;
    	System.out.println("AUTO");
    	System.out.print("Left Encoder:");
    	System.out.print(RobotMap.driveLeftMotor1.getEncPosition());
    	System.out.print("Right Encoder");
    	System.out.println(RobotMap.driveRightMotor1.getEncPosition());
    	if (Constants.defaultAutoSpeed * Constants.kP * errorAvg >= Constants.defaultAutoSpeed) {
			Robot.drive.tankDrive(Constants.defaultAutoSpeed, Constants.defaultAutoSpeed);
    	
		} else {
			Robot.drive.tankDrive(Constants.defaultAutoSpeed * Constants.kP * errorAvg, Constants.defaultAutoSpeed * Constants.kP * errorAvg);
		}
	    	
	    	//SmartDashboard.putNumber("Left Encoder", Robot.drive.leftEncoder.getDistance());
    	//}else{
    	//	end();
    	//}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Math.abs(errorAvg) <= Constants.kTolerance) || isTimedOut();
    	//isTimedOut();
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	/*stopAuto = true;
    	System.out.println("AUTO-END");
    	Robot.drive.stop();
    	Robot.drive = null;
        Robot.collector = null;
        Robot.shooter = null;
        Robot.ellevator = null;
        Robot.climber = null;
        Robot.utilities = null;
        Robot.shooterDoor = null;
        Robot.autoOptions = null;*/
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
