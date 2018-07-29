package com.nishatoma.commonbinder

import android.os.Bundle
import com.nishatoma.binders.activity.AbstractActivity
import com.nishatoma.binders.property.AbstractActivityProperties

class MainActivity : AbstractActivity<ExamplePresenter, ExampleAdapter>() {

    override fun setProperties(): AbstractActivityProperties<ExamplePresenter, ExampleAdapter> {
        presenter = ExamplePresenter()
        adapter = ExampleAdapter()
        return AbstractActivityProperties(presenter, adapter, "", true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
