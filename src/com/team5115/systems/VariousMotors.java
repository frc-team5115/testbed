package com.team5115.systems;

import com.team5115.Constants;


import edu.wpi.first.wpilibj.Victor;

public class VariousMotors {
	
	public boolean inuse;
	
	Victor aMotor;
	
	public int direction;
	
	
	public VariousMotors() {
		aMotor = new Victor(2);
	
	}
	
	public void go (double amountOfGo) {
		aMotor.set(amountOfGo);
		
	}
}



