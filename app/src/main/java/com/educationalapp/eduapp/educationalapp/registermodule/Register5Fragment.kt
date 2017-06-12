package com.educationalapp.eduapp.educationalapp.registermodule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

import com.educationalapp.eduapp.educationalapp.R

class Register5Fragment : Fragment(), RegisterContract.View {
    private var mRegisterPresenter: RegisterPresenter? = null
    private var mNamaLengkapEditText: EditText? = null
    private var mEmailEditText: EditText? = null
    private var mUsernameEditText: EditText? = null
    private var mPasswordEditText: EditText? = null
    private var mPeranEditText: EditText? = null
    private var mGrupEditText: EditText? = null
    private var mYaButton: Button? = null
    private var mTidakButton: Button? = null
    private var mRegisterActivity: RegisterActivity? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater!!.inflate(R.layout.fragment_register5, container, false)

        mNamaLengkapEditText = view.findViewById(R.id.FragmentRegister_fullname_et_2) as EditText
        mEmailEditText = view.findViewById(R.id.FragmentRegister_email_et_2) as EditText
        mUsernameEditText = view.findViewById(R.id.FragmentRegister_username_et_2) as EditText
        mPasswordEditText = view.findViewById(R.id.FragmentRegister_password_et_2) as EditText
        mPeranEditText = view.findViewById(R.id.FragmentRegister_peran_et) as EditText
        mGrupEditText = view.findViewById(R.id.FragmentRegister_grup_et) as EditText
        mYaButton = view.findViewById(R.id.FragmentRegister_ya_btn) as Button
        mTidakButton = view.findViewById(R.id.FragmentRegister_tidak_btn) as Button
        mRegisterActivity = activity as RegisterActivity

        showAPIData()

        mYaButton?.setOnClickListener(mYaButtonPressed)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRegisterPresenter = RegisterPresenter(this, mRegisterActivity!!)
    }

    fun showAPIData() {
        mNamaLengkapEditText?.setText(mRegisterActivity?.registerAPI?.getNamaLengkap())
        mEmailEditText?.setText(mRegisterActivity?.registerAPI?.getEmail())
        mUsernameEditText?.setText(mRegisterActivity?.registerAPI?.getUsername())
        mPasswordEditText?.setText(mRegisterActivity?.registerAPI?.getPassword())
        mPeranEditText?.setText(mRegisterActivity?.registerAPI?.getPeran().toString())
        mGrupEditText?.setText(mRegisterActivity?.registerAPI?.getGrup().toString())

        mNamaLengkapEditText?.isEnabled = false
        mEmailEditText?.isEnabled = false
        mUsernameEditText?.isEnabled = false
        mPasswordEditText?.isEnabled = false
        mPeranEditText?.isEnabled = false
        mGrupEditText?.isEnabled = false
    }

    private val mYaButtonPressed = View.OnClickListener { mRegisterPresenter?.onNextButtonOneClick() }
    override fun gotoRegisterPageThree() { mRegisterActivity?.changePageThree() }
    override fun getNamaLengkap(): String { return mNamaLengkapEditText?.text.toString() }
    override fun getUsername(): String { return mUsernameEditText?.text.toString() }
    override fun getPassword(): String { return mPasswordEditText?.text.toString() }
    override fun getEmail(): String { return mEmailEditText?.text.toString() }
    override fun getPeran(): Int { return mPeranEditText?.text.toString().toInt() }
    override fun getGrup(): Int { return mGrupEditText?.text.toString().toInt() }

    override fun getConfirmPassword(): String { TODO("not implemented") }
    override fun gotoRegisterPageTwo() { TODO("not implemented") }
    override fun gotoRegisterPageFour() { TODO("not implemented") }
    override fun gotoRegisterPageFive() { TODO("not implemented") }
}
