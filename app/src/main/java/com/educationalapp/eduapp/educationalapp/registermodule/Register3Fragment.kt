package com.educationalapp.eduapp.educationalapp.registermodule

import android.media.Image
import android.nfc.Tag
import android.os.Bundle
import android.os.Debug
import android.support.v4.app.Fragment
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

import com.educationalapp.eduapp.educationalapp.R
import org.w3c.dom.Text

class Register3Fragment : Fragment(), RegisterContract.View {

    private var mNavLeftImageView: ImageView? = null
    private var mNavRightImageView: ImageView? = null
    private var mCharImageView: ImageView? = null
    private var mCharName: TextView? = null
    private var mNextButton: Button? = null

    private var charList: MutableList<Int> = mutableListOf<Int>()
    private var charName: MutableList<String> = mutableListOf<String>()
    private var charId: MutableList<Int> = mutableListOf<Int>()
    private var charListPointer: Int = 0

    private var mRegisterPresenter: RegisterPresenter? = null
    private var mRegisterActivity: RegisterActivity? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater!!.inflate(R.layout.fragment_register3, container, false)

        mNavLeftImageView = view.findViewById(R.id.FragmentRegister_char_nav_left_iv) as ImageView
        mNavRightImageView = view.findViewById(R.id.FragmentRegister_char_nav_right_iv) as ImageView
        mCharImageView = view.findViewById(R.id.FragmentRegister_char_iv) as ImageView
        mCharName = view.findViewById(R.id.FragmentRegister_charName_tv) as TextView
        mNextButton = view.findViewById(R.id.FragmentRegister_next_btn_2) as Button
        mRegisterActivity = activity as RegisterActivity

        populateChar()

        mNavLeftImageView?.setOnClickListener(mNavLeftPressed)
        mNavRightImageView?.setOnClickListener(mNavRightPressed)
        mNextButton?.setOnClickListener(mNextButtonPressed)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRegisterPresenter = RegisterPresenter(this, mRegisterActivity!!)
    }

    private fun populateChar() {
        charList.add(R.drawable.ic_apps_black_36dp)
        charName.add("Apps")
        charId.add(1)
        charList.add(R.drawable.ic_cancel_black_36dp)
        charName.add("Cancel")
        charId.add(2)

        mCharImageView?.setImageResource(charList.first())
        mCharName?.text = charName.first()
        charListPointer = 0
    }

    private val mNavLeftPressed = View.OnClickListener {
        charListPointer--
        if(charListPointer < 0)
            charListPointer = charList.size - 1

        mCharImageView?.setImageResource(charList[charListPointer])
        mCharName?.text = charName[charListPointer]
    }
    private val mNavRightPressed = View.OnClickListener {
        charListPointer++
        if(charListPointer >= charList.size)
            charListPointer = 0

        mCharImageView?.setImageResource(charList[charListPointer])
        mCharName?.text = charName[charListPointer]
    }

    private val mNextButtonPressed = View.OnClickListener { mRegisterPresenter?.onNextButtonTwoClick() }
    override fun gotoRegisterPageFour() { mRegisterActivity?.changePageFour() }
    override fun getPeran(): Int { return charId[charListPointer] }

    override fun getNamaLengkap(): String { TODO("not implemented") }
    override fun getUsername(): String { TODO("not implemented") }
    override fun getPassword(): String { TODO("not implemented") }
    override fun getConfirmPassword(): String { TODO("not implemented") }
    override fun getEmail(): String { TODO("not implemented") }
    override fun getGrup(): Int { TODO("not implemented") }
    override fun gotoRegisterPageTwo() { TODO("not implemented") }
    override fun gotoRegisterPageThree() { TODO("not implemented") }
    override fun gotoRegisterPageFive() { TODO("not implemented") }
}
