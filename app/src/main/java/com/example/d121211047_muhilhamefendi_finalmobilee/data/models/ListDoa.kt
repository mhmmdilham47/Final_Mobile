package com.example.d121211047_muhilhamefendi_finalmobilee.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class ListDoa(
    val artinya: String,
    val ayat: String,
    val doa: String,
    val id: String,
    val latin: String
) : Parcelable