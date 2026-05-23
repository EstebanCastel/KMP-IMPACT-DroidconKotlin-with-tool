package co.touchlab.droidcon.db

import app.cash.sqldelight.ColumnAdapter
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlinx.datetime.TimeZone

public data class ConferenceTable(
  public val id: Long,
  public val conferenceName: String,
  public val conferenceTimeZone: TimeZone,
  public val projectId: String,
  public val collectionName: String,
  public val apiKey: String,
  public val scheduleId: String,
  public val selected: Boolean,
  public val active: Boolean,
  public val venueMap: String?,
) {
  public class Adapter(
    public val conferenceTimeZoneAdapter: ColumnAdapter<TimeZone, String>,
  )
}
