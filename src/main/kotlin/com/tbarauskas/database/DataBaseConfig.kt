package com.tbarauskas.database

import com.typesafe.config.Config

data class DataBaseConfig(
    val url: String,
    val username: String,
    val password: String
) {
    companion object {
        fun fromConfigs(config: Config): DataBaseConfig {
            val dataBaseBranch = config.getConfig("dataBase")
            return DataBaseConfig(
                url = dataBaseBranch.getString("jdbcUrl"),
                username = dataBaseBranch.getString("username"),
                password = dataBaseBranch.getString("password")
            )
        }
    }
}
