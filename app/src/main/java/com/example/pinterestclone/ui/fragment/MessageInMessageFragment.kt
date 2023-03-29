package com.example.pinterestclone.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pinterestclone.R

class MessageInMessageFragment : Fragment(R.layout.fragment_message_in_message) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        initViews()
    }

    private fun initViews() {
    }

    override fun onResume() {
        super.onResume()
        initViews()
    }
}