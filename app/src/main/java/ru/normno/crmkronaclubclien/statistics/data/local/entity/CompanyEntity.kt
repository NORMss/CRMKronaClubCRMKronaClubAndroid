package ru.normno.crmkronaclubclien.statistics.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.normno.crmkronaclubclien.statistics.domain.model.Achievement

@Entity(tableName = "company")
data class CompanyEntity(
    @ColumnInfo("id")
    @PrimaryKey val id: Long,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("avatar")
    val avatar: String?,
    @ColumnInfo("globalRating")
    val globalRating: Int,
    @ColumnInfo("localRating")
    val localRating: Int,
    @ColumnInfo("specialAchievement")
    val specialAchievement: Achievement?,
    @ColumnInfo("achievements")
    val achievements: List<Achievement>,
    @ColumnInfo("employeeIds")
    val employeeIds: List<Long>,
)
