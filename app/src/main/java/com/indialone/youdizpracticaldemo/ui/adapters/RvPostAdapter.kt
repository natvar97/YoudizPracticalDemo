package com.indialone.youdizpracticaldemo.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.indialone.youdizpracticaldemo.BR
import com.indialone.youdizpracticaldemo.R
import com.indialone.youdizpracticaldemo.databinding.RvItemLayoutBinding
import com.indialone.youdizpracticaldemo.model.PostResponse

class RvPostAdapter(
    private val listener: ClickListener
) : RecyclerView.Adapter<RvPostAdapter.RvPostViewHolder>() {

    private val arrayList = ArrayList<PostResponse>()

    class RvPostViewHolder(itemView: RvItemLayoutBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView
        fun bind(post: PostResponse) {
            binding.setVariable(BR.item, post)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RvPostAdapter.RvPostViewHolder {
        val binding: RvItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.rv_item_layout,
            parent,
            false
        )
        return RvPostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvPostAdapter.RvPostViewHolder, position: Int) {
        holder.bind(arrayList[position])

        holder.itemView.setOnClickListener {
            listener.onClick(position, arrayList[position])
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun addData(list: List<PostResponse>) {
        arrayList.clear()
        arrayList.addAll(list)
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onClick(position: Int, data: PostResponse)
    }

}