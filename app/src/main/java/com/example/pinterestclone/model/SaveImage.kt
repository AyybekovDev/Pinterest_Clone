package com.example.pinterestclone.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "SavedImage")
data class SaveImage(
    @PrimaryKey
    val url: String
) : Serializable
