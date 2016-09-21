package com.team5115.statemachines;

import com.team5115.robot.InputManager;
import com.team5115.robot.Robot;

public class Fondle extends StateMachineBase{
	
	boolean release;
	boolean intake;
	boolean isFondling;
	
	public Fondle() {
		intake = InputManager.intake();
		release = InputManager.release();
	
	}
	
	public void update() {
		switch (state) {
		case 1:    //STATE 1 Waiting for input
			
			if(InputManager.intake())
				state = 2;
			if(InputManager.release())
				state = 3;
			
			break;
			
		case 2:    //STATE 2 Intake button pressed
			
			if(isFondling == true)
				Robot.ballfondler.squeeze();
			else 
				Robot.ballfondler.fondle();
			
			if(release == true)
				state = 3;
				
			break;
			
		case 3:     //STATE 3 Release button pressed
			
			Robot.ballfondler.stopFondling();
			state = 1;
					
			break;
			
		}
	}

}
