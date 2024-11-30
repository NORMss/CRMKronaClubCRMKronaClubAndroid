package ru.normno.crmkronaclubclien.statistics.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Company(
    val id: Long,
    val city: String,
    val name: String,
    val avatar: String,
    val globalRating: Int,
    val localRating: Int,
    val users: Set<Long>,
    val score: Float,
    val specialAchievement: Achievement?,
    val achievements: List<Achievement>,
)
