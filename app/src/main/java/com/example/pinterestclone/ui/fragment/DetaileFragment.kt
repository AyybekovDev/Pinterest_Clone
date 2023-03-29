package com.example.pinterestclone.ui.fragment


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.pinterestclone.R
import com.example.pinterestclone.data.remote.ApiClient
import com.example.pinterestclone.model.SaveImage
import com.example.pinterestclone.model.search.OnePeople
import com.example.pinterestclone.repository.ImageRepository
import com.example.pinterestclone.utils.hide
import com.example.pinterestclone.utils.show
import com.jsibbold.zoomage.ZoomageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetaileFragment : Fragment(R.layout.fragment_detaile) {
    lateinit var list: ArrayList<OnePeople>
    lateinit var repository: ImageRepository
    private val args: DetaileFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val callback=object:OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val main=args.main
                if (main=="main"){
                    findNavController().navigate(R.id.action_detaileFragment_to_mainFragment)
                }
                if (main=="save"){
                    findNavController().navigate(R.id.action_detaileFragment_to_saveFragment)
                }
                if (main=="search"){
                    findNavController().navigate(R.id.action_detaileFragment_to_searchFragment)
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback)
        setupUI(view)
    }
    private fun setupUI(view: View) {
        val iv_Detailback = view.findViewById<ImageView>(R.id.iv_DetailbackMain)
        val btnDetailsave = view.findViewById<TextView>(R.id.btnDetailsave)
        val id = args.id
        val main=args.main
        repository = ImageRepository(requireActivity().application)
        iv_Detailback.setOnClickListener {
            if (main=="main"){
                findNavController().navigate(R.id.action_detaileFragment_to_mainFragment)
            }
            if (main=="save"){
                findNavController().navigate(R.id.action_detaileFragment_to_saveFragment)
            }
            if (main=="search"){
                findNavController().navigate(R.id.action_detaileFragment_to_searchFragment)
            }
        }
        btnDetailsave.setOnClickListener {
            repository.saveImage(SaveImage(url = id))
            Toast.makeText(requireContext(), "Rasm saqlandi", Toast.LENGTH_SHORT).show()
            btnDetailsave.text = "Сохранено"
            btnDetailsave.setTextColor(Color.BLACK)
            btnDetailsave.setBackgroundColor(Color.WHITE)
        }
        loadImage(id, view)
    }
    private fun loadImage(id: String, view: View) {
        val loading = view?.findViewById<ProgressBar>(R.id.deteilprogres)
        loading?.show()
        val ivDetailmain = view.findViewById<ZoomageView>(R.id.iv_Detailmain)
        val ivDetailImg = view.findViewById<ImageView>(R.id.iv_DetailImg)
        val ivDetailShare = view.findViewById<ImageView>(R.id.iv_DetailShare)
        val tvDetailname = view.findViewById<TextView>(R.id.tv_Detailname)
        val tvInt = view.findViewById<TextView>(R.id.tv_int)
        ApiClient.apiService.getImageById(id).enqueue(object : Callback<OnePeople> {
            override fun onResponse(call: Call<OnePeople>, response: Response<OnePeople>) {
                if (response.isSuccessful) {
                    Glide.with(ivDetailmain).load(response.body()!!.urls.full)
                        .placeholder(R.drawable.loading)
                        .into(ivDetailmain)
                    Glide.with(ivDetailImg).load(response.body()!!.urls.small)
                        .placeholder(R.drawable.loading)
                        .into(ivDetailImg)
                    tvDetailname.text = response.body()!!.user.name
                    tvInt.text = response.body()!!.user.total_likes.toString()
                    ivDetailShare.setOnClickListener {
                        val intent = Intent(Intent.ACTION_SEND)
                        intent.type = "text/plain"
                        intent.putExtra(Intent.EXTRA_TEXT, response.body()!!.links.download)
                        startActivity(intent)
                    }
                    loading?.hide()
                }
            }
            override fun onFailure(call: Call<OnePeople>, t: Throwable) {
            }
        })
    }

}
