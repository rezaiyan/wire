package io.github.rezaiyan.wire.common.main.matches

import kotlinx.serialization.Serializable

@Serializable
data class Matches (

	val id : Int,
	val competition : Competition,
	val season : Season,
	val utcDate : String,
	val status : String,
	val matchday : Int,
	val stage : String,
	val group : String? = null,
	val lastUpdated : String,
	val odds : Odds? = null,
	val score : Score,
	val homeTeam : HomeTeam? = null,
	val awayTeam : AwayTeam? = null,
	val referees : List<String>
)