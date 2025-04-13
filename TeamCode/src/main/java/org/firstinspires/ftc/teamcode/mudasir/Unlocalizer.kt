package org.firstinspires.ftc.teamcode.mudasir

import com.qualcomm.robotcore.hardware.HardwareMap

/**
 * This class can be used when no localization is needed or when a specific localization method is not implemented yet.
 * It provides default values for all the methods in the Localizer interface.
 */
class Unlocalizer : Localizer {

    private lateinit var hardwareMap: HardwareMap

    override fun setHardwareMap(hardwareMap: HardwareMap) {
        this.hardwareMap = hardwareMap
    }

    override fun getX(): Double {
        return 0.0
    }

    override fun getY(): Double {
        return  0.0
    }

    override fun getHeading(): Double {
        return 0.0
    }

    override fun getVelocity(): Double {
        return 0.0
    }

    override fun getAngularVelocity(): Double {
        return 0.0
    }

    override fun update() {
        return
    }

}