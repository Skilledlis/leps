package com.skilled.obstest.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skilled.obstest.data.Repository
import com.skilled.obstest.data.TokenResponse
import com.skilled.obstest.data.User
import com.skilled.obstest.auth.Authentication
import com.skilled.obstest.auth.DataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @created 10.12.2022
 * @author SkilledLis
 */
abstract class BaseSplashViewModel : ViewModel() {
    protected val _token: MutableLiveData<TokenResponse> = MutableLiveData()
    val token: LiveData<TokenResponse> = _token
}

class SplashViewModel(
    userDataStore: DataStore,
    private val repository: Repository
) : BaseSplashViewModel(), Authentication {

    init {
        auth(userDataStore.getUser())
    }


    override fun auth(user: User?) {
        viewModelScope.launch(Dispatchers.IO) {
            _token.postValue(TokenResponse.Loading)

            delay(1500)

            if (user != null) {
                val result = repository.auth(user)
                _token.postValue(result)
                return@launch
            }

            _token.postValue(TokenResponse.Empty)

        }
    }


}


