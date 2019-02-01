package io.github.thiminhnhut.loginatm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.github.thiminhnhut.loginatm.model.Account
import io.github.thiminhnhut.loginatm.model.AccountDB
import io.github.thiminhnhut.loginatm.view.FragmentLogin
import io.github.thiminhnhut.loginatm.view.FragmentStatusLogin

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentLogin: FragmentLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            login()
        }
    }

    private fun login() {
        if (supportFragmentManager.findFragmentByTag("fragmentLogin") == null) {
            Toast.makeText(applicationContext, "Create Fragment Login First", Toast.LENGTH_SHORT).show()
            fragmentLogin = FragmentLogin.newInstance(object : FragmentLogin.OnEvent {
                override fun onClickLogin(sender: Any, accountNo: String, password: String) {
                    val account = AccountDB.newInstance().getAccount()
                    if (account.checkLogin(accountNo, password)) {
                        statusLogin(true, account)
                    } else {
                        statusLogin(false, null)
                    }
                }
            })
            supportFragmentManager.beginTransaction()
                .replace(R.id.root_layout, fragmentLogin)
                .addToBackStack("fragmentLogin")
                .commit()
        } else {
            supportFragmentManager.popBackStack("fragmentLogin", 0)
        }
    }

    private fun statusLogin(isLoginSuccess: Boolean, account: Account?) {
        val fragmentStatusLogin = FragmentStatusLogin.newInstance(object : FragmentStatusLogin.OnEvent {
            override fun onClick(sender: Any) {
                fragmentLogin.resetLogin()
            }
        }, isLoginSuccess, account)
        fragmentStatusLogin.show(supportFragmentManager, "statusLogin")
    }
}
