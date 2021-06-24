package io.github.rezaiyan.wire.common.main.matches

import kotlinx.serialization.Serializable

@Serializable
data class Season (

	val id : Int,
	val startDate : String,
	val endDate : String,
	val currentMatchday : Int,
	val winner : String? = null
)