package com.ifk8edvmat1gabkojginkir.ktuprojektas.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ifk8edvmat1gabkojginkir.ktuprojektas.databinding.FragmentRankingsBinding
import com.ifk8edvmat1gabkojginkir.ktuprojektas.databinding.FragmentSettingsBinding
import com.ifk8edvmat1gabkojginkir.ktuprojektas.ui.settings.SettingsViewModel

class SettingsFragment : Fragment() {

    private lateinit var settingViewModel: SettingsViewModel
    private var _binding: FragmentSettingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        settingViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}