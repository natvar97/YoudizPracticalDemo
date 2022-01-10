package com.indialone.youdizpracticaldemo.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.indialone.youdizpracticaldemo.BR
import com.indialone.youdizpracticaldemo.R
import com.indialone.youdizpracticaldemo.databinding.RvCommentsLayoutBinding
import com.indialone.youdizpracticaldemo.model.CommentsResponse

class RvCommentsAdapter : RecyclerView.Adapter<RvCommentsAdapter.RvCommentsViewHolder>() {

    private val arrayList = ArrayList<CommentsResponse>()
    var mBinding: RvCommentsLayoutBinding? = null

    inner class RvCommentsViewHolder(itemView: RvCommentsLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private var binding: RvCommentsLayoutBinding = itemView
        fun bind(comment: CommentsResponse) {
            binding.setVariable(BR.comment, comment)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvCommentsViewHolder {
        val binding: RvCommentsLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.rv_comments_layout, parent, false
        )
        return RvCommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvCommentsViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun addData(list: List<CommentsResponse>) {
        arrayList.clear()
        arrayList.addAll(list)
        notifyDataSetChanged()
    }

}