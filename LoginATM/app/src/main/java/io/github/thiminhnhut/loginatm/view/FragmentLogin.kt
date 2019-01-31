package io.github.thiminhnhut.loginatm.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import io.github.thiminhnhut.loginatm.R

class FragmentLogin: Fragment() {
    private lateinit var listener: OnEvent

    private lateinit var edtAccountNumber: EditText
    private lateinit var edtPassword: EditText

    companion object {
        fun newInstance(listener: OnEvent): FragmentLogin {
            val result = FragmentLogin()
            result.listener = listener
            return result
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        edtAccountNumber = view.findViewById(R.id.edtAccountNumber)
        edtPassword = view.findViewById(R.id.edtPassword)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val accountNo = edtAccountNumber.text.toString()
            val password = edtPassword.text.toString()
            listener.onClickLogin(this, accountNo, password)
        }
        return view
    }

    fun resetLogin() {
        edtAccountNumber.text.clear()
        edtPassword.text.clear()
    }

    interface OnEvent {
        fun onClickLogin(sender: Any, accountNo: String, password: String)
    }
}