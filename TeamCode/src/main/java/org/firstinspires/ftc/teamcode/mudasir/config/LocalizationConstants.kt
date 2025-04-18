package org.firstinspires.ftc.teamcode.mudasir.config

import org.firstinspires.ftc.teamcode.mudasir.lib.GoBildaPinpointDriver

object LocalizationConstants {
    object Pinpoint {
        var xEncoderDir = GoBildaPinpointDriver.EncoderDirection.FORWARD
        var yEncoderDir = GoBildaPinpointDriver.EncoderDirection.REVERSED
        var podsType = GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD
    }
}