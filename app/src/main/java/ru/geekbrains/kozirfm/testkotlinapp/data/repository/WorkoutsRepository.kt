package ru.geekbrains.kozirfm.testkotlinapp.data.repository

import androidx.lifecycle.LiveData
import ru.geekbrains.kozirfm.testkotlinapp.data.model.Workout
import ru.geekbrains.kozirfm.testkotlinapp.data.providers.ArrayDataProvider
import ru.geekbrains.kozirfm.testkotlinapp.data.providers.IRemoteDataProvider

object WorkoutsRepository {

    private val remoteDataProvider: IRemoteDataProvider = ArrayDataProvider()

    fun getWorkouts(): LiveData<List<Workout>> = remoteDataProvider.getWorkouts()
    fun addWorkout(workout: Workout) = remoteDataProvider.addWorkout(workout)

}