package io.github.rezaiyan.wire.common.main.matches

import kotlinx.serialization.Serializable

@Serializable
data class Match (

	val count : Int,
	val filters : Filters,
	val matches : List<Matches>
)