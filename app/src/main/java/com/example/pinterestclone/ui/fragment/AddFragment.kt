package com.example.pinterestclone.ui.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.pinterestclone.R

class AddFragment : Fragment(R.layout.fragment_add) {
    lateinit var iv_image: ImageView
    private val REQUEST_CODE = 111

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View?) {
        iv_image = view?.findViewById(R.id.iv_image)!!
        iv_image?.setOnClickListener {
            pickImage()
        }
    }
    private fun pickImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            val imguri = data?.data
            iv_image.setImageURI(imguri)
        }
    }
}