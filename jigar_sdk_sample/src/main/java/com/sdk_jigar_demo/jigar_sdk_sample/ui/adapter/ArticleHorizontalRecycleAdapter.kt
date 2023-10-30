package com.sdk_jigar_demo.jigar_sdk_sample.ui.adapter

import android.graphics.Color
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdk_jigar_demo.R
import com.sdk_jigar_demo.jigar_sdk_sample.data.Article
import com.sdk_jigar_demo.databinding.RvArticleHorizontalBinding
import com.sdk_jigar_demo.jigar_sdk_sample.ui.interfaces.ArticleClickListener
import com.sdk_jigar_demo.jigar_sdk_sample.utils.DateFunctions
import com.sdk_jigar_demo.jigar_sdk_sample.utils.extensions.layoutInflater
import com.sdk_jigar_demo.jigar_sdk_sample.utils.extensions.onClick


class ArticleHorizontalRecycleAdapter(
    private val list: ArrayList<Article>,
    private val listener: ArticleClickListener? = null
) : RecyclerView.Adapter<ArticleHorizontalRecycleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ViewHolder {
        val binding = RvArticleHorizontalBinding.inflate(parent.context.layoutInflater, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            val context = root.context
            with(list[position]) {
                data = this
                this.cover_image?.text_hex_code?.let {
                    tvArticleName.setTextColor(Color.parseColor(it))
                    tvArticleDate.setTextColor(Color.parseColor(it))
                    tvArticleAuthorName.setTextColor(Color.parseColor(it))
                }

                tvArticleAuthorName.text = if (this.connectedminds_feed == 1){
                    context.getString(R.string.by_connectedminds)
                }else{
                    "By ".plus((this.expert.first_name + " " + this.expert.last_name)).also {
                        tvArticleAuthorName.text = it
                    }
                }

                (context.getString(
                    R.string.combine_two_strings_by_dot,
                    DateFunctions.convertMilliSecondsToDate(this.created_at, DateFunctions.MMM_dd_yyyy),
                    DateFunctions.displayAudioDuration(this.duration.toLong()).plus(" read")
                )).also {
                    tvArticleDate.text = it
                }

                holder.itemView.onClick {
                    listener?.onArticleClicked(position, this@with)
                }
            }
        }


    }


    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(val binding: RvArticleHorizontalBinding) :
            RecyclerView.ViewHolder(binding.root)
}