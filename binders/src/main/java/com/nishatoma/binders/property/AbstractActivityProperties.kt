package com.nishatoma.binders.property

import com.nishatoma.binders.adapter.AbstractAdapter
import com.nishatoma.binders.presenter.AbstractPresenter

/**
 * Used in an activity that inherits AbstractActivity. This class defines the presenter and adapter,
 * with the option to include a page title and to build binders or not.
 */
data class AbstractActivityProperties<out P : AbstractPresenter,
        out A : AbstractAdapter>(

        val presenter: P,
        val adapter: A,
        val pageTitle: String? = null,
        val isRowsIncluded: Boolean? = true
)


