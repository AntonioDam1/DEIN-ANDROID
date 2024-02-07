package com.example.recyclerviewalberto

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ColorsAdapter(private val colors: List<Color>) : RecyclerView.Adapter<ColorsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val row: View = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(row)
    }
    override fun getItemCount() = colors.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val color = colors[position]
        holder.bindRow(color)
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val circleView: View = view.findViewById(R.id.circleView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val subtitleTextView: TextView = view.findViewById(R.id.subtitleTextView)
        val imagen: ImageView = view.findViewById(R.id.image)
        fun bindRow(color: Color) {
            titleTextView.text = color.name
            subtitleTextView.text = color.hex
            Glide.with( itemView.context).load(color. photo).into(imagen)
            val gradientDrawable = circleView.background as GradientDrawable
            val colorId = android.graphics.Color.parseColor(color.hex)
            gradientDrawable.setColor(colorId)
        }
    }
}