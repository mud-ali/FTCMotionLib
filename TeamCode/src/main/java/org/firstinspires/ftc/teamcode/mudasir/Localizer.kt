package org.firstinspires.ftc.teamcode.mudasir

import com.qualcomm.robotcore.hardware.HardwareMap

interface Localizer {
    fun setHardwareMap(hardwareMap: HardwareMap)
    fun getX(): Double
    fun getY(): Double
    fun getHeading(): Double
    fun getVelocity(): Double
    fun getAngularVelocity(): Double
    fun update()
}