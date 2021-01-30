package com.example.stackoverflowclone.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.stackoverflowclone.R
import kotlinx.android.synthetic.main.fragment_question_detail.*

class QuestionDetailFragment : Fragment(R.layout.fragment_question_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: QuestionDetailFragmentArgs by navArgs()
        title.text = args.myArg

    }

}