package com.example.myapplication222.repository

import androidx.lifecycle.LiveData
import com.example.myapplication222.post
interface PostRepository {
    fun get(): LiveData<post>
    fun like()
}