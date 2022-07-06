package com.example.demo_mvvm.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.demo_mvvm.R
import java.util.*

abstract class BaseActivity<T : ViewBinding, V : ViewModel> : AppCompatActivity(),
    View.OnClickListener, OnMainCallback {
    private var binding: T? = null
    private var viewModel: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initViewBinding()
        viewModel = ViewModelProvider(this).get(initViewModel())
        setContentView(binding!!.root)
        initView()
    }

    abstract fun onBackPress()
    abstract fun initView()
    abstract fun initViewBinding(): T
    abstract fun initViewModel(): Class<V>


    override fun onClick(v: View?) {
    }

    fun toast(mess: String) {
        Toast.makeText(this, mess, Toast.LENGTH_SHORT).show()
    }

    override fun showFragment(TAG: String, data: Objects?, isBack: Boolean) {

        try {
            val clasz = Class.forName(TAG)
            val cons = clasz.getConstructor()
            val fragment = cons.newInstance() as BaseFragment<*, *>
            fragment.setCallBack(this)
            if(data != null)
            fragment.setData(data)
            val trans = supportFragmentManager.beginTransaction()
            if (isBack) {
                trans.addToBackStack(null)
            }
            trans.replace(R.id.containerMain, fragment, TAG).commit()


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}