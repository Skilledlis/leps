package com.skilled.obstest.splash

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.skilled.obstest.App
import com.skilled.obstest.R
import com.skilled.obstest.data.TokenResponse
import com.skilled.obstest.auth.DataStore


/**
 * @created 10.12.2022
 * @author SkilledLis
 */
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val viewModel: BaseSplashViewModel by viewModels<SplashViewModel> {

        val app = requireActivity().application as App
        SplashViewModelFactory(DataStore.Base(app.sharedPreferences), app.repository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val processBar = view.findViewById<ProgressBar>(R.id.progressBar)

        viewModel.token.observe(viewLifecycleOwner) {
            when (it) {
                is TokenResponse.Success<*> -> {
                    findNavController().navigate(
                        R.id.action_splashFragment_to_main_navigation_graph,
                        bundleOf(USER_TOKE to it.data)
                    )
                }
                is TokenResponse.Error -> {
                    Log.e(this.javaClass.simpleName, it.errorMessage)
                    findNavController().navigate(R.id.action_splashFragment_to_authentication_navigation_graph)
                }
                is TokenResponse.Loading -> {
                    processBar.visibility = View.VISIBLE
                }
                is TokenResponse.Empty -> {
                    findNavController().navigate(R.id.action_splashFragment_to_authentication_navigation_graph)
                }
            }


        }
    }

    companion object {
        const val USER_TOKE = "TOKEN"
    }

}