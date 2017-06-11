package com.educationalapp.eduapp.educationalapp.registermodule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.educationalapp.eduapp.educationalapp.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Register1Fragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Register1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Register1Fragment : Fragment(), RegisterContract.View {

    private var mStartButton: Button? = null
    private var mRegisterPresenter: RegisterPresenter? = null
    private var mRegisterActivity: RegisterActivity? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater!!.inflate(R.layout.fragment_register1, container, false)
        mStartButton = view.findViewById(R.id.FragmentRegister_start_btn) as Button
        mRegisterActivity = activity as RegisterActivity

        mStartButton?.setOnClickListener(mStartButtonPressed)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRegisterPresenter = RegisterPresenter(this, mRegisterActivity!!)
    }

    override fun getNamaLengkap(): String { TODO("not implemented") }
    override fun getUsername(): String { TODO("not implemented") }
    override fun getPassword(): String { TODO("not implemented") }
    override fun getConfirmPassword(): String { TODO("not implemented") }
    override fun getEmail(): String { TODO("not implemented") }
    override fun getGrup(): Int { TODO("not implemented") }
    override fun getPeran(): Int { TODO("not implemented") }
    override fun gotoRegisterPageThree() { TODO("not implemented") }

    private val mStartButtonPressed = View.OnClickListener { mRegisterPresenter?.onStartButtonClick() }
    override fun gotoRegisterPageTwo() { mRegisterActivity?.changePageTwo() }
}
