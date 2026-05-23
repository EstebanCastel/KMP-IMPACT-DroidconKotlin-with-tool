package co.touchlab.droidcon.db

import kotlin.Long
import kotlin.String

public data class SessionSpeakerTable(
  public val sessionId: String,
  public val speakerId: String,
  public val conferenceId: Long,
  public val displayOrder: Long,
)
