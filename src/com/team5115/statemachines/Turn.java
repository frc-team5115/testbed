package com.team5115.statemachines;

import com.team5115.robot.Robot;

import edu.wpi.first.wpilibj.Timer;

public class Turn extends StateMachineBase {
	
	double angle;
	
	public void setVar(double a) {
		angle = a;
	}
	
	public void update() {
		switch (state) {
		case 1:
			
			Robot.drivetrain.resetEncoders();
			double arc = (Robot.drivetrain.rightDist() - Robot.drivetrain.leftDist()) / 2;
			
			if (Math.abs(arc / (2.104 * Math.PI)) >= Math.abs(angle / 360)) {
				state = 0;
			} else {
				Robot.drivetrain.drive(-0.6 * Math.signum(angle), 0.6 * Math.signum(angle), 1);
			}
			
			break;
		}
	}

}
