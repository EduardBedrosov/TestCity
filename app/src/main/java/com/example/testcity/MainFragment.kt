package com.example.testcity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testcity.model.Categories
import com.example.testcity.model.CategoriesAdapter
import com.example.testcity.model.Popular
import com.example.testcity.model.PopularItemAdapter

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        popular(view)
        categories(view)
    }

    private fun categories(
        view: View
    ) {
        val recyclerview = view.findViewById<RecyclerView>(R.id.rv_categories)
        val layoutTemp = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerview.layoutManager = layoutTemp
        layoutTemp.findFirstVisibleItemPosition()
        layoutTemp.findLastVisibleItemPosition()
        val dataCategories = addCategories()
        val categoriesAdapter = CategoriesAdapter(dataCategories)
        recyclerview.adapter = categoriesAdapter
        recyclerScrollListener(recyclerview, categoriesAdapter)
    }

    private fun recyclerScrollListener(
        recyclerview: RecyclerView,
        categoriesAdapter: CategoriesAdapter
    ) {
        recyclerview.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            var x = 0F
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                x -= dx
                Log.i("abc", x.toString())
                //                dataCategories.map { it.rotationAngle = x*0.1F }
                categoriesAdapter.rotationAngel = x * 0.1F
                recyclerView.post {
                    categoriesAdapter.notifyDataSetChanged()
                    //                    categoriesAdapter.notifyItemRangeChanged(0, 6)
                }
            }
        })
    }

    private fun addCategories(): ArrayList<Categories> {
        val dataCategories = ArrayList<Categories>()
        dataCategories.add(
            Categories(
                1, "#FF9800".toColorInt(), R.drawable.ic_cake,
                "Cakes", "75 products"
            )
        )
        dataCategories.add(
            Categories(
                2, "#3F51B5".toColorInt(), R.drawable.ic_cake,
                "Chocolates", "85 products"
            )
        )
        dataCategories.add(
            Categories(
                2, "#21BD27".toColorInt(), R.drawable.ic_cake,
                "Cookies", "95 products"
            )
        )
        dataCategories.add(
            Categories(
                4, Color.parseColor("#FF9800"), R.drawable.ic_cake,
                "Cakes Again", "75 products"
            )
        )
        dataCategories.add(
            Categories(
                5, Color.parseColor("#3F51B5"), R.drawable.ic_cake,
                "Chocolates Again", "85 products"
            )
        )
        dataCategories.add(
            Categories(
                6, Color.parseColor("#21BD27"), R.drawable.ic_cake,
                "Cookies Again", "95 products"
            )
        )
        return dataCategories
    }

    private fun popular(
        view: View
    ) {
        val recyclerviewPopular = view.findViewById<RecyclerView>(R.id.rv_popular)
        recyclerviewPopular.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        addPopulars(recyclerviewPopular)
    }

    private fun addPopulars(recyclerviewPopular: RecyclerView) {
        val dataPopulars = ArrayList<Popular>()
        dataPopulars.add(
            Popular(
                1, R.drawable.konfet, "Bisquits",
                R.drawable.ic_baseline_shopping_basket_24, "2500Dram/KG"
            )
        )
        dataPopulars.add(
            Popular(
                2, R.drawable.no_path, "Candy Chocolates",
                R.drawable.ic_baseline_shopping_basket_24, "2500Dram/KG"
            )
        )
        dataPopulars.add(
            Popular(
                3, R.drawable.konfet, "Jelly Gummy",
                R.drawable.ic_baseline_shopping_basket_24, "2500Dram/KG"
            )
        )
        val popularAdapter = PopularItemAdapter(dataPopulars)
        recyclerviewPopular.adapter = popularAdapter
    }
}