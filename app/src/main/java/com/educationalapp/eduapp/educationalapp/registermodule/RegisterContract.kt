package com.educationalapp.eduapp.educationalapp.registermodule

/**
 * Created by michaelknight123 on 6/2/2017.
 */
class RegisterContract {

    public interface View {
        fun getNamaPanjang(): String
        fun getEmail(): String
        fun getUsername(): String
        fun getPassword(): String
        fun getGrup(): Int
        fun getPeran(): Int
    }

}