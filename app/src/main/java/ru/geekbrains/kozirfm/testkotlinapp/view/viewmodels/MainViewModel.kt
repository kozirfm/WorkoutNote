package ru.geekbrains.kozirfm.testkotlinapp.view.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.kozirfm.testkotlinapp.data.model.Workout
import ru.geekbrains.kozirfm.testkotlinapp.data.repository.WorkoutsRepository
import ru.geekbrains.kozirfm.testkotlinapp.view.viewstates.MainViewState

class MainViewModel : ViewModel() {

    private val viewStateLiveData: MutableLiveData<MainViewState> = MutableLiveData()

    init {
        WorkoutsRepository.getWorkouts().observeForever {
            viewStateLiveData.value = MainViewState.ShowWorkouts(it)
        }
    }

    fun viewState(): LiveData<MainViewState> {
        return viewStateLiveData
    }

    fun addWorkout(title: String, description: String) {
        WorkoutsRepository.addWorkout(Workout(title = title, description = description, listOf()))
    }

}