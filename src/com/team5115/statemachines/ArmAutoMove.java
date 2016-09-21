package com.team5115.statemachines;

import com.team5115.robot.Robot;

import edu.wpi.first.wpilibj.Timer;

public class ArmAutoMove extends StateMachineBase {
	
	int dir;
	double timeout;
	double initTime;
	
	public void setVar(int d, double t) {
		dir = d;
		timeout = t;
		
	}
	
	public void update() {
		switch (state) {
		case 1:	//"initTime" defined
			initTime = Timer.getFPGATimestamp();
			
			state = 2;
			break;
			
		case 2:
			if (dir == 1)
				Robot.arm.lift();
			
			if (dir == -1)
				Robot.arm.lower();
			
			if ((dir == 1) ? Robot.arm.getTopLimit() : Robot.arm.getBottomLimit() ||Timer.getFPGATimestamp() - initTime >= timeout)
				state = 3;
			break;
			
		case 3:
			Robot.arm.hold();
			break;
			
		}	
	}

}
