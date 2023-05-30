package org.android.go.sopt.presentation.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.android.go.sopt.R
import org.android.go.sopt.data.remote.ServicePool
import org.android.go.sopt.databinding.ActivitySignupBinding
import org.android.go.sopt.presentation.login.LoginActivity
import org.android.go.sopt.util.makeToastMessage

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private val signUpService = ServicePool.signUpService

    private val viewModel by viewModels<SignUpViewmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            viewModel.signUp(
                binding.etId.text.toString(),
                binding.etPw.text.toString(),
                binding.etName.text.toString(),
                binding.etSpecialty.text.toString(),
            )

            viewModel.signUpResult.observe(this) { signUpResult ->
                startActivity(
                    Intent(
                        this@SignUpActivity,
                        LoginActivity::class.java,
                    ),

                )

                makeToastMessage(
                    signUpResult.message,
                )
            }
            signLimit()
        }
        // 키보드 숨기기
        binding.root.setOnClickListener {
            hideKeyboard()
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

    private fun signLimit() {
        if (binding.etId.length() in 6..10 && binding.etPw.length() in 8..12 &&
            binding.etName.length() != 0 && binding.etSpecialty.length() != 0
        ) {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java).apply {
                putExtra("id", binding.etId.text.toString())
                putExtra("pw", binding.etPw.text.toString())
                putExtra("name", binding.etName.text.toString())
                putExtra("specialty", binding.etSpecialty.text.toString())
            }
            setResult(RESULT_OK, intent)
            Snackbar.make(
                binding.root,
                getString(R.string.sign_success),
                Snackbar.LENGTH_SHORT,
            ).show()
            finish()
        } else {
            Snackbar.make(
                binding.root,
                getString(R.string.sign_fail),
                Snackbar.LENGTH_SHORT,
            ).show()
        }
    }
}
