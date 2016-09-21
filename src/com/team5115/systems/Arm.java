package com.team5115.systems;

import com.team5115.Constants;
import com.team5115.robot.InputManager;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;

public class Arm {
	public boolean inuse;
		
		Victor bicep;
		Victor bicep2;
		boolean flex;
		boolean relax;
		DigitalInput topLimit;
		DigitalInput bottomLimit;
		
		public Arm() {
			bicep = new Victor(0);
			bicep2 = new Victor(1);
			flex = InputManager.flex();
			relax = InputManager.relax();
		
			topLimit = new DigitalInput(Constants.ARM_LIMIT_TOP);
			bottomLimit = new DigitalInput(Constants.ARM_LIMIT_BOTTOM);
		}
		
		public void lift() {
			if(flex)
				bicep.set(.7);
				bicep2.set(.7);
			
			if(getTopLimit())
				bicep.set(-.5);
				bicep2.set(-.5);
		}
		
		public void lower() {
			if(relax)
				bicep.set(-.7);
				bicep2.set(-.7);
			
			if(getBottomLimit())
				bicep.set(.5);
				bicep2.set(.5);
		}
		
		public void hold() {
			if(relax == flex){
				bicep.set(0);
				bicep2.set(0);
			}
		}
		
		public boolean getTopLimit() {
			return topLimit.get();
		}
		
		public boolean getBottomLimit() {
			return bottomLimit.get();
		}

}
