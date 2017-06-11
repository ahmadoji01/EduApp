package com.educationalapp.eduapp.educationalapp.registermodule


/**
 * Created by michaelknight123 on 6/2/2017.
 */
class RegisterPresenter(view: RegisterContract.View, registerActivity: RegisterActivity) {

    private var view: RegisterContract.View? = null
    private var registerActivity: RegisterActivity? = null

    init {
        this.view = view
        this.registerActivity = registerActivity
    }

    fun onStartButtonClick() { view?.gotoRegisterPageTwo(); }
    fun onNextButtonOneClick() {
        var namaLengkap: String = view!!.getNamaLengkap()
        var email: String = view!!.getEmail()
        var username: String = view!!.getUsername()
        var password: String = view!!.getPassword()
        var confirmPassword: String = view!!.getConfirmPassword()

        registerActivity?.registerAPI?.setNamaLengkap(namaLengkap)
        registerActivity?.registerAPI?.setEmail(email)
        registerActivity?.registerAPI?.setUsername(username)
        registerActivity?.registerAPI?.setPassword(password)
        registerActivity?.registerAPI?.setConfirmPassword(confirmPassword)

        view!!.gotoRegisterPageThree()
    }
}