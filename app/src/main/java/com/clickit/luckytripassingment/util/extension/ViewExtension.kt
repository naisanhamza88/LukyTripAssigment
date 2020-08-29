package com.nafith.nafithoman.util.extension

import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clickit.luckytripassingment.base.BaseActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
fun View.getParentActivity(): AppCompatActivity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}