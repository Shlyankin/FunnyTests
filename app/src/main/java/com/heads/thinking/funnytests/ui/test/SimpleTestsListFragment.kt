package com.heads.thinking.funnytests.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.di.ComponentManager
import com.heads.thinking.funnytests.di.mvvm.factory.ViewModelFactory
import com.heads.thinking.funnytests.mvvm.test.SimpleTestViewModel
import kotlinx.android.synthetic.main.fragment_simple_tests_list.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [SimpleTestsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SimpleTestsListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var simpleTestViewModel: SimpleTestViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_tests_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ComponentManager.instance.getFragmentComponent(this).inject(this) // inject all objects
        simpleTestViewModel = ViewModelProviders.of(this, viewModelFactory).get(SimpleTestViewModel::class.java)
        testRecyclerView.adapter = simpleTestViewModel.adapter
        simpleTestViewModel.loadTests()
        // list init
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SimpleTestsListFragment()
    }
}
