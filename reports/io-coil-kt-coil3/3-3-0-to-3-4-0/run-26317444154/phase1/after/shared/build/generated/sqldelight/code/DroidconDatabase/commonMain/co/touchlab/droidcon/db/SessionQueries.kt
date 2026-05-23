package co.touchlab.droidcon.db

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.time.Instant

public class SessionQueries(
  driver: SqlDriver,
  private val sessionTableAdapter: SessionTable.Adapter,
) : TransacterImpl(driver) {
  public fun <T : Any> allSessions(conferenceId: Long, mapper: (
    id: String,
    conferenceId: Long,
    title: String,
    description: String?,
    startsAt: Instant,
    endsAt: Instant,
    serviceSession: Long,
    rsvp: Long?,
    rsvpSent: Long,
    roomId: Long?,
    feedbackRating: Int?,
    feedbackComment: String?,
    feedbackSent: Long,
  ) -> T): Query<T> = AllSessionsQuery(conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
      sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
      cursor.getLong(6)!!,
      cursor.getLong(7),
      cursor.getLong(8)!!,
      cursor.getLong(9),
      cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
      cursor.getString(11),
      cursor.getLong(12)!!
    )
  }

  public fun allSessions(conferenceId: Long): Query<SessionTable> = allSessions(conferenceId, ::SessionTable)

  public fun <T : Any> attendingSessions(conferenceId: Long, mapper: (
    id: String,
    conferenceId: Long,
    title: String,
    description: String?,
    startsAt: Instant,
    endsAt: Instant,
    serviceSession: Long,
    rsvp: Long?,
    rsvpSent: Long,
    roomId: Long?,
    feedbackRating: Int?,
    feedbackComment: String?,
    feedbackSent: Long,
  ) -> T): Query<T> = AttendingSessionsQuery(conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
      sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
      cursor.getLong(6)!!,
      cursor.getLong(7),
      cursor.getLong(8)!!,
      cursor.getLong(9),
      cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
      cursor.getString(11),
      cursor.getLong(12)!!
    )
  }

  public fun attendingSessions(conferenceId: Long): Query<SessionTable> = attendingSessions(conferenceId, ::SessionTable)

  public fun existsById(id: String, conferenceId: Long): Query<Long> = ExistsByIdQuery(id, conferenceId) { cursor ->
    cursor.getLong(0)!!
  }

  public fun <T : Any> sessionById(
    id: String,
    conferenceId: Long,
    mapper: (
      id: String,
      conferenceId: Long,
      title: String,
      description: String?,
      startsAt: Instant,
      endsAt: Instant,
      serviceSession: Long,
      rsvp: Long?,
      rsvpSent: Long,
      roomId: Long?,
      feedbackRating: Int?,
      feedbackComment: String?,
      feedbackSent: Long,
    ) -> T,
  ): Query<T> = SessionByIdQuery(id, conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
      sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
      cursor.getLong(6)!!,
      cursor.getLong(7),
      cursor.getLong(8)!!,
      cursor.getLong(9),
      cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
      cursor.getString(11),
      cursor.getLong(12)!!
    )
  }

  public fun sessionById(id: String, conferenceId: Long): Query<SessionTable> = sessionById(id, conferenceId, ::SessionTable)

  public fun <T : Any> mySessions(conferenceId: Long, mapper: (
    id: String,
    title: String,
    startsAt: Instant,
    endsAt: Instant,
    feedbackRating: Int?,
    roomName: String,
  ) -> T): Query<T> = MySessionsQuery(conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(2)!!),
      sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(3)!!),
      cursor.getLong(4)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
      cursor.getString(5)!!
    )
  }

  public fun mySessions(conferenceId: Long): Query<MySessions> = mySessions(conferenceId, ::MySessions)

  public fun <T : Any> myPastSession(conferenceId: Long, mapper: (
    id: String,
    title: String,
    endsAt: Instant,
    feedbackRating: Int?,
  ) -> T): Query<T> = MyPastSessionQuery(conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(2)!!),
      cursor.getLong(3)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) }
    )
  }

  public fun myPastSession(conferenceId: Long): Query<MyPastSession> = myPastSession(conferenceId, ::MyPastSession)

  public fun <T : Any> userSessions(
    speakerId: String,
    conferenceId: Long,
    mapper: (
      id: String,
      conferenceId: Long,
      title: String,
      description: String?,
      startsAt: Instant,
      endsAt: Instant,
      serviceSession: Long,
      rsvp: Long?,
      rsvpSent: Long,
      roomId: Long?,
      feedbackRating: Int?,
      feedbackComment: String?,
      feedbackSent: Long,
    ) -> T,
  ): Query<T> = UserSessionsQuery(speakerId, conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
      sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
      cursor.getLong(6)!!,
      cursor.getLong(7),
      cursor.getLong(8)!!,
      cursor.getLong(9),
      cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
      cursor.getString(11),
      cursor.getLong(12)!!
    )
  }

  public fun userSessions(speakerId: String, conferenceId: Long): Query<SessionTable> = userSessions(speakerId, conferenceId, ::SessionTable)

  public fun <T : Any> sessionFeedbackToSend(conferenceId: Long, mapper: (
    id: String,
    conferenceId: Long,
    title: String,
    description: String?,
    startsAt: Instant,
    endsAt: Instant,
    serviceSession: Long,
    rsvp: Long?,
    rsvpSent: Long,
    roomId: Long?,
    feedbackRating: Int,
    feedbackComment: String?,
    feedbackSent: Long,
  ) -> T): Query<T> = SessionFeedbackToSendQuery(conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
      sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
      cursor.getLong(6)!!,
      cursor.getLong(7),
      cursor.getLong(8)!!,
      cursor.getLong(9),
      sessionTableAdapter.feedbackRatingAdapter.decode(cursor.getLong(10)!!),
      cursor.getString(11),
      cursor.getLong(12)!!
    )
  }

  public fun sessionFeedbackToSend(conferenceId: Long): Query<SessionFeedbackToSend> = sessionFeedbackToSend(conferenceId, ::SessionFeedbackToSend)

  public fun <T : Any> sessionWithRoom(
    conferenceId: Long,
    conferenceId_: Long,
    mapper: (
      id: String,
      title: String,
      description: String?,
      startsAt: Instant,
      endsAt: Instant,
      serviceSession: Long,
      rsvp: Long?,
      roomId: Long?,
      roomName: String,
      allNames: String?,
    ) -> T,
  ): Query<T> = SessionWithRoomQuery(conferenceId, conferenceId_) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2),
      sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(3)!!),
      sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(4)!!),
      cursor.getLong(5)!!,
      cursor.getLong(6),
      cursor.getLong(7),
      cursor.getString(8)!!,
      cursor.getString(9)
    )
  }

  public fun sessionWithRoom(conferenceId: Long, conferenceId_: Long): Query<SessionWithRoom> = sessionWithRoom(conferenceId, conferenceId_, ::SessionWithRoom)

  /**
   * @return The number of rows updated.
   */
  public fun upsert(
    id: String,
    conferenceId: Long,
    title: String,
    description: String?,
    startsAt: Instant,
    endsAt: Instant,
    serviceSession: Long,
    roomId: Long?,
    rsvp: Long?,
    rsvpSent: Long,
    feedbackRating: Int?,
    feedbackComment: String?,
    feedbackSent: Long,
  ): QueryResult<Long> {
    val result = driver.execute(-994_530_431, """
        |INSERT OR REPLACE INTO sessionTable(id, conferenceId, title, description, startsAt, endsAt, serviceSession, roomId, rsvp, rsvpSent, feedbackRating, feedbackComment, feedbackSent)
        |VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)
        """.trimMargin(), 13) {
          var parameterIndex = 0
          bindString(parameterIndex++, id)
          bindLong(parameterIndex++, conferenceId)
          bindString(parameterIndex++, title)
          bindString(parameterIndex++, description)
          bindLong(parameterIndex++, sessionTableAdapter.startsAtAdapter.encode(startsAt))
          bindLong(parameterIndex++, sessionTableAdapter.endsAtAdapter.encode(endsAt))
          bindLong(parameterIndex++, serviceSession)
          bindLong(parameterIndex++, roomId)
          bindLong(parameterIndex++, rsvp)
          bindLong(parameterIndex++, rsvpSent)
          bindLong(parameterIndex++, feedbackRating?.let { sessionTableAdapter.feedbackRatingAdapter.encode(it) })
          bindString(parameterIndex++, feedbackComment)
          bindLong(parameterIndex++, feedbackSent)
        }
    notifyQueries(-994_530_431) { emit ->
      emit("sessionTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun updateRsvp(
    rsvp: Long?,
    id: String,
    conferenceId: Long,
  ): QueryResult<Long> {
    val result = driver.execute(846_711_414, """UPDATE sessionTable SET rsvp = ? WHERE id = ? AND conferenceId = ?""", 3) {
          var parameterIndex = 0
          bindLong(parameterIndex++, rsvp)
          bindString(parameterIndex++, id)
          bindLong(parameterIndex++, conferenceId)
        }
    notifyQueries(846_711_414) { emit ->
      emit("sessionTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun updateRsvpSent(
    rsvpSent: Long,
    sessionId: String,
    conferenceId: Long,
  ): QueryResult<Long> {
    val result = driver.execute(1_143_530_286, """UPDATE sessionTable SET rsvpSent = ? WHERE id = ? AND conferenceId = ?""", 3) {
          var parameterIndex = 0
          bindLong(parameterIndex++, rsvpSent)
          bindString(parameterIndex++, sessionId)
          bindLong(parameterIndex++, conferenceId)
        }
    notifyQueries(1_143_530_286) { emit ->
      emit("sessionTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun updateFeedBack(
    feedbackRating: Int?,
    feedbackComment: String?,
    sessionId: String,
    conferenceId: Long,
  ): QueryResult<Long> {
    val result = driver.execute(1_666_204_640, """UPDATE sessionTable SET feedbackRating = ?, feedbackComment = ?, feedbackSent = 0 WHERE id = ? AND conferenceId = ?""", 4) {
          var parameterIndex = 0
          bindLong(parameterIndex++, feedbackRating?.let { sessionTableAdapter.feedbackRatingAdapter.encode(it) })
          bindString(parameterIndex++, feedbackComment)
          bindString(parameterIndex++, sessionId)
          bindLong(parameterIndex++, conferenceId)
        }
    notifyQueries(1_666_204_640) { emit ->
      emit("sessionTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun updateFeedBackSent(
    feedbackSent: Long,
    sessionId: String,
    conferenceId: Long,
  ): QueryResult<Long> {
    val result = driver.execute(-135_096_424, """UPDATE sessionTable SET feedbackSent = ? WHERE id = ? AND conferenceId = ?""", 3) {
          var parameterIndex = 0
          bindLong(parameterIndex++, feedbackSent)
          bindString(parameterIndex++, sessionId)
          bindLong(parameterIndex++, conferenceId)
        }
    notifyQueries(-135_096_424) { emit ->
      emit("sessionTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteById(sessionId: String, conferenceId: Long): QueryResult<Long> = transactionWithResult {
    driver.execute(1_667_173_728, """DELETE FROM sessionSpeakerTable WHERE sessionId = ?""", 1) {
          var parameterIndex = 0
          bindString(parameterIndex++, sessionId)
        }
    driver.execute(1_667_173_729, """DELETE FROM sessionTable WHERE id = ? AND conferenceId = ?""", 2) {
          var parameterIndex = 0
          bindString(parameterIndex++, sessionId)
          bindLong(parameterIndex++, conferenceId)
        }
  }.also {
    notifyQueries(-1_388_207_761) { emit ->
      emit("sessionSpeakerTable")
      emit("sessionTable")
    }
  }

  private inner class AllSessionsQuery<out T : Any>(
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sessionTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sessionTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_652_322_740, """SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable WHERE conferenceId = ? ORDER BY sessionTable.startsAt ASC""", mapper, 1) {
      var parameterIndex = 0
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Session.sq:allSessions"
  }

  private inner class AttendingSessionsQuery<out T : Any>(
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sessionTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sessionTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-2_005_357_005, """SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable WHERE rsvp != 0 AND conferenceId = ? ORDER BY sessionTable.startsAt ASC""", mapper, 1) {
      var parameterIndex = 0
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Session.sq:attendingSessions"
  }

  private inner class ExistsByIdQuery<out T : Any>(
    public val id: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sessionTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sessionTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_347_964_832, """SELECT count(1) FROM sessionTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
      var parameterIndex = 0
      bindString(parameterIndex++, id)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Session.sq:existsById"
  }

  private inner class SessionByIdQuery<out T : Any>(
    public val id: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sessionTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sessionTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_040_722_038, """SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
      var parameterIndex = 0
      bindString(parameterIndex++, id)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Session.sq:sessionById"
  }

  private inner class MySessionsQuery<out T : Any>(
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sessionTable", "roomTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sessionTable", "roomTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_286_344_773, """
    |SELECT sessionTable.id, sessionTable.title, sessionTable.startsAt, sessionTable.endsAt, sessionTable.feedbackRating, roomTable.name AS roomName
    |FROM sessionTable
    |JOIN roomTable ON sessionTable.roomId = roomTable.id AND roomTable.conferenceId = sessionTable.conferenceId
    |WHERE rsvp != 0 AND sessionTable.conferenceId = ? ORDER BY sessionTable.startsAt ASC
    """.trimMargin(), mapper, 1) {
      var parameterIndex = 0
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Session.sq:mySessions"
  }

  private inner class MyPastSessionQuery<out T : Any>(
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sessionTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sessionTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-800_947_642, """
    |SELECT sessionTable.id, sessionTable.title, sessionTable.endsAt, sessionTable.feedbackRating
    |FROM sessionTable
    |WHERE rsvp != 0 AND sessionTable.feedbackRating IS NULL AND conferenceId = ?
    """.trimMargin(), mapper, 1) {
      var parameterIndex = 0
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Session.sq:myPastSession"
  }

  private inner class UserSessionsQuery<out T : Any>(
    public val speakerId: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sessionTable", "sessionSpeakerTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sessionTable", "sessionSpeakerTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-747_294_118, """
    |SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable
    |JOIN sessionSpeakerTable ON sessionTable.id = sessionSpeakerTable.sessionId AND sessionTable.conferenceId = sessionSpeakerTable.conferenceId
    |WHERE sessionSpeakerTable.speakerId = ? AND sessionTable.conferenceId = ?
    """.trimMargin(), mapper, 2) {
      var parameterIndex = 0
      bindString(parameterIndex++, speakerId)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Session.sq:userSessions"
  }

  private inner class SessionFeedbackToSendQuery<out T : Any>(
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sessionTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sessionTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-33_666_004, """SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable WHERE feedbackRating IS NOT NULL AND feedbackSent = 0 AND conferenceId = ?""", mapper, 1) {
      var parameterIndex = 0
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Session.sq:sessionFeedbackToSend"
  }

  private inner class SessionWithRoomQuery<out T : Any>(
    public val conferenceId: Long,
    public val conferenceId_: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sessionTable", "roomTable", "sessionSpeakerTable", "profileTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sessionTable", "roomTable", "sessionSpeakerTable", "profileTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_257_788_059, """
    |SELECT
    |    sessionTable.id, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt,
    |    sessionTable.serviceSession, sessionTable.rsvp, sessionTable.roomId, roomTable.name AS roomName,
    |    speakers.allNames
    |FROM sessionTable
    |LEFT JOIN (
    |    SELECT sessionId, group_concat(fullName, ', ') AS allNames
    |    FROM sessionSpeakerTable
    |    JOIN profileTable ON profileTable.id = sessionSpeakerTable.speakerId AND profileTable.conferenceId = sessionSpeakerTable.conferenceId
    |    WHERE sessionSpeakerTable.conferenceId = ?
    |    GROUP BY sessionId
    |) AS speakers ON speakers.sessionId = sessionTable.id
    |JOIN roomTable ON sessionTable.roomId = roomTable.id AND roomTable.conferenceId = sessionTable.conferenceId
    |WHERE sessionTable.conferenceId = ?
    """.trimMargin(), mapper, 2) {
      var parameterIndex = 0
      bindLong(parameterIndex++, conferenceId)
      bindLong(parameterIndex++, conferenceId_)
    }

    override fun toString(): String = "Session.sq:sessionWithRoom"
  }
}
