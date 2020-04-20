package com.madlab.sharedelementdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.madlab.sharedelementdemo.R
import com.madlab.sharedelementdemo.adapter.RecycleViewAdapter
import com.madlab.sharedelementdemo.model.TechnologyData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val techData: ArrayList<TechnologyData> by lazy {
        ArrayList<TechnologyData>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addTechnology()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecycleViewAdapter(techData, this@MainActivity, this@MainActivity)
        }
    }

    private fun addTechnology() {

        techData.add(TechnologyData(R.drawable.java_logo, "Java",getString(R.string.text_java_details)))
        techData.add(TechnologyData(R.drawable.kotlin_logo, "Kotlin",getString(R.string.text_kotlin_details)))
        techData.add(TechnologyData(R.drawable.python_logo, "Python",getString(R.string.text_python_details)))
        techData.add(TechnologyData(R.drawable.ruby_logo, "Ruby",getString(R.string.text_ruby_details)))
        techData.add(TechnologyData(R.drawable.c_logo, "C++",getString(R.string.text_c_details)))
    }
}
