// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4089.Stealth2017.subsystems;

import org.usfirst.frc4089.Stealth2017.Constants;
import org.usfirst.frc4089.Stealth2017.RobotMap;
import org.usfirst.frc4089.Stealth2017.commands.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Shooter extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController shooterMotor = RobotMap.shooterMotor;
    private final Encoder quadratureEncoder1 = RobotMap.shooterQuadratureEncoder1;
    
    private final Servo RBarrelBlocker = RobotMap.RBarrelBlocker;
    private final Servo LBarrelBlocker = RobotMap.LBarrelBlocker;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void stopShooter(){
    	shooterMotor.set(0);
    }
    public void spinShooter(){
    	shooterMotor.set(-Constants.shooterSpeed);    	
    }
    public void reverseShooter(){
    	shooterMotor.set( Constants.shooterSpeed);      	
    }
    public void closeOuterBarrels(){
    	RBarrelBlocker.set(1);
    	LBarrelBlocker.set(0);
    }
    public void openOuterBsrrels(){
    	RBarrelBlocker.set(0.3);
    	LBarrelBlocker.set(0.7);
    }
}

