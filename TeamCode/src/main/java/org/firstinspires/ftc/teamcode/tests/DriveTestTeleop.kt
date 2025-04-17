package org.firstinspires.ftc.teamcode.tests

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.mudasir.MecanumDrive

@TeleOp(name="DriveTestTeleop", group="hardwareTests")
class DriveTestTeleop : OpMode() {

    private lateinit var drive : MecanumDrive

    override fun init() {
        drive = MecanumDrive(hardwareMap)
    }

    override fun loop() {
        drive.move(
            gamepad1.left_stick_x.toDouble(),
            -gamepad1.left_stick_y.toDouble(),
            gamepad1.right_stick_x.toDouble()
        )
    }
}