package com.example.presentation.util

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.view.ViewTreeObserver
import android.view.WindowInsets
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

/**
 * RxBinding의 Throttle 기능 사용하는 Button 함수
 * @param throttleSecond 해당 시간동안 중복 클릭 방지 (기본으로 1초)
 * @param subscribe 클릭 리스너 정의
 */
fun View.onThrottleClick(throttleSecond: Long = 1, subscribe: ((View) -> Unit)? = null) = clicks()
    .throttleFirst(throttleSecond, TimeUnit.SECONDS)
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe { subscribe?.invoke(this) }

fun View.changeBackground(context: Context, colorId: Int) {
    this.background = ContextCompat.getDrawable(context, colorId)
}

fun EditText?.showKeyboardAndFocus(isShowKeyBoard: Boolean) {
    this?.let { editText ->
        val imm = editText.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (isShowKeyBoard) {
            editText.post {
                editText.requestFocus()
                imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED)
            }
        } else {
            editText.post {
                imm.hideSoftInputFromWindow(editText.windowToken, InputMethodManager.SHOW_FORCED)
            }
        }
    }
}

fun View.clearFocusWithHideKeyboard() {
    clearFocus()
    keyboardVisible(false)
}

fun View.keyboardVisible(show: Boolean, flag: Int = 0, focus: Boolean = false) {
    if (show && focus) requestFocus()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        windowInsetsController?.run { if (show) ::show else ::hide }?.invoke(WindowInsets.Type.ime())
    } else {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager ?: return
        if (show) imm.showSoftInput(this, flag)
        else imm.hideSoftInputFromWindow(windowToken, flag)
    }
}

fun View.addOnceOnGlobalLayoutListener(listener: () -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            this@addOnceOnGlobalLayoutListener.viewTreeObserver.removeOnGlobalLayoutListener(this)
            listener()
        }
    })
}

fun View.setBackgroundTint(@ColorRes tintColorRes: Int) {
    backgroundTintList = ContextCompat.getColorStateList(this.context, tintColorRes)
}

/**
 * RecyclerViewAdapter에서 ViewHolder 생성인자로 View 객체를 만들어주는 코드를 줄이기 위해 만들어짐
 */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

/**
 * isVisible 함수와 비슷하나 상태가 다를때만 동작하도록 하는 함수
 */
inline var View.isVisibleWhenStatusDiffer: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        if (value) {
            if (!isVisibleWhenStatusDiffer) visibility = View.VISIBLE
        } else {
            if (isVisibleWhenStatusDiffer) visibility = View.GONE
        }
    }

fun View.setMargin(start: Int? = null, end: Int? = null, top: Int? = null, bottom: Int? = null) {
    (layoutParams as MarginLayoutParams).let { marginLayoutParams ->
        start?.let { marginLayoutParams.marginStart = it }
        end?.let { marginLayoutParams.marginEnd = it }
        top?.let { marginLayoutParams.topMargin = it }
        bottom?.let { marginLayoutParams.bottomMargin = it }
    }
}