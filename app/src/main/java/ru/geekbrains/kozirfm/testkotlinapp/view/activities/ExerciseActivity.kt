package ru.geekbrains.kozirfm.testkotlinapp.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_exercise.*
import ru.geekbrains.kozirfm.testkotlinapp.R
import ru.geekbrains.kozirfm.testkotlinapp.data.model.Workout
import ru.geekbrains.kozirfm.testkotlinapp.view.adapters.ExerciseNameAdapter
import ru.geekbrains.kozirfm.testkotlinapp.view.adapters.ExerciseSetAdapter

class ExerciseActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context, workout: Workout) {
            Intent(context, ExerciseActivity::class.java).run {
                this.putExtra("EXTRA", workout)
                context.startActivity(this)
            }
        }
    }

    private val exerciseNameAdapter: ExerciseNameAdapter by lazy { ExerciseNameAdapter() }
    private val exerciseSetAdapter: ExerciseSetAdapter by lazy { ExerciseSetAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        recyclerViewExerciseName.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        val workout = intent.getParcelableExtra<Workout>("EXTRA")
        workout?.let { exerciseNameAdapter.exerciseNames = it.exercises }
        recyclerViewExerciseName.adapter = exerciseNameAdapter

        recyclerViewExerciseSet.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        workout?.let { exerciseSetAdapter.exerciseSetList = it.exercises[0].sets }

        recyclerViewExerciseSet.adapter = exerciseSetAdapter
    }

}