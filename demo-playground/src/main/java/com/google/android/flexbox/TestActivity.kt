package com.google.android.flexbox

import android.app.Activity
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.apps.flexbox.R
import com.google.android.flexbox.FlexboxItemDecoration.*

class TestActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.test_activity)

        val rv = findViewById<RecyclerView>(R.id.rv)
        val data = listOf(
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
        )
        val lm = FlexboxLayoutManager(
            this,
            FlexDirection.ROW,
            FlexWrap.WRAP
        )
        lm.setRecyclerView(rv)
        rv.layoutManager = lm
//        rv.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
//            rv.invalidateItemDecorations()
//        }
        val decor = FlexboxItemDecoration(this).apply {
            setDrawable(resources.getDrawable(R.drawable.flex_decor))
            //setOrientation(HORIZONTAL)
            setOrientation(VERTICAL)
            //setOrientation(BOTH)
        }
        rv.addItemDecoration(decor)
        rv.adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): RecyclerView.ViewHolder {
//                val view = TextView(this@TestActivity)
//                val layoutParams = ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT
//                )
//                view.layoutParams = layoutParams
                val view = LayoutInflater.from(this@TestActivity).inflate(
                    R.layout.flex_item2, rv, false
                )
                return MyViewHolder(view)
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                //(holder.itemView as TextView).text = data[position]
            }

            override fun getItemCount(): Int {
                return data.size
            }
        }

    }
}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

data class Pojo(val text: String)