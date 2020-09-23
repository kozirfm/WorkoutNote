package ru.geekbrains.kozirfm.testkotlinapp.data.providers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.geekbrains.kozirfm.testkotlinapp.data.model.Exercise
import ru.geekbrains.kozirfm.testkotlinapp.data.model.Set
import ru.geekbrains.kozirfm.testkotlinapp.data.model.Workout

class ArrayDataProvider : IRemoteDataProvider {

    private val workoutList: MutableLiveData<List<Workout>> = MutableLiveData()

    private val workouts: MutableList<Workout> = mutableListOf(
        Workout(
            "Понедельник", "",
            listOf(
                Exercise(
                    "Руки",
                    listOf(Set(0.0F, 0), Set(0.0F, 0), Set(0.0F, 0))
                ),Exercise(
                    "Ноги",
                    listOf(Set(0.0F, 0))
                ),Exercise(
                    "Спина",
                    listOf(Set(0.0F, 0))
                ),Exercise(
                    "Плечи",
                    listOf(Set(0.0F, 0))
                ),Exercise(
                    "Пресс",
                    listOf(Set(0.0F, 0))
                )
            )
        ),
        Workout(
            "Среда", "",
            listOf(
                Exercise(
                    "",
                    listOf(Set(0.0F, 0))
                )
            )
        ),
        Workout(
            "Пятница", "",
            listOf(
                Exercise(
                    "",
                    listOf(Set(0.0F, 0))
                )
            )
        )
    )

    init {
        workoutList.value = workouts
    }

    override fun getWorkouts(): LiveData<List<Workout>> {
        return workoutList
    }

    override fun addWorkout(workout: Workout) {
        workouts.add(workout)
        workoutList.value = workouts
    }


}