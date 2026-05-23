package co.touchlab.droidcon.db

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Long
import kotlin.String

public class RoomQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> selectAll(conferenceId: Long, mapper: (
    id: Long,
    conferenceId: Long,
    name: String,
  ) -> T): Query<T> = SelectAllQuery(conferenceId) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!
    )
  }

  public fun selectAll(conferenceId: Long): Query<RoomTable> = selectAll(conferenceId, ::RoomTable)

  public fun <T : Any> selectById(
    id: Long,
    conferenceId: Long,
    mapper: (
      id: Long,
      conferenceId: Long,
      name: String,
    ) -> T,
  ): Query<T> = SelectByIdQuery(id, conferenceId) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!
    )
  }

  public fun selectById(id: Long, conferenceId: Long): Query<RoomTable> = selectById(id, conferenceId, ::RoomTable)

  public fun existsById(id: Long, conferenceId: Long): Query<Long> = ExistsByIdQuery(id, conferenceId) { cursor ->
    cursor.getLong(0)!!
  }

  /**
   * @return The number of rows updated.
   */
  public fun upsert(
    id: Long,
    conferenceId: Long,
    name: String,
  ): QueryResult<Long> {
    val result = driver.execute(-240_282_582, """INSERT OR REPLACE INTO roomTable(id, conferenceId, name) VALUES(?,?,?)""", 3) {
          var parameterIndex = 0
          bindLong(parameterIndex++, id)
          bindLong(parameterIndex++, conferenceId)
          bindString(parameterIndex++, name)
        }
    notifyQueries(-240_282_582) { emit ->
      emit("roomTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteById(roomId: Long?, conferenceId: Long): QueryResult<Long> = transactionWithResult {
    driver.execute(null, """UPDATE sessionTable SET roomId = NULL WHERE roomId ${ if (roomId == null) "IS" else "=" } ? AND conferenceId = ?""", 2) {
          var parameterIndex = 0
          bindLong(parameterIndex++, roomId)
          bindLong(parameterIndex++, conferenceId)
        }
    driver.execute(null, """DELETE FROM roomTable WHERE id ${ if (roomId == null) "IS" else "=" } ? AND conferenceId = ?""", 2) {
          var parameterIndex = 0
          bindLong(parameterIndex++, roomId)
          bindLong(parameterIndex++, conferenceId)
        }
  }.also {
    notifyQueries(248_515_992) { emit ->
      emit("roomTable")
      emit("sessionTable")
    }
  }

  private inner class SelectAllQuery<out T : Any>(
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("roomTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("roomTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_144_601_130, """SELECT roomTable.id, roomTable.conferenceId, roomTable.name FROM roomTable WHERE conferenceId = ?""", mapper, 1) {
      var parameterIndex = 0
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Room.sq:selectAll"
  }

  private inner class SelectByIdQuery<out T : Any>(
    public val id: Long,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("roomTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("roomTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_122_937_961, """SELECT roomTable.id, roomTable.conferenceId, roomTable.name FROM roomTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
      var parameterIndex = 0
      bindLong(parameterIndex++, id)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Room.sq:selectById"
  }

  private inner class ExistsByIdQuery<out T : Any>(
    public val id: Long,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("roomTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("roomTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_310_278_711, """SELECT count(1) FROM roomTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
      var parameterIndex = 0
      bindLong(parameterIndex++, id)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "Room.sq:existsById"
  }
}
