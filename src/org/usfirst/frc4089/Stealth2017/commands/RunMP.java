package org.usfirst.frc4089.Stealth2017.commands;

import org.usfirst.frc4089.Stealth2017.Robot;
import org.usfirst.frc4089.Stealth2017.subsystems.MotionProfile;
import org.usfirst.frc4089.Stealth2017.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import com.ctre.CANTalon;;


/**
 *
 */
public class RunMP extends Command {

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
    MotionProfile MPLeft = new MotionProfile(RobotMap.driveLeftMotor1,LeftPoints);
    MotionProfile MPRight = new MotionProfile(RobotMap.driveRightMotor1,RightPoints);
		
	public RunMP() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	MPLeft.startMotionProfile();
    	MPRight.startMotionProfile();
    	MPLeft.MotionProfileStart();
    	MPRight.MotionProfileStart();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		/* call this periodically, and catch the output.  Only apply it if user wants to run MP. */
    	MPLeft.control();
    	MPRight.control();

    	RobotMap.driveLeftMotor1.changeControlMode(CANTalon.TalonControlMode.MotionProfile);
    	RobotMap.driveRightMotor1.changeControlMode(CANTalon.TalonControlMode.MotionProfile);
		
		CANTalon.SetValueMotionProfile setOutput = MPLeft.getSetValue();
		RobotMap.driveLeftMotor1.set(setOutput.value);

		setOutput = MPRight.getSetValue();
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

