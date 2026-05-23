package co.touchlab.droidcon.db

import app.cash.sqldelight.ColumnAdapter
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.time.Instant

public data class SessionTable(
  public val id: String,
  public val conferenceId: Long,
  public val title: String,
  public val description: String?,
  public val startsAt: Instant,
  public val endsAt: Instant,
  public val serviceSession: Long,
  public val rsvp: Long?,
  public val rsvpSent: Long,
  public val roomId: Long?,
  public val feedbackRating: Int?,
  public val feedbackComment: String?,
  public val feedbackSent: Long,
) {
  public class Adapter(
    public val startsAtAdapter: ColumnAdapter<Instant, Long>,
    public val endsAtAdapter: ColumnAdapter<Instant, Long>,
    public val feedbackRatingAdapter: ColumnAdapter<Int, Long>,
  )
}
