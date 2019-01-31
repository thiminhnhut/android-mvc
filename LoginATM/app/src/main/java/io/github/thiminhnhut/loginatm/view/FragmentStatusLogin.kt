package io.github.thiminhnhut.loginatm.view

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import io.github.thiminhnhut.loginatm.R

class FragmentStatusLogin: DialogFragment() {

    private lateinit var listener: OnEvent

    companion object {
        private var isLoginSuccess = false
        fun newInstance(listener: OnEvent, isLoginSuccess: Boolean): FragmentStatusLogin {
            this.isLoginSuccess = isLoginSuccess
            val result = FragmentStatusLogin()
            result.listener = listener
            return result
        }
    }

    override fun onStart() {
        super.onStart()
        if (dialog != null) {
            dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_status_login, container, false)
        val txtStatusLogin =view.findViewById<TextView>(R.id.txtStatusLogin)
        val btnOK = view.findViewById<Button>(R.id.btnOK)

        if (!isLoginSuccess) {
            txtStatusLogin.text = resources.getString(R.string.login_fail)
        }

        btnOK.setOnClickListener {
            dialog.dismiss()
            listener.onClick(this)
        }

        return view
    }

    interface OnEvent {
        fun onClick(sender: Any)
    }
}