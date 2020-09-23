package ru.geekbrains.kozirfm.testkotlinapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.workout_list_item.view.*
import ru.geekbrains.kozirfm.testkotlinapp.R
import ru.geekbrains.kozirfm.testkotlinapp.data.model.Workout

class WorkoutAdapter(var onItemClick: (Workout) -> Unit) :
    RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {

    var workoutList: List<Workout> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        return WorkoutViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.workout_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        holder.bind(workoutList[position])
    }

    override fun getItemCount(): Int {
        return workoutList.count()
    }

    inner class WorkoutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(workout: Workout) = with(itemView) {
            txtWorkoutListItemTitle.text = workout.title
            txtWorkoutListItemDescription.text = workout.description

            itemView.setOnClickListener {
                onItemClick(workout)
            }
        }
    }
}
