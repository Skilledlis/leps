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
class ConfirmFragment : Fragment(R.layout.fragment_confirm) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.cancelButton).apply {
            setOnClickListener { findNavController().popBackStack() }
        }
    }


}