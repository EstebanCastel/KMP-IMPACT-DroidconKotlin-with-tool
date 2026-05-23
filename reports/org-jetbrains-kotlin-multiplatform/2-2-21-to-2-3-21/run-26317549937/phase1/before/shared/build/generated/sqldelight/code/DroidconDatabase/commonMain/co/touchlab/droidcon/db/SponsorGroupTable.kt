package co.touchlab.droidcon.db

import app.cash.sqldelight.ColumnAdapter
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String

public data class SponsorGroupTable(
  public val name: String,
  public val conferenceId: Long,
  public val displayPriority: Int,
  public val prominent: Boolean,
) {
  public class Adapter(
    public val displayPriorityAdapter: ColumnAdapter<Int, Long>,
  )
}
