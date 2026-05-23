package co.touchlab.droidcon.db

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Long
import kotlin.String

public class ProfileQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> selectById(
    id: String,
    conferenceId: Long,
    mapper: (
      id: String,
      conferenceId: Long,
      fullName: String,
      bio: String?,
      tagLine: String?,
      profilePicture: String?,
      twitter: String?,
      linkedIn: String?,
      website: String?,
    ) -> T,
  ): Query<T> = SelectByIdQuery(id, conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      cursor.getString(4),
      cursor.getString(5),
      cursor.getString(6),
      cursor.getString(7),
      cursor.getString(8)
    )
  }

  public fun selectById(id: String, conferenceId: Long): Query<ProfileTable> = selectById(id, conferenceId, ::ProfileTable)

  public fun existsById(id: String, conferenceId: Long): Query<Long> = ExistsByIdQuery(id, conferenceId) { cursor ->
    cursor.getLong(0)!!
  }

  public fun <T : Any> selectBySession(
    sessionId: String,
    conferenceId: Long,
    mapper: (
      id: String,
      conferenceId: Long,
      fullName: String,
      bio: String?,
      tagLine: String?,
      profilePicture: String?,
      twitter: String?,
      linkedIn: String?,
      website: String?,
    ) -> T,
  ): Query<T> = SelectBySessionQuery(sessionId, conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      cursor.getString(4),
      cursor.getString(5),
      cursor.getString(6),
      cursor.getString(7),
      cursor.getString(8)
    )
  }

  public fun selectBySession(sessionId: String, conferenceId: Long): Query<ProfileTable> = selectBySession(sessionId, conferenceId, ::ProfileTable)

  public fun <T : Any> selectBySponsor(
    sponsorName: String,
    sponsorGroupName: String,
    conferenceId: Long,
    mapper: (
      id: String,
      conferenceId: Long,
      fullName: String,
      bio: String?,
      tagLine: String?,
      profilePicture: String?,
      twitter: String?,
      linkedIn: String?,
      website: String?,
    ) -> T,
  ): Query<T> = SelectBySponsorQuery(sponsorName, sponsorGroupName, conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      cursor.getString(4),
      cursor.getString(5),
      cursor.getString(6),
      cursor.getString(7),
      cursor.getString(8)
    )
  }

  public fun selectBySponsor(
    sponsorName: String,
    sponsorGroupName: String,
    conferenceId: Long,
  ): Query<ProfileTable> = selectBySponsor(sponsorName, sponsorGroupName, conferenceId, ::ProfileTable)

  public fun <T : Any> selectAll(conferenceId: Long, mapper: (
    id: String,
    conferenceId: Long,
    fullName: String,
    bio: String?,
    tagLine: String?,
    profilePicture: String?,
    twitter: String?,
    linkedIn: String?,
    website: String?,
  ) -> T): Query<T> = SelectAllQuery(conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      cursor.getString(4),
      cursor.getString(5),
      cursor.getString(6),
      cursor.getString(7),
      cursor.getString(8)
    )
  }

  public fun selectAll(conferenceId: Long): Query<ProfileTable> = selectAll(conferenceId, ::ProfileTable)

  /**
   * @return The number of rows updated.
   */
  public fun upsert(
    id: String,
    conferenceId: Long,
    fullName: String,
    bio: String?,
    tagLine: String?,
    profilePicture: String?,
    twitter: String?,
    linkedIn: String?,
    website: String?,
  ): QueryResult<Long> {
    val result = driver.execute(340_997_844, """
        |INSERT OR REPLACE INTO profileTable(id, conferenceId, fullName, bio, tagLine, profilePicture, twitter, linkedIn, website)
        |VALUES(?,?,?,?,?,?,?,?,?)
        """.trimMargin(), 9) {
          var parameterIndex = 0
          bindString(parameterIndex++, id)
          bindLong(parameterIndex++, conferenceId)
          bindString(parameterIndex++, fullName)
          bindString(parameterIndex++, bio)
          bindString(parameterIndex++, tagLine)
          bindString(parameterIndex++, profilePicture)
          bindString(parameterIndex++, twitter)
          bindString(parameterIndex++, linkedIn)
          bindString(parameterIndex++, website)
        }
    notifyQueries(340_997_844) { emit ->
      emit("profileTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun delete(speakerId: String, conferenceId: Long): QueryResult<Long> = transactionWithResult {
    driver.execute(345_447_169, """DELETE FROM sessionSpeakerTable WHERE speakerId = ?""", 1) {
          var parameterIndex = 0
          bindString(parameterIndex++, speakerId)
        }
    driver.execute(345_447_170, """DELETE FROM profileTable WHERE id = ? AND conferenceId = ?""", 2) {
          var parameterIndex = 0
          bindString(parameterIndex++, speakerId)
          bindLong(parameterIndex++, conferenceId)
        }
  }.also {
    notifyQueries(-156_064_944) { emit ->
      emit("profileTable")
      emit("sessionSpeakerTable")
    }
  }

  private inner class SelectByIdQuery<out T : Any>(
    public val id: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("profileTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("profileTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(2_135_878_163, """SELECT profileTable.id, profileTable.conferenceId, profileTable.fullName, profileTable.bio, profileTable.tagLine, profileTable.profilePicture, profileTable.twitter, profileTable.linkedIn, profileTable.website FROM profileTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
      var parameterIndex = 0
      bindString(parameterIndex++, id)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Profile.sq:selectById"
  }

  private inner class ExistsByIdQuery<out T : Any>(
    public val id: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("profileTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("profileTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-297_338_509, """SELECT count(1) FROM profileTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
      var parameterIndex = 0
      bindString(parameterIndex++, id)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Profile.sq:existsById"
  }

  private inner class SelectBySessionQuery<out T : Any>(
    public val sessionId: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("profileTable", "sessionSpeakerTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("profileTable", "sessionSpeakerTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_763_508_382, """
    |SELECT profileTable.id, profileTable.conferenceId, profileTable.fullName, profileTable.bio, profileTable.tagLine, profileTable.profilePicture, profileTable.twitter, profileTable.linkedIn, profileTable.website
    |FROM profileTable
    |JOIN sessionSpeakerTable ON sessionSpeakerTable.speakerId = id AND sessionSpeakerTable.conferenceId = profileTable.conferenceId
    |WHERE sessionSpeakerTable.sessionId = ? AND profileTable.conferenceId = ?
    |ORDER BY sessionSpeakerTable.displayOrder
    """.trimMargin(), mapper, 2) {
      var parameterIndex = 0
      bindString(parameterIndex++, sessionId)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Profile.sq:selectBySession"
  }

  private inner class SelectBySponsorQuery<out T : Any>(
    public val sponsorName: String,
    public val sponsorGroupName: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("profileTable", "sponsorRepresentativeTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("profileTable", "sponsorRepresentativeTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(2_074_595_618, """
    |SELECT profileTable.id, profileTable.conferenceId, profileTable.fullName, profileTable.bio, profileTable.tagLine, profileTable.profilePicture, profileTable.twitter, profileTable.linkedIn, profileTable.website
    |FROM profileTable
    |JOIN sponsorRepresentativeTable ON sponsorRepresentativeTable.representativeId = id AND sponsorRepresentativeTable.conferenceId = profileTable.conferenceId
    |WHERE sponsorRepresentativeTable.sponsorName = ? AND sponsorRepresentativeTable.sponsorGroupName = ? AND profileTable.conferenceId = ?
    |ORDER BY sponsorRepresentativeTable.displayOrder
    """.trimMargin(), mapper, 3) {
      var parameterIndex = 0
      bindString(parameterIndex++, sponsorName)
      bindString(parameterIndex++, sponsorGroupName)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Profile.sq:selectBySponsor"
  }

  private inner class SelectAllQuery<out T : Any>(
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("profileTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("profileTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(761_634_624, """
    |SELECT profileTable.id, profileTable.conferenceId, profileTable.fullName, profileTable.bio, profileTable.tagLine, profileTable.profilePicture, profileTable.twitter, profileTable.linkedIn, profileTable.website
    |FROM profileTable
    |WHERE conferenceId = ?
    """.trimMargin(), mapper, 1) {
      var parameterIndex = 0
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Profile.sq:selectAll"
  }
}
