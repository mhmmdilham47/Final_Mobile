package com.example.d121211047_muhilhamefendi_finalmobilee.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class ListDoa(
    @SerialName("artinya")
    val artinya: String,
    @SerialName("ayat")
    val ayat: String,
    @SerialName("doa")
    val doa: String,
    @SerialName("id")
    val id: String,
    @SerialName("latin")
    val latin: String
) : Parcelable