package ru.blackmirrror.receivingpayments.authorization.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.blackmirrror.receivingpayments.R
import ru.blackmirrror.receivingpayments.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding
    private val viewModel by viewModel<AuthViewModel>()

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
            onClick()
        }
    }

    private fun onClick() {
        if (!checkEditText())
            return
        viewModel.getToken(
            binding.etLogin.text.toString(),
            binding.etPassword.text.toString()
        )
        viewModel.token.observe(viewLifecycleOwner) { token ->
            if (token.isNullOrEmpty()) {
                showToast(getString(R.string.toast_error_login_data))
            }
            else {
                val action = AuthFragmentDirections.actionAuthFragmentToPaymentsFragment(token)
                Navigation.findNavController(binding.root).navigate(action)
            }
        }
    }

    private fun checkEditText(): Boolean {
        if (binding.etLogin.text.isNullOrEmpty()
            || binding.etPassword.text.isNullOrEmpty()) {
            showToast(getString(R.string.toast_fill_fields))
            return false
        }
        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}