package com.educationalapp.eduapp.educationalapp.registermodule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.educationalapp.eduapp.educationalapp.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Register1Fragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Register1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Register1Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater!!.inflate(R.layout.fragment_register1, container, false)
        return view
    }
}
