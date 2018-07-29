package com.nishatoma.binders.presenter

abstract class AbstractPresenter {

    /**
     * Called when the activity is finished loading. This may be after onCreate, or
     * after OnPrepareOptionsMenu, depending on the situation.
     *
     * The child that extends this class should override this method and have its business logic.
     */
    abstract fun onViewReady()
}