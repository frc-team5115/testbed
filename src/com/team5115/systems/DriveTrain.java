package com.team5115.systems;

import com.team5115.Constants;

import edu.wpi.first.wpilibj.CANTalon;

public class DriveTrain {
	
	public boolean inuse;
	
	CANTalon frontleft;
	CANTalon frontright;
	CANTalon backleft;
	CANTalon backright;
	
	public int direction;
	
	
	public DriveTrain() {
		frontleft = new CANTalon(Constants.FRONT_LEFT_MOTOR_ID);
		frontright = new CANTalon(Constants.FRONT_RIGHT_MOTOR_ID);
		backleft = new CANTalon(Constants.BACK_LEFT_MOTOR_ID);
		backright = new CANTalon(Constants.BACK_RIGHT_MOTOR_ID);

		backleft.changeControlMode(CANTalon.TalonControlMode.Follower);
		backright.changeControlMode(CANTalon.TalonControlMode.Follower);
		backleft.set(frontleft.getDeviceID());
		backright.set(frontright.getDeviceID());
		
		frontright.setInverted(true);
		direction = 1;
	}
	
	public void drive(double leftSpeed, double rightSpeed, double throttle) {
		if (leftSpeed > 1) {
			leftSpeed = 1;
			rightSpeed /= leftSpeed;
		}
		if (rightSpeed > 1) {
			rightSpeed = 1;
			leftSpeed /= rightSpeed;
		}
		
		frontleft.set(-direction * leftSpeed * Constants.THROTTLE);
		frontright.set(-direction * rightSpeed * Constants.THROTTLE);
	}
	
	 public double leftDist() {
	    	double leftDist = frontleft.getPosition() * direction;
	    	return leftDist / 1440 * 7 * Math.PI / 12;
	    }
	    
	    public double rightDist() {
	    	double rightDist = -frontright.getPosition() * direction;
	    	return rightDist / 1440 * 7 * Math.PI / 12;
	    }
	    
	    public double distanceTraveled() {
	    	return (leftDist() + rightDist()) / 2;
	    }
	    
	    public double leftSpeed() {
	    	double leftspeed = frontleft.getSpeed();
	    	return leftspeed;
	    }
	    
	    public double rightSpeed() {
	    	double rightspeed = frontright.getSpeed();
	    	return rightspeed;
	    }
	    
	    public void resetEncoders() {
	    	frontleft.setPosition(1);
	    	frontright.setPosition(1);
	    }
	}


