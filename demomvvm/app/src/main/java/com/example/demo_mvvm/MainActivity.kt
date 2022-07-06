package com.example.demo_mvvm

import com.example.demo_mvvm.base.BaseActivity
import com.example.demo_mvvm.databinding.ActivityMainBinding
import com.example.demo_mvvm.fragment.MainFragment
import com.example.demo_mvvm.viewmodel.VMBase

class MainActivity : BaseActivity<ActivityMainBinding, VMBase>() {
    override fun onBackPress() {
        onBackPressed()
    }

    override fun initView() {
        showFragment(MainFragment().TAG, null, false)
    }

    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initViewModel(): Class<VMBase> {
      return VMBase::class.java
    }


}