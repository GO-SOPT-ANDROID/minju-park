package org.android.go.sopt.presentation.signup
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivitySignupBinding
import org.android.go.sopt.presentation.login.LoginActivity

class SignUpActivity:AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.btnSignup.setOnClickListener{

                //회원가입 성공조건문
                if(binding.etId.length() in 6..10&&binding.etPw.length() in 8..12
                    &&binding.etName.length()!=0&&binding.etSpecialty.length()!=0){
                    val intent=Intent(this@SignUpActivity, LoginActivity::class.java).apply {
                        //ID,PW,NAME,SPECIALTY 데이터 전달
                        putExtra("id", binding.etId.text.toString())
                        putExtra("pw", binding.etPw.text.toString())
                        putExtra("name", binding.etName.text.toString())
                        putExtra("specialty", binding.etSpecialty.text.toString())
                    }
                    setResult(RESULT_OK,intent)
                    //조건에 맞을 시 회원가입 화면 종료 => 성공 스낵바
                    Snackbar.make(
                        binding.root,getString(R.string.sign_success),Snackbar.LENGTH_SHORT
                    ).show()
                    finish()
                    //조건에 맞지 않을 때 => 실패 스낵바
                }else{
                    Snackbar.make(
                        binding.root,getString(R.string.sign_fail),Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        //키보드 숨기기
        binding.root.setOnClickListener{
            hideKeyboard()
        }
    }

    private fun hideKeyboard() {
        val inputManager: InputMethodManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            this.currentFocus!!.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
    }



