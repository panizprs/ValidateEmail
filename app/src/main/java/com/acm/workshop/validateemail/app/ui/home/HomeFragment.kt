package com.acm.workshop.validateemail.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.acm.workshop.validateemail.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager


class HomeFragment : DaggerFragment(){

    @Inject
    lateinit var homeViewModelFactory : HomeViewModelFactory

    val homeViewModel by lazy{
        ViewModelProviders.of(this, homeViewModelFactory)[HomeViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emailValidationTextView = view.findViewById<TextView>(R.id.emailValidation)
        val emailEditText = view.findViewById<EditText>(R.id.email)
        val validationButton = view.findViewById<Button>(R.id.validateButton)

        validationButton.setOnClickListener {
            homeViewModel.isEmailValid(emailEditText.text.toString())
            hideKeyboardFrom(requireContext(), this.view?.rootView)
        }
        homeViewModel.emailValidation.observe(this, Observer { result ->
            emailValidationTextView.text = result.toString()
        })
    }
    private fun hideKeyboardFrom(context: Context, view: View?) {
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }

}