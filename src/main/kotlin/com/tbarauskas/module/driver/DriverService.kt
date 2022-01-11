package com.tbarauskas.module.driver

class DriverService(
    private val driverDAO: DriverDAO
) {
    fun getAllDrivers(): List<Driver> {
        return driverDAO.getAllDrivers()
    }
}
