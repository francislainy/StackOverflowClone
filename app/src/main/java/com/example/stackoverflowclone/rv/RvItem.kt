package com.example.stackoverflowclone.rv

import androidx.navigation.NavController
import com.example.stackoverflowclone.R
import com.example.stackoverflowclone.activities.MainActivity
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.rv_item.view.*

private val LOG_TAG = RvItem::class.java.canonicalName

class RvItem(
    private val activity: MainActivity,
    private val title: String
) : Item<GroupieViewHolder>() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        var navController: NavController? = null

        viewHolder.apply {

            with(viewHolder.itemView) {

                tvTitle.text = title

            }

        }
    }


    override fun getLayout() = R.layout.rv_item

}