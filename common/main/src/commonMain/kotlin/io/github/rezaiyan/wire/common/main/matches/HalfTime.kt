package io.github.rezaiyan.wire.common.main.matches

import kotlinx.serialization.Serializable

@Serializable
data class HalfTime (

	val homeTeam : Int,
	val awayTeam : Int
)