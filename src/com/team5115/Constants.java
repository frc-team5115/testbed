package com.team5115;

public class Constants {

	public static final double DELAY = 0.005;

	// Buttons and Axes
	public static final int AXIS_X = 1;
	public static final int AXIS_Y = 2;
	public static final int BUTTON_QUICK_TURN = 9;
	public static final double JOYSTICK_DEADBAND = 0.01;
	public static final int BUTTON_ARM_UP = 6;
	public static final int BUTTON_ARM_DOWN = 8;
	public static final int BUTTON_FONDLE_START = 6;
	public static final int BUTTON_FONDLE_STOP = 8;

	// Motors
	public static final int FRONT_LEFT_MOTOR_ID = 1;
	public static final int FRONT_RIGHT_MOTOR_ID = 2;
	public static final int BACK_LEFT_MOTOR_ID = 3;
	public static final int BACK_RIGHT_MOTOR_ID = 4;

	// Driving
	public static final double QUICK_TURN_POWER = 0.5;
	public static final double NEG_INERTIA_TURN = 1.0;
	public static final double NEG_INERTIA_SPEED = 1.0;
	
	// Sensors
	public static final int BALL_FONDLER_LIMIT = 0;
	public static final int ARM_LIMIT_TOP = 1;
	public static final int ARM_LIMIT_BOTTOM = 2;

}
