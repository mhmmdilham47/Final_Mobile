package com.example.d121211047_muhilhamefendi_finalmobilee.data.response

import com.example.d121211047_muhilhamefendi_finalmobilee.data.models.ListDoa
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("GetDoaResponse")
class GetDoaResponse : ArrayList<ListDoa>()