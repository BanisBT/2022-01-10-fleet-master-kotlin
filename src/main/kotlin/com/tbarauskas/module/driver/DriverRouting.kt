package com.tbarauskas.module.driver

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.driverRouting() {
    val driverService by inject<DriverService>()

    route("/drivers") {

        get("/all") {
            call.respond(driverService.getAllDrivers())
        }
    }
}

fun Application.registerDriverRouting() {
    routing {
        driverRouting()
    }
}
