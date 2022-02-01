package com.example.portfolioapp.data.repositories

import com.example.portfolioapp.data.model.Repo
import kotlinx.coroutines.flow.Flow

interface RepositoryList {
    suspend fun listRepositories(user: String): Flow<List<Repo>>
}