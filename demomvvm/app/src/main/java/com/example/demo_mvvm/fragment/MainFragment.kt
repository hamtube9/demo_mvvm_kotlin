package com.example.demo_mvvm.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demo_mvvm.base.BaseFragment
import com.example.demo_mvvm.databinding.MainFragmentBinding
import com.example.demo_mvvm.viewmodel.FragmentMainViewModel

class MainFragment : BaseFragment<MainFragmentBinding, FragmentMainViewModel>() {
    val TAG = MainFragment::class.java.name


    override fun initView() {
        binding!!.edtEmail.hint = "email"
        binding!!.passEmail.hint = "password"
    }

    override fun initViewModel(): Class<FragmentMainViewModel> {
        return FragmentMainViewModel::class.java
    }

    override fun initViewBinding(
        inflater: LayoutInflater,
        viewGroup: ViewGroup
    ): MainFragmentBinding {
        return MainFragmentBinding.inflate(inflater, viewGroup, false)
    }

    override fun onClick(v: View?) {
    }
}