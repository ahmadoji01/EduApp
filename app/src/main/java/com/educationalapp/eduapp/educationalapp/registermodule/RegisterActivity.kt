package com.educationalapp.eduapp.educationalapp.registermodule

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.educationalapp.eduapp.educationalapp.R

class RegisterActivity : AppCompatActivity() {

    private var registerPageOne: Register1Fragment? = null
    private var registerPageTwo: Register2Fragment? = null
    private var registerPresenter: RegisterPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        if(findViewById(R.id.register_fragment_container) != null) {

            if(savedInstanceState != null)
                return

            registerPageOne = Register1Fragment()
            registerPageOne?.arguments = intent.extras
            supportFragmentManager.beginTransaction()
                    .add(R.id.register_fragment_container, registerPageOne).commit()
        }
    }

    fun changePageTwo() {
        registerPageTwo = Register2Fragment()
        supportFragmentManager.beginTransaction()
                .replace(R.id.register_fragment_container, registerPageTwo).commit()
    }
}
