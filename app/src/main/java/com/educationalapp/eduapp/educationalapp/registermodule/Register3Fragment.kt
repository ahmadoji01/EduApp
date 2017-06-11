package com.educationalapp.eduapp.educationalapp.registermodule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import com.educationalapp.eduapp.educationalapp.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Register3Fragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Register3Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Register3Fragment : Fragment(), RegisterContract.View {
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
        var view: View = inflater!!.inflate(R.layout.fragment_register3, container, false)

        mNamaLengkapEditText = view.findViewById(R.id.FragmentRegister_fullname_et_2) as EditText
        mEmailEditText = view.findViewById(R.id.FragmentRegister_email_et_2) as EditText
        mUsernameEditText = view.findViewById(R.id.FragmentRegister_username_et_2) as EditText
        mPasswordEditText = view.findViewById(R.id.FragmentRegister_password_et_2) as EditText
        mConfirmPasswordEditText = view.findViewById(R.id.FragmentRegister_confirm_password_et_2) as EditText
        mNextButton = view.findViewById(R.id.FragmentRegister_next_btn_2) as Button
        mRegisterActivity = activity as RegisterActivity

        mNamaLengkapEditText?.setText(mRegisterActivity?.registerAPI?.getNamaLengkap(), TextView.BufferType.EDITABLE)
        mEmailEditText?.setText(mRegisterActivity?.registerAPI?.getEmail(), TextView.BufferType.EDITABLE)
        mUsernameEditText?.setText(mRegisterActivity?.registerAPI?.getUsername(), TextView.BufferType.EDITABLE)
        mPasswordEditText?.setText(mRegisterActivity?.registerAPI?.getPassword(), TextView.BufferType.EDITABLE)
        mConfirmPasswordEditText?.setText(mRegisterActivity?.registerAPI?.getConfirmPassword(), TextView.BufferType.EDITABLE)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRegisterPresenter = RegisterPresenter(this, mRegisterActivity!!)
    }

    override fun getNamaLengkap(): String { return mNamaLengkapEditText?.text.toString() }
    override fun getUsername(): String { return mUsernameEditText?.text.toString() }
    override fun getPassword(): String { return mPasswordEditText?.text.toString() }
    override fun getConfirmPassword(): String { return mConfirmPasswordEditText?.text.toString() }
    override fun getEmail(): String { return mEmailEditText?.text.toString() }
    override fun getGrup(): Int { TODO("not implemented") }
    override fun getPeran(): Int { TODO("not implemented") }
    override fun gotoRegisterPageTwo() { TODO("not implemented") }
    override fun gotoRegisterPageThree() { TODO("not implemented") }
}
