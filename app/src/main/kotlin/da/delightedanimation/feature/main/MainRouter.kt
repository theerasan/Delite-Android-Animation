package da.delightedanimation.feature.main

import android.content.Context
import da.delightedanimation.R
import da.delightedanimation.feature.main.step.StepItem
import da.delightedanimation.feature.step1.list.Step1ListActivity
import da.delightedanimation.feature.step2.list.Step2ListActivity
import da.delightedanimation.feature.step3.list.Step3ListActivity
import da.delightedanimation.feature.step4.list.Step4ListActivity
import da.delightedanimation.feature.step5.list.Step5ListActivity

interface MainRouter {
    fun gotoNextStep(item: StepItem?)
}

class MainRouterImpl(val context: Context) : MainRouter {
    override fun gotoNextStep(item: StepItem?) {
        item?.let {
            when(it.imageRes) {
                R.drawable.mobile_conf_001 -> Step1ListActivity.route(context)
                R.drawable.mobile_conf_002 -> Step2ListActivity.route(context)
                R.drawable.mobile_conf_003 -> Step3ListActivity.route(context)
                R.drawable.mobile_conf_004 -> Step4ListActivity.route(context)
                R.drawable.mobile_conf_005 -> Step5ListActivity.route(context)
            }
        }
    }
}