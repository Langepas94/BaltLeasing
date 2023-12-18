package com.example.baltleasing.destinations.ServicesScreen.adapter.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.util.TypedValue
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.baltleasing.destinations.ServicesScreen.adapter.ServiceRecyclerAdapter

class ServiceAdapterDecoration(private val space: Float, private val context: Context) : RecyclerView.ItemDecoration() {

    private val spaceInPx: Int

    init {
        spaceInPx = dpToPx(space)
    }
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val adapter = parent.adapter as? ServiceRecyclerAdapter
        val layoutManager = parent.layoutManager as? StaggeredGridLayoutManager

        if (position != RecyclerView.NO_POSITION && layoutManager != null) {
            outRect.top = spaceInPx
            val spanIndex = (view.layoutParams as? StaggeredGridLayoutManager.LayoutParams)?.spanIndex
            if (spanIndex != null && spanIndex > 0) {
                outRect.left = spaceInPx
            }
            if (position == state.itemCount - 1) {
                outRect.bottom = spaceInPx
            }
        }
    }

    private fun dpToPx(dp: Float): Int {
        val metrics = context.resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, metrics).toInt()
    }
}
