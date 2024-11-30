package ru.normno.crmkronaclubclien.statistics.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.normno.crmkronaclubclien.statistics.domain.model.Achievement

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Long,
    @ColumnInfo("companyId")
    val companyId: Long,
    @ColumnInfo("city")
    val city: String,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("firstName")
    val firstName: String,
    @ColumnInfo("lastName")
    val lastName: String,
    @ColumnInfo("positionInCompany")
    val positionInCompany: String,
    @ColumnInfo("avatar")
    val avatar: String?,
    @ColumnInfo("specialAchievement")
    val specialAchievement: Achievement,
    @ColumnInfo("achievements")
    val achievements: List<Achievement>,
)
