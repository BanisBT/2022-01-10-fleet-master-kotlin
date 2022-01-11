package com.tbarauskas.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.sqlobject.SqlObjectPlugin
import org.jdbi.v3.sqlobject.kotlin.KotlinSqlObjectPlugin
import org.koin.dsl.module

fun postgresqlDbModule(dataBaseConfig: DataBaseConfig) = module {
    single {
        val config = HikariConfig()
        config.jdbcUrl = dataBaseConfig.url
        config.username = dataBaseConfig.username
        config.password = dataBaseConfig.password
        HikariDataSource(config)
    }
    single {
        val dataSource = get<HikariDataSource>()
        val jdbi = Jdbi.create(dataSource)
        jdbi.installPlugin(SqlObjectPlugin())
        jdbi.installPlugin(KotlinPlugin())
        jdbi.installPlugin(KotlinSqlObjectPlugin())

        jdbi
    }
}
