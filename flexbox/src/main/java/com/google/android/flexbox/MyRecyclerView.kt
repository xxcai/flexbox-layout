package com.google.android.flexbox

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RecyclerView(context, attrs) {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        invalidateItemDecorations()
        super.onLayout(changed, l, t, r, b)
    }
}