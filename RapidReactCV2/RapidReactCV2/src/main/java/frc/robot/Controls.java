package frc.robot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

import edu.wpi.first.math.Pair;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.commands.*;


public class Controls {


  private static Joystick m_rightJoystick, m_leftJoystick, m_operator; 
	private static JoystickButton m_cancelAll;
  private static JoystickButton m_collectorCollect, m_collectorUncollect, m_collectorOpen, m_collectorClose, m_climberDown, m_climberUp, m_storageUp, m_storageDown;
  private static LinkedList<MyPair<Long,Double>> integralCalculator = new LinkedList<>();
  private static LinkedList<MyPair<Long,Double>> integralCalculator2 = new LinkedList<>();
  private static Double integralDuration = 0.5;//in sec
  private static Double lastJoystic = 0.0;
  private static Long lastTime;
  private static Double lastJoystic2 = 0.0;
  private static double prevRspeed = 0;
  private static double prevLspeed = 0;
  
    

  public static void init() {

    // initialize joysticks and operator
    m_rightJoystick = new Joystick(Constants.JoystickPorts.rightJoystick);
    m_leftJoystick = new Joystick(Constants.JoystickPorts.leftJoystick);
    m_operator = new Joystick(Constants.JoystickPorts.operator);
	  m_cancelAll =   new JoystickButton(m_rightJoystick,5);
    // initialize buttons for specific commands later on
    m_collectorOpen = new JoystickButton(m_operator, Constants.ButtonPorts.collectorOpen);
    m_collectorClose = new JoystickButton(m_operator, Constants.ButtonPorts.collectorClose);
    m_collectorCollect = new JoystickButton(m_operator, Constants.ButtonPorts.collectorCollect);
    m_collectorUncollect = new JoystickButton(m_operator, Constants.ButtonPorts.collectorUncollect);

    m_climberDown = new JoystickButton(m_operator, Constants.ButtonPorts.climberDown);
    m_climberUp = new JoystickButton(m_operator, Constants.ButtonPorts.climberUp);

    m_storageUp = new JoystickButton(m_operator, Constants.ButtonPorts.storageUp);
    m_storageDown = new JoystickButton(m_operator, Constants.ButtonPorts.storageDown);
    lastTime = System.currentTimeMillis();
    MyPair<Long,Double> a = new MyPair<>(lastTime, 0.0);
    integralCalculator.add(a);
    MyPair<Long,Double> a2 = new MyPair<>(lastTime, 0.0);
    integralCalculator2.add(a2);
    // initialize commands on buttons
    initCommands();

  }

  public static void movePeriodic() {

    // tank move robot according to the joystick's movement levels

    // --THE OLD CODE, IT WORKS, USE IF NECESSARY-- \\
    // Chassis.getInstance().tankMove(
    //   -m_leftJoystick.getY() * Constants.Speeds.motorSpeed,
    //   -m_rightJoystick.getY() * Constants.Speeds.motorSpeed);
    // --OLD CODE END-- \\
   
    //right
    Long curTime = System.currentTimeMillis();
    double curJoystick = m_rightJoystick.getY();
    double integral = integralCalculator.get(integralCalculator.size() -1).b + (curTime -lastTime)*(curJoystick+lastJoystic)/2;//trapozied area 
    integralCalculator.add(new MyPair<Long,Double>(curTime, integral));
    MyPair<Long,Double> first = integralCalculator.getFirst();
    while(curTime - first.a > integralDuration*1000){
      integralCalculator.remove();
      first = integralCalculator.getFirst();
    }
    double output = (integral-first.b)/(curTime-first.a);
    SmartDashboard.putNumber("RIntegral Output", output);
    SmartDashboard.putNumber("RIntegral Output", output);
    SmartDashboard.putNumber("RJoyStickY", curJoystick);

    lastTime = curTime;
    lastJoystic = curJoystick;

    //left
    double curJoystick2 = m_leftJoystick.getY();
    double integral2 = integralCalculator2.get(integralCalculator2.size() -1).b + (curTime -lastTime)*(curJoystick2+lastJoystic2)/2;//trapozied area 
    integralCalculator2.add(new MyPair<Long,Double>(curTime, integral2));
    MyPair<Long,Double> first2 = integralCalculator2.getFirst();
    while(curTime - first2.a > integralDuration*1000){
      integralCalculator2.remove();
      first2 = integralCalculator2.getFirst();
    }
    double output2 = (integral2-first2.b)/(curTime-first2.a);
    SmartDashboard.putNumber("LIntegral Output", output2);
    SmartDashboard.putNumber("LJoyStickY", curJoystick2);
    lastJoystic2 = curJoystick2;
    // Chassis.getInstance().tankMove(
    //   -m_leftJoystick.getY() * Constants.Speeds.motorSpeed - m_rightJoystick.getY() * Constants.Speeds.driveSoften * Constants.Speeds.motorSpeed,
    //   -m_rightJoystick.getY() * Constants.Speeds.motorSpeed -  m_leftJoystick.getY() * Constants.Speeds.driveSoften * Constants.Speeds.motorSpeed);
    double Lspeed = -m_leftJoystick.getY() * Constants.Speeds.motorSpeed - (m_rightJoystick.getY() * Constants.Speeds.driveSoften * Constants.Speeds.motorSpeed - prevRspeed);
    double Rspeed = -m_rightJoystick.getY() * Constants.Speeds.motorSpeed -  (m_leftJoystick.getY() * Constants.Speeds.driveSoften * Constants.Speeds.motorSpeed - prevLspeed);
        Chassis.getInstance().tankMove(
      Lspeed,
      Rspeed);
    prevLspeed = Lspeed;
    prevRspeed = Rspeed;
  }
  

  private static void initCommands() {

    // make each button do what it was defined for
	final Command cancelAll = new Command(){
		
		@Override
		public boolean isFinished() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void initialize(){
			CommandScheduler.getInstance().cancelAll();
		}
		@Override
		public Set<Subsystem> getRequirements() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	m_cancelAll.whenHeld(cancelAll);
    CollectorOpen collectorOpen = new CollectorOpen();
    m_collectorOpen.whileHeld(collectorOpen);

    CollectorClose collectorClose = new CollectorClose();
    m_collectorClose.whileHeld(collectorClose);

    CollectorCollect collectorCollect = new CollectorCollect();
    m_collectorCollect.whileHeld(collectorCollect);

    CollectorUncollect collectorUncollect = new CollectorUncollect();
    m_collectorUncollect.whileHeld(collectorUncollect);

    ClimberDown climberD = new ClimberDown();
    m_climberDown.whileHeld(climberD);

    ClimberUp climberU = new ClimberUp();
    m_climberUp.whileHeld(climberU);

    StorageUp storageU = new StorageUp();
    m_storageUp.whileHeld(storageU);
    
    StorageDown storageD = new StorageDown();
    m_storageDown.whileHeld(storageD);
  }
}