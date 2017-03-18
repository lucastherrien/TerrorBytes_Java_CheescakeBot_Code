package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.subsystems.DriveTrain;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTankTimed extends Command {

	double leftpower;
	double rightpower;
	double seconds;
	
    public DriveTankTimed(double left, double right, double seconds) {
        requires(Robot.driveTrain);
        this.leftpower = left;
        this.rightpower = right;
        this.seconds = seconds;
        setTimeout(seconds);
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    		System.out.println("[Command] Intializing DriveTankTimed for " + seconds + " seconds");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.driveTrain.driveTank(leftpower, rightpower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
