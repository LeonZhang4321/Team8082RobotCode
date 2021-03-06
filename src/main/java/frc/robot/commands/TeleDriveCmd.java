// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.commands;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Chassis;


// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.Chassis;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class TeleDriveCmd extends CommandBase {
    //private Joystick m_DriveStick;  //kz add 2022
    //private Chassis myChassis; //kz add 2022
    private final Supplier<Double> speedFunction, turnFunction;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
        private final Chassis m_chassis;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


    //public TeleDriveCmd(Chassis subsystem) {
    public TeleDriveCmd(Chassis subsystem, Supplier<Double> speedFunction, Supplier<Double> turnFunction) { 
        this.speedFunction = speedFunction; //KZ added on Feb 25
        this.turnFunction = turnFunction;   //KZ added on Feb 25
        this.m_chassis = subsystem;         //KZ added on Feb 25

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        //m_chassis = subsystem; //KZ commented on Feb 25
        addRequirements(m_chassis);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
      //addRequirements(RobotContainer.getInstance().m_chassis);
      //m_DriveStick = RobotContainer.getInstance().getJoystick3D(); // return joystick3D = new Joystick(0);
      //getInstance().getJoystick3D(); //kz add 2022
     //m_chassis = RobotContainer.getInstance().m_chassis; //kz add 2022
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
       // m_chassis.encoderReset();   
        System.out.println("Teleop DriveCmd Started!");
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double realTimeSpeed = speedFunction.get();
        double realTimeTurn = turnFunction.get();

        double left = realTimeSpeed + realTimeTurn;
        double right = realTimeSpeed - realTimeTurn;
        m_chassis.setMotors(left, right);
       
       
        //double xSpeed = myDriveStick.getY(); //kz: see ppt or joystick map
        //double zRotation = myDriveStick.getX(); //kz: see ppt or joystick map
        
        
        //double forw = -1 * RobotContainer.getInstance().getjoystick3D().getRawAxis(1); /* positive is forward */
        //double turn = +1 * RobotContainer.getInstance().getjoystick3D().getRawAxis(2); /* positive is right */                                    
        //m_chassis.ArcadeDrive(forw, turn, false);  //true means exponetial trottle
        

        /* -------- [2] Make sure Gamepad Forward is positive for FORWARD, and GZ is positive for RIGHT */
       // work << "A: " << Abutton << "T: " << m_timer.Get().to<double>() << " GF:" << forw << " GT:" << turn << " ME:" << m_encoder.GetDistance();

        /* get sensor values */
        //double leftPos = _leftFront->GetSelectedSensorPosition(0);
        //double rightPos = _rightFront->GetSelectedSensorPosition(0);
         //work << " L:" << leftVelUnitsPer100ms << " R:" << rightVelUnitsPer100ms;
        // double leftVelUnitsPer100ms = m_chassis.GetLeftSelectedSensorVelocity();
        // double rightVelUnitsPer100ms =m_chassis.GetRightSelectedSensorVelocity();
        // System.out.printf(" L:", leftVelUnitsPer100ms, "       R:",  rightVelUnitsPer100ms);
        // System.out.println("Teleop DriveCmd Executing!");       
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        //m_chassis.stop(); //KZ commented on Feb 25
        System.out.println("Teleop DriveCmd ended!");
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {                 
        return false;        
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
