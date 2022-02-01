package com.example.portfolioapp.data.repositories

import android.os.RemoteException
import com.example.portfolioapp.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepositoryImpl(private val service: GitHubService): RepositoryList {
    override suspend fun listRepositories(user: String) = flow {
        try {
            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Não foi possível realizar a busca no momento.")
        }
    }
}