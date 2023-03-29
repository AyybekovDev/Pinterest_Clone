package com.example.pinterestclone.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pinterestclone.model.SaveImage

@Database(entities = [SaveImage::class], version = 1)
abstract class PinterestDataBase : RoomDatabase() {
    abstract fun getImageDao(): PinterestDao
    companion object {
        private var DB_INSTANCE: PinterestDataBase? = null

        fun getInstance(context: Context): PinterestDataBase {
            if (DB_INSTANCE == null) {
                DB_INSTANCE =
                    Room.databaseBuilder(
                        context.applicationContext,
                        PinterestDataBase::class.java,
                        "SavedImage.db"
                    )
                        .allowMainThreadQueries()
                        .build()
            }
            return DB_INSTANCE!!
        }
    }
}






