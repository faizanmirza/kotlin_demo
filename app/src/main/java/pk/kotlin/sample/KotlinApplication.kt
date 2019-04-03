package pk.kotlin.sample

import android.app.Application
import android.content.Context

/**
 * Created on 02/04/2019.
 */

class KotlinApplication : Application() {

    companion object {
        private lateinit var instance: KotlinApplication

        @JvmStatic
        fun getInstance() = instance
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}