
package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

import com.ctre.CANTalon;

/**
 *
 */
public class DriveTrain extends Subsystem {
	SpeedController frontRight;
	SpeedController frontLeft;
	SpeedController rearLeft;
	SpeedController rearRight;
	
	public void selectMotorController(String MOTOR_CONTROLLER_TYPE){
		if(MOTOR_CONTROLLER_TYPE=="CANTalon"){
			 frontRight = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR_PORT);
			 frontLeft = new CANTalon(RobotMap.FRONT_LEFT_MOTOR_PORT);
			 rearRight = new CANTalon(RobotMap.REAR_RIGHT_MOTOR_PORT);
			 rearLeft = new CANTalon(RobotMap.REAR_LEFT_MOTOR_PORT);
		}
		else if(MOTOR_CONTROLLER_TYPE == "spark"){
			 frontRight = new Spark(RobotMap.FRONT_RIGHT_MOTOR_PORT);
			 frontLeft = new Spark(RobotMap.FRONT_LEFT_MOTOR_PORT);
			 rearRight = new Spark(RobotMap.REAR_RIGHT_MOTOR_PORT);
			 rearLeft = new Spark(RobotMap.REAR_LEFT_MOTOR_PORT);
		}
		else if(MOTOR_CONTROLLER_TYPE == "victor"){
			 frontRight = new Victor(RobotMap.FRONT_RIGHT_MOTOR_PORT);
			 frontLeft = new Victor(RobotMap.FRONT_LEFT_MOTOR_PORT);
			 rearRight = new Victor(RobotMap.REAR_RIGHT_MOTOR_PORT);
			 rearLeft = new Victor(RobotMap.REAR_LEFT_MOTOR_PORT);
		}
		else{
			System.out.println("motor controller selection failed\nfind an FRC legal motor controller or implement option for desired "
					+ "legal controller");
			frontRight = null;
			frontLeft = null;
			rearRight = null;
			rearLeft = null;
		}
	}
	
	RobotDrive robotDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDrive());
    	
    }
    
    public void driveTank(double leftPower, double rightPower) {
    	robotDrive.tankDrive(leftPower, rightPower);
    }
}

