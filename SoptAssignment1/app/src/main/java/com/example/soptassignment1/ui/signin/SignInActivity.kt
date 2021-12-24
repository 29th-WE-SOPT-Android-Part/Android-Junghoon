package com.example.soptassignment1.ui.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.soptassignment1.data.RequestLoginData
import com.example.soptassignment1.data.ResponseLoginData
import com.example.soptassignment1.SOPTSharedPreferences
import com.example.soptassignment1.databinding.ActivitySigninBinding
import com.example.soptassignment1.ui.signup.SignUpActivity
import com.example.soptassignment1.ui.home.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySigninBinding

    private var getLoginText = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val idString = result.data?.getStringExtra("ID")
            val passwordString = result.data?.getStringExtra("password")
            binding.etID.setText(idString)
            binding.etPassword.setText(passwordString)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 홈 뷰로 이동
        binding.btnLogin.setOnClickListener {
            initNetwork()
        }

        // 자동로그인
        initClickEvent()
        doAutoLogin()

        // 회원가입 뷰로 이동
        binding.tvSignup2.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            getLoginText.launch(intent)
        }
    }

    private fun initNetwork() {
        val requestLoginData = RequestLoginData(
            id = binding.etID.text.toString(),
            password = binding.etPassword.text.toString()
        )

        val call: Call<ResponseLoginData> = LoginServiceCreator.loginService.postLogin(requestLoginData)

        call.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if(response.isSuccessful) {
                    val data = response.body()?.data

                    Toast.makeText(this@SignInActivity, "${data?.email}님 반갑습니다!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                }
                else
                    Toast.makeText(this@SignInActivity, "로그인에 실패하셨습니다", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e("NetworkText", "error:$t")
            }
        })
    }

    private fun initClickEvent() {
        binding.ibCheck.setOnClickListener {
            binding.ibCheck.isSelected = !binding.ibCheck.isSelected
            SOPTSharedPreferences.setAutoLogin(this, binding.ibCheck.isSelected)
        }
    }

    private fun doAutoLogin() {
        if(SOPTSharedPreferences.getAutoLogin(this)) {
            Toast.makeText(this@SignInActivity, "자동 로그인 되었습니다", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
            finish()
        }
    }
}