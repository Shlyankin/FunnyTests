package com.heads.thinking.funnytests.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.FragmentTestResultBinding
import com.heads.thinking.funnytests.di.ComponentManager
import com.heads.thinking.funnytests.di.mvvm.factory.ViewModelFactory
import com.heads.thinking.funnytests.model.ResultSection
import com.heads.thinking.funnytests.model.Test
import com.heads.thinking.funnytests.model.TestResult
import com.heads.thinking.funnytests.mvvm.test.TestResultViewModel
import kotlinx.android.synthetic.main.fragment_test_result.*
import javax.inject.Inject


class TestResultFragment() : Fragment() {
    constructor(test: Test, resultsMap: Map<ResultSection, TestResult>): this() {
        this.test = test
        this.resultsMap = resultsMap
    }
    lateinit var resultsMap: Map<ResultSection, TestResult>
    lateinit var test: Test

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var testResultViewModel: TestResultViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ComponentManager.instance.getFragmentComponent(this).inject(this) // inject all objects
        testResultViewModel = ViewModelProviders.of(this, viewModelFactory).get(TestResultViewModel::class.java)
        if(!testResultViewModel.isInitialized) testResultViewModel.initViewModel(test, resultsMap)
        else {
            test = testResultViewModel.test
            resultsMap = testResultViewModel.testResult
        }

        val binder= DataBindingUtil.inflate<FragmentTestResultBinding>(inflater, R.layout.fragment_test_result,container,false)
        binder.testResultViewModel = testResultViewModel
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultsRecyclerView.adapter = testResultViewModel.adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(test: Test, testResult: Map<ResultSection, TestResult>) = TestResultFragment(test, testResult)
    }

}
