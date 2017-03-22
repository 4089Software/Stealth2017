package org.usfirst.frc4089.Stealth2017.commands;

import org.usfirst.frc4089.Stealth2017.MPPaths.*;
import org.usfirst.frc4089.Stealth2017.Robot;
import org.usfirst.frc4089.Stealth2017.RobotMap;
import org.usfirst.frc4089.Stealth2017.MP.MotionProfile;

import edu.wpi.first.wpilibj.command.Command;
import com.ctre.CANTalon;
import org.usfirst.frc4089.Stealth2017.MP.MotionProfile;

/**
 *
 */
public class RunMP extends Command {
/*
 * what is this for???
 * TODO: ask team why this is here. Need to use the GeneratedMotionProfile.class
 */
	/*
	public static double [][]LeftPoints = new double[][]{
		{1.0, 0.4,1000},
		{2.0, 0.4, 500},
		{3.0, 0.4, 250},
		{4.0, 0.4, 125}		
	};
	
	public static double [][]RightPoints = new double[][]{
		{1.0, 0.4,1000},
		{2.0, 0.4, 500},
		{3.0, 0.4, 250},
		{4.0, 0.4, 125}		
	};
	
		
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
    //TODO: Mitch: removed call to local double array, and redirected MotionProfile to the GeneratedMotionProfile.class
	
	
	//MotionProfile MPLeft = new MotionProfile(RobotMap.driveLeftMotor1,LeftPoints);
    //MotionProfile MPRight = new MotionProfile(RobotMap.driveRightMotor1,RightPoints);
	//GeneratedMotionProfile
	MotionProfile MPL = new MotionProfile(RobotMap.driveLeftMotor1);
    MotionProfile MPR = new MotionProfile(RobotMap.driveRightMotor1);
	
	public RunMP() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	MPL.startMotionProfile();
    	MPR.startMotionProfile();
    	MPL.startMotionProfile();
    	MPR.startMotionProfile();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		/* call this periodically, and catch the output.  Only apply it if user wants to run MP. */
    	MPL.control();
    	MPR.control();

    	RobotMap.driveLeftMotor1.changeControlMode(CANTalon.TalonControlMode.MotionProfile);
    	RobotMap.driveRightMotor1.changeControlMode(CANTalon.TalonControlMode.MotionProfile);
		
		CANTalon.SetValueMotionProfile setOutput = MPL.getSetValue();
	
		RobotMap.driveLeftMotor1.set(setOutput.value);

		setOutput = MPR.getSetValue();
		RobotMap.driveRightMotor1.set(setOutput.value);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.driveLeftMotor1.changeControlMode(CANTalon.TalonControlMode.Voltage);
    	RobotMap.driveRightMotor1.changeControlMode(CANTalon.TalonControlMode.Voltage);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

