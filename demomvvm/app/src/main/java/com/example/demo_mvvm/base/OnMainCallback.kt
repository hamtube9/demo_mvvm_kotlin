package com.example.demo_mvvm.base

import java.util.*

interface OnMainCallback {
    fun showFragment( TAG : String, data: Objects?, isBack : Boolean)
}