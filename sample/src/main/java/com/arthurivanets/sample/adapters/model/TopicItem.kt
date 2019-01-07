/*
 * Copyright 2017 Arthur Ivanets, arthur.ivanets.l@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.arthurivanets.sample.adapters.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arthurivanets.adapster.Adapter
import com.arthurivanets.adapster.listeners.ItemClickListener
import com.arthurivanets.adapster.listeners.OnItemClickListener
import com.arthurivanets.adapster.markers.ItemResources
import com.arthurivanets.adapster.model.BaseItem
import com.arthurivanets.adapster.model.Item
import com.arthurivanets.adapster.model.markers.Header
import com.arthurivanets.sample.R
import com.arthurivanets.sample.model.Topic
import com.squareup.picasso.Picasso

class TopicItem(itemModel : Topic) : BaseItem<Topic, TopicItem.ViewHolder, ItemResources>(itemModel),
        Header<TopicItem.ViewHolder> {


    override fun init(adapter : Adapter<out Item<out RecyclerView.ViewHolder, out ItemResources>>?,
                      parent : ViewGroup,
                      inflater : LayoutInflater,
                      resources : ItemResources?) : ViewHolder {
        return ViewHolder(inflater.inflate(
            layout,
            parent,
            false
        ))
    }


    override fun bind(adapter : Adapter<out Item<out RecyclerView.ViewHolder, out ItemResources>>?,
                      viewHolder : ViewHolder,
                      resources : ItemResources?) {
        super.bind(adapter, viewHolder, resources)

        viewHolder.nameTv.text = itemModel.name

        Picasso.with(viewHolder.imageIv.context.applicationContext)
            .load(itemModel.imageUrl)
            //.centerCrop()
            .into(viewHolder.imageIv)
    }


    override fun setOnItemClickListener(viewHolder : ViewHolder, onItemClickListener : OnItemClickListener<Header<ViewHolder>>?) {
        viewHolder.itemView.setOnClickListener(ItemClickListener(this, 0, onItemClickListener))
    }


    override fun getLayout() : Int {
        return R.layout.topic_item_layout
    }


    class ViewHolder(itemView : View) : BaseItem.ViewHolder<Topic>(itemView) {

        val imageIv = itemView.findViewById<ImageView>(R.id.imageIv)
        val nameTv = itemView.findViewById<TextView>(R.id.nameTv)

    }


}