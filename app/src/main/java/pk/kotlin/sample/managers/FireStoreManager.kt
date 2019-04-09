package pk.kotlin.sample.managers


import pk.kotlin.sample.KotlinApplication
import pk.kotlin.sample.constants.FireStoreCollection
import pk.kotlin.sample.entities.Session
import pk.kotlin.sample.entities.Speaker
import pk.kotlin.sample.listeners.ScheduleResponseListener
import pk.kotlin.sample.listeners.SpeakerDetailsResponseListener


/**
 * Created on 02/04/2019.
 */
object FireStoreManager {

    private val TAG = FireStoreManager.javaClass.canonicalName!!

    fun getSchedule(scheduleResponseListener: ScheduleResponseListener) {

        var sessionList = ArrayList<Session>()

        val docRef = KotlinApplication.getFireStoreInstance().collection(FireStoreCollection.DATE)
            .document("WJqsWCMmpTga6K4sbNz0")
            .collection(FireStoreCollection.SESSION).orderBy("startDateTime")

        docRef.get()
            .addOnSuccessListener { document ->

                if (document != null) {

                    for (doc in document.documents) {
                        sessionList.add(doc.toObject(Session::class.java)!!)
                    }
                    scheduleResponseListener.onScheduleResponseSuccess(sessionList)
                } else {
                    scheduleResponseListener.onScheduleResponseSuccess(sessionList)
                }
            }
            .addOnFailureListener { exception ->
                exception.printStackTrace()
                scheduleResponseListener.onScheduleResponseFailure()
            }
    }

    fun getSpeakerDetails(speakerName: String, speakerDetailsResponseListener: SpeakerDetailsResponseListener) {

        val docRef =
            KotlinApplication.getFireStoreInstance().collection(FireStoreCollection.SPEAKER).document(speakerName)

        docRef.get()
            .addOnSuccessListener { document ->

                if (document != null) {

                    var speaker = document.toObject(Speaker::class.java)
                    speakerDetailsResponseListener.onSpeakerResponseSuccess(speaker)
                } else {
                    speakerDetailsResponseListener.onSpeakerResponseFailure()
                }
            }
            .addOnFailureListener { exception ->
                exception.printStackTrace()
                speakerDetailsResponseListener.onSpeakerResponseFailure()
            }
    }
}