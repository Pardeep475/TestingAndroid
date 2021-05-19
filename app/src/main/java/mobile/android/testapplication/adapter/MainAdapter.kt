package mobile.android.testapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.rv_item.view.*
import mobile.android.testapplication.R
import mobile.android.testapplication.databinding.RvItemBinding
import mobile.android.testapplication.model.APIResponseModelElement
import mobile.android.testapplication.model.ApiResponseModel

class MainAdapter(
    private val context: Context,
    private val itemList: ArrayList<APIResponseModelElement>
) :
    RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    private lateinit var rvItemBinding: RvItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        rvItemBinding = DataBindingUtil.inflate<RvItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.rv_item, parent, false
        )
        return MyViewHolder(rvItemBinding)
    }

    override fun getItemCount(): Int {
        return itemList.size
//        return 50
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        Glide.with(context)
            .load(itemList[position].download_url)
            .placeholder(circularProgressDrawable)
            .error(R.drawable.img_placeholder_2)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.itemView.id_item_rv)
    }

    class MyViewHolder(item: RvItemBinding) : RecyclerView.ViewHolder(item.root)
}