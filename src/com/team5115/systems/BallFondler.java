package com.team5115.systems;

import com.team5115.Constants;
import com.team5115.robot.InputManager;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;

public class BallFondler {
	Victor shooter;
	boolean intake;
	boolean release;
	DigitalInput isFondling;
	
	public BallFondler() {
		shooter = new Victor(2);
		intake = InputManager.intake();
		release = InputManager.release();
		isFondling = new DigitalInput(Constants.BALL_FONDLER_LIMIT);

	}
	
	public void fondle() {
		if(intake)
			shooter.set(.7);
	}
	
	public void stopFondling() {
		if(release)
			shooter.set(-.7);
	}
	
	public void squeeze() {
		if(intake == release){
			shooter.set(0);
		}
	}

	public boolean isfondled(){
		return isFondling.get();
	}

}
