package org.android.go.sopt
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.android.go.sopt.databinding.ActivitySignupBinding

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
                    val intent=Intent(this@SignUpActivity,MainActivity::class.java).apply {
                        //ID,PW,NAME,SPECIALTY 데이터 전달
                        putExtra("id", binding.etId.text.toString())
                        putExtra("pw", binding.etPw.text.toString())
                        putExtra("name", binding.etName.text.toString())
                        putExtra("specialty", binding.etSpecialty.text.toString())
                    }
                    setResult(RESULT_OK,intent)
                    //조건에 맞을 시 회원가입 화면 종료 => 성공 스낵바
                    Snackbar.make(
                        binding.root,"회원가입이 완료되었습니다.",Snackbar.LENGTH_SHORT
                    ).show()
                    finish()
                    //조건에 맞지 않을 때 => 실패 스낵바
                }else{
                    Snackbar.make(
                        binding.root,"회원가입 조건에 맞게 다시 입력해주세요.",Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }



