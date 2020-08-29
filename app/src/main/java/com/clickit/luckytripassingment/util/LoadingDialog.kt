package com.clickit.luckytripassingment.util

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.clickit.luckytripassingment.R
import com.clickit.luckytripassingment.base.BaseActivity
import com.wang.avi.AVLoadingIndicatorView
import java.util.*

/**
 * Created by Hamza Abdullah on 11/01/2018.
 */
class LoadingView(a: AppCompatActivity?) : Dialog(a!!) {
    private val dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.loadin_dialog)
        Objects.requireNonNull(dialog.window)!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val mProgressBar: AVLoadingIndicatorView = findViewById(R.id.progress)
        mProgressBar.show()
    }

    init {
        dialog = this
    }
}