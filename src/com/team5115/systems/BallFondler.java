package com.team5115.systems;

import com.team5115.robot.InputManager;

import edu.wpi.first.wpilibj.Victor;

public class BallFondler {
	Victor shooter;
	boolean intake;
	boolean release;
	boolean isFondling;
	
	
	public BallFondler() {
		shooter = new Victor(0);
		intake = InputManager.intake();
		release = InputManager.release();
		isFondling = InputManager.isfondled();
	}
	
	public void fondle() {
		if(intake == true)
			shooter.set(.7);
	}
	
	public void stopFondling() {
		if(release == true)
			shooter.set(-.7);
	}
	
	public void squeeze() {
		if(intake == release){
			shooter.set(0);
		}
	}
}
