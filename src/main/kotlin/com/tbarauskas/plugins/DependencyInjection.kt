package com.tbarauskas.plugins

import com.tbarauskas.database.DataBaseConfig
import com.tbarauskas.database.postgresqlDbModule
import com.tbarauskas.module.driver.driverServiceModule
import com.typesafe.config.ConfigFactory
import io.ktor.application.*
import org.koin.ktor.ext.Koin

fun Application.configureDependencyInjection() {
    val config = ConfigFactory.load()

    val dataBaseConfig = DataBaseConfig.fromConfigs(config)

    install(Koin) {
        modules(
            postgresqlDbModule(dataBaseConfig),
            driverServiceModule
        )
    }
}
