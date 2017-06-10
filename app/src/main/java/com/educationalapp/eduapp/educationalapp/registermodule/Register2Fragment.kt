package com.educationalapp.eduapp.educationalapp.registermodule

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

import com.educationalapp.eduapp.educationalapp.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Register2Fragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Register2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Register2Fragment : Fragment(), RegisterContract.View {

    private var mRegisterPresenter: RegisterPresenter? = null
    private var mNamaLengkapEditText: EditText? = null
    private var mEmailEditText: EditText? = null
    private var mUsernameEditText: EditText? = null
    private var mPasswordEditText: EditText? = null
    private var mConfirmPasswordEditText: EditText? = null
    private var mNextButton: Button? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater!!.inflate(R.layout.fragment_register2, container, false)

        mNamaLengkapEditText = view.findViewById(R.id.FragmentRegister_fullname_et) as EditText
        mEmailEditText = view.findViewById(R.id.FragmentRegister_email_et) as EditText
        mUsernameEditText = view.findViewById(R.id.FragmentRegister_username_et) as EditText
        mPasswordEditText = view.findViewById(R.id.FragmentRegister_password_et) as EditText
        mConfirmPasswordEditText = view.findViewById(R.id.FragmentRegister_confirm_password_et) as EditText
        mNextButton = view.findViewById(R.id.FragmentRegister_next1_btn) as Button

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRegisterPresenter = RegisterPresenter(this, RegisterAPI())
    }

    override fun getNamaPanjang(): String { TODO("not implemented") }
    override fun getUsername(): String { TODO("not implemented") }
    override fun getPassword(): String { TODO("not implemented") }
    override fun getEmail(): String { TODO("not implemented") }
    override fun getGrup(): Int { TODO("not implemented") }
    override fun getPeran(): Int { TODO("not implemented") }
    override fun gotoRegisterPageTwo() { TODO("not implemented") }
    override fun gotoRegisterPageThree() { TODO("not implemented") }
}