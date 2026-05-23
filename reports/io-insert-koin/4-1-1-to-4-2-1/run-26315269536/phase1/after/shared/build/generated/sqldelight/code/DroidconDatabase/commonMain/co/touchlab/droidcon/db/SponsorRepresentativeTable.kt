package co.touchlab.droidcon.db

import kotlin.Long
import kotlin.String

public data class SponsorRepresentativeTable(
  public val sponsorName: String,
  public val sponsorGroupName: String,
  public val representativeId: String,
  public val conferenceId: Long,
  public val displayOrder: Long,
)
