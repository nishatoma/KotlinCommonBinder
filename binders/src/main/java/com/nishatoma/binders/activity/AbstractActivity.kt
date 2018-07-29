package com.nishatoma.binders.activity

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.nishatoma.binders.R
import com.nishatoma.binders.adapter.AbstractAdapter
import com.nishatoma.binders.presenter.AbstractPresenter
import com.nishatoma.binders.property.AbstractActivityProperties

abstract class AbstractActivity<P: AbstractPresenter, A: AbstractAdapter> : AppCompatActivity() {

    protected lateinit var properties: AbstractActivityProperties<P, A>
    protected lateinit var presenter: P
    protected lateinit var adapter: A
    protected lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        properties = setProperties()
        presenter = properties.presenter
        adapter = properties.adapter

        if (properties.isRowsIncluded == true) {
            adapter.buildRows()
        }

        title = properties.pageTitle
        setContentView(getLayoutId())

        recyclerView = findViewById(R.id.abstract_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter

        presenter.onViewReady()

        recyclerView.requestFocus()
    }

    /**
     * Returns the id for the current layout being used. Can be used to return a different layout
     * as you wish.
     */
    open fun getLayoutId(): Int {
        return R.layout.abstract_activity
    }

    /**
     * Returns the id for the recycler view. Will return a different id, if you wish to override or
     * provide a different layout.
     */
    open fun getRecyclerViewId(): Int {
        return R.id.abstract_recycler_view
    }

    /**
     * Reload the adapter attached to this activity.
     */
    fun reload() {
        adapter.reload()
    }

    /**
     * Set the adapter and presenter of this class to the adapter and presenter of your choice.
     */
    abstract fun setProperties(): AbstractActivityProperties<P, A>
}