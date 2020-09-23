package ru.geekbrains.kozirfm.testkotlinapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.set_list_item.view.*
import ru.geekbrains.kozirfm.testkotlinapp.R
import ru.geekbrains.kozirfm.testkotlinapp.data.model.Set

class ExerciseSetAdapter : RecyclerView.Adapter<ExerciseSetAdapter.ExerciseSetViewHolder>() {

    var exerciseSetList: List<Set> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseSetViewHolder {
        return ExerciseSetViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.set_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExerciseSetViewHolder, position: Int) {
        holder.bind(exerciseSetList[position])
    }

    override fun getItemCount(): Int {
        return exerciseSetList.count()
    }

    class ExerciseSetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(set: Set) {
            return with(itemView) {
                textViewExerciseSetRepeat.text = set.repeat.toString()
                textViewExerciseSetWeight.text = set.weight.toString()
            }
        }

    }
}