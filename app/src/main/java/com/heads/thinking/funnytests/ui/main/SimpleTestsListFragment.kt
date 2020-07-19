package com.heads.thinking.funnytests.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.di.ComponentManager
import com.heads.thinking.funnytests.mvp.test.SimpleTestViewModel
import kotlinx.android.synthetic.main.fragment_simple_tests_list.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [SimpleTestsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SimpleTestsListFragment : Fragment() {

    @Inject
    lateinit var simpleTestViewModel: SimpleTestViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_tests_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ComponentManager.instance.getFragmentComponent(this).inject(this) // inject all objects
        testRecyclerView.adapter = simpleTestViewModel.adapter
        simpleTestViewModel.loadTests()
        // list init
    }

    companion object {
        @JvmStatic
        fun newInstance() = SimpleTestsListFragment()
    }
}
