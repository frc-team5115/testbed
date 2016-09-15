
package com.team5115.robot;

import com.team5115.Constants;
import com.team5115.statemachines.ArmDrive;
import com.team5115.statemachines.Fondle;
import com.team5115.statemachines.HoffDrive;
import com.team5115.systems.Arm;
import com.team5115.systems.BallFondler;
import com.team5115.systems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends IterativeRobot {

	public static DriveTrain drivetrain;
	public static Arm arm;
	public static BallFondler ballfondler;

	public static HoffDrive hd;
	public static ArmDrive ad;
	public static Fondle f;

	public void robotInit() {
		drivetrain = new DriveTrain();
		arm = new Arm();
		ballfondler = new BallFondler();

		hd = new HoffDrive();
		ad = new ArmDrive();
		f = new Fondle(); 
	}

	public void autonomousInit() {}

	public void autonomousPeriodic() {
		Timer.delay(Constants.DELAY);
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
