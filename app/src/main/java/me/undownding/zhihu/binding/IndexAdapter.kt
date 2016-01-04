package me.undownding.zhihu.binding

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.undownding.zhihu.R

import me.undownding.zhihu.databinding.ListItemIndexBinding
import me.undownding.zhihu.model.StoryList

/**
 * Created by undow on 2016/1/4.
 */
public class IndexAdapter(private val storyList: StoryList) : RecyclerView.Adapter<IndexAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder? {
        val inflater = LayoutInflater.from(parent.context);
        val binding: ListItemIndexBinding = DataBindingUtil.inflate(inflater, R.layout.list_item_index, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.story = storyList.stories[position]
    }

    override fun getItemCount(): Int {
        return storyList.stories.size
    }

    class Holder(internal val binding: ListItemIndexBinding) : RecyclerView.ViewHolder(binding.root)
}
