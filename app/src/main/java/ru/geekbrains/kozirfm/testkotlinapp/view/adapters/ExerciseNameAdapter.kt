package ru.geekbrains.kozirfm.testkotlinapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.exercise_list_item.view.*
import ru.geekbrains.kozirfm.testkotlinapp.R
import ru.geekbrains.kozirfm.testkotlinapp.data.model.Exercise

class ExerciseNameAdapter : RecyclerView.Adapter<ExerciseNameAdapter.ExerciseNameViewHolder>() {

    var exerciseNames: List<Exercise> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseNameViewHolder {
        return ExerciseNameViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.exercise_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExerciseNameViewHolder, position: Int) {
        holder.bind(exercise = exerciseNames[position])
    }

    override fun getItemCount(): Int {
        return exerciseNames.count()
    }

    inner class ExerciseNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(exercise: Exercise) = with(itemView) {
            textViewExerciseNameItem.text = exercise.name
        }
    }

}
