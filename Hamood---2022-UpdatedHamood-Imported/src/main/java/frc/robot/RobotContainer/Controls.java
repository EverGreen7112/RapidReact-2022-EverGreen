package frc.robot.RobotContainer;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.commands.Swurv;
import frc.robot.commands.CollectorCommands.CollectorComm;


public class Controls{

    // creates joystick variables \\
    private static Joystick m_rightJoystick, m_leftJoystick, m_operatorJoystick; 

    // Joystick Button Variables \\
    private static JoystickButton m_collectorButton;
    private static POVButton m_DpadButtonUp, m_DpadButtonDown;
    

  // initialize \\
  //-------------------------------------------------------------------------------------------------------------\\
  public static void init() {
    // Joysticks \\
    m_rightJoystick = new Joystick(Constants.JoystickPorts.rightChassisJS);
    m_leftJoystick = new Joystick(Constants.JoystickPorts.leftChassisJS);
    m_operatorJoystick = new Joystick(Constants.JoystickPorts.operatorJS);

    // Left & Right Joystick Buttons \\
    m_collectorButton = new JoystickButton(m_leftJoystick, Constants.ButtonPorts.LEFT_JS_COLLECTOR);
  
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
      leftSpeed = m_leftJoystick.getY() * Constants.MathConsts.CHASSIS_MOTOR_SPEED;
      rightSpeed = m_rightJoystick.getY() * Constants.MathConsts.CHASSIS_MOTOR_SPEED;
    } 
    // Operator \\
    else {
      leftSpeed = m_operatorJoystick.getRawAxis(1) * Constants.MathConsts.CHASSIS_MOTOR_SPEED;
      rightSpeed = m_operatorJoystick.getRawAxis(3) * Constants.MathConsts.CHASSIS_MOTOR_SPEED;
    }
    
    Chassis.getInstance().tankMove(leftSpeed,rightSpeed);
  }

  // all the commands that are linked to buttons are initialized here \\
  public static void commandsPeriodic() {
    // Collector Command \\
    CollectorComm collectorComm = new CollectorComm();
    m_collectorButton.whileHeld(collectorComm);

    // Swurv command
    Swurv swurvComm = new Swurv();
    swurvComm.execute();
    // m_collectorButton.whenHeld(swurvComm);
    SmartDashboard.putNumber("Gyro Angle", Chassis.getInstance().getGyro().getAngle());
    SmartDashboard.putNumber("Joystick angle", Controls.getRightJoystickAsAngle());
  }


  public static int getDPadY(){
    return (m_DpadButtonUp.get() ? 1 : 0) + (m_DpadButtonDown.get() ? -1 : 0);
  }

  public static double getRightJoystickAsAngle(){
    return ((Math.atan2(-m_rightJoystick.getX(), m_rightJoystick.getY()) * 180 / Math.PI) + 180) % 360;
  }
}