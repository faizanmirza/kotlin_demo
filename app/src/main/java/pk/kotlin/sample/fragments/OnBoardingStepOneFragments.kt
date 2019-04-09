package pk.kotlin.sample.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import pk.kotlin.sample.R


class OnBoardingStepOneFragments : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_on_boarding_step_one, container, false)
        initUI(view)
        return view
    }

    private fun initUI(view: View?) {
        var logo = view?.findViewById<AppCompatImageView>(R.id.imgLogo)
        val animate = AnimationUtils.loadAnimation(activity, R.anim.slide_splash)
        logo?.startAnimation(animate)
    }
}