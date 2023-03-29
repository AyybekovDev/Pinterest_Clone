package com.example.pinterestclone.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pinterestclone.R
import com.example.pinterestclone.adapter.PinterestAdapter
import com.example.pinterestclone.data.remote.ApiClient
import com.example.pinterestclone.model.HomeItem
import com.example.pinterestclone.utils.EndlessRecyclerViewScrollListener
import com.example.pinterestclone.utils.hide
import com.example.pinterestclone.utils.show
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment(R.layout.fragment_main) {
    var list = ArrayList<HomeItem>()
    lateinit var adapter: PinterestAdapter
    private var pages = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }
    private fun initViews(view: View) {
        listPhotos1()
        val rvPhoto = view.findViewById<RecyclerView>(R.id.rv_main)
        val manager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        adapter = PinterestAdapter(list)
        rvPhoto.adapter = adapter
        rvPhoto.layoutManager = manager
        adapter.detail = {
            val bundle = Bundle()
            bundle.putString("id",it)
            bundle.putString("main","main")
            findNavController().navigate(R.id.action_mainFragment_to_detaileFragment, bundle)
        }
        val scrollListener = object : EndlessRecyclerViewScrollListener(manager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                listPhotos1()
            }
        }
        rvPhoto.addOnScrollListener(scrollListener)
    }
    private fun listPhotos1() {
        val loading = view?.findViewById<ProgressBar>(R.id.loading)
        loading?.show()
        ApiClient.apiService.listPhotos1(getPages(), "rSqXKqR6TpdYIhRIFdFEo913HU7_1tUSnnblDIXwE9E")
            .enqueue(object : Callback<ArrayList<HomeItem>> {
                override fun onResponse(
                    call: Call<ArrayList<HomeItem>>,
                    response: Response<ArrayList<HomeItem>>
                ) {
                    if (response.isSuccessful) {
                        list.clear()
                        list = response.body()!!
                        adapter.submitList(response.body()!!)
                        loading?.hide()
                    }
                }
                override fun onFailure(call: Call<ArrayList<HomeItem>>, t: Throwable) {

                }
            })
    }
    private fun getPages(): Int {
        return ++pages
    }
}