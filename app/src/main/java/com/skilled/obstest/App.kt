package com.skilled.obstest

import android.app.Application
import android.content.SharedPreferences
import com.skilled.obstest.data.Repository

/**
 * @created 10.12.2022
 * @author SkilledLis
 */
class App : Application() {

    //dasda

    //dev commit

     val  sharedPreferences: SharedPreferences by lazy {
         getSharedPreferences("ShPName", MODE_PRIVATE)
     }
     val repository: Repository by lazy {
        Repository.MockRepository()
    }


}