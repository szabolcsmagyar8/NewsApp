package com.androiddevs.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.androiddevs.mvvmnewsapp.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : BaseFragment(R.layout.fragment_article) {

    private val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = args.article

        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article?.url)
        }

        fab.setOnClickListener {
            article?.let {
                viewModel.saveArticle(it)
                Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}
