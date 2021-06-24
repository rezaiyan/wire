package io.github.rezaiyan.wire.common.main.entities

import kotlinx.serialization.Serializable

@Serializable
data class Program(
    val Time: String,
    val cover: String,
    val name: String,
    val producer: String,
    val start: String,
    val stop: String
){

    val title
    get() = name.replace("&quot;","")
}