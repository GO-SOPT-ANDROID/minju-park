package org.android.go.sopt.presentation.login
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.R
import org.android.go.sopt.data.remote.ServicePool
import org.android.go.sopt.data.remote.model.RequestSignInDto
import org.android.go.sopt.data.remote.model.ResponseSignInDto
import org.android.go.sopt.databinding.ActivityLoginBinding
import org.android.go.sopt.presentation.introduce.IntroduceActivity
import org.android.go.sopt.presentation.signup.SignUpActivity
import org.android.go.sopt.util.makeToastMessage
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private val signInService = ServicePool.signInService
    lateinit var binding: ActivityLoginBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var id: String
    private lateinit var pw: String
    private lateinit var name: String
    private lateinit var specialty: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 받아오기
        val startForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
        ) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                id = result.data?.getStringExtra("id").toString()
                pw = result.data?.getStringExtra("pw").toString()
                name = result.data?.getStringExtra("name").toString()
                specialty = result.data?.getStringExtra("specialty").toString()
            }
        }

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startForResult.launch(intent)
        }
        binding.btnLogin.setOnClickListener {
            signInService.signin(
                RequestSignInDto(
                    binding.etId.text.toString(),
                    binding.etPw.text.toString(),
                ),
            ).enqueue(object : retrofit2.Callback<ResponseSignInDto> {
                override fun onResponse(
                    call: Call<ResponseSignInDto>,
                    response: Response<ResponseSignInDto>,
                ) {
                    if (response.isSuccessful) {
                        response.body()?.message?.let { makeToastMessage(it) }
                            ?: "로그인에 성공했습니다."
                        if (!isFinishing) finish()
                    } else {
                        // 실패한 응답
                        response.body()?.message?.let { makeToastMessage(it) }
                            ?: "서버통신 실패(40X)"
                    }
                }
                override fun onFailure(call: Call<ResponseSignInDto>, t: Throwable) {
                    t.message?.let { makeToastMessage(it) }
                }
            })

            if (binding.etId.text.toString() == id && binding.etPw.text.toString() == pw) {
                Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show()
                val intent = Intent(this, IntroduceActivity::class.java).apply {
                    // name,specailty 데이터 전달
                    putExtra("name", name)
                    putExtra("specialty", specialty)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.login_fail), Toast.LENGTH_SHORT).show()
            }
        }
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
}
