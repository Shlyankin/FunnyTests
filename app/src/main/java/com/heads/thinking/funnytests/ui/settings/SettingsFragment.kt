package com.heads.thinking.funnytests.ui.settings

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.di.ComponentManager

class SettingsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ComponentManager.instance.getFragmentComponent(this).inject(this) // inject all objects

        // list init
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }
}
