package com.heads.thinking.funnytests.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.di.ComponentManager
import com.heads.thinking.funnytests.di.mvvm.factory.ViewModelFactory
import com.heads.thinking.funnytests.mvvm.create.CreateTestViewModel
import javax.inject.Inject

class CreateTestFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var createTestViewModel: CreateTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ComponentManager.instance.getFragmentComponent(this).inject(this) // inject all objects
        createTestViewModel = ViewModelProviders.of(this, viewModelFactory).get(CreateTestViewModel::class.java)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CreateTestFragment()
    }
}
