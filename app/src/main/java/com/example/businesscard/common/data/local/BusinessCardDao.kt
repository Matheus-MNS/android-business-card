package com.example.businesscard.common.data.local

import androidx.room.*
import com.example.businesscard.common.data.model.BusinessCardModel
import kotlinx.coroutines.flow.Flow

@Dao
interface BusinessCardDao {

    @Query("SELECT * FROM BusinessCardModel")
    fun getBusinessCardList(): Flow<List<BusinessCardModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBusinessCard(businessCard: BusinessCardModel)

    @Delete
    fun deleteBusinessCard(businessCardModel: BusinessCardModel)

    @Update
    fun updateBusinessCard(businessCard: BusinessCardModel)
}