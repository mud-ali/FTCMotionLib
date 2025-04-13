package org.firstinspires.ftc.teamcode.mudasir

import kotlin.math.max
import kotlin.math.min

class PID(val kp: Double, val ki: Double, val kd: Double, val kf: Double = 0.0) {

    /**
     * f(kf, error) : feedforward segment of PIDF output
     */
    private var ffEquation : ((Double, Double) -> Double)? = null

    constructor(kp: Double, ki: Double, kd: Double, kf: Double = 0.0, ffEquation: (Double, Double) -> Double) : this(kp, ki, kd, kf) {
        this.ffEquation = ffEquation
    }

    private val errorHistory = mutableListOf<Double>()
    private var integral = 0.0

    fun evalPID(error : Double, dt: Double) : Double {
        var output = kp * error

        // compute the derivative
        var derivative = 0.0
        if (errorHistory.size >= 2) {
            derivative = (errorHistory[errorHistory.size - 2] - error) / (2*dt)
        } else if (errorHistory.size == 1) {
            derivative = (errorHistory[0] - error) / dt
        }
        
        output += kd * derivative
        
        // compute the integral
        if (errorHistory.size >= 1) {
            integral += (errorHistory.last() + error) * dt
        }

        output += ki * integral

        // compute the feedforward
        val feedforward = ffEquation?.invoke(kf, error) ?: 0.0
        output += feedforward

        errorHistory.add(error)
        if (errorHistory.size >= 4) {
            errorHistory.removeAt(0)
        }

        return min(max(output, -1.0), 1.0)
    }
}
