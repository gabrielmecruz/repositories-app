package com.example.portfolioapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.portfolioapp.data.model.Repo
import com.example.portfolioapp.domain.ListUserRepoUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(private val listUserRepoUseCase: ListUserRepoUseCase): ViewModel() {
    private val _repo = MutableLiveData<State>()
    val repo: LiveData<State> = _repo

    fun getListRepo(user: String) {
        viewModelScope.launch {
            listUserRepoUseCase(user)
                    .onStart {
                        _repo.postValue(State.Loading)
                    }
                    .catch {
                        _repo.postValue(State.Error(it))
                    }
                    .collect {
                        _repo.postValue(State.Success(it))
                    }
        }
    }

    sealed class State {
        object Loading: State()
        data class Success(val list: List<Repo>): State()
        data class Error(val error: Throwable): State()
    }
}