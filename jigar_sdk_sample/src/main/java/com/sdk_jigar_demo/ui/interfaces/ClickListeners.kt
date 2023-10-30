package com.sdk_jigar_demo.ui.interfaces

import com.sdk_jigar_demo.data.Article
import com.sdk_jigar_demo.data.HealingClip
import com.sdk_jigar_demo.data.Podcast

interface PodcastClickListener {
    fun onPodcastClicked(position: Int, podcast: Podcast)
}
interface ArticleClickListener {
    fun onArticleClicked(position: Int, article: Article)
}
interface ClipClickListener {
    fun onClipClicked(position: Int, clip: HealingClip)
}