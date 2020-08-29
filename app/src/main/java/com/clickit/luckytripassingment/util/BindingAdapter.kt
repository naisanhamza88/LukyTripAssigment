package com.clickit.luckytripassingment.util

import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.clickit.luckytripassingment.R
import com.nafith.nafithoman.util.extension.getParentActivity

import com.squareup.picasso.Picasso
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Hamza Abdullah on 1/30/2020.
 */
@ExperimentalCoroutinesApi


@BindingAdapter("arrayAdapter")
fun setArrayAdapter(view: Spinner, adapter: MutableLiveData<ArrayAdapter<String>>) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null) {
        view.adapter = adapter.value
    }
}


@ExperimentalCoroutinesApi
@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
    }
}

@ExperimentalCoroutinesApi
@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, value: MutableLiveData<Boolean>) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null) {
        value.observe(parentActivity, Observer { result ->
            if (result) {
                view.visibility = View.VISIBLE
            } else {
                view.visibility = View.GONE
            }
        })
    }
}

@BindingAdapter("android:tag")
fun setTag(view: View, tag: String) {
    view.tag = tag
}

@BindingAdapter("android:text")
fun setText(view: AppCompatTextView, text: MutableLiveData<String>?) {
    if (text != null) {
        view.text = text.value
    }

}


@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}


@InverseBindingAdapter(attribute = "android:text")
fun getTextFromBinding(view: AppCompatEditText): String {
    return view.text.toString()
}
