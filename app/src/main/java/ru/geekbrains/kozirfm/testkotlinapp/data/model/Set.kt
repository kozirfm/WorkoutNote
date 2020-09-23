package ru.geekbrains.kozirfm.testkotlinapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Set(val weight: Float, val repeat: Int) : Parcelable