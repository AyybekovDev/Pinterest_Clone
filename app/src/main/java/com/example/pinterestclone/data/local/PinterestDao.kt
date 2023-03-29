package com.example.pinterestclone.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pinterestclone.model.HomeItem
import com.example.pinterestclone.model.SaveImage
import com.example.pinterestclone.model.User

@Dao
interface PinterestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveImage(saveImage: SaveImage)

    @Query("SELECT * FROM SavedImage")
    fun getAllImage(): List<SaveImage>


}