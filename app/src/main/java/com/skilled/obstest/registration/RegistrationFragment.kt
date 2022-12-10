package com.skilled.obstest.registration

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.skilled.obstest.R


class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button?>(R.id.buttonReg).apply {
            setOnClickListener {
                viewModel.registration()
            }
        }

        viewModel.regStatus.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(R.id.action_registrationFragment_to_confirmFragment)
            }
        }


    }
}