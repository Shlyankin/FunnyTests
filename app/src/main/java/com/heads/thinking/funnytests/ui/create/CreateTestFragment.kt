package com.heads.thinking.funnytests.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.Utils.IMAGE_REQUEST_CODE
import com.heads.thinking.funnytests.Utils.getPickImageIntent
import com.heads.thinking.funnytests.databinding.FragmentCreateTestBinding
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
        ComponentManager.instance.getFragmentComponent(this).inject(this) // inject all objects
        createTestViewModel = ViewModelProviders.of(this, viewModelFactory).get(CreateTestViewModel::class.java)

        var binder= DataBindingUtil.inflate<FragmentCreateTestBinding>(inflater, R.layout.fragment_create_test,container,false)
        binder.viewModel = createTestViewModel
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observePickImage()
    }

    fun observePickImage() {
        createTestViewModel.pickImage.observe(viewLifecycleOwner, Observer {
            if (it) {
                startActivityForResult(getPickImageIntent(context), IMAGE_REQUEST_CODE)
                createTestViewModel.pickImage.value = false
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CreateTestFragment()
    }
}
