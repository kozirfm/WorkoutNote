package ru.geekbrains.kozirfm.testkotlinapp.data.providers

import androidx.lifecycle.LiveData
import ru.geekbrains.kozirfm.testkotlinapp.data.model.Workout

interface IRemoteDataProvider {
    fun getWorkouts(): LiveData<List<Workout>>
    fun addWorkout(workout: Workout)
}