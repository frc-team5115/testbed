package com.team5115.systems;

import com.team5115.Constants;
import com.team5115.robot.InputManager;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Victor;

public class Arm {
	public boolean inuse;
		
		Victor bicep;
		boolean flex;
		boolean relax;
		boolean isTopLimit;
		boolean isBottomLimit;
		
		public Arm() {
			bicep = new Victor(0);
			flex = InputManager.flex();
			relax = InputManager.relax();
			isTopLimit = InputManager.isTopLimit();
			isBottomLimit = InputManager.isBottomLimit();
		}
		
		public void lift() {
			if(flex == true)
				bicep.set(.7);
			
			if(isTopLimit == true)
				bicep.set(-.5);
		}
		
		public void lower() {
			if(relax == true)
				bicep.set(-.7);
			
			if(isBottomLimit == true)
				bicep.set(.5);
		}
		
		public void hold() {
			if(relax == flex){
				bicep.set(0);
			}
		}
		

}
