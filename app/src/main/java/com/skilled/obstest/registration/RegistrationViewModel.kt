package com.skilled.obstest.registration

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @created 10.12.2022
 * @author SkilledLis
 */
class RegistrationViewModel : ViewModel() {

    init {
        Log.e("TAAAG", "init regVM")
    }

    val regStatus: MutableLiveData<Boolean> = MutableLiveData()


    fun registration() {
        regStatus.postValue(true)
    }

    fun finalize(){
        Log.d("TAAAG", "RegistrationViewModel is finalize")
    }

}
