package com.educationalapp.eduapp.educationalapp.registermodule

/**
 * Created by michaelknight123 on 6/2/2017.
 */
class RegisterAPI {
    private var namaPanjang: String? = null
    private var email: String? = null
    private var username: String? = null
    private var password: String? = null
    private var grup: Int? = null
    private var peran: Int? = null

    public fun setNamaPanjang(namaPanjang: String?) {
        this.namaPanjang = namaPanjang
    }
    public fun getNamaPanjang(): String? {
        return this.namaPanjang
    }

    public fun setEmail(email: String?) {
        this.email = email
    }
    public fun getEmail(): String? {
        return this.email
    }

    public fun setUsername(username: String?) {
        this.username = username
    }
    public fun getUsername(): String? {
        return this.username
    }

    public fun setPassword(password: String?) {
        this.password = password
    }
    public fun getPassword(): String? {
        return this.password
    }

    public fun setGrup(grup: Int?) {
        this.grup = grup
    }
    public fun getGrup(): Int? {
        return this.grup
    }

    public fun setPeran(peran: Int?) {
        this.peran = peran
    }
    public fun getPeran(): Int? {
        return this.peran
    }
}