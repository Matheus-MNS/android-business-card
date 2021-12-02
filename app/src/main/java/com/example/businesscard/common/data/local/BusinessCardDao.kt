package com.example.businesscard.common.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.businesscard.common.data.model.BusinessCardModel
import kotlinx.coroutines.flow.Flow

@Dao
interface BusinessCardDao {

    @Query("SELECT * FROM BusinessCardModel")
    fun getBusinessCardList(): Flow<List<BusinessCardModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBusinessCard(businessCard: BusinessCardModel)

}