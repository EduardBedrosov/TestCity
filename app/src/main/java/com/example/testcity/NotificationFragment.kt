package com.example.testcity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.testcity.databinding.FragmentNotificationBinding


class NotificationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNotificationBinding.inflate(inflater, container, false)
        binding.ivPointerDown.setOnClickListener {
            it.findNavController().navigate(
                NotificationFragmentDirections.actionNotificationFragmentToMainFragment()
            )
        }
        return binding.root
    }
}