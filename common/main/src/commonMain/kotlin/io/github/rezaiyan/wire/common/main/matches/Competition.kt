package io.github.rezaiyan.wire.common.main.matches

import kotlinx.serialization.Serializable

@Serializable
class Competition (

	val id : Int,
	val name : String,
	val area : Area
)