package com.team5115.robot;


import java.util.*;
import java.io.*;

import com.team5115.Constants;
import com.team5115.statemachines.AreYouGoing;
import com.team5115.systems.VariousMotors;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	/**
	 * The Robot class handles the basic functions of the robot
	 * Subsystems and State Machines are created and run during the various stages of operation
	 * Robot has 3 distinct phases, autonomous, teleop, and disabled
	 * Autonomous - Robot runs by itself
	 * Teleop - Robot is controlled by the driver
	 * Disabled - Robot is diededed
	 */
	
	// Define subsystems
	public static VariousMotors vm;
	
	// Define state machines
	public static AreYouGoing go;
	
	// Define variables
	
	
	// Initialization phase of the robot
	public void robotInit() {
	// Initialize objects and variables here
		
		go = new AreYouGoing();
		
		vm = new VariousMotors();
		
	}
	
	// Runs when autonomous phase starts
	public void autonomousInit() {
	// Put state machine commands here
		
		go.setSpeedTime(.5, 3);
		go.setState(1);
		
	}
	
	// Runs periodically during the autonomous phase
	public void autonomousPeriodic() {
	// Put state machine commands here
		go.update();
		
	}
	
	// Runs when the remote operation by the driver begins
	public void teleopInit() {
	// Start state machine commands here (Drive, Manipulators, etc.)

	}
	
	// Runs peridoically during the teleoperation
	public void teleopPeriodic() {
	// Put state machine commands here
		
	}
	
	// Runs when the robot enters the disabled state
	public void disabledInit() {}	
	
	// Runs periodically when the robot is disabled
	public void disabledPeriodic() {
		Timer.delay(Constants.DELAY);
	}

}
