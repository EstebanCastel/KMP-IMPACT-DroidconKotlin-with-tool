package co.touchlab.droidcon.db

import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import co.touchlab.droidcon.db.shared.newInstance
import co.touchlab.droidcon.db.shared.schema
import kotlin.Unit

public interface DroidconDatabase : Transacter {
  public val conferenceQueries: ConferenceQueries

  public val profileQueries: ProfileQueries

  public val roomQueries: RoomQueries

  public val sessionQueries: SessionQueries

  public val sessionSpeakerQueries: SessionSpeakerQueries

  public val sponsorQueries: SponsorQueries

  public val sponsorGroupQueries: SponsorGroupQueries

  public val sponsorRepresentativeQueries: SponsorRepresentativeQueries

  public companion object {
    public val Schema: SqlSchema<QueryResult.Value<Unit>>
      get() = DroidconDatabase::class.schema

    public operator fun invoke(
      driver: SqlDriver,
      conferenceTableAdapter: ConferenceTable.Adapter,
      sessionTableAdapter: SessionTable.Adapter,
      sponsorGroupTableAdapter: SponsorGroupTable.Adapter,
    ): DroidconDatabase = DroidconDatabase::class.newInstance(driver, conferenceTableAdapter, sessionTableAdapter, sponsorGroupTableAdapter)
  }
}
