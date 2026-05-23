package co.touchlab.droidcon.db

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Long
import kotlin.String

public class SessionSpeakerQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> selectBySessionId(
    sessionId: String,
    conferenceId: Long,
    mapper: (
      sessionId: String,
      speakerId: String,
      conferenceId: Long,
      displayOrder: Long,
    ) -> T,
  ): Query<T> = SelectBySessionIdQuery(sessionId, conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!,
      cursor.getLong(3)!!
    )
  }

  public fun selectBySessionId(sessionId: String, conferenceId: Long): Query<SessionSpeakerTable> = selectBySessionId(sessionId, conferenceId, ::SessionSpeakerTable)

  public fun <T : Any> selectBySpeakerId(
    speakerId: String,
    conferenceId: Long,
    mapper: (
      sessionId: String,
      speakerId: String,
      conferenceId: Long,
      displayOrder: Long,
    ) -> T,
  ): Query<T> = SelectBySpeakerIdQuery(speakerId, conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!,
      cursor.getLong(3)!!
    )
  }

  public fun selectBySpeakerId(speakerId: String, conferenceId: Long): Query<SessionSpeakerTable> = selectBySpeakerId(speakerId, conferenceId, ::SessionSpeakerTable)

  /**
   * @return The number of rows updated.
   */
  public fun insertUpdate(
    sessionId: String,
    speakerId: String,
    conferenceId: Long,
    displayOrder: Long,
  ): QueryResult<Long> {
    val result = driver.execute(552_573_131, """
        |INSERT OR REPLACE INTO sessionSpeakerTable(sessionId, speakerId, conferenceId, displayOrder)
        |VALUES (?,?,?,?)
        """.trimMargin(), 4) {
          var parameterIndex = 0
          bindString(parameterIndex++, sessionId)
          bindString(parameterIndex++, speakerId)
          bindLong(parameterIndex++, conferenceId)
          bindLong(parameterIndex++, displayOrder)
        }
    notifyQueries(552_573_131) { emit ->
      emit("sessionSpeakerTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteBySessionId(sessionId: String, conferenceId: Long): QueryResult<Long> {
    val result = driver.execute(-2_077_169_978, """DELETE FROM sessionSpeakerTable WHERE sessionId = ? AND conferenceId = ?""", 2) {
          var parameterIndex = 0
          bindString(parameterIndex++, sessionId)
          bindLong(parameterIndex++, conferenceId)
        }
    notifyQueries(-2_077_169_978) { emit ->
      emit("sessionSpeakerTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteBySpeakerId(speakerId: String, conferenceId: Long): QueryResult<Long> {
    val result = driver.execute(-140_046_865, """DELETE FROM sessionSpeakerTable WHERE speakerId = ? AND conferenceId = ?""", 2) {
          var parameterIndex = 0
          bindString(parameterIndex++, speakerId)
          bindLong(parameterIndex++, conferenceId)
        }
    notifyQueries(-140_046_865) { emit ->
      emit("sessionSpeakerTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteAll(conferenceId: Long): QueryResult<Long> {
    val result = driver.execute(-303_241_043, """DELETE FROM sessionSpeakerTable WHERE conferenceId = ?""", 1) {
          var parameterIndex = 0
          bindLong(parameterIndex++, conferenceId)
        }
    notifyQueries(-303_241_043) { emit ->
      emit("sessionSpeakerTable")
    }
    return result
  }

  private inner class SelectBySessionIdQuery<out T : Any>(
    public val sessionId: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sessionSpeakerTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sessionSpeakerTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-623_236_395, """SELECT sessionSpeakerTable.sessionId, sessionSpeakerTable.speakerId, sessionSpeakerTable.conferenceId, sessionSpeakerTable.displayOrder FROM sessionSpeakerTable WHERE sessionId = ? AND conferenceId = ?""", mapper, 2) {
      var parameterIndex = 0
      bindString(parameterIndex++, sessionId)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "SessionSpeaker.sq:selectBySessionId"
  }

  private inner class SelectBySpeakerIdQuery<out T : Any>(
    public val speakerId: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sessionSpeakerTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sessionSpeakerTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_313_886_718, """SELECT sessionSpeakerTable.sessionId, sessionSpeakerTable.speakerId, sessionSpeakerTable.conferenceId, sessionSpeakerTable.displayOrder FROM sessionSpeakerTable WHERE speakerId = ? AND conferenceId = ?""", mapper, 2) {
      var parameterIndex = 0
      bindString(parameterIndex++, speakerId)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "SessionSpeaker.sq:selectBySpeakerId"
  }
}
