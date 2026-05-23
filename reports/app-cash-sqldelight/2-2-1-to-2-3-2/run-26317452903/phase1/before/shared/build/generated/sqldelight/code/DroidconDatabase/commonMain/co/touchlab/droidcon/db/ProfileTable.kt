package co.touchlab.droidcon.db

import kotlin.Long
import kotlin.String

public data class ProfileTable(
  public val id: String,
  public val conferenceId: Long,
  public val fullName: String,
  public val bio: String?,
  public val tagLine: String?,
  public val profilePicture: String?,
  public val twitter: String?,
  public val linkedIn: String?,
  public val website: String?,
)
