package co.touchlab.droidcon.db

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Long
import kotlin.String

public class SponsorRepresentativeQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> selectBySponsorId(
    sponsorName: String,
    sponsorGroupName: String,
    conferenceId: Long,
    mapper: (
      sponsorName: String,
      sponsorGroupName: String,
      representativeId: String,
      conferenceId: Long,
      displayOrder: Long,
    ) -> T,
  ): Query<T> = SelectBySponsorIdQuery(sponsorName, sponsorGroupName, conferenceId) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getLong(3)!!,
      cursor.getLong(4)!!
    )
  }

  public fun selectBySponsorId(
    sponsorName: String,
    sponsorGroupName: String,
    conferenceId: Long,
  ): Query<SponsorRepresentativeTable> = selectBySponsorId(sponsorName, sponsorGroupName, conferenceId, ::SponsorRepresentativeTable)

  /**
   * @return The number of rows updated.
   */
  public fun insertUpdate(
    sponsorName: String,
    sponsorGroupName: String,
    representativeId: String,
    conferenceId: Long,
    displayOrder: Long,
  ): QueryResult<Long> {
    val result = driver.execute(-1_918_102_539, """
        |INSERT OR REPLACE INTO sponsorRepresentativeTable(sponsorName, sponsorGroupName, representativeId, conferenceId, displayOrder)
        |VALUES (?,?,?,?,?)
        """.trimMargin(), 5) {
          var parameterIndex = 0
          bindString(parameterIndex++, sponsorName)
          bindString(parameterIndex++, sponsorGroupName)
          bindString(parameterIndex++, representativeId)
          bindLong(parameterIndex++, conferenceId)
          bindLong(parameterIndex++, displayOrder)
        }
    notifyQueries(-1_918_102_539) { emit ->
      emit("sponsorRepresentativeTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteBySponsorId(
    sponsorName: String,
    sponsorGroupName: String,
    conferenceId: Long,
  ): QueryResult<Long> {
    val result = driver.execute(1_942_852_960, """DELETE FROM sponsorRepresentativeTable WHERE sponsorName = ? AND sponsorGroupName = ? AND conferenceId = ?""", 3) {
          var parameterIndex = 0
          bindString(parameterIndex++, sponsorName)
          bindString(parameterIndex++, sponsorGroupName)
          bindLong(parameterIndex++, conferenceId)
        }
    notifyQueries(1_942_852_960) { emit ->
      emit("sponsorRepresentativeTable")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteAll(conferenceId: Long): QueryResult<Long> {
    val result = driver.execute(1_271_156_163, """DELETE FROM sponsorRepresentativeTable WHERE conferenceId = ?""", 1) {
          var parameterIndex = 0
          bindLong(parameterIndex++, conferenceId)
        }
    notifyQueries(1_271_156_163) { emit ->
      emit("sponsorRepresentativeTable")
    }
    return result
  }

  private inner class SelectBySponsorIdQuery<out T : Any>(
    public val sponsorName: String,
    public val sponsorGroupName: String,
    public val conferenceId: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("sponsorRepresentativeTable", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("sponsorRepresentativeTable", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-898_180_753, """SELECT sponsorRepresentativeTable.sponsorName, sponsorRepresentativeTable.sponsorGroupName, sponsorRepresentativeTable.representativeId, sponsorRepresentativeTable.conferenceId, sponsorRepresentativeTable.displayOrder FROM sponsorRepresentativeTable WHERE sponsorName = ? AND sponsorGroupName = ? AND conferenceId = ?""", mapper, 3) {
      var parameterIndex = 0
      bindString(parameterIndex++, sponsorName)
      bindString(parameterIndex++, sponsorGroupName)
      bindLong(parameterIndex++, conferenceId)
    }

    override fun toString(): String = "SponsorRepresentative.sq:selectBySponsorId"
  }
}
