package me.samen.pwm.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_card.view.*
import me.samen.pwm.R
import me.samen.pwm.data.UserAccount

/*
 * Copyright (c) 2016 Newshunt. All rights reserved.
 */
class AccListAdapter(val items: Array<UserAccount>, val listener1: View.OnClickListener, val listener2: View.OnClickListener) : RecyclerView.Adapter<AccListAdapter
.AccListViewHolder>() {

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
            itemView.textView.text = ua.website
            itemView.textView.setOnClickListener(listener1)
            itemView.textView.tag=pos
            itemView.textView2.text = ua.username
            itemView.textView2.setOnClickListener(listener1)
            itemView.textView2.tag=pos
            itemView.textView3.setOnClickListener(listener2)
            itemView.textView3.tag=pos
        }
    }
}