package com.example.unioncoop.base

import android.view.View
import androidx.databinding.ViewDataBinding
import com.example.unioncoop.objects.BaseObject


/**
 * Created by Raed Saeed on 01/10/2020.
 */
interface TypeFactory {
    fun type(baseObject: BaseObject?): Int
    fun createViewHolder(view: View?, type: Int): AbstractViewHolder<BaseObject>? {
        return null
    }

    fun createViewHolder(viewDataBinding: ViewDataBinding?, type: Int): AbstractViewHolder<*>? {
        return null
    }
}