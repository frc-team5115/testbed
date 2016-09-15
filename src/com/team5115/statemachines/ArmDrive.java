package com.team5115.statemachines;

import com.team5115.Constants;
import com.team5115.robot.InputManager;
import com.team5115.robot.Robot;

public class ArmDrive extends StateMachineBase {
	
	boolean flex;
	boolean relax;
	
	public void update() {
		switch (state) {
		case 1:
			
			Robot.arm.lift();
			Robot.arm.lower();
			Robot.arm.hold();
			
			break;

		}
	}
}
