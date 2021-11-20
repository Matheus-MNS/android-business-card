package com.example.businesscard.data.repository

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.businesscard.data.model.BusinessCardModel

interface Repository{

    @Query("SELECT * FROM BusinessCardModel")
    fun getAll(): LiveData<List<BusinessCardModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businessCard: BusinessCardModel)

}