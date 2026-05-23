package co.touchlab.droidcon.db

import kotlin.Long
import kotlin.String
import kotlin.time.Instant

public data class SessionWithRoom(
  public val id: String,
  public val title: String,
  public val description: String?,
  public val startsAt: Instant,
  public val endsAt: Instant,
  public val serviceSession: Long,
  public val rsvp: Long?,
  public val roomId: Long?,
  public val roomName: String,
  public val allNames: String?,
)
