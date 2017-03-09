package org.usfirst.frc4089.Stealth2017;

public class Constants {
	//assorted variables
	public static final double collectorSpeed = .5;
	public static final double ellevatorSpeedUp = 1;
	public static final double ellevatorSpeedDown = -.75;
	public static final double shooterSpeed = 1;
	public static final double climber1Speed = 1;
	public static final double climber2Speed = 1;
	public static final double rightSpeed = 1;
	public static final double leftSpeed = .9;
	public static final double curve = -0.1;
	public final static double kTolerance = 0.1;
	public final static double kP = -1.0 / 5.0;
	public final static double kI = -1.0 / 5.0;
	public final static double kD = -1.0 / 5.0;
	public final static double defaultAutoSpeed = .75;
	
	//Motor IDs
	public static final int rightMotor1SpeedControl = 6; //normally 6
	public static final int rightMotor2SpeedControl = 7;
	public static final int left1MotorSpeedControl = 1; //normally 1
	public static final int left2MotorSpeedControl = 2;
	public static final int climbMotor1SpeedControl = 8; //normally 8
	public static final int climbMotor2SpeedControl = 4;
	public static final int ShooterMotorSpeedControl = 10;
	public static final int ellevatorMotorSpeedControl = 9; //normally 9
	public static final int agitatorMotorSpeedControl = 5;
	public static final int collectorMotorControl = 3;
	//servos
	public static final int shooterDoorPort = 1;
	public static final int RBarrelBlockerPort = 2;
	public static final int LBarrelBlockerPort = 3;
}