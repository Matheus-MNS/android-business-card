package com.example.businesscard.data.repository

import com.example.businesscard.data.model.BusinessCardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RepositoryImpl(private val repository: Repository) {

    fun insert(businessCardModel: BusinessCardModel) = runBlocking {
        launch(Dispatchers.IO) {
            repository.insert(businessCardModel)
        }
    }

    fun getAll() = repository.getAll()
}