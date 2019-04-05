package pk.kotlin.sample.managers


import android.util.Log
import pk.kotlin.sample.KotlinApplication
import pk.kotlin.sample.entities.Session


/**
 * Created on 02/04/2019.
 */
object FireStoreManager {

    private val TAG = FireStoreManager.javaClass.canonicalName!!


    fun getSchedule(): ArrayList<Session> {

        val docRef = KotlinApplication.getFireStoreInstance().collection("speakers")

        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: " + document.documents)
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }


//        var list = listOf("sana", "taha")
//
//        var session = Session(
//            "pairCode",
//            "Flutter development - Live code",
//            "1",
//            "2",
//            R.color.listColor1,
//            R.color.white,
//            "taha",
//            "A live code action by two Flutter developers, showcasing the delightful development experience while creating a complete application.",
//            list
//        )
//
//        var session1 = Session(
//            "pairCode",
//            "Flutter development - Live code",
//            "1",
//            "2",
//            R.color.listColor2,
//            R.color.white,
//            "taha",
//            "A live code action by two Flutter developers, showcasing the delightful development experience while creating a complete application.",
//            list
//        );

        var sessionList = ArrayList<Session>()

        return sessionList
    }
}