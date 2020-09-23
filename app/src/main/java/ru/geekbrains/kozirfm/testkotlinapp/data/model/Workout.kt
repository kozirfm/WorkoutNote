package ru.geekbrains.kozirfm.testkotlinapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Workout(val title: String, val description: String, val exercises: List<Exercise>) : Parcelable