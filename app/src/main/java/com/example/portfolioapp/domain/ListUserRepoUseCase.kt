package com.example.portfolioapp.domain

import com.example.portfolioapp.core.UseCase
import com.example.portfolioapp.data.model.Repo
import com.example.portfolioapp.data.repositories.RepositoryList
import kotlinx.coroutines.flow.Flow

class ListUserRepoUseCase(private val repository: RepositoryList): UseCase<String, List<Repo>>() {
    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }
}