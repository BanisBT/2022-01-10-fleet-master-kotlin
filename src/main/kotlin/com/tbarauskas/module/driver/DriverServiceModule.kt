package com.tbarauskas.module.driver

import org.jdbi.v3.core.Jdbi
import org.koin.dsl.module
import org.jdbi.v3.sqlobject.kotlin.onDemand

val driverServiceModule = module {
    single {
        get<Jdbi>().onDemand<DriverDAO>()
    }
    single {
        DriverService(get())
    }
}
