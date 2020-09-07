package com.chebdowski.resume.features.resume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chebdowski.resume.R

class ResumeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resume_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ResumeFragment.newInstance())
                    .commitNow()
        }
    }
}