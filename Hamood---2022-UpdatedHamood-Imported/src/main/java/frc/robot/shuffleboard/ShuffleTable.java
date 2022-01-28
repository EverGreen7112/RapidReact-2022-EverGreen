package frc.robot.shuffleboard;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class ShuffleTable extends TimedRobot {
   NetworkTableEntry xEntry;
   NetworkTableEntry yEntry;

   public void robotInit() {
      NetworkTableInstance inst = NetworkTableInstance.getDefault();

      NetworkTable table = inst.getTable("datatable");

      xEntry = table.getEntry("X");
      yEntry = table.getEntry("Y");
   }

   double x = 0;
   double y = 0;

   public void teleopPeriodic() {
      xEntry.setDouble(x);
      yEntry.setDouble(y);
      x += 0.05;
      y += 1.0;
   }
}