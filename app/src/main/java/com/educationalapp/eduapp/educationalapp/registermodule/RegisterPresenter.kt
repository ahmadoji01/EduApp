package com.educationalapp.eduapp.educationalapp.registermodule


/**
 * Created by michaelknight123 on 6/2/2017.
 */
class RegisterPresenter(view: RegisterContract.View, registerAPI: RegisterAPI) {
    private var view: RegisterContract.View? = null
    private var registerAPI: RegisterAPI? = null

    init {
        this.view = view
        this.registerAPI = registerAPI
    }

    fun onStartButtonClick() { view?.gotoRegisterPageTwo(); }
}