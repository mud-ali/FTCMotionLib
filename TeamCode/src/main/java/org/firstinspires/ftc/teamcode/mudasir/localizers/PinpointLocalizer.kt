package org.firstinspires.ftc.teamcode.mudasir.localizers

import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit
import org.firstinspires.ftc.robotcore.external.navigation.UnnormalizedAngleUnit
import org.firstinspires.ftc.teamcode.mudasir.lib.GoBildaPinpointDriver

class PinpointLocalizer : Localizer {

    private lateinit var pinpoint : GoBildaPinpointDriver
    private var lastSampleTime = System.nanoTime() - 1e8

    override fun setHardwareMap(hardwareMap: HardwareMap) {
        pinpoint = hardwareMap.get(GoBildaPinpointDriver::class.java, "odo")
    }

    override fun getX(): Double {
        return pinpoint.getPosX(DistanceUnit.INCH)
    }

    override fun getY(): Double {
        return pinpoint.getPosY(DistanceUnit.INCH)
    }

    override fun getHeading(): Double {
        return pinpoint.getHeading(AngleUnit.DEGREES)
    }

    override fun getVelocityX(): Double {
        return pinpoint.getVelX(DistanceUnit.INCH)
    }

    override fun getVelocityY(): Double {
        return pinpoint.getVelY(DistanceUnit.INCH)
    }

    override fun getAngularVelocity(): Double {
        return pinpoint.getHeadingVelocity(UnnormalizedAngleUnit.DEGREES)
    }

    /**
     * This method should be called in a loop to update the localizer's state.
     * @return the time since the last update in seconds.
     */
    override fun update(): Double {
        val currentTime = System.nanoTime()
        val timeDiff = (currentTime - lastSampleTime) / 1e9
        lastSampleTime = currentTime.toDouble()
        return timeDiff
    }
}