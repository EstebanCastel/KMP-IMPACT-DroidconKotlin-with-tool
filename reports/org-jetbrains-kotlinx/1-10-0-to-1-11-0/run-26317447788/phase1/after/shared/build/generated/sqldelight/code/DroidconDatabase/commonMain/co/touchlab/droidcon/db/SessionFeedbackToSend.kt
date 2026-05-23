package co.touchlab.droidcon.db

import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.time.Instant

public data class SessionFeedbackToSend(
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
  public val feedbackRating: Int,
  public val feedbackComment: String?,
  public val feedbackSent: Long,
)
