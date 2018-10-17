package br.com.fiap.carolpandim.canivetesuico.toast

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import br.com.fiap.carolpandim.canivetesuico.R

enum class CustomToastType {
    INFO, SUCCESS, ERROR, WARNING
}

class CustomToast(val context: Context, val inflater: LayoutInflater) {

    fun showToast(text: String, type: CustomToastType) {
        val customToastroot = inflater.inflate(getLayout(type), null)
        val customtoast = Toast(context)

        val textView = customToastroot.findViewById<TextView>(R.id.textView1)
        textView.text = text

        customtoast.view = customToastroot
        customtoast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0, 0)
        customtoast.duration = Toast.LENGTH_LONG

        customtoast.show()
    }

    private fun getLayout(type: CustomToastType): Int {
        return when (type) {
            CustomToastType.INFO -> R.layout.custom_toast_info
            CustomToastType.SUCCESS -> R.layout.custom_toast
            CustomToastType.ERROR -> R.layout.custom_toast
            CustomToastType.WARNING -> R.layout.custom_toast
        }
    }


}