package io.github.thiminhnhut.loginatm.model

class Account(var accountNo: String, var password: String, var amount: Int, var customerName: String) {

    fun checkLogin(accountNo: String?, password: String?): Boolean {
        return this.accountNo == accountNo && this.password == password
    }
}