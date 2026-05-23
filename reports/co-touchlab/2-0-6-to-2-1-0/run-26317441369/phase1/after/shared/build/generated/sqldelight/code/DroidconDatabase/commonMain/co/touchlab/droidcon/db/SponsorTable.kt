package co.touchlab.droidcon.db

import kotlin.Boolean
import kotlin.Long
import kotlin.String

public data class SponsorTable(
  public val name: String,
  public val groupName: String,
  public val conferenceId: Long,
  public val hasDetail: Boolean,
  public val description: String?,
  public val iconUrl: String,
  public val url: String,
)
