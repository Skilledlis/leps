package com.skilled.obstest.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.skilled.obstest.auth.DataStore
import com.skilled.obstest.data.Repository

/**
 * @created 10.12.2022
 * @author SkilledLis
 */
class SplashViewModelFactory(
    private val userDataStore: DataStore,
    private val repository: Repository
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SplashViewModel(
            userDataStore = userDataStore,
            repository = repository
        ) as T
    }
}