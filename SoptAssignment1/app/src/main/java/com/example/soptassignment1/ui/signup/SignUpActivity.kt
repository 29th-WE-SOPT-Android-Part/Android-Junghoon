package com.example.soptassignment1.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.soptassignment1.ui.signin.LoginServiceCreator
import com.example.soptassignment1.data.RequestSignupData
import com.example.soptassignment1.data.ResponseSignupData
import com.example.soptassignment1.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 로그인 뷰로 이동
        binding.btnSignup.setOnClickListener {
            initNetwork()
            finish()
        }
    }

    private fun initNetwork() {
        val requestSignupData = RequestSignupData(
            id = binding.etID.text.toString(),
            name = binding.etName.text.toString(),
            password = binding.etPassword.text.toString()
        )

        val call: Call<ResponseSignupData> = LoginServiceCreator.signupService.postSignup(requestSignupData)

        call.enqueue(object : Callback<ResponseSignupData> {
            override fun onResponse(
                call: Call<ResponseSignupData>,
                response: Response<ResponseSignupData>
            ) {
                if(response.isSuccessful) {
                    val data = response.body()?.data

                    Toast.makeText(this@SignUpActivity, "${data?.email}님 회원가입이 완료되었습니다!", Toast.LENGTH_SHORT).show()
                }
                else
                    Toast.makeText(this@SignUpActivity, "회원가입에 실패하셨습니다", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseSignupData>, t: Throwable) {
                Log.e("NetworkText", "error:$t")
            }
        })
    }
}