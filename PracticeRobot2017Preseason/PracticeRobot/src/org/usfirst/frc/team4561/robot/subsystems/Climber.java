
package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Climber core subsystem file
 */
public class Climber extends Subsystem {
    
	private SpeedController climberMotor;
	
	public void selectMotorController(String MOTOR_CONTROLLER_TYPE){
	
	if(MOTOR_CONTROLLER_TYPE == "CANtalon"){
		climberMotor = new CANTalon(RobotMap.CLIMBER_MOTOR_PORT);
	}
	
	else if(MOTOR_CONTROLLER_TYPE == "spark"){
		climberMotor = new Spark(RobotMap.CLIMBER_MOTOR_PORT);
	}
	
	else if(MOTOR_CONTROLLER_TYPE == "victor"){
		climberMotor = new Victor(RobotMap.CLIMBER_MOTOR_PORT);
	}
	
	else{
		System.out.println("motor controller selection failed\nfind an FRC legal motor controller or implement option for desired "
				+ "legal controller");
		climberMotor = null;
	}
	
  }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setClimber(double power) {
    	climberMotor.set(power);
    }
}

