package pk.kotlin.sample

import android.app.Application
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

/**
 * Created on 02/04/2019.
 */

class KotlinApplication : Application() {

    companion object {
        private lateinit var instance: KotlinApplication
        private lateinit var fireStoreInstance: FirebaseFirestore

        @JvmStatic
        fun getInstance() = instance

        @JvmStatic
        fun getFireStoreInstance() = fireStoreInstance
    }


    override fun onCreate() {
        super.onCreate()
        instance = this

        val settings = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(true)
            .build()
        fireStoreInstance = FirebaseFirestore.getInstance()
        fireStoreInstance.firestoreSettings = settings
    }
}