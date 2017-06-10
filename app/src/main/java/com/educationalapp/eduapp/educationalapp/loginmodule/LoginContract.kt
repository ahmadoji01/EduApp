package com.educationalapp.eduapp.educationalapp.loginmodule

import android.support.annotation.StringRes

/**
 * Created by michaelknight123 on 6/1/2017.
 */
class LoginContract {

    public interface View  {
        fun getUsername(): String
        fun setUsernameEmptyErrorMsg(@StringRes resId: Int)
        fun getPassword(): String
        fun setPasswordEmptyErrorMsg(@StringRes resId: Int)
        fun gotoMainMenu()
        fun showIncorrectLoginMsg()
        fun gotoRegister()
    }
}