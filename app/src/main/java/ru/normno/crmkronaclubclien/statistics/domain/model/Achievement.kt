package ru.normno.crmkronaclubclien.statistics.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Achievement(
    val name: String,
    val description: String,
    val image: String,
)
