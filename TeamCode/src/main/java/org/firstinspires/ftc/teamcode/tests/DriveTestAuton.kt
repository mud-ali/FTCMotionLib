package org.firstinspires.ftc.teamcode.tests

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.mudasir.MecanumDrive
import org.firstinspires.ftc.teamcode.mudasir.localizers.Unlocalizer
import org.firstinspires.ftc.teamcode.setup.configure

class DriveTestAuton : LinearOpMode() {

    override fun runOpMode() {
        configure()
        val localizer = Unlocalizer()
        val drive = MecanumDrive(hardwareMap, localizer)

        waitForStart()

        drive.moveTo(24.0,0.0,0.0)
        sleep(1000)
        drive.moveTo(0.0,0.0,0.0)
        sleep(1000)
    }
}