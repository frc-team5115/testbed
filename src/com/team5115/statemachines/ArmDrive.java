package com.team5115.statemachines;

import com.team5115.Constants;
import com.team5115.robot.InputManager;
import com.team5115.robot.Robot;

public class ArmDrive extends StateMachineBase {
	
	boolean flex;
	boolean relax;
	
	public void update() {
		switch (state) {
		case 1:		//waiting for input
			
			Robot.arm.hold();
			
			if (InputManager.flex()) {
				Robot.arm.lift();
			}
			
			if (InputManager.relax()) {
				Robot.arm.lower();
			}
			break;

		}
	}
}
