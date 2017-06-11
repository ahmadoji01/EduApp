package com.educationalapp.eduapp.educationalapp.registermodule

/**
 * Created by michaelknight123 on 6/2/2017.
 */
class RegisterContract {

    public interface View {
        fun getNamaLengkap(): String
        fun getEmail(): String
        fun getUsername(): String
        fun getPassword(): String
        fun getConfirmPassword(): String
        fun getGrup(): Int
        fun getPeran(): Int
        fun gotoRegisterPageTwo()
        fun gotoRegisterPageThree()
        fun gotoRegisterPageFour()
        fun gotoRegisterPageFive()
    }

}