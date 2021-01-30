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
import com.xwray.groupie.viewbinding.BindableItem

open class RvItem @JvmOverloads constructor(
    private val activity: MainActivity,
    private val text: CharSequence = ""
) : BindableItem<RvItemBinding>() {

    override fun getLayout(): Int = R.layout.rv_item

    override fun initializeViewBinding(view: View): RvItemBinding = RvItemBinding.bind(view)

    override fun bind(viewBinding: RvItemBinding, position: Int) {
        viewBinding.tvTitle.text = text
        var navController: NavController? = null

        viewBinding.tvTitle.apply {

            setOnClickListener {
                
                val action =
                    HomeFragmentDirections.actionHomeFragmentToQuestionDetailFragment(text.toString())

                navController = Navigation.findNavController(activity, R.id.nav_host_fragment)
                navController!!.navigate(action)

            }

        }
    }


    companion object {

        val LOG_TAG = RvItem::class.java.canonicalName
    }

}