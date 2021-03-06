package da.delightedanimation.feature.step1.list

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.dgreenhalgh.android.simpleitemdecoration.linear.EndOffsetItemDecoration
import com.dgreenhalgh.android.simpleitemdecoration.linear.StartOffsetItemDecoration
import da.delightedanimation.R
import da.delightedanimation.databinding.ActivityStep1Binding
import da.delightedanimation.feature.cat.CatAdapter
import da.delightedanimation.feature.cat.CatItem

interface Step1ListView {
    fun setItems(items: List<CatItem>?)
}

class Step1ListViewImpl(activity: AppCompatActivity, val binding: ActivityStep1Binding) : Step1ListView {

    init {
        with(activity) {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }

        with(binding.catList) {
            val pixelSize = context.resources.getDimensionPixelSize(R.dimen.gap_xlarge)
            addItemDecoration(StartOffsetItemDecoration(pixelSize))
            addItemDecoration(EndOffsetItemDecoration(pixelSize))
            setHasFixedSize(false)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            adapter = CatAdapter(binding.viewModel?.itemClick)
        }
    }

    override fun setItems(items: List<CatItem>?) {
        (binding.catList.adapter as CatAdapter).items = items ?: emptyList()
    }
}

