package da.delightedanimation.feature.cat
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import da.delightedanimation.R
import da.delightedanimation.common.SingleLiveEvent
import da.delightedanimation.databinding.ItemCatBinding

class CatAdapter(private val itemClick: SingleLiveEvent<CatItem>?) : RecyclerView.Adapter<CatViewHolder>() {

    var items: List<CatItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemId(position: Int): Long = items[position].imageRes.toLong()
}

class CatViewHolder(itemView: View, private val itemClick: SingleLiveEvent<CatItem>?): RecyclerView.ViewHolder(itemView) {
    private val binding: ItemCatBinding = DataBindingUtil.bind(itemView)!!
    fun bind(item: CatItem) {
        binding.item = item
        binding.root.setOnClickListener {
            itemClick?.postValue(item)
        }
    }
}