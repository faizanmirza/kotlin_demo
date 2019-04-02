package pk.kotlin.sample.managers


import com.google.firebase.firestore.FirebaseFirestore
import pk.kotlin.sample.R
import pk.kotlin.sample.entities.Session


/**
 * Created on 02/04/2019.
 */
object FireStoreManager {

    private val TAG = FireStoreManager.javaClass.canonicalName!!

    var firebaseFirestore = FirebaseFirestore.getInstance()

    fun getSchedule(): ArrayList<Session> {

        var list = listOf("sana", "taha")

        var session = Session(
            "pairCode",
            "Flutter development - Live code",
            "1",
            "2",
            R.color.listColor1,
            R.color.white,
            "taha",
            "A live code action by two Flutter developers, showcasing the delightful development experience while creating a complete application.",
            list
        )

        var session1 = Session(
            "pairCode",
            "Flutter development - Live code",
            "1",
            "2",
            R.color.listColor2,
            R.color.white,
            "taha",
            "A live code action by two Flutter developers, showcasing the delightful development experience while creating a complete application.",
            list
        );

        var sessionList = ArrayList<Session>()
        sessionList.add(session)
        sessionList.add(session1)
        return sessionList
    }
}