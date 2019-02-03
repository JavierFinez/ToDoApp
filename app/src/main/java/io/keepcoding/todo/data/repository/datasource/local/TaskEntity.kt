package io.keepcoding.todo.data.repository.datasource.local

import androidx.room.*
import java.util.*
import androidx.room.ForeignKey.CASCADE

@Entity(
    tableName = "tasks",
    foreignKeys = [ForeignKey(
        entity = TaskEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("parent_task_id"),
        onDelete = CASCADE)
    ],
    indices = [Index(value = ["parent_task_id"])]
)
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val content: String,
    @ColumnInfo(name = "created_at")
    val createdAt: Date,
    @ColumnInfo(name = "is_done")
    val isDone: Boolean,
    @ColumnInfo(name = "is_high_priority")
    val isHighPriority: Boolean,
    @ColumnInfo(name = "parent_task_id")
    val parentTaskId: Long?
)
