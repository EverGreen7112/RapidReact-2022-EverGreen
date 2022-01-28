package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class Controls{

    // creates joystick variables
    private static Joystick m_rightJoystick, m_leftJoystick, m_operatorJoystick; 
    private static JoystickButton m_collectorButton, m_turboButton;
    private static POVButton m_DpadButtonUp;
    private static POVButton m_DpadButtonDown;
    

  // initialize \\
  //-------------------------------------------------------------------------------------------------------------\\
  public static void init() {
    // Joysticks \\
    m_rightJoystick = new Joystick(Constants.JoystickPorts.rightChassisJS);
    m_leftJoystick = new Joystick(Constants.JoystickPorts.leftChassisJS);
    m_operatorJoystick = new Joystick(Constants.JoystickPorts.operatorJS);

    // Left & Right Joystick Buttons \\
    m_collectorButton = new JoystickButton(m_rightJoystick, Constants.ButtonPorts.RIGHT_JS_COLLECTOR);
    m_turboButton = new JoystickButton(m_leftJoystick, Constants.ButtonPorts.LEFT_JS_TURBO);
  
    // Operator Buttons \\
    // NOTE: pove buttons need to get actual angles from 0 to 360 with 0 being up and 180 down going clockwise
    m_DpadButtonUp = new POVButton(m_operatorJoystick, 0); 
    m_DpadButtonDown = new POVButton(m_operatorJoystick, 180);
  }
  
  //-----------------------------------------------------------------------------\\
  // Joysticks \\
  // gets the left joystick
  public static Joystick getM_leftJoystick() {
      return m_leftJoystick;
  }

  // gets the right joystick
  public static Joystick getM_rightJoystick() {
      return m_rightJoystick;
  }

  // gets the operator joystick 
  public static Joystick getM_operatorJoystick() {
      return m_operatorJoystick;
  }

  //--------------------------------------------------------------------------------\\

  // Buttons \\
  // gets the Collector button
  public static JoystickButton getM_collectorButton() {
    return m_collectorButton;
  }
  //--------------------------------------------------------------------------------\\
  
  // uses tank-drive whil in periodic mode
  public static void movePeriodic() { 
    boolean operatorOrJoystic = true;
    double leftSpeed, rightSpeed; 
    
    // Joystick \\
    if (operatorOrJoystic) {
      leftSpeed = m_leftJoystick.getY() * NoneConstants.get_chassisSpeed();
      rightSpeed = m_rightJoystick.getY() * NoneConstants.get_chassisSpeed();
    } 
    // Operator \\
    else {
      leftSpeed = m_operatorJoystick.getRawAxis(1) * NoneConstants.get_chassisSpeed();
      rightSpeed = m_operatorJoystick.getRawAxis(3) * NoneConstants.get_chassisSpeed();
    }
    
    Chassis.getInstance().tankMove(leftSpeed,rightSpeed);
  }

  // all the commands that are linked to buttons are initialized here \\
  public static void commandsPeriodic() {
    // Collector Command \\
    CollectorComm collectorComm = new CollectorComm();
    m_collectorButton.whenHeld(collectorComm);

    // Turbo Command \\
    Turbo turbo = new Turbo();
    m_turboButton.whenHeld(turbo);
  }


  public static int getDPadY(){
    return (m_DpadButtonUp.get() ? 1 : 0) + (m_DpadButtonDown.get() ? -1 : 0);
  }
}