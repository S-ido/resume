package com.chebdowski.resume.core.platform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chebdowski.resume.R.id
import com.chebdowski.resume.R.layout
import com.chebdowski.resume.core.extension.inTransaction
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layout.resume_activity)
        setSupportActionBar(toolbar)
        addFragment(savedInstanceState)
    }

    private fun addFragment(savedInstanceState: Bundle?) =
        savedInstanceState ?: supportFragmentManager.inTransaction {
            add(id.fragmentContainer, fragment())
        }

    abstract fun fragment(): BaseFragment

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(id.fragmentContainer) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }
}