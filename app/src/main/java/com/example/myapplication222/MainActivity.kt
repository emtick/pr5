package com.example.myapplication222

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication222.R
import com.example.myapplication222.databinding.ActivityMainBinding
import com.example.myapplication222.viewModel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                textView.text = post.author
                textView2.text = post.published
                textView3.text = post.content
                if (post.likedByMe) {
                    like.setImageResource(R.drawable.ic_launcher_foreground)
                    likeCount.text = post.likes.toString()
                    root.setOnClickListener{
                        Log.d( "stuff", "stuff")
                    }
                    imageView.setOnClickListener{
                        Log.d("stuff", "avatar")

                    }
                    like.setOnClickListener {
                        Log.d("stuff", "like")
                        post.likedByMe = !post.likedByMe
                        like.setImageResource(
                            if (post.likedByMe) R.drawable.ic_launcher_foreground else R.drawable.baseline_favorite_border_24
                        )
                        if (post.likedByMe) post.likes++ else post.likes--
                        likeCount.text = post.likes.toString()
                        if (post.likes == 1000) likeCount.text =  post.likes.toString(); likeCount.text = "1k"

                    }

                    share.setOnClickListener {
                        Log.d("stuff", "sharee")
                        post.shareByMe = !post.shareByMe
                        if (post.shareByMe) post.shares++
                        shareCount.text = post.shares.toString()
                    }
                }
                binding.like.setOnClickListener {
                    viewModel.like()
                }
            }
        }
    }
}