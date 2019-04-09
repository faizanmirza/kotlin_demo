package pk.kotlin.sample.activities

import CircleTransform
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import com.squareup.picasso.Picasso
import pk.kotlin.sample.R
import pk.kotlin.sample.constants.GlobalConstants
import pk.kotlin.sample.entities.Session
import pk.kotlin.sample.entities.Speaker
import pk.kotlin.sample.presenter.ScheduleDetailPresenter
import pk.kotlin.sample.utils.Utils
import pk.kotlin.sample.views.ScheduleDetailView


class ScheduleDetailActivity : AppCompatActivity(), ScheduleDetailView {

    private var session: Session? = null
    private lateinit var txtSpeaker: TextView
    private lateinit var txtAboutSpeaker: TextView
    private lateinit var txtTitle: TextView
    private lateinit var txtSubTitle: TextView
    private lateinit var relColoredBox: LinearLayout
    private lateinit var imgUser: AppCompatImageView
    private val scheduleDetailPresenter = ScheduleDetailPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_detail)

        session = intent.extras.get(GlobalConstants.SESSION) as Session?
        initUI()
    }

    private fun initUI() {

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        txtSpeaker = findViewById<AppCompatTextView>(R.id.txtSpeaker)
        txtAboutSpeaker = findViewById<AppCompatTextView>(R.id.txtAboutSpeaker)
        txtTitle = findViewById<AppCompatTextView>(R.id.txtTitle)
        txtSubTitle = findViewById<AppCompatTextView>(R.id.txtSubTitle)
        relColoredBox = findViewById(R.id.relColoredBox)
        imgUser = findViewById(R.id.imgUser)

        setupToolbar(toolbar)
        setUI()
    }

    private fun setUI() {

        if (!TextUtils.isEmpty(session?.speakerId))
            scheduleDetailPresenter.fetchSpeakerDetails(session?.speakerId!!)

        txtTitle.text = session?.title
        txtSubTitle.text = session?.description
    }


    private fun setupToolbar(toolbar: Toolbar) {

        toolbar.title = session?.title

        var backgroundColor = R.color.listColor1

        if (session?.getSessionBackGroundColor() != null) {
            backgroundColor = session?.getSessionBackGroundColor()!!
        }
        toolbar.setBackgroundColor(Utils.getColor(backgroundColor))

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Utils.getColor(backgroundColor)
        }

        setSessionBackground(backgroundColor)
    }

    private fun setSessionBackground(backgroundColor: Int) {
        var background = relColoredBox.background

        if (background is GradientDrawable) {
            background.setColor(Utils.getColor(backgroundColor))
        } else {
            relColoredBox.setBackgroundColor(Utils.getColor(backgroundColor))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_nothing, R.anim.slide_bottom_down)
    }

    override fun populateSpeakerData(speaker: Speaker?) {

        txtSpeaker.text = speaker?.name
        txtAboutSpeaker.text = speaker?.description
        Picasso.get().load(speaker?.photoUrl).placeholder(R.drawable.ic_person).transform(CircleTransform())
            .into(imgUser)
    }

}
