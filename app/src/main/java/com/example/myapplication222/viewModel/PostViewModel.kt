package com.example.myapplication222.viewModel
import androidx.lifecycle.ViewModel
import com.example.myapplication222.repository.PostRepository
import com.example.myapplication222.repository.PostRepositorylnMemorylmpl
class PostViewModel: ViewModel() {
    private val repository: PostRepository = PostRepositorylnMemorylmpl()
    val data = repository.get()
    fun like() = repository.like()
}