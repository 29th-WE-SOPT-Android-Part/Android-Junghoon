package com.example.soptassignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.soptassignment1.databinding.ActivitySigninBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 홈 뷰로 이동
        binding.btnLogin.setOnClickListener {
            if(binding.etID.text.isNullOrBlank() && binding.etPassword.text.isNullOrBlank()) {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "박정훈님 환영합니다", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        // 회원가입 뷰로 이동
        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}