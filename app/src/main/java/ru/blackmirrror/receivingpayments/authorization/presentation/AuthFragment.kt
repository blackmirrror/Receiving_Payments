package ru.blackmirrror.receivingpayments.authorization.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ru.blackmirrror.receivingpayments.R
import ru.blackmirrror.receivingpayments.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(inflater, container, false)

        setUpFields()

        return binding.root
    }

    private fun setUpFields() {
        binding.toolbar.title.text = getString(R.string.title_auth)

        binding.btnEnter.setOnClickListener {
            val action = AuthFragmentDirections.actionAuthFragmentToPaymentsFragment("token")
            Navigation.findNavController(binding.root).navigate(action)
        }
    }
}