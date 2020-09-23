package ru.geekbrains.kozirfm.testkotlinapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Exercise(val name: String, val sets: List<Set>) : Parcelable