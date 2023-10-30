package com.sdk_jigar_demo.jigar_sdk_sample.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdk_jigar_demo.jigar_sdk_sample.data.HealingClip
import com.sdk_jigar_demo.databinding.RvClipHorizontalBinding
import com.sdk_jigar_demo.jigar_sdk_sample.ui.interfaces.ClipClickListener
import com.sdk_jigar_demo.jigar_sdk_sample.utils.extensions.layoutInflater
import com.sdk_jigar_demo.jigar_sdk_sample.utils.extensions.onClick


class ClipHorizontalRecycleAdapter(
    private val list: ArrayList<HealingClip>,
    private val listener: ClipClickListener? = null
) : RecyclerView.Adapter<ClipHorizontalRecycleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ViewHolder {
        val binding = RvClipHorizontalBinding.inflate(parent.context.layoutInflater, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            with(list[position]) {
                data = this
                holder.itemView.onClick {
                    listener?.onClipClicked(position, this@with)
                }
            }
        }


    }


    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(val binding: RvClipHorizontalBinding) :
            RecyclerView.ViewHolder(binding.root)
}