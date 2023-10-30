package com.sdk_jigar_demo.jigar_sdk_sample.ui.interfaces

import com.sdk_jigar_demo.jigar_sdk_sample.data.Article
import com.sdk_jigar_demo.jigar_sdk_sample.data.HealingClip
import com.sdk_jigar_demo.jigar_sdk_sample.data.Podcast

interface PodcastClickListener {
    fun onPodcastClicked(position: Int, podcast: Podcast)
}
interface ArticleClickListener {
    fun onArticleClicked(position: Int, article: Article)
}
interface ClipClickListener {
    fun onClipClicked(position: Int, clip: HealingClip)
}