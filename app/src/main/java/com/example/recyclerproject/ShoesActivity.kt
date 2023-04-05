package com.example.recyclerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init

class ShoesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var shoesList: ArrayList<Shoes>
    private lateinit var shoesAdapter: ShoesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoes)

        init()

    }
    private fun init(){
        recyclerView = findViewById(R.id.rv_shoes)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        shoesList = ArrayList()

        addDataToList()

            shoesAdapter = ShoesAdapter(shoesList)
            recyclerView.adapter = shoesAdapter


    }
    private fun addDataToList(){
        shoesList.add(Shoes(R.drawable.airjordan1mid,"Nike","Air Jordan 1 Mid","Rp 899.000"))
        shoesList.add(Shoes(R.drawable.nikedunklow,"Nike","Dunk Low","Rp 899.000"))
        shoesList.add(Shoes(R.drawable.nikeairmax97,"Nike","Airmax 97","Rp 899.000"))
        shoesList.add(Shoes(R.drawable.nikeblazerlow77,"Nike","Blazer Low 77","Rp 899.000"))
        shoesList.add(Shoes(R.drawable.lebronwitness7,"Nike","LeBron Witness 7","Rp 899.000"))
        shoesList.add(Shoes(R.drawable.kyrie5lowep,"Nike","Kyrie 5 Low EP","Rp 899.000"))
        shoesList.add(Shoes(R.drawable.kdtrey5,"Nike","KD Trey 5","Rp 899.000"))
        shoesList.add(Shoes(R.drawable.nikeairforce1,"Nike","Air Force 1","Rp 599.000"))
        shoesList.add(Shoes(R.drawable.kd15ep,"Nike","KD 15 Ep","Rp 1.299.000"))
        shoesList.add(Shoes(R.drawable.nikedunklow1,"Nike","Dunk Low 1","Rp 799.000"))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.grid, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when(selectedMode){
            R.id.action_grid -> {
                title = ""
                showRecyclerGrid()
            }
            R.id.action_card_view -> {
                title = ""
                showRecyclerCardView()
            }
        }
    }

    private fun showRecyclerCardView() {
        recyclerView = findViewById(R.id.rv_shoes)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        shoesList = ArrayList()

        addDataToList()

        shoesAdapter = ShoesAdapter(shoesList)
        recyclerView.adapter = shoesAdapter
    }


    private fun showRecyclerGrid() {
       recyclerView.layoutManager = GridLayoutManager(this,2)
        val shoesGridAdapter = ShoesGridAdapter(shoesList)
        recyclerView.adapter = shoesGridAdapter

            }
        }




