package com.example.stackoverflowclone.rv

import android.view.View
import com.example.stackoverflowclone.R
import com.example.stackoverflowclone.activities.MainActivity
import com.example.stackoverflowclone.databinding.RvItemBinding
import com.xwray.groupie.viewbinding.BindableItem

private val LOG_TAG = RvItem::class.java.canonicalName

open class RvItem @JvmOverloads constructor(
    val activity: MainActivity,
    val text: CharSequence = ""
) : BindableItem<RvItemBinding>() {

    override fun getLayout(): Int = R.layout.rv_item

    override fun initializeViewBinding(view: View): RvItemBinding = RvItemBinding.bind(view)

    override fun bind(viewBinding: RvItemBinding, position: Int) {
        viewBinding.tvTitle.text = text
    }
}