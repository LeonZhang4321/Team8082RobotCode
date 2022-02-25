// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final Conveyor m_conveyor = new Conveyor();
    public final Intake m_intake = new Intake();
    public final Chassis m_chassis = new Chassis();

// Joysticks
private final XboxController gamepadF310 = new XboxController(1);
private final Joystick joystick3D = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems
    SmartDashboard.putData(m_conveyor);
    SmartDashboard.putData(m_intake);
    SmartDashboard.putData(m_chassis);


    // SmartDashboard Buttons
    SmartDashboard.putData("AutonomousCmd", new AutonomousCmd( m_chassis ));
   // SmartDashboard.putData("TeleDriveCmd", new TeleDriveCmd( m_chassis )); //KZ commented on Feb 25
    SmartDashboard.putData("IntakeBallCmd", new IntakeBallCmd( m_intake ));
    SmartDashboard.putData("StopConveyCmd", new StopConveyCmd( m_conveyor ));
    SmartDashboard.putData("ConveyBallCmd", new ConveyBallCmd( m_conveyor ));
    SmartDashboard.putData("StopIntakeCmd", new StopIntakeCmd( m_intake ));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_conveyor.setDefaultCommand(new StopConveyCmd( m_conveyor ) );
    m_intake.setDefaultCommand(new StopIntakeCmd( m_intake ) );
    //m_chassis.setDefaultCommand(new TeleDriveCmd( m_chassis ) );
    m_chassis.setDefaultCommand(new TeleDriveCmd(m_chassis,()->joystick3D.getRawAxis(1),()->joystick3D.getRawAxis(2)));


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.addOption("AutonomousCmd", new AutonomousCmd( m_chassis ));
    m_chooser.setDefaultOption("AutonomousCmd", new AutonomousCmd( m_chassis ));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
    
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
final JoystickButton buttonY = new JoystickButton(gamepadF310, XboxController.Button.kY.value);        
buttonY.whenPressed(new StopConveyCmd( m_conveyor ) ,true);
    SmartDashboard.putData("buttonY",new StopConveyCmd( m_conveyor ) );

final JoystickButton buttonX = new JoystickButton(gamepadF310, XboxController.Button.kX.value);        
buttonX.whenPressed(new ConveyBallCmd( m_conveyor ) ,true);
    SmartDashboard.putData("buttonX",new ConveyBallCmd( m_conveyor ) );

final JoystickButton buttonB = new JoystickButton(gamepadF310, XboxController.Button.kB.value);        
buttonB.whenPressed(new StopIntakeCmd( m_intake ) ,true);
    SmartDashboard.putData("buttonB",new StopIntakeCmd( m_intake ) );

final JoystickButton buttonA = new JoystickButton(gamepadF310, XboxController.Button.kA.value);        
buttonA.whenPressed(new IntakeBallCmd( m_intake ) ,true);
    SmartDashboard.putData("buttonA",new IntakeBallCmd( m_intake ) );



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
    //SmartDashboard.putData("Turn90",new Turn(90)); //KZ 2022-01-19 added
    //buttonA.debounce(0.1,DebounceType.kBoth).whenActive(new AutonomousCommand() ,true);
    
    // Binds an ExampleCommand to be scheduled when both the 'X' and 'Y' buttons of the driver gamepad are pressed
    //buttonA.and(buttonB).whileActiveOnce(new StopIntakeCmd(m_intake));

  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getjoystick3D() {
        return joystick3D;
    }

public XboxController getgamepadF310() {
      return gamepadF310;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    //1:
    return m_chooser.getSelected();  

    //2:
    //return new T1Group();

    //3:
    // return new SequentialCommandGroup(
    //   new Turn(90),  
    //   new ParallelCommandGroup(
    //     new AutonomousCmd(), 
    //     new DriveCmd(m_chassis) 
    //     )
    // );

  }  

}

