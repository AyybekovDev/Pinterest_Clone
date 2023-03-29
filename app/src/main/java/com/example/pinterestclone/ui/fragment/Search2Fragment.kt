package com.example.pinterestclone.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pinterestclone.R
import com.example.pinterestclone.adapter.SearchAdapter
import com.example.pinterestclone.data.remote.ApiClient
import com.example.pinterestclone.model.search.yangisi.ResultsItem
import com.example.pinterestclone.model.search.yangisi.SearchResp
import com.example.pinterestclone.utils.EndlessRecyclerViewScrollListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Search2Fragment : Fragment(R.layout.fragment_search2) {
    var list = ArrayList<ResultsItem>()
    lateinit var adapter: SearchAdapter
    private var pages = 0
    private val args:Search2FragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }
    private fun initViews(view: View) {
        val share=args.share
        val ivBack = view?.findViewById<ImageView>(R.id.iv_back)
        val tvSearch = view?.findViewById<EditText>(R.id.search1)
        tvSearch?.setText(share)
        tvSearch?.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                hideKeyboard()
                searchImages(tvSearch.text.toString())
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
//        tvSearch?.addTextChangedListener {
//            searchImages(it.toString())
//        }
        searchImages(tvSearch?.text.toString())
        ivBack?.setOnClickListener {
            findNavController().navigate(R.id.action_search2Fragment_to_searchFragment)
        }
        val rvPhoto = view?.findViewById<RecyclerView>(R.id.rv_search2)
        val manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        adapter = SearchAdapter(list)
        rvPhoto?.adapter = adapter
        rvPhoto?.layoutManager = manager
        adapter.detail = {
            val bundle = Bundle()
            bundle.putString("id", it)
            bundle.putString("main","search")
            findNavController().navigate(R.id.action_search2Fragment_to_detaileFragment, bundle)
        }
        val scrollListener = object : EndlessRecyclerViewScrollListener(manager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                searchImages(tvSearch?.text.toString())
            }
        }
        rvPhoto?.addOnScrollListener(scrollListener)
    }
    private fun searchImages(query: String) {
        ApiClient.apiService.searchImages(query).enqueue(object : Callback<SearchResp> {
            override fun onResponse(call: Call<SearchResp>, response: Response<SearchResp>) {
                if (response.isSuccessful) {
                    Log.d("TAG", "onResponse: $list ")
                    list = response.body()!!.results
                    adapter.submitList(list)
                }
            }
            override fun onFailure(call: Call<SearchResp>, t: Throwable) {

            }
        })
    }
    private fun getPages(): Int {
        return ++pages
    }

    private fun hideKeyboard() {
        val hide =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hide.hideSoftInputFromWindow(requireView().windowToken, 0)
    }
}