package io.github.rezaiyan.wire.common.main.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Conductor(
  val Ok: Boolean,
  @Transient var name: String = "",
  @SerialName("Result")
  val Program: List<Program>,
) {

  val list = Program
    get() = field
      .filter {
        it.name.contains("لیگ قهرمانان") ||
        it.name.contains("ورزش") ||
        it.name.contains("فوتبال") ||
          it.name.contains("والیبال") ||
          it.name.contains("بسکتبال")
      }
      /*.filter {
        val toLocalDateTime = System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val hour = toLocalDateTime.hour
        val minute = toLocalDateTime.minute
        val second = toLocalDateTime.second

        val startTime = it.start.split(":")

        if (startTime[0].toInt() > hour) {
          return@filter true
        }else if (startTime[0].toInt() == hour){
          if (startTime[1].toInt() > minute) {
            return@filter true
          }else if (startTime[1].toInt() == minute){
            if (startTime[2].toInt() > second)
              return@filter true
          }
        }
        return@filter false
      }*/
      .sortedBy { it.start }
}