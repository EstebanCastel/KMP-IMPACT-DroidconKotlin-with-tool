package co.touchlab.droidcon.db

import kotlin.Long
import kotlin.String

public data class RoomTable(
  public val id: Long,
  public val conferenceId: Long,
  public val name: String,
)
