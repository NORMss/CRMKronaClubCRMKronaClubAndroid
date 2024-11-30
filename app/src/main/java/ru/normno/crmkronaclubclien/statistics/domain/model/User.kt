package ru.normno.crmkronaclubclien.statistics.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Long,
    val companyId: Long,
    val city: String,
    val name: String,
    val rating: Int,
    val firstName: String,
    val lastName: String,
    val globalRating: Int,
    val localRating: Int,
    val positionInCompany: String,
    val avatar: String,
    val score: Float,
    val specialAchievement: Achievement?,
    val achievements: List<Achievement>,
)