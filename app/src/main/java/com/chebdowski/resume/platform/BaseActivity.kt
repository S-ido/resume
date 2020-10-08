package com.chebdowski.resume.platform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chebdowski.resume.R.id
import com.chebdowski.resume.R.layout
import com.chebdowski.resume.extension.inTransaction

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layout.resume_activity)
        addFragment(savedInstanceState)
    }

    private fun addFragment(savedInstanceState: Bundle?) =
        savedInstanceState ?: supportFragmentManager.inTransaction {
            add(id.fragmentContainer, fragment())
        }

    abstract fun fragment(): BaseFragment
}