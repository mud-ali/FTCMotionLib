package org.firstinspires.ftc.teamcode.setup

import org.firstinspires.ftc.teamcode.mudasir.PID
import org.firstinspires.ftc.teamcode.mudasir.config.LocalizationConstants
import org.firstinspires.ftc.teamcode.mudasir.config.PIDConfig
import org.firstinspires.ftc.teamcode.mudasir.config.RobotConfig
import org.firstinspires.ftc.teamcode.mudasir.lib.GoBildaPinpointDriver

fun configure() {
    // Override config values here
    RobotConfig.backLeftMotorName = "BL"
    PIDConfig.MecanumPIDX = PID(3.0,0.1,0.01)
    LocalizationConstants.Pinpoint.xEncoderDir = GoBildaPinpointDriver.EncoderDirection.REVERSED
}