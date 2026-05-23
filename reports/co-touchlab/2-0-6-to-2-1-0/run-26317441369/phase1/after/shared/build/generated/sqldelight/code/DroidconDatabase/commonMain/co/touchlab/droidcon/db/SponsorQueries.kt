package co.touchlab.droidcon.db

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Boolean
import kotlin.Long
import kotlin.String

public class SponsorQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> selectAll(conferenceId: Long, mapper: (
    name: String,
    groupName: String,
    conferenceId: Long,
    hasDetail: Boolean,
    description: String?,
    iconUrl: String,
    url: String,
  ) -> T): Query<T> = SelectAllQuery(conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!,
      cursor.getBoolean(3)!!,
      cursor.getString(4),
      cursor.getString(5)!!,
      cursor.getString(6)!!
    )
  }

  public fun selectAll(conferenceId: Long): Query<SponsorTable> = selectAll(conferenceId, ::SponsorTable)

  public fun <T : Any> sponsorsByGroup(
    groupName: String,
    conferenceId: Long,
    mapper: (
      name: String,
      groupName: String,
      conferenceId: Long,
      hasDetail: Boolean,
      description: String?,
      iconUrl: String,
      url: String,
    ) -> T,
  ): Query<T> = SponsorsByGroupQuery(groupName, conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!,
      cursor.getBoolean(3)!!,
      cursor.getString(4),
      cursor.getString(5)!!,
      cursor.getString(6)!!
    )
  }

  public fun sponsorsByGroup(groupName: String, conferenceId: Long): Query<SponsorTable> = sponsorsByGroup(groupName, conferenceId, ::SponsorTable)

  public fun <T : Any> sponsorById(
    name: String,
    groupName: String,
    conferenceId: Long,
    mapper: (
      name: String,
      groupName: String,
      conferenceId: Long,
      hasDetail: Boolean,
      description: String?,
      iconUrl: String,
      url: String,
    ) -> T,
  ): Query<T> = SponsorByIdQuery(name, groupName, conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!,
      cursor.getBoolean(3)!!,
      cursor.getString(4),
      cursor.getString(5)!!,
      cursor.getString(6)!!
    )
  }

  public fun sponsorById(
    name: String,
    groupName: String,
    conferenceId: Long,
  ): Query<SponsorTable> = sponsorById(name, groupName, conferenceId, ::SponsorTable)

  public fun existsById(
    name: String,
    groupName: String,
    conferenceId: Long,
  ): Query<Long> = ExistsByIdQuery(name, groupName, conferenceId) { cursor ->
    cursor.getLong(0)!!
  }

  /**
   * @return The number of rows updated.
   */
  public fun upsert(
    name: String,
    groupName: String,
    conferenceId: Long,
    hasDetail: Boolean,
    description: String?,
    iconUrl: String,
    url: String,
  ): QueryResult<Long> {
    val result = driver.execute(1_240_180_485, """
        |INSERT OR REPLACE INTO sponsorTable(name, groupName, conferenceId, hasDetail, description, iconUrl, url)
        |VALUES (?, ?, ?, ?, ?, ?, ?)
        """.trimMargin(), 7) {
          var parameterIndex = 0
          bindString(parameterIndex++, name)
          bindString(parameterIndex++, groupName)
          bindLong(parameterIndex++, conferenceId)
          bindBoolean(parameterIndex++, hasDetail)
          bindString(parameterIndex++, description)
          bindString(parameterIndex++, iconUrl)
          bindString(parameterIndex++, url)
        }
    notifyQueries(1_240_180_485) { emit ->
      emit("sponsorTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteById(
    name: String,
    groupName: String,
    conferenceId: Long,
  ): QueryResult<Long> {
    val result = driver.execute(566_442_739, """DELETE FROM sponsorTable WHERE name = ? AND groupName = ? AND conferenceId = ?""", 3) {
          var parameterIndex = 0
          bindString(parameterIndex++, name)
          bindString(parameterIndex++, groupName)
          bindLong(parameterIndex++, conferenceId)
        }
    notifyQueries(566_442_739) { emit ->
      emit("sponsorTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteAll(conferenceId: Long): QueryResult<Long> {
    val result = driver.execute(1_957_933_664, """DELETE FROM sponsorTable WHERE conferenceId = ?""", 1) {
          var parameterIndex = 0
          bindLong(parameterIndex++, conferenceId)
        }
    notifyQueries(1_957_933_664) { emit ->
      emit("sponsorTable")
    }
    return result
  }

  private inner class SelectAllQuery<out T : Any>(
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sponsorTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sponsorTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(600_667_503, """SELECT sponsorTable.name, sponsorTable.groupName, sponsorTable.conferenceId, sponsorTable.hasDetail, sponsorTable.description, sponsorTable.iconUrl, sponsorTable.url FROM sponsorTable WHERE conferenceId = ?""", mapper, 1) {
      var parameterIndex = 0
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Sponsor.sq:selectAll"
  }

  private inner class SponsorsByGroupQuery<out T : Any>(
    public val groupName: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sponsorTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sponsorTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(708_121_721, """SELECT sponsorTable.name, sponsorTable.groupName, sponsorTable.conferenceId, sponsorTable.hasDetail, sponsorTable.description, sponsorTable.iconUrl, sponsorTable.url FROM sponsorTable WHERE groupName = ? AND conferenceId = ?""", mapper, 2) {
      var parameterIndex = 0
      bindString(parameterIndex++, groupName)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Sponsor.sq:sponsorsByGroup"
  }

  private inner class SponsorByIdQuery<out T : Any>(
    public val name: String,
    public val groupName: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sponsorTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sponsorTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_851_740_682, """SELECT sponsorTable.name, sponsorTable.groupName, sponsorTable.conferenceId, sponsorTable.hasDetail, sponsorTable.description, sponsorTable.iconUrl, sponsorTable.url FROM sponsorTable WHERE name = ? AND groupName = ? AND conferenceId = ? LIMIT 1""", mapper, 3) {
      var parameterIndex = 0
      bindString(parameterIndex++, name)
      bindString(parameterIndex++, groupName)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Sponsor.sq:sponsorById"
  }

  private inner class ExistsByIdQuery<out T : Any>(
    public val name: String,
    public val groupName: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sponsorTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sponsorTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-992_351_964, """SELECT count(1) FROM sponsorTable WHERE name = ? AND groupName = ? AND conferenceId = ? LIMIT 1""", mapper, 3) {
      var parameterIndex = 0
      bindString(parameterIndex++, name)
      bindString(parameterIndex++, groupName)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Sponsor.sq:existsById"
  }
}
