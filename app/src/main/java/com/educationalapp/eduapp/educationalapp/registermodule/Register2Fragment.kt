package com.educationalapp.eduapp.educationalapp.registermodule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

import com.educationalapp.eduapp.educationalapp.R

class Register2Fragment : Fragment(), RegisterContract.View {

    private var mRegisterPresenter: RegisterPresenter? = null
    private var mNamaLengkapEditText: EditText? = null
    private var mEmailEditText: EditText? = null
    private var mUsernameEditText: EditText? = null
    private var mPasswordEditText: EditText? = null
    private var mConfirmPasswordEditText: EditText? = null
    private var mNextButton: Button? = null
    private var mRegisterActivity: RegisterActivity? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater!!.inflate(R.layout.fragment_register2, container, false)

        mNamaLengkapEditText = view.findViewById(R.id.FragmentRegister_fullname_et_1) as EditText
        mEmailEditText = view.findViewById(R.id.FragmentRegister_email_et_1) as EditText
        mUsernameEditText = view.findViewById(R.id.FragmentRegister_username_et_1) as EditText
        mPasswordEditText = view.findViewById(R.id.FragmentRegister_password_et_1) as EditText
        mConfirmPasswordEditText = view.findViewById(R.id.FragmentRegister_confirm_password_et_1) as EditText
        mNextButton = view.findViewById(R.id.FragmentRegister_next_btn_1) as Button
        mRegisterActivity = activity as RegisterActivity

        mNextButton?.setOnClickListener(mNextButtonPressed)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRegisterPresenter = RegisterPresenter(this, mRegisterActivity!!)
    }

    private val mNextButtonPressed = View.OnClickListener { mRegisterPresenter?.onNextButtonOneClick() }
    override fun gotoRegisterPageThree() { mRegisterActivity?.changePageThree() }
    override fun getNamaLengkap(): String { return mNamaLengkapEditText?.text.toString() }
    override fun getUsername(): String { return mUsernameEditText?.text.toString() }
    override fun getPassword(): String { return mPasswordEditText?.text.toString() }
    override fun getConfirmPassword(): String { return mConfirmPasswordEditText?.text.toString() }
    override fun getEmail(): String { return mEmailEditText?.text.toString() }

    override fun getGrup(): Int { TODO("not implemented") }
    override fun getPeran(): Int { TODO("not implemented") }
    override fun gotoRegisterPageTwo() { TODO("not implemented") }
    override fun gotoRegisterPageFour() { TODO("not implemented") }
    override fun gotoRegisterPageFive() { TODO("not implemented") }
}
