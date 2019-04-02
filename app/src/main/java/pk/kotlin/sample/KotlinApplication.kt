package pk.kotlin.sample

import android.app.Application

/**
 * Created on 02/04/2019.
 */

class KotlinApplication : Application() {

    companion object {
        lateinit var instance: KotlinApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}