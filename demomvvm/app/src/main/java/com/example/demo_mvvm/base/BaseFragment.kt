package com.example.demo_mvvm.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.util.*


abstract class BaseFragment<T : ViewBinding?, V : ViewModel?> : Fragment(), View.OnClickListener {
    var binding: T? = null
    var viewModel: V? = null
    var onMainCallback: OnMainCallback? = null
    var obj: Objects? = null
    var mContext : Context? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = initViewBinding(inflater,container!!)
        viewModel = ViewModelProvider(this).get(initViewModel())
        initView()
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onClick(v: View?) {

    }


     fun toast(mess:String){
      toast(mess)
     }
    abstract fun initView()

    abstract fun initViewModel(): Class<V>

    abstract fun initViewBinding(inflater: LayoutInflater, viewGroup: ViewGroup): T

    open fun setCallBack(callBack: OnMainCallback) {
        onMainCallback = callBack
    }

    fun  setData(obj : Objects){
        this.obj = obj
    }
}