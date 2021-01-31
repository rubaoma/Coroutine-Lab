package com.example.filmescoroutines.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.security.auth.callback.Callback

class MainRepository {

    fun getFilmes(callback: (filmes: List<Filme>) -> Unit) {

        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Filme(1, "Matrix"),
                    Filme(2, "Rei Leão"),
                    Filme(3, "Super-mam"),
                    Filme(4, "X-mem")
                )
            )
        }).start()
    }

    /**
     * Fazendo uma chamada utilizando coroutines
     * Uma Coroutines tem que estar dentro de uma função suspensa (suspend)
     * */
    suspend fun getFilmesCoroutine(): List<Filme> {

      return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                Filme(1, "Matrix"),
                Filme(2, "Rei Leão"),
                Filme(3, "Super-mam"),
                Filme(4, "X-mem")
            )
        }
    }
}