package org.firstinspires.ftc.teamcode.mudasir

import com.qualcomm.robotcore.hardware.HardwareMap

interface Localizer {
    fun setHardwareMap(hardwareMap: HardwareMap)
    fun getX(): Double
    fun getY(): Double
    fun getHeading(): Double
    fun getVelocity(): Double
    fun getAngularVelocity(): Double
    /**
     * This method should be called in a loop to update the localizer's state.
     * @return the time since the last update in seconds.
     */
    fun update() : Double
}