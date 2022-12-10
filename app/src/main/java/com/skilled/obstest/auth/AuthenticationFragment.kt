package com.skilled.obstest.auth

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.skilled.obstest.R

/**
 * @created 10.12.2022
 * @author SkilledLis
 */
class AuthenticationFragment : Fragment(R.layout.fragment_authentication) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.buttonRegistration).apply {
            setOnClickListener {
                findNavController().navigate(R.id.action_authenticationFragment_to_registrationFragment)
            }
        }
        view.findViewById<Button>(R.id.buttonLogIn).apply {
            setOnClickListener {
                findNavController().navigate(R.id.action_authenticationFragment_to_main_navigation_graph)
            }
        }
    }
}





