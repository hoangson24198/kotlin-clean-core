package com.hoangson.baseandroid.presentation.dialog

import android.content.Context
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton
import com.hoangson.baseandroid.R
import com.hoangson.baseandroid.core.bases.BaseDialog
import kotlinx.android.synthetic.main.dialog_pause.*

class DialogPause(context: Context) : BaseDialog(context) {
    var message: String = ""
    override fun getLayout(): Int {
        return R.layout.dialog_pause
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        if (!message.isEmpty())
            txtMessage.text = message
    }

    fun setYesListener(onYes: (() -> Unit)? = null) {
        val btnYes = this.findViewById<AppCompatImageButton>(R.id.btnYes)
        btnYes.setOnClickListener {
            onYes?.invoke()
        }
    }

    fun setNoListener(onNo: (() -> Unit)? = null) {
        val btnNo = this.findViewById<AppCompatImageButton>(R.id.btnNo)
        btnNo.setOnClickListener {
            onNo?.invoke()
        }
    }
}