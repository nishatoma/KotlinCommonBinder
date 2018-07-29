package com.nishatoma.binders.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.nishatoma.binders.binder.AbstractBinder

abstract class AbstractAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val itemList: ArrayList<AbstractBinder<*>> = ArrayList()

    /**
     * Returns the binder that corresponds with its ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getDataBinder<AbstractBinder<RecyclerView.ViewHolder>>(viewType)!!.createViewHolder(parent)
    }

    /**
     * Gets item count from the item list.
     */
    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        @Suppress("UNCHECKED_CAST")
        (itemList as ArrayList<AbstractBinder<RecyclerView.ViewHolder>>)[position].bindViewHolder(holder)
    }

    /**
     * Returns binder's unique id as hash code.
     */
    override fun getItemViewType(position: Int): Int {
        return getItems()[position].getViewType()
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : AbstractBinder<RecyclerView.ViewHolder>> getDataBinder(viewType: Int): T? {
        for (binder in getItems()) {
            if (binder.getViewType() == viewType) {
                return binder as T
            }
        }
        return null
    }

    private fun getItems(): ArrayList<AbstractBinder<*>> {
        return itemList
    }

    /**
     * Reload the recycler view and notify data set changed.
     */
    fun reload() {
        itemList.clear()
        buildRows()
        notifyDataSetChanged()
    }

    /**
     * Add a binder to the recycler view.
     */
    fun add(binder: AbstractBinder<*>) {
        itemList.add(binder)
        notifyItemChanged(itemList.size)
    }

    /**
     * Fills recycler view with the list of binders.
     *
     * Example usage:
     *
     * override fun buildRows() {
     *
     *      add(yourCustomBinder1)
     *      add(yourCustomBinder2)
     * }
     */
    abstract fun buildRows()
}