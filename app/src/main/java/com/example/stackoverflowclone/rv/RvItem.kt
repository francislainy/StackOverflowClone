package com.example.stackoverflowclone.rv

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.stackoverflowclone.R
import com.example.stackoverflowclone.activities.MainActivity
import com.example.stackoverflowclone.databinding.RvItemBinding
import com.example.stackoverflowclone.fragments.HomeFragment
import com.example.stackoverflowclone.fragments.HomeFragmentDirections
import com.example.stackoverflowclone.fragments.QuestionDetailFragmentDirections
import com.example.stackoverflowclone.model.Question
import com.google.gson.Gson
import com.xwray.groupie.viewbinding.BindableItem

open class RvItem @JvmOverloads constructor(
    private val activity: MainActivity,
    private val json: String = ""
) : BindableItem<RvItemBinding>() {

    override fun getLayout(): Int = R.layout.rv_item

    override fun initializeViewBinding(view: View): RvItemBinding = RvItemBinding.bind(view)

    override fun bind(viewBinding: RvItemBinding, position: Int) {

        val gson = Gson()
        val question = gson.fromJson(json, Question::class.java)

        viewBinding.tvTitle.text = question.title

        var navController: NavController? = null

        viewBinding.tvTitle.apply {

            setOnClickListener {

                val action =
                    HomeFragmentDirections.actionHomeFragmentToQuestionDetailFragment(question.title)

                navController = Navigation.findNavController(activity, R.id.nav_host_fragment)
                navController!!.navigate(action)

            }

        }
    }


    companion object {

        val LOG_TAG = RvItem::class.java.canonicalName
    }

}