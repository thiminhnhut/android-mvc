package io.github.thiminhnhut.loginatm.view

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import io.github.thiminhnhut.loginatm.R
import io.github.thiminhnhut.loginatm.model.Account

class FragmentStatusLogin: DialogFragment() {

    private lateinit var listener: OnEvent

    companion object {
        private var isLoginSuccess = false
        private var account: Account? = null
        fun newInstance(listener: OnEvent, isLoginSuccess: Boolean, account: Account? = null): FragmentStatusLogin {
            this.isLoginSuccess = isLoginSuccess
            this.account = account
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
            val layoutInfo = view.findViewById<LinearLayout>(R.id.layoutInfo)
            val layoutParams = layoutInfo.layoutParams
            layoutParams.height = 0
            view.layoutParams = layoutParams
        } else {
            val txtAccountNo = view.findViewById<TextView>(R.id.txtAccountNo)
            val txtCustomerName = view.findViewById<TextView>(R.id.txtCustomerName)
            val txtAmount = view.findViewById<TextView>(R.id.txtAmount)
            if (account != null) {
                txtAccountNo.text = account!!.accountNo
                txtCustomerName.text = account!!.customerName
                txtAmount.text = account!!.amount.toString()
            }
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