package com.nishatoma.binders.binder

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class AbstractBinder<T : RecyclerView.ViewHolder> {

    internal fun getView(@LayoutRes layoutId: Int, parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    }

    /**
     * Returns what type of view this is based on hash code.
     */
    fun getViewType(): Int {
        return this.javaClass.simpleName.hashCode()
    }

    abstract fun createViewHolder(parent: ViewGroup): T

    abstract fun bindViewHolder(holder: T)
}