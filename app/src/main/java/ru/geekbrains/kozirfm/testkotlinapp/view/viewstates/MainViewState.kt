package ru.geekbrains.kozirfm.testkotlinapp.view.viewstates

import ru.geekbrains.kozirfm.testkotlinapp.data.model.Workout

sealed class MainViewState(val workouts: List<Workout>?) {
    class ShowWorkouts(workouts: List<Workout>?) : MainViewState(workouts = workouts)
}