package co.touchlab.droidcon.db.shared

import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.AfterVersion
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import co.touchlab.droidcon.db.ConferenceQueries
import co.touchlab.droidcon.db.ConferenceTable
import co.touchlab.droidcon.db.DroidconDatabase
import co.touchlab.droidcon.db.ProfileQueries
import co.touchlab.droidcon.db.RoomQueries
import co.touchlab.droidcon.db.SessionQueries
import co.touchlab.droidcon.db.SessionSpeakerQueries
import co.touchlab.droidcon.db.SessionTable
import co.touchlab.droidcon.db.SponsorGroupQueries
import co.touchlab.droidcon.db.SponsorGroupTable
import co.touchlab.droidcon.db.SponsorQueries
import co.touchlab.droidcon.db.SponsorRepresentativeQueries
import kotlin.Long
import kotlin.Unit
import kotlin.reflect.KClass

internal val KClass<DroidconDatabase>.schema: SqlSchema<QueryResult.Value<Unit>>
  get() = DroidconDatabaseImpl.Schema

internal fun KClass<DroidconDatabase>.newInstance(
  driver: SqlDriver,
  conferenceTableAdapter: ConferenceTable.Adapter,
  sessionTableAdapter: SessionTable.Adapter,
  sponsorGroupTableAdapter: SponsorGroupTable.Adapter,
): DroidconDatabase = DroidconDatabaseImpl(driver, conferenceTableAdapter, sessionTableAdapter, sponsorGroupTableAdapter)

private class DroidconDatabaseImpl(
  driver: SqlDriver,
  conferenceTableAdapter: ConferenceTable.Adapter,
  sessionTableAdapter: SessionTable.Adapter,
  sponsorGroupTableAdapter: SponsorGroupTable.Adapter,
) : TransacterImpl(driver),
    DroidconDatabase {
  override val conferenceQueries: ConferenceQueries =
      ConferenceQueries(driver, conferenceTableAdapter)

  override val profileQueries: ProfileQueries = ProfileQueries(driver)

  override val roomQueries: RoomQueries = RoomQueries(driver)

  override val sessionQueries: SessionQueries = SessionQueries(driver, sessionTableAdapter)

  override val sessionSpeakerQueries: SessionSpeakerQueries = SessionSpeakerQueries(driver)

  override val sponsorQueries: SponsorQueries = SponsorQueries(driver)

  override val sponsorGroupQueries: SponsorGroupQueries =
      SponsorGroupQueries(driver, sponsorGroupTableAdapter)

  override val sponsorRepresentativeQueries: SponsorRepresentativeQueries =
      SponsorRepresentativeQueries(driver)

  public object Schema : SqlSchema<QueryResult.Value<Unit>> {
    override val version: Long
      get() = 1

    override fun create(driver: SqlDriver): QueryResult.Value<Unit> {
      driver.execute(null, """
          |CREATE TABLE conferenceTable(
          |    id INTEGER PRIMARY KEY AUTOINCREMENT,
          |    conferenceName TEXT NOT NULL,
          |    conferenceTimeZone TEXT NOT NULL,
          |    projectId TEXT NOT NULL,
          |    collectionName TEXT NOT NULL,
          |    apiKey TEXT NOT NULL,
          |    scheduleId TEXT NOT NULL,
          |    selected INTEGER NOT NULL DEFAULT 0,
          |    active INTEGER NOT NULL DEFAULT 1,
          |    venueMap TEXT
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE profileTable(
          |    id TEXT NOT NULL,
          |    conferenceId INTEGER NOT NULL,
          |    fullName TEXT NOT NULL,
          |    bio TEXT,
          |    tagLine TEXT,
          |    profilePicture TEXT,
          |    twitter TEXT,
          |    linkedIn TEXT,
          |    website TEXT,
          |    PRIMARY KEY (id, conferenceId),
          |    FOREIGN KEY (conferenceId) REFERENCES conferenceTable(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE roomTable(
          |    id INTEGER NOT NULL,
          |    conferenceId INTEGER NOT NULL,
          |    name TEXT NOT NULL,
          |    PRIMARY KEY (id, conferenceId),
          |    FOREIGN KEY (conferenceId) REFERENCES conferenceTable(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE sessionTable(
          |    id TEXT NOT NULL,
          |    conferenceId INTEGER NOT NULL,
          |    title TEXT NOT NULL,
          |    description TEXT,
          |    startsAt INTEGER NOT NULL,
          |    endsAt INTEGER NOT NULL,
          |    serviceSession INTEGER NOT NULL DEFAULT 0,
          |    rsvp INTEGER,
          |    rsvpSent INTEGER NOT NULL DEFAULT 0,
          |    roomId INTEGER,
          |    feedbackRating INTEGER,
          |    feedbackComment TEXT,
          |    feedbackSent INTEGER NOT NULL DEFAULT 0,
          |    PRIMARY KEY (id, conferenceId),
          |    FOREIGN KEY (roomId) REFERENCES roomTable(id),
          |    FOREIGN KEY (conferenceId) REFERENCES conferenceTable(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE sessionSpeakerTable(
          |    sessionId TEXT NOT NULL,
          |    speakerId TEXT NOT NULL,
          |    conferenceId INTEGER NOT NULL,
          |    displayOrder INTEGER NOT NULL DEFAULT 0,
          |    PRIMARY KEY (sessionId, speakerId, conferenceId),
          |    FOREIGN KEY (sessionId, conferenceId) REFERENCES sessionTable(id, conferenceId),
          |    FOREIGN KEY (speakerId, conferenceId) REFERENCES profileTable(id, conferenceId),
          |    FOREIGN KEY (conferenceId) REFERENCES conferenceTable(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE sponsorTable(
          |    name TEXT NOT NULL,
          |    groupName TEXT NOT NULL,
          |    conferenceId INTEGER NOT NULL,
          |    hasDetail INTEGER NOT NULL,
          |    description TEXT,
          |    iconUrl TEXT NOT NULL,
          |    url TEXT NOT NULL,
          |    PRIMARY KEY (name, groupName, conferenceId),
          |    FOREIGN KEY (groupName, conferenceId) REFERENCES sponsorGroupTable(name, conferenceId),
          |    FOREIGN KEY (conferenceId) REFERENCES conferenceTable(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE sponsorGroupTable(
          |    name TEXT NOT NULL,
          |    conferenceId INTEGER NOT NULL,
          |    displayPriority INTEGER NOT NULL,
          |    prominent INTEGER NOT NULL,
          |    PRIMARY KEY (name, conferenceId),
          |    FOREIGN KEY (conferenceId) REFERENCES conferenceTable(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE sponsorRepresentativeTable(
          |    sponsorName TEXT NOT NULL,
          |    sponsorGroupName TEXT NOT NULL,
          |    representativeId TEXT NOT NULL,
          |    conferenceId INTEGER NOT NULL,
          |    displayOrder INTEGER NOT NULL DEFAULT 0,
          |    PRIMARY KEY (sponsorName, sponsorGroupName, representativeId, conferenceId),
          |    FOREIGN KEY (sponsorName, sponsorGroupName, conferenceId) REFERENCES sponsorTable(name, groupName, conferenceId),
          |    FOREIGN KEY (representativeId, conferenceId) REFERENCES profileTable(id, conferenceId),
          |    FOREIGN KEY (conferenceId) REFERENCES conferenceTable(id)
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |INSERT INTO conferenceTable(conferenceName, conferenceTimeZone, projectId, collectionName, apiKey, scheduleId, selected, active, venueMap)
          |VALUES ("Droidcon NYC 2025", "America/New_York", "droidcon-148cc", "sponsors-nyc-2025", "AIzaSyCkD5DH2rUJ8aZuJzANpIFj0AVuCNik1l0", "4lffd9w7", 1, 1, NULL)
          """.trimMargin(), 0)
      return QueryResult.Unit
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Long,
      newVersion: Long,
      vararg callbacks: AfterVersion,
    ): QueryResult.Value<Unit> = QueryResult.Unit
  }
}
