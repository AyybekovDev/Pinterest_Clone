package com.example.pinterestclone.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pinterestclone.R
import com.example.pinterestclone.adapter.SaveAdapter
import com.example.pinterestclone.data.remote.ApiClient
import com.example.pinterestclone.model.SaveImage
import com.example.pinterestclone.model.search.OnePeople
import com.example.pinterestclone.repository.ImageRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SaveFragment : Fragment(R.layout.fragment_save) {
    lateinit var saveImage: ArrayList<SaveImage>
    lateinit var repository: ImageRepository
    lateinit var adapter: SaveAdapter
    private val list = ArrayList<OnePeople>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi(view)
    }

    private fun setUpUi(view: View) {
        val rvSave=view.findViewById<RecyclerView>(R.id.rv_save)
        repository = ImageRepository(requireActivity().application)
            saveImage = repository.getAllImage() as ArrayList
            for (i in saveImage.size - 1 downTo 0) {
                loadImages(saveImage[i].url)
            }
            val manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = SaveAdapter(list)
            rvSave.adapter = adapter
            rvSave.layoutManager = manager
            adapter.detail = {
                val bundle = Bundle()
                bundle.putString("id", it)
                bundle.putString("main","save")
                findNavController().navigate(R.id.action_saveFragment_to_detaileFragment, bundle)
            }
    }

    private fun loadImages(url: String) {
        ApiClient.apiService.getImageById(url).enqueue(object : Callback<OnePeople> {
            override fun onResponse(call: Call<OnePeople>, response: Response<OnePeople>) {
                if (response.isSuccessful) {
                    adapter.submitList(response.body()!!)
                }
            }
            override fun onFailure(call: Call<OnePeople>, t: Throwable) {

            }
        })
    }
}

