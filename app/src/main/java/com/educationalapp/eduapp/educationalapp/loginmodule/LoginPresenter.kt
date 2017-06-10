package com.educationalapp.eduapp.educationalapp.loginmodule

import com.educationalapp.eduapp.educationalapp.R

/**
 * Created by michaelknight123 on 6/1/2017.
 */

class LoginPresenter(view: LoginContract.View, loginAPI: LoginAPI) {

    private var view: LoginContract.View? = null
    private var loginAPI: LoginAPI? = null

    init {
        this.view = view
        this.loginAPI = loginAPI
    }

    fun onLoginButtonClick() {
        var username: String = view!!.getUsername()
        var password: String = view!!.getPassword()
        var empty: Boolean = false

        if(username.isEmpty()) {
            view?.setUsernameEmptyErrorMsg(R.string.username_empty_string)
            empty = true
        }
        if(password.isEmpty()) {
            view?.setPasswordEmptyErrorMsg(R.string.password_empty_string)
            empty = true
        }

        if(empty)
            return

        if(loginAPI!!.authenticate(username, password)) {
            view?.gotoMainMenu()
            return
        }

        view?.showIncorrectLoginMsg()
    }

    fun onRegisterTextViewClick() {
        view?.gotoRegister()
    }
}
