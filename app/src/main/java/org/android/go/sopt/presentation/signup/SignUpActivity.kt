package org.android.go.sopt.presentation.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.data.remote.ServicePool
import org.android.go.sopt.databinding.ActivitySignupBinding
import org.android.go.sopt.presentation.login.LoginActivity
import org.android.go.sopt.util.makeToastMessage

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private val signUpService = ServicePool.signUpService

    private val viewModel by viewModels<SignUpViewmodel>()
    private var idFlag = false
    private var pwFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.isEnabled = false
        textWatcher()
        clickSignUp()
        binding.root.setOnClickListener {
            hideKeyboard()
        }
    }

    private fun Regexid(id: String): Boolean {
        return id.matches("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{6,10}\$".toRegex())
    }

    private fun Regexpw(pw: String): Boolean {
        return pw.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*?])[A-Za-z[0-9]!@#\$%^&*?]{6,12}$".toRegex())
    }

    private fun flagCheck() {
        binding.btnSignup.isEnabled = idFlag && pwFlag
    }

    private fun textWatcher() {
        with(binding) {
            etId.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if (Regexid(etId.text.toString()) || etId.text.isNullOrBlank()) {
                        layoutEtId.error = null
                        idFlag = true
                    } else {
                        layoutEtId.error = "영문,숫자 포함 6-10글자"
                    }
                    flagCheck()
                }
            })

            etPw.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if (Regexpw(etPw.text.toString()) || etPw.text.isNullOrBlank()) {
                        layoutEtPw.error = null
                        pwFlag = true
                    } else {
                        layoutEtPw.error = "영문,숫자,특수문자 포함 6-12글자"
                    }
                    flagCheck()
                }
            })
        }
    }

    private fun clickSignUp() {
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
