package io.github.rezaiyan.wire.common.main.matches

import kotlinx.serialization.Serializable

@Serializable
data class FullTime (

	val homeTeam : Int,
	val awayTeam : Int
)