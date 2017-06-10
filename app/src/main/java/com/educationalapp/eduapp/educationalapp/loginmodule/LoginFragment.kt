package com.educationalapp.eduapp.educationalapp.loginmodule

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.educationalapp.eduapp.educationalapp.R
import com.educationalapp.eduapp.educationalapp.homemodule.HomeActivity
import com.educationalapp.eduapp.educationalapp.registermodule.RegisterActivity
import org.w3c.dom.Text


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LoginFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(), LoginContract.View {

    // TODO: Rename and change types of parameters
    private var mUsernameEditText: EditText? = null
    private var mPasswordEditText: EditText? = null
    private var mLoginButton: Button? = null
    private var mLoginPresenter: LoginPresenter? = null
    private var mRegisterTextView: TextView? = null
    private var mForgotTextView: TextView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view: View = inflater!!.inflate(R.layout.fragment_login, container, false)
        mUsernameEditText = view.findViewById(R.id.FragmentLogin_username_et) as EditText
        mPasswordEditText = view.findViewById(R.id.FragmentLogin_password_et) as EditText
        mLoginButton = view.findViewById(R.id.FragmentLogin_login_btn) as Button
        mRegisterTextView = view.findViewById(R.id.FragmentLogin_register_tv) as TextView
        mForgotTextView = view.findViewById(R.id.FragmentLogin_forgot_password_tv) as TextView

        mLoginButton?.setOnClickListener(mLoginButtonPressed)
        mRegisterTextView?.setOnClickListener(mRegisterTextViewPressed)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mLoginPresenter = LoginPresenter(this, LoginAPI())
    }

    private val mRegisterTextViewPressed = View.OnClickListener {
        mLoginPresenter?.onRegisterTextViewClick()
    }

    private val mLoginButtonPressed = View.OnClickListener {
        mLoginPresenter?.onLoginButtonClick()
    }

    override fun getUsername(): String {
        return mUsernameEditText?.text.toString()
    }

    override fun setUsernameEmptyErrorMsg(resId: Int) {
        mUsernameEditText?.setError(getString(resId))
    }

    override fun getPassword(): String {
        return mPasswordEditText?.text.toString()
    }

    override fun setPasswordEmptyErrorMsg(resId: Int) {
        mPasswordEditText?.setError(getString(resId))
    }

    override fun gotoMainMenu() {
        val intent: Intent = Intent(activity, HomeActivity::class.java)
        startActivity(intent)
        activity.finish()
    }

    override fun gotoRegister() {
        val intent: Intent = Intent(activity, RegisterActivity::class.java)
        startActivity(intent)
        activity.finish()
    }

    override fun showIncorrectLoginMsg() {
        Toast.makeText(context, R.string.username_password_incorrect_string, Toast.LENGTH_SHORT).show()
    }

}
