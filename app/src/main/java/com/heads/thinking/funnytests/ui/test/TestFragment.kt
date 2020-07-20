package com.heads.thinking.funnytests.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.FragmentTestBinding
import com.heads.thinking.funnytests.di.ComponentManager
import com.heads.thinking.funnytests.di.mvvm.factory.ViewModelFactory
import com.heads.thinking.funnytests.model.Test
import com.heads.thinking.funnytests.mvp.test.TestViewModel
import javax.inject.Inject

class TestFragment() : Fragment() {
    constructor(test: Test) : this() {
        this.test = test
    }
    lateinit var test: Test

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var testViewModel: TestViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ComponentManager.instance.getFragmentComponent(this).inject(this) // inject all objects
        testViewModel = ViewModelProviders.of(this, viewModelFactory).get(TestViewModel::class.java)
        if(!testViewModel.isInitialized) testViewModel.initViewModel(test)
        else test = testViewModel.test
        var binder= DataBindingUtil.inflate<FragmentTestBinding>(inflater, R.layout.fragment_test,container,false)
        binder.testViewModel = testViewModel
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance(test: Test) = TestFragment(test)
    }
}
