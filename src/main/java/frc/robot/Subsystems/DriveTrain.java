package frc.robot.Subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    SparkMax m_left_motor = new SparkMax(4, MotorType.kBrushless);
    SparkMax m_left_motor_f = new SparkMax(3, MotorType.kBrushless);
    SparkMax m_right_motor = new SparkMax(2, MotorType.kBrushless);
    SparkMax m_right_motor_f = new SparkMax(1, MotorType.kBrushless);

    SparkMaxConfig m_left_config = new SparkMaxConfig();
    SparkMaxConfig m_left_f_config = new SparkMaxConfig();
    SparkMaxConfig m_right_config = new SparkMaxConfig();
    SparkMaxConfig m_right_f_config = new SparkMaxConfig();
    
    public DriveTrain() {
        m_left_config.idleMode(IdleMode.kCoast);
        m_left_f_config.follow(4)
                       .idleMode(IdleMode.kCoast);
        m_right_config.inverted(true)
                      .idleMode(IdleMode.kCoast);
        m_right_f_config.inverted(true)
                        .follow(2)
                        .idleMode(IdleMode.kCoast);

        m_left_motor.configure(m_left_config, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
        m_left_motor_f.configure(m_left_f_config, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
        m_right_motor.configure(m_right_config, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
        m_right_motor_f.configure(m_right_f_config, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    public void drive(double forward_axis, double turn_axis) {
        // positive turn = right turn

        m_left_motor.set(forward_axis * 0.5 + turn_axis * 0.25);
        m_right_motor.set(forward_axis * 0.5 - turn_axis * 0.25);
    }

    public double getMotor() {
        return m_right_motor.get();
    }
}
