package com.example.unioncoop.base

import android.os.Bundle
import android.view.View
import androidx.annotation.NonNull

import androidx.recyclerview.widget.RecyclerView




/**
 * Created by Raed Saeed on 01/10/2020.
 */
abstract class AbstractViewHolder<T>(@NonNull itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    abstract fun bind(element: T)
    fun bindTwo(element: Bundle?) {}
    fun bindTwo(element: T) {}
}
