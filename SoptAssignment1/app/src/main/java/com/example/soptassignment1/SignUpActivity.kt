package com.example.soptassignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.soptassignment1.databinding.ActivitySignUpBinding


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 로그인 뷰로 이동
        binding.btnSignup.setOnClickListener {
            if(binding.etName.text.isNullOrBlank() || binding.etID.text.isNullOrBlank() || binding.etPassword.text.isNullOrBlank())
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            else {
           setResult(RESULT_OK, Intent(this, SignInActivity::class.java).apply {
                      putExtra("ID", binding.etID.text.toString())
                      putExtra("password", binding.etPassword.text.toString())
           })
                finish()
            }
        }
    }
}