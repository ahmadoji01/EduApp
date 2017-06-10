package com.educationalapp.eduapp.educationalapp.loginmodule

/**
 * Created by michaelknight123 on 5/31/2017.
 */
class LoginAPI {

    private var username: String = "uzzybotak"
    private var password: String = "michaelknight123"

    fun authenticate(username: String, password: String): Boolean {
        return (this.username.equals(username) && this.password.equals(password))
    }
}