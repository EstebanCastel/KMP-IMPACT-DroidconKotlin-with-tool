package co.touchlab.droidcon.db

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String

public class SponsorGroupQueries(
  driver: SqlDriver,
  private val sponsorGroupTableAdapter: SponsorGroupTable.Adapter,
) : TransacterImpl(driver) {
  public fun <T : Any> selectAll(conferenceId: Long, mapper: (
    name: String,
    conferenceId: Long,
    displayPriority: Int,
    prominent: Boolean,
  ) -> T): Query<T> = SelectAllQuery(conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!!,
      sponsorGroupTableAdapter.displayPriorityAdapter.decode(cursor.getLong(2)!!),
      cursor.getBoolean(3)!!
    )
  }

  public fun selectAll(conferenceId: Long): Query<SponsorGroupTable> = selectAll(conferenceId, ::SponsorGroupTable)

  public fun <T : Any> sponsorGroupByName(
    name: String,
    conferenceId: Long,
    mapper: (
      name: String,
      conferenceId: Long,
      displayPriority: Int,
      prominent: Boolean,
    ) -> T,
  ): Query<T> = SponsorGroupByNameQuery(name, conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!!,
      sponsorGroupTableAdapter.displayPriorityAdapter.decode(cursor.getLong(2)!!),
      cursor.getBoolean(3)!!
    )
  }

  public fun sponsorGroupByName(name: String, conferenceId: Long): Query<SponsorGroupTable> = sponsorGroupByName(name, conferenceId, ::SponsorGroupTable)

  public fun existsByName(name: String, conferenceId: Long): Query<Long> = ExistsByNameQuery(name, conferenceId) { cursor ->
    cursor.getLong(0)!!
  }

  /**
   * @return The number of rows updated.
   */
  public fun upsert(
    name: String,
    conferenceId: Long,
    displayPriority: Int,
    prominent: Boolean,
  ): QueryResult<Long> {
    val result = driver.execute(1_898_383_444, """
        |INSERT OR REPLACE INTO sponsorGroupTable(name, conferenceId, displayPriority, prominent)
        |VALUES (?, ?, ?, ?)
        """.trimMargin(), 4) {
          var parameterIndex = 0
          bindString(parameterIndex++, name)
          bindLong(parameterIndex++, conferenceId)
          bindLong(parameterIndex++, sponsorGroupTableAdapter.displayPriorityAdapter.encode(displayPriority))
          bindBoolean(parameterIndex++, prominent)
        }
    notifyQueries(1_898_383_444) { emit ->
      emit("sponsorGroupTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteAll(conferenceId: Long): QueryResult<Long> {
    val result = driver.execute(-338_388_303, """DELETE FROM sponsorGroupTable WHERE conferenceId = ?""", 1) {
          var parameterIndex = 0
          bindLong(parameterIndex++, conferenceId)
        }
    notifyQueries(-338_388_303) { emit ->
      emit("sponsorGroupTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteByName(name: String, conferenceId: Long): QueryResult<Long> {
    val result = driver.execute(-597_853_070, """DELETE FROM sponsorGroupTable WHERE name = ? AND conferenceId = ?""", 2) {
          var parameterIndex = 0
          bindString(parameterIndex++, name)
          bindLong(parameterIndex++, conferenceId)
        }
    notifyQueries(-597_853_070) { emit ->
      emit("sponsorGroupTable")
    }
    return result
  }

  private inner class SelectAllQuery<out T : Any>(
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sponsorGroupTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sponsorGroupTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_695_654_464, """SELECT sponsorGroupTable.name, sponsorGroupTable.conferenceId, sponsorGroupTable.displayPriority, sponsorGroupTable.prominent FROM sponsorGroupTable WHERE conferenceId = ?""", mapper, 1) {
      var parameterIndex = 0
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "SponsorGroup.sq:selectAll"
  }

  private inner class SponsorGroupByNameQuery<out T : Any>(
    public val name: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sponsorGroupTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sponsorGroupTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(2_104_385_292, """SELECT sponsorGroupTable.name, sponsorGroupTable.conferenceId, sponsorGroupTable.displayPriority, sponsorGroupTable.prominent FROM sponsorGroupTable WHERE name = ? AND conferenceId = ? LIMIT 1""", mapper, 2) {
      var parameterIndex = 0
      bindString(parameterIndex++, name)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "SponsorGroup.sq:sponsorGroupByName"
  }

  private inner class ExistsByNameQuery<out T : Any>(
    public val name: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sponsorGroupTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sponsorGroupTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(344_023_651, """SELECT count(1) FROM sponsorGroupTable WHERE name = ? AND conferenceId = ? LIMIT 1""", mapper, 2) {
      var parameterIndex = 0
      bindString(parameterIndex++, name)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "SponsorGroup.sq:existsByName"
  }
}
