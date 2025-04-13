package org.firstinspires.ftc.teamcode.mudasir

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import kotlin.math.max

class MecanumDrive(hardwareMap: HardwareMap) {

    private val frontLeftMotor: DcMotor = hardwareMap.get(DcMotor::class.java, RobotConfig.frontLeftMotorName)
    private val frontRightMotor: DcMotor = hardwareMap.get(DcMotor::class.java, RobotConfig.frontRightMotorName)
    private val backLeftMotor: DcMotor = hardwareMap.get(DcMotor::class.java, RobotConfig.backLeftMotorName)
    private val backRightMotor: DcMotor = hardwareMap.get(DcMotor::class.java, RobotConfig.backRightMotorName)
    private lateinit var localizer: Localizer

    init {
        frontLeftMotor.direction = DcMotorSimple.Direction.FORWARD
        backLeftMotor.direction = DcMotorSimple.Direction.REVERSE
        frontRightMotor.direction = DcMotorSimple.Direction.FORWARD
        backRightMotor.direction = DcMotorSimple.Direction.REVERSE

        frontLeftMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
        frontRightMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
        backLeftMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
        backRightMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER

        frontLeftMotor.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        frontRightMotor.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        backLeftMotor.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        backRightMotor.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER

        frontLeftMotor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        frontRightMotor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backLeftMotor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backRightMotor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
    }

    constructor(hardwareMap: HardwareMap, localizer: Localizer) : this(hardwareMap) {
        this.localizer = localizer
        this.localizer.setHardwareMap(hardwareMap)
    }


    fun move(x: Double, y: Double, rotation: Double) {
        val maxPower = max(y+x+rotation, 1.0)

        val frontLeftPower = y + x + rotation
        val frontRightPower = y - x - rotation
        val backLeftPower = y - x + rotation
        val backRightPower = y + x - rotation

        frontLeftMotor.power = frontLeftPower / maxPower
        frontRightMotor.power = frontRightPower / maxPower
        backLeftMotor.power = backLeftPower / maxPower
        backRightMotor.power = backRightPower / maxPower
    }

    fun moveTo(x: Double, y: Double, heading: Double) {
        val currentX = localizer.getX()
        val currentY = localizer.getY()
        val currentHeading = localizer.getHeading()

        val errorX = x - currentX
        val errorY = y - currentY
        val errorHeading = heading - currentHeading

        //TODO: use PID to assign motor powers
    }
}