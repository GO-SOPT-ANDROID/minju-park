package org.android.go.sopt.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.databinding.ActivityLoginBinding
import org.android.go.sopt.presentation.introduce.IntroduceActivity
import org.android.go.sopt.presentation.signup.SignUpActivity
import org.android.go.sopt.util.makeToastMessage

class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<LoginViewmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.root.setOnClickListener {
            hideKeyboard()
        }

        binding.btnSignup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            viewModel.signIn(
                binding.etId.text.toString(),
                binding.etPw.text.toString(),
            )
        }
        viewModel.signInResult.observe(this) { signInResult ->
            startActivity(
                Intent(
                    this@LoginActivity,
                    IntroduceActivity::class.java,
                ),
            )
        }
    }

    private fun hideKeyboard() {
        val inputManager: InputMethodManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            this.currentFocus!!.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS,
        )
    }
}
