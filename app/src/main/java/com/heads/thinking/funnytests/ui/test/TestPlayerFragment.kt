package com.heads.thinking.funnytests.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.FragmentTestPlayerBinding
import com.heads.thinking.funnytests.di.ComponentManager
import com.heads.thinking.funnytests.di.mvvm.factory.ViewModelFactory
import com.heads.thinking.funnytests.model.Test
import com.heads.thinking.funnytests.mvvm.test.TestPlayerViewModel
import javax.inject.Inject

class TestPlayerFragment() : Fragment() {
    constructor(test: Test): this() {
        this.test = test
    }
    lateinit var test: Test

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var testPlayerViewModel: TestPlayerViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ComponentManager.instance.getFragmentComponent(this).inject(this) // inject all objects
        testPlayerViewModel = ViewModelProviders.of(this, viewModelFactory).get(TestPlayerViewModel::class.java)
        if(!testPlayerViewModel.isInitialized) testPlayerViewModel.initViewModel(test)
        else test = testPlayerViewModel.test

        var binder= DataBindingUtil.inflate<FragmentTestPlayerBinding>(inflater, R.layout.fragment_test_player,container,false)
        binder.testPlayerViewModel = testPlayerViewModel
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testPlayerViewModel.showToast.observe(viewLifecycleOwner, Observer {
            if (it) {
                Toast.makeText(this.context, testPlayerViewModel.toastMessage, Toast.LENGTH_SHORT).show()
                testPlayerViewModel.toastMessage = ""
                testPlayerViewModel.showToast.value = false
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(test: Test) = TestPlayerFragment(test)
    }
}
