package co.touchlab.droidcon.db

import kotlin.Int
import kotlin.String
import kotlin.time.Instant

public data class MySessions(
  public val id: String,
  public val title: String,
  public val startsAt: Instant,
  public val endsAt: Instant,
  public val feedbackRating: Int?,
  public val roomName: String,
)
