package com.team5115.statemachines;

import com.team5115.robot.Robot;

import edu.wpi.first.wpilibj.Timer;


public class AreYouGoing extends StateMachineBase {
	
	double speed;
	double tiem;
	double throttle;
	boolean doneDriving;
	double startTime;
	
	public AreYouGoing() {
				
	}
	
	public void setSpeedTime(double s, double t) {
		startTime = Timer.getFPGATimestamp();
		speed = s;		//speed should be between 1 and -1
		tiem = t;
		Timer.delay(.05);
		
	}
	
	public void update() {
		switch (state) {
		case 1:	//drive forward
			
			double timeElapsed = Timer.getFPGATimestamp();
			
		 if ((timeElapsed - tiem) <= startTime) {	
			Robot.vm.go(speed);
		 }
		 else
			 Robot.vm.go(0);
			break;			
			
		}
	}

}
