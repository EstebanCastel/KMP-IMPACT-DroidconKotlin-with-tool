package co.touchlab.droidcon.db

import app.cash.sqldelight.ExecutableQuery
import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlinx.datetime.TimeZone

public class ConferenceQueries(
  driver: SqlDriver,
  private val conferenceTableAdapter: ConferenceTable.Adapter,
) : TransacterImpl(driver) {
  public fun <T : Any> selectAll(mapper: (
    id: Long,
    conferenceName: String,
    conferenceTimeZone: TimeZone,
    projectId: String,
    collectionName: String,
    apiKey: String,
    scheduleId: String,
    selected: Boolean,
    active: Boolean,
    venueMap: String?,
  ) -> T): Query<T> = Query(-1_395_907_319, arrayOf("conferenceTable"), driver, "Conference.sq", "selectAll", "SELECT conferenceTable.id, conferenceTable.conferenceName, conferenceTable.conferenceTimeZone, conferenceTable.projectId, conferenceTable.collectionName, conferenceTable.apiKey, conferenceTable.scheduleId, conferenceTable.selected, conferenceTable.active, conferenceTable.venueMap FROM conferenceTable") { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getString(6)!!,
      cursor.getBoolean(7)!!,
      cursor.getBoolean(8)!!,
      cursor.getString(9)
    )
  }

  public fun selectAll(): Query<ConferenceTable> = selectAll(::ConferenceTable)

  public fun <T : Any> selectAllActive(mapper: (
    id: Long,
    conferenceName: String,
    conferenceTimeZone: TimeZone,
    projectId: String,
    collectionName: String,
    apiKey: String,
    scheduleId: String,
    selected: Boolean,
    active: Boolean,
    venueMap: String?,
  ) -> T): Query<T> = Query(2_064_180_591, arrayOf("conferenceTable"), driver, "Conference.sq", "selectAllActive", "SELECT conferenceTable.id, conferenceTable.conferenceName, conferenceTable.conferenceTimeZone, conferenceTable.projectId, conferenceTable.collectionName, conferenceTable.apiKey, conferenceTable.scheduleId, conferenceTable.selected, conferenceTable.active, conferenceTable.venueMap FROM conferenceTable WHERE active = 1") { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getString(6)!!,
      cursor.getBoolean(7)!!,
      cursor.getBoolean(8)!!,
      cursor.getString(9)
    )
  }

  public fun selectAllActive(): Query<ConferenceTable> = selectAllActive(::ConferenceTable)

  public fun <T : Any> selectById(id: Long, mapper: (
    id: Long,
    conferenceName: String,
    conferenceTimeZone: TimeZone,
    projectId: String,
    collectionName: String,
    apiKey: String,
    scheduleId: String,
    selected: Boolean,
    active: Boolean,
    venueMap: String?,
  ) -> T): Query<T> = SelectByIdQuery(id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getString(6)!!,
      cursor.getBoolean(7)!!,
      cursor.getBoolean(8)!!,
      cursor.getString(9)
    )
  }

  public fun selectById(id: Long): Query<ConferenceTable> = selectById(id, ::ConferenceTable)

  public fun <T : Any> selectSelected(mapper: (
    id: Long,
    conferenceName: String,
    conferenceTimeZone: TimeZone,
    projectId: String,
    collectionName: String,
    apiKey: String,
    scheduleId: String,
    selected: Boolean,
    active: Boolean,
    venueMap: String?,
  ) -> T): Query<T> = Query(-2_035_931_085, arrayOf("conferenceTable"), driver, "Conference.sq", "selectSelected", "SELECT conferenceTable.id, conferenceTable.conferenceName, conferenceTable.conferenceTimeZone, conferenceTable.projectId, conferenceTable.collectionName, conferenceTable.apiKey, conferenceTable.scheduleId, conferenceTable.selected, conferenceTable.active, conferenceTable.venueMap FROM conferenceTable WHERE selected = 1 LIMIT 1") { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getString(6)!!,
      cursor.getBoolean(7)!!,
      cursor.getBoolean(8)!!,
      cursor.getString(9)
    )
  }

  public fun selectSelected(): Query<ConferenceTable> = selectSelected(::ConferenceTable)

  public fun lastInsertRowId(): ExecutableQuery<Long> = Query(1_347_239_914, driver, "Conference.sq", "lastInsertRowId", "SELECT last_insert_rowid()") { cursor ->
    cursor.getLong(0)!!
  }

  /**
   * @return The number of rows updated.
   */
  public fun insert(
    conferenceName: String,
    conferenceTimeZone: TimeZone,
    projectId: String,
    collectionName: String,
    apiKey: String,
    scheduleId: String,
    selected: Boolean,
    active: Boolean,
    venueMap: String?,
  ): QueryResult<Long> {
    val result = driver.execute(435_967_797, """
        |INSERT INTO conferenceTable(conferenceName, conferenceTimeZone, projectId, collectionName, apiKey, scheduleId, selected, active, venueMap)
        |VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.trimMargin(), 9) {
          var parameterIndex = 0
          bindString(parameterIndex++, conferenceName)
          bindString(parameterIndex++, conferenceTableAdapter.conferenceTimeZoneAdapter.encode(conferenceTimeZone))
          bindString(parameterIndex++, projectId)
          bindString(parameterIndex++, collectionName)
          bindString(parameterIndex++, apiKey)
          bindString(parameterIndex++, scheduleId)
          bindBoolean(parameterIndex++, selected)
          bindBoolean(parameterIndex++, active)
          bindString(parameterIndex++, venueMap)
        }
    notifyQueries(435_967_797) { emit ->
      emit("conferenceTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun updateConference(
    conferenceName: String,
    conferenceTimeZone: TimeZone,
    projectId: String,
    collectionName: String,
    apiKey: String,
    scheduleId: String,
    selected: Boolean,
    active: Boolean,
    venueMap: String?,
    id: Long,
  ): QueryResult<Long> {
    val result = driver.execute(-1_547_379_647, """
        |UPDATE conferenceTable
        |SET conferenceName = ?, conferenceTimeZone = ?, projectId = ?, collectionName = ?, apiKey = ?, scheduleId = ?, selected = ?, active = ?, venueMap = ?
        |WHERE id = ?
        """.trimMargin(), 10) {
          var parameterIndex = 0
          bindString(parameterIndex++, conferenceName)
          bindString(parameterIndex++, conferenceTableAdapter.conferenceTimeZoneAdapter.encode(conferenceTimeZone))
          bindString(parameterIndex++, projectId)
          bindString(parameterIndex++, collectionName)
          bindString(parameterIndex++, apiKey)
          bindString(parameterIndex++, scheduleId)
          bindBoolean(parameterIndex++, selected)
          bindBoolean(parameterIndex++, active)
          bindString(parameterIndex++, venueMap)
          bindLong(parameterIndex++, id)
        }
    notifyQueries(-1_547_379_647) { emit ->
      emit("conferenceTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteById(id: Long): QueryResult<Long> {
    val result = driver.execute(-1_197_834_599, """DELETE FROM conferenceTable WHERE id = ?""", 1) {
          var parameterIndex = 0
          bindLong(parameterIndex++, id)
        }
    notifyQueries(-1_197_834_599) { emit ->
      emit("conferenceTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun updateSelected(): QueryResult<Long> {
    val result = driver.execute(-2_118_054_144, """
        |UPDATE conferenceTable
        |SET selected = 0
        |WHERE selected = 1
        """.trimMargin(), 0)
    notifyQueries(-2_118_054_144) { emit ->
      emit("conferenceTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun setSelected(id: Long): QueryResult<Long> {
    val result = driver.execute(1_556_245_025, """
        |UPDATE conferenceTable
        |SET selected = 1
        |WHERE id = ?
        """.trimMargin(), 1) {
          var parameterIndex = 0
          bindLong(parameterIndex++, id)
        }
    notifyQueries(1_556_245_025) { emit ->
      emit("conferenceTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun changeSelectedConference(conferenceId: Long): QueryResult<Long> = transactionWithResult {
    driver.execute(687_586_900, """UPDATE conferenceTable SET selected = 0 WHERE selected = 1""", 0)
    driver.execute(687_586_901, """UPDATE conferenceTable SET selected = 1 WHERE id = ?""", 1) {
          var parameterIndex = 0
          bindLong(parameterIndex++, conferenceId)
        }
  }.also {
    notifyQueries(1_350_434_659) { emit ->
      emit("conferenceTable")
    }
  }

  private inner class SelectByIdQuery<out T : Any>(
    public val id: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("conferenceTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("conferenceTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-323_412_630, """SELECT conferenceTable.id, conferenceTable.conferenceName, conferenceTable.conferenceTimeZone, conferenceTable.projectId, conferenceTable.collectionName, conferenceTable.apiKey, conferenceTable.scheduleId, conferenceTable.selected, conferenceTable.active, conferenceTable.venueMap FROM conferenceTable WHERE id = ?""", mapper, 1) {
      var parameterIndex = 0
      bindLong(parameterIndex++, id)
    }

    override fun toString(): String = "Conference.sq:selectById"
  }
}
