package com.chebdowski.resume.core.platform

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    open fun onBackPressed() {}
}