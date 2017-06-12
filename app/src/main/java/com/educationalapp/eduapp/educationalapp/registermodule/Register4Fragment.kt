package com.educationalapp.eduapp.educationalapp.registermodule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import com.educationalapp.eduapp.educationalapp.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Register4Fragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Register4Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Register4Fragment : Fragment(), RegisterContract.View {
    private var mNavLeftImageView: ImageView? = null
    private var mNavRightImageView: ImageView? = null
    private var mGroupImageView: ImageView? = null
    private var mGroupName: TextView? = null
    private var mNextButton: Button? = null

    private var groupList: MutableList<Int> = mutableListOf<Int>()
    private var groupName: MutableList<String> = mutableListOf<String>()
    private var groupId: MutableList<Int> = mutableListOf<Int>()
    private var groupListPointer: Int = 0

    private var mRegisterPresenter: RegisterPresenter? = null
    private var mRegisterActivity: RegisterActivity? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater!!.inflate(R.layout.fragment_register4, container, false)

        mNavLeftImageView = view.findViewById(R.id.FragmentRegister_group_nav_left_iv) as ImageView
        mNavRightImageView = view.findViewById(R.id.FragmentRegister_group_nav_right_iv) as ImageView
        mGroupImageView = view.findViewById(R.id.FragmentRegister_group_iv) as ImageView
        mGroupName = view.findViewById(R.id.FragmentRegister_groupName_tv) as TextView
        mNextButton = view.findViewById(R.id.FragmentRegister_next_btn_3) as Button
        mRegisterActivity = activity as RegisterActivity

        populateGroup()

        mNavLeftImageView?.setOnClickListener(mNavLeftPressed)
        mNavRightImageView?.setOnClickListener(mNavRightPressed)
        mNextButton?.setOnClickListener(mNextButtonPressed)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRegisterPresenter = RegisterPresenter(this, mRegisterActivity!!)
    }

    private fun populateGroup() {
        groupList.add(R.drawable.ic_arrow_drop_down_circle_black_36dp)
        groupName.add("CircleArrow")
        groupId.add(1)
        groupList.add(R.drawable.ic_expand_more_black_36dp)
        groupName.add("Expand")
        groupId.add(2)

        mGroupImageView?.setImageResource(groupList.first())
        mGroupName?.text = groupName.first()
        groupListPointer = 0
    }

    private val mNavLeftPressed = View.OnClickListener {
        groupListPointer--
        if(groupListPointer < 0)
            groupListPointer = groupList.size - 1

        mGroupImageView?.setImageResource(groupList[groupListPointer])
        mGroupName?.text = groupName[groupListPointer]
    }
    private val mNavRightPressed = View.OnClickListener {
        groupListPointer++
        if(groupListPointer >= groupList.size)
            groupListPointer = 0

        mGroupImageView?.setImageResource(groupList[groupListPointer])
        mGroupName?.text = groupName[groupListPointer]
    }

    private val mNextButtonPressed = View.OnClickListener { mRegisterPresenter?.onNextButtonThreeClick() }
    override fun gotoRegisterPageFive() { mRegisterActivity?.changePageFive() }
    override fun getGrup(): Int { return groupId[groupListPointer] }

    override fun getNamaLengkap(): String { TODO("not implemented") }
    override fun getUsername(): String { TODO("not implemented") }
    override fun getPassword(): String { TODO("not implemented") }
    override fun getConfirmPassword(): String { TODO("not implemented") }
    override fun getEmail(): String { TODO("not implemented") }
    override fun getPeran(): Int { TODO("not implemented") }
    override fun gotoRegisterPageTwo() { TODO("not implemented") }
    override fun gotoRegisterPageThree() { TODO("not implemented") }
    override fun gotoRegisterPageFour() { TODO("not implemented") }
}
