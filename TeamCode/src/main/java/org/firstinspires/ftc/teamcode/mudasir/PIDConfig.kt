package org.firstinspires.ftc.teamcode.mudasir

import kotlin.math.cos

object PIDConfig {
    var MecanumPIDX : PID = PID(
        kp = 0.1,
        ki = 0.01,
        kd = 0.001,
        kf = 0.0
    )
    var MecanumPIDY : PID = PID(
        kp = 0.1,
        ki = 0.01,
        kd = 0.001,
        kf = 0.0
    )
    var MecanumPIDHeading : PID = PID(
        kp = 0.1,
        ki = 0.01,
        kd = 0.001,
        kf = 0.01,
        ffEquation = { kf, error -> kf * cos(error) }
    )
}