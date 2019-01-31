package io.github.thiminhnhut.loginatm.model

class AccountDB {
    companion object {
        fun newInstance(): AccountDB {
            return AccountDB()
        }
    }

    fun getAccount(): Account {
        return Account("1350366", "12345", 100, "Nguyen Van A")
    }
}