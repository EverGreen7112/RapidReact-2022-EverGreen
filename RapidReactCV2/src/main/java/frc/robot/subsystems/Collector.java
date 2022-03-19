package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collector extends SubsystemBase {

	private static Collector m_collector = new Collector(); // collector's instance

	private WPI_VictorSPX m_collectorMotorOpen, m_collectorMotorCollect;

	private DigitalInput m_switchUp;// , m_switchDown;

	public Collector() {

		// initialize open motor and turning ("Collect") motor, fix rotation for head
		// side
		m_collectorMotorOpen = new WPI_VictorSPX(Constants.MotorPorts.collectorOpen);
		m_collectorMotorCollect = new WPI_VictorSPX(Constants.MotorPorts.collectorCollect);

		m_collectorMotorOpen.setNeutralMode(NeutralMode.Brake);

		m_collectorMotorCollect.setInverted(true);

		// initialize microswitches for when to stop movement upwards and downwards
		// m_switchUp = new DigitalInput(Constants.DigitalPorts.switchUp);
		// m_switchDown = new DigitalInput(Constants.DigitalPorts.switchDown);

	}

	public static Collector getInstance() {
		return m_collector;
	}

	public boolean isUp() {

		// was microswitch maximizing up movement pressed
		return false;

	}

	public boolean isDown() {

		// was microswitch maximizing down movement pressed
		// return m_switchDown.get();
		return false;

	}

	public void open(double speed) {

		// open / close (depends on speed > 0 or not) using the motor
		m_collectorMotorOpen.set(speed);

	}

	public void set(double speed) {

		// make collector collection rode spin
		m_collectorMotorCollect.set(speed);

	}

}
