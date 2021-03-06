package com.ifk8edvmat1gabkojginkir.ktuprojektas.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ifk8edvmat1gabkojginkir.ktuprojektas.QuizMainActivty
import com.ifk8edvmat1gabkojginkir.ktuprojektas.R
import com.ifk8edvmat1gabkojginkir.ktuprojektas.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val button: Button = binding.btnStart
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            button.text = it
        }

        )


        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}