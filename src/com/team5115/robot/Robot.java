package com.team5115.robot;


import com.team5115.Constants;
import com.team5115.statemachines.ArmAutoMove;
import com.team5115.statemachines.ArmDrive;
import com.team5115.statemachines.Fondle;
import com.team5115.statemachines.HoffDrive;
import com.team5115.statemachines.StraightLine;
import com.team5115.statemachines.Turn;
import com.team5115.systems.Arm;
import com.team5115.systems.BallFondler;
import com.team5115.systems.DriveTrain;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	public static DriveTrain drivetrain;
	public static Arm arm;
	public static BallFondler ballfondler;
	public static HoffDrive hd;
	public static ArmDrive ad;
	public static Fondle f;
	public static StraightLine sl;
	public static Turn t;
	public static ArmAutoMove am;	
	public static NetworkTable nt;
	public static SendableChooser defenseChooser;
	public static SendableChooser gateChooser;

	public void robotInit() {
		drivetrain = new DriveTrain();
		arm = new Arm();
		ballfondler = new BallFondler();
		defenseChooser = new SendableChooser();
    	gateChooser = new SendableChooser();
    	defenseChooser.addDefault("Low bar", 0);
    	defenseChooser.addObject("Cheval de Frise", 1);
    	defenseChooser.addObject("Portcullis", 2);
    	defenseChooser.addObject("Terrain", 3);
    	gateChooser.addDefault("Gate 1", 1);
    	gateChooser.addObject("Gate 2", 2);
    	gateChooser.addObject("Gate 3", 3);
    	gateChooser.addObject("Gate 4", 4);
    	gateChooser.addObject("Gate 5", 5);
    	SmartDashboard.putData("Defense", defenseChooser);
    	SmartDashboard.putData("Gate Chooser", gateChooser);

		hd = new HoffDrive();
		ad = new ArmDrive();
		f = new Fondle(); 
		sl = new StraightLine();
		t = new Turn();
		am = new ArmAutoMove();
		
		nt = NetworkTable.getTable("pi");
    	nt.putNumber("rioStatus", 0);
    	nt.putNumber("angleToGoal", 0);
    	nt.putNumber("distanceToGoal", 0);
	}

	public void autonomousInit() {
		Timer.delay(Constants.DELAY);
		nt.putNumber("riostatus", 1);
    	int defense = (int) defenseChooser.getSelected();
    	int gate = (int) gateChooser.getSelected();
	}

	public void autonomousPeriodic() {
	}

	public void teleopInit() {
		hd.setState(1);
		ad.setState(1);
		f.setState(1);
	}

	public void teleopPeriodic() {
		hd.update();
		ad.update();
		f.update();
		
		Timer.delay(Constants.DELAY);		
		SmartDashboard.putString("Direction", drivetrain.direction == Constants.DIR_ARM ? "ARM" : "BALL");
		SmartDashboard.putString("Left Speed", drivetrain.leftSpeed() + "");
		SmartDashboard.putString("Right Speed", drivetrain.rightSpeed() + "");
		
	}
	public void disabledInit() {
		hd.setState(0);
		ad.setState(0);
		f.setState(0);
	}

	public void disabledPeriodic() {
		Timer.delay(Constants.DELAY);
	}

}
