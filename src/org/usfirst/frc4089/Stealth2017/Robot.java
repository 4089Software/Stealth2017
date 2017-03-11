// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
/*
TO-DO List:
	ClimberMotor
	Servo digital programmer
	smart shooter door button
*/
package org.usfirst.frc4089.Stealth2017;

import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import java.nio.ByteBuffer;
import java.util.HashMap;

import org.usfirst.frc4089.Stealth2017.commands.*;
import org.usfirst.frc4089.Stealth2017.subsystems.*;
import edu.wpi.cscore.UsbCamera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static boolean stopAuto = false;
    Command autonomousCommand;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Drive drive;
    public static Collector collector;
    public static Shooter shooter;
    public static Ellevator ellevator;
    public static Climber climber;
    public static Utilities utilities;
    public static ShooterDoor shooterDoor;

    public static AutoOptions autoOptions;
    //public static I2C arduinoCom;
    public static DriverStation ds = DriverStation.getInstance();
    
    /*static HashMap<Integer, String> sampleDict = new HashMap<Integer, String>(){/**
		 * 
		 *
		private static final long serialVersionUID = 1L;

	{
    	put(16, "AutonCommandName1");
    	put(17, "AutonCommandName2");
    	put(19, "EllevatorRun");
    }};*/
    
    private void I2CTransaction()
	{
    	/*ByteBuffer sent, received;
    	sent = ByteBuffer.allocateDirect(4);
    	received = ByteBuffer.allocateDirect(2);
		if(Alliance.Blue == ds.getAlliance())
		{
			sent.put((byte)((int)'B'));
		}
		else
		{
			if(Alliance.Red == ds.getAlliance())
			{
				sent.put((byte)((int)'R'));
			}
			else
			{
				sent.put((byte)((int)'I'));
			}
		}
		
		sent.put((byte)ds.getLocation());
		if(ds.isEnabled())
		{
			sent.put((byte)((int)'E'));
		}
		else
		{
			sent.put((byte)((int)'D'));
		}
		
		sent.put((byte)0);

    	Robot.arduinoCom.transaction(sent, 4, received, 2);
    	Timer.delay(0.005);
    	int selection = received.getShort();
    	if(selection >= 16 && autonomousCommand == null)
    	{
	    	try {
				Class<?> autonClass = Class.forName(sampleDict.get(selection));
				autonomousCommand = (Command)autonClass.newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}*/
	}
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        stopAuto = true;
    	drive = new Drive();
        collector = new Collector();
        shooter = new Shooter();
        ellevator = new Ellevator();
        climber = new Climber();
        utilities = new Utilities();
        shooterDoor = new ShooterDoor();
        autoOptions = new AutoOptions();
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        /*new Thread(() -> {
        	UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        }).start();
        */// OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        //arduinoCom = new I2C(I2C.Port.kOnboard, 40);

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = null;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	//I2CTransaction();
    }

    public void disabledPeriodic() {
        //Scheduler.getInstance().run();
        //I2CTransaction();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand = AutoOptions.getCommand(0); 
    	if (autonomousCommand != null) autonomousCommand.start(); 

        //I2CTransaction();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        //I2CTransaction();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        //I2CTransaction();
        System.out.println("TELE-INIT");
        //AutoDriveDistance.stopAutos();
        /*drive = new Drive();
        collector = new Collector();
        shooter = new Shooter();
        ellevator = new Ellevator();
        climber = new Climber();
        utilities = new Utilities();
        shooterDoor = new ShooterDoor();
        autoOptions = new AutoOptions();
    */
        }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //I2CTransaction();
        //System.out.println("TELE-PERIODIC");
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
