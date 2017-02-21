package org.usfirst.frc4089.Stealth2017.subsystems;

import org.usfirst.frc4089.Stealth2017.RobotMap;

import edu.wpi.first.wpilibj.PWMConfigDataResult;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterDoor extends Subsystem{

	private final Servo shooterDoor = RobotMap.shooterDoor;
	public double shooterDoorPos = 1;
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	public void cycleDoor(){
		shooterDoor.set(shooterDoorPos);
	}

}
