package ru.geekbrains.kozirfm.testkotlinapp.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.geekbrains.kozirfm.testkotlinapp.R
import ru.geekbrains.kozirfm.testkotlinapp.view.adapters.WorkoutAdapter
import ru.geekbrains.kozirfm.testkotlinapp.view.fragments.AddWorkoutDialog
import ru.geekbrains.kozirfm.testkotlinapp.view.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private val workoutAdapter: WorkoutAdapter by lazy {
        WorkoutAdapter { workout ->
            ExerciseActivity.start(this, workout)
        }
    }
    private val mainViewModel: MainViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewMain.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerViewMain.adapter = workoutAdapter

        mainViewModel.viewState().observe(this) { state ->
            state.workouts?.let { workoutAdapter.workoutList = it }
        }

        fabAddWorkout.setOnClickListener {
            AddWorkoutDialog.createInstance { title, description ->

                mainViewModel.addWorkout(title, description)

            }.show(supportFragmentManager, AddWorkoutDialog.TAG)
        }
    }

}