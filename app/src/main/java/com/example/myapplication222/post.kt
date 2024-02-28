package com.example.myapplication222

 data class post (
     val id: Long,
     val author: String,
     val content: String,
     val published: String,
     var likes: Int = 0,
     var shares: Int =0,
     var likedByMe: Boolean = false,
     var shareByMe: Boolean = false
  )