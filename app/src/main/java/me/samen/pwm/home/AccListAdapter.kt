package me.samen.pwm.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_card.view.*
import me.samen.pwm.R
import me.samen.pwm.common.UserAccount
import java.util.*

class AccListAdapter(val items: ArrayList<UserAccount>, val listener1: View.OnClickListener, val
listener2: View.OnClickListener) : RecyclerView.Adapter<AccListAdapter.AccListViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AccListViewHolder?, position: Int): Unit {
        holder?.show(items.get(position), position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AccListViewHolder = AccListViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout
            .list_item_card, parent, false), listener1, listener2)

    class AccListViewHolder(itemView: View, val listener1: View.OnClickListener, val listener2: View.OnClickListener) : RecyclerView.ViewHolder(itemView) {
        fun show(ua: UserAccount, pos: Int) {
            itemView.apply {
                textView.apply {
                    text = ua.website
                    tag = pos
                    setOnClickListener(listener1)
                }
                textView2.apply {
                    text = ua.username
                    setOnClickListener(listener1)
                    tag=pos
                }
                textView3.apply {
                    setOnClickListener(listener2)
                    tag = pos
                }
            }
        }
    }
}