package com.team5115.statemachines;

import com.team5115.robot.Robot;

import edu.wpi.first.wpilibj.Timer;


public class StraightLine extends StateMachineBase {
	
	double dist;
	double speed;
	double throttle;
	boolean doneDriving;
	
	public StraightLine() {
		throttle = (dist - Robot.drivetrain.distanceTraveled()) * 0.5; 
	}
	
	public void setVar(double d, double s) {
		dist = d;
		speed = s;
		doneDriving = false;
		Robot.drivetrain.resetEncoders();
	}
	
	public void update() {
		switch (state) {
		case 1:	//drive forward
				
			Robot.drivetrain.drive(speed, speed, throttle);
				
			if (Robot.drivetrain.distanceTraveled() >= dist) 
					state = 2;
			break;
			
		case 2:
			Robot.drivetrain.drive(0,0,0);
			doneDriving = true;
			
			break;
			
		}
	}

}
