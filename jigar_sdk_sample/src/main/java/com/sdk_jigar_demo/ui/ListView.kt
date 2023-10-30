package com.sdk_jigar_demo.ui

import android.view.View
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.sdk_jigar_demo.ConnectedMindSDK
import com.sdk_jigar_demo.data.Article
import com.sdk_jigar_demo.data.HealingClip
import com.sdk_jigar_demo.data.Podcast
import com.sdk_jigar_demo.databinding.LayoutRvBinding
import com.sdk_jigar_demo.ui.adapter.ArticleHorizontalRecycleAdapter
import com.sdk_jigar_demo.ui.adapter.ClipHorizontalRecycleAdapter
import com.sdk_jigar_demo.ui.adapter.PodcastHorizontalRecycleAdapter
import com.sdk_jigar_demo.ui.interfaces.ArticleClickListener
import com.sdk_jigar_demo.ui.interfaces.ClipClickListener
import com.sdk_jigar_demo.ui.interfaces.PodcastClickListener
import com.sdk_jigar_demo.utils.extensions.isNotNullOrEmpty
import com.sdk_jigar_demo.utils.extensions.layoutInflater

object ListView{
    fun getPodcastByEmotionIdView(content: JsonObject,listener : PodcastClickListener? = null): View? {
        val list: ArrayList<Podcast> = Gson().fromJson(content.get("data").asJsonArray, object :TypeToken<ArrayList<Podcast>>() {}.type)
        var layoutRv: LayoutRvBinding? = null
        if (list.isNotNullOrEmpty()){
            ConnectedMindSDK().instance?.let { context ->
                layoutRv = LayoutRvBinding.inflate(context.layoutInflater, null, false)
                layoutRv?.let {
                    with(it){
                        val podcastRecycleAdapter = PodcastHorizontalRecycleAdapter(list,listener)
                        rv.adapter = podcastRecycleAdapter
                    }
                }
            }
        }
        return layoutRv?.root
    }
    fun getArticleByEmotionIdView(content: JsonObject,listener : ArticleClickListener? = null): View? {
        val list: ArrayList<Article> = Gson().fromJson(content.get("data").asJsonArray, object :TypeToken<ArrayList<Article>>() {}.type)
        var layoutRv: LayoutRvBinding? = null
        if (list.isNotNullOrEmpty()){
            ConnectedMindSDK().instance?.let { context ->
                layoutRv = LayoutRvBinding.inflate(context.layoutInflater, null, false)
                layoutRv?.let {
                    with(it){
                        val articleRecycleAdapter = ArticleHorizontalRecycleAdapter(list,listener)
                        rv.adapter = articleRecycleAdapter
                    }
                }
            }
        }
        return layoutRv?.root
    }
    fun getClipByEmotionIdView(content: JsonObject,listener : ClipClickListener? = null): View? {
        val list: ArrayList<HealingClip> = Gson().fromJson(content.get("data").asJsonArray, object :TypeToken<ArrayList<HealingClip>>() {}.type)
        var layoutRv: LayoutRvBinding? = null
        if (list.isNotNullOrEmpty()){
            ConnectedMindSDK().instance?.let { context ->
                layoutRv = LayoutRvBinding.inflate(context.layoutInflater, null, false)
                layoutRv?.let {
                    with(it){
                        val clipRecycleAdapter = ClipHorizontalRecycleAdapter(list,listener)
                        rv.adapter = clipRecycleAdapter
                    }
                }
            }
        }
        return layoutRv?.root
    }
}