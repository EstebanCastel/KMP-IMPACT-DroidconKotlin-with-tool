# detekt

## Metrics

* 236 number of properties

* 464 number of functions

* 161 number of classes

* 26 number of packages

* 96 number of kt files

## Complexity Report

* 5,448 lines of code (loc)

* 4,472 source lines of code (sloc)

* 3,261 logical lines of code (lloc)

* 147 comment lines of code (cloc)

* 563 cyclomatic complexity (mcc)

* 151 cognitive complexity

* 387 number of total code smells

* 3% comment source ratio

* 172 mcc per 1,000 lloc

* 118 code smells per 1,000 lloc

## Findings (387)

### complexity, CyclomaticComplexMethod (1)

Prefer splitting up complex methods into smaller, easier to test methods.

[Documentation](https://detekt.dev/docs/rules/complexity#cyclomaticcomplexmethod)

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:70:26
```
The function runSynchronization appears to be too complex based on Cyclomatic Complexity (complexity: 19). Defined complexity threshold for methods is set to '15'
```
```kotlin
67         private const val FEEDBACK_SYNC_DELAY: Long = 5L * 60L * 1000L
68     }
69 
70     override suspend fun runSynchronization(conference: Conference) {
!!                          ^ error
71         coroutineScope {
72             launch {
73                 var lastSessionizeSyncThisLoop: Instant = dateTimeService.now().minus(3, DateTimeUnit.HOUR)

```

### complexity, LongMethod (5)

One method should have one responsibility. Long methods tend to handle many things at once. Prefer smaller methods to make them easier to understand.

[Documentation](https://detekt.dev/docs/rules/complexity#longmethod)

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/shared/DroidconDatabaseImpl.kt:64:18
```
The function create is too long (114). The maximum length is 60.
```
```kotlin
61     override val version: Long
62       get() = 1
63 
64     override fun create(driver: SqlDriver): QueryResult.Value<Unit> {
!!                  ^ error
65       driver.execute(null, """
66           |CREATE TABLE conferenceTable(
67           |    id INTEGER PRIMARY KEY AUTOINCREMENT,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/application/service/impl/DefaultNotificationSchedulingService.kt:70:25
```
The function scheduleNotifications is too long (61). The maximum length is 60.
```
```kotlin
67         )
68     }
69 
70     private suspend fun scheduleNotifications(sessionFlow: Flow<List<Session>>, settingsFlow: Flow<Settings>) {
!!                         ^ error
71         sessionFlow
72             .combine(
73                 settingsFlow,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:70:26
```
The function runSynchronization is too long (97). The maximum length is 60.
```
```kotlin
67         private const val FEEDBACK_SYNC_DELAY: Long = 5L * 60L * 1000L
68     }
69 
70     override suspend fun runSynchronization(conference: Conference) {
!!                          ^ error
71         coroutineScope {
72             launch {
73                 var lastSessionizeSyncThisLoop: Instant = dateTimeService.now().minus(3, DateTimeUnit.HOUR)

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:211:26
```
The function syncConferences is too long (85). The maximum length is 60.
```
```kotlin
208     /**
209      * Synchronizes conference data from Firestore with the local database
210      */
211     override suspend fun syncConferences() {
!!!                          ^ error
212         log.d { "Syncing conferences from Firestore" }
213         try {
214             val apiDataSource = apiDataSource as? DefaultApiDataSource

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:334:17
```
The function updateScheduleFromDataSource is too long (90). The maximum length is 60.
```
```kotlin
331     private fun dateFromString(dateTimeString: String): String = dateTimeString.split("T")[0]
332     private fun timeFromString(dateTimeString: String): String = dateTimeString.split("T")[1]
333 
334     private fun updateScheduleFromDataSource(_days: List<ScheduleDto.DayDto>, conference: Conference) {
!!!                 ^ error
335         val originalToAdjustedDateMap = _days.flatMap { dayDto ->
336             dayDto.rooms.flatMap { roomDto -> roomDto.sessions }
337         }.map { sessionDto -> dateFromString(sessionDto.startsAt) }.toSet().toList().sorted().mapIndexed { index, date ->

```

### complexity, LongParameterList (13)

The more parameters a function has the more complex it is. Long parameter lists are often used to control complex algorithms and violate the Single Responsibility Principle. Prefer functions with short parameter lists.

[Documentation](https://detekt.dev/docs/rules/complexity#longparameterlist)

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:138:20
```
The function insert(conferenceName: String, conferenceTimeZone: TimeZone, projectId: String, collectionName: String, apiKey: String, scheduleId: String, selected: Boolean, active: Boolean, venueMap: String?) has too many parameters. The current threshold is set to 6.
```
```kotlin
135   /**
136    * @return The number of rows updated.
137    */
138   public fun insert(
!!!                    ^ error
139     conferenceName: String,
140     conferenceTimeZone: TimeZone,
141     projectId: String,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:173:30
```
The function updateConference(conferenceName: String, conferenceTimeZone: TimeZone, projectId: String, collectionName: String, apiKey: String, scheduleId: String, selected: Boolean, active: Boolean, venueMap: String?, id: Long) has too many parameters. The current threshold is set to 6.
```
```kotlin
170   /**
171    * @return The number of rows updated.
172    */
173   public fun updateConference(
!!!                              ^ error
174     conferenceName: String,
175     conferenceTimeZone: TimeZone,
176     projectId: String,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:143:20
```
The function upsert(id: String, conferenceId: Long, fullName: String, bio: String?, tagLine: String?, profilePicture: String?, twitter: String?, linkedIn: String?, website: String?) has too many parameters. The current threshold is set to 6.
```
```kotlin
140   /**
141    * @return The number of rows updated.
142    */
143   public fun upsert(
!!!                    ^ error
144     id: String,
145     conferenceId: Long,
146     fullName: String,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:271:20
```
The function upsert(id: String, conferenceId: Long, title: String, description: String?, startsAt: Instant, endsAt: Instant, serviceSession: Long, roomId: Long?, rsvp: Long?, rsvpSent: Long, feedbackRating: Int?, feedbackComment: String?, feedbackSent: Long) has too many parameters. The current threshold is set to 6.
```
```kotlin
268   /**
269    * @return The number of rows updated.
270    */
271   public fun upsert(
!!!                    ^ error
272     id: String,
273     conferenceId: Long,
274     title: String,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:106:20
```
The function upsert(name: String, groupName: String, conferenceId: Long, hasDetail: Boolean, description: String?, iconUrl: String, url: String) has too many parameters. The current threshold is set to 6.
```
```kotlin
103   /**
104    * @return The number of rows updated.
105    */
106   public fun upsert(
!!!                    ^ error
107     name: String,
108     groupName: String,
109     conferenceId: Long,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/application/service/impl/DefaultNotificationSchedulingService.kt:26:43
```
The constructor(sessionRepository: SessionRepository, roomRepository: RoomRepository, settingsRepository: SettingsRepository, notificationService: NotificationService, dateTimeService: DateTimeService, settings: ObservableSettings, json: Json, localizedStringFactory: NotificationSchedulingService.LocalizedStringFactory, conferenceConfigProvider: ConferenceConfigProvider) has too many parameters. The current threshold is set to 7.
```
```kotlin
23 import kotlinx.serialization.encodeToString
24 import kotlinx.serialization.json.Json
25 
26 class DefaultNotificationSchedulingService(
!!                                           ^ error
27     private val sessionRepository: SessionRepository,
28     private val roomRepository: RoomRepository,
29     private val settingsRepository: SettingsRepository,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/entity/Profile.kt:6:14
```
The constructor(id: Id, fullName: String, bio: String?, tagLine: String?, profilePicture: Url?, twitter: Url?, linkedIn: Url?, website: Url?) has too many parameters. The current threshold is set to 7.
```
```kotlin
3  import co.touchlab.droidcon.composite.Url
4  
5  // TODO: Add sponsors if desired.
6  class Profile(
!               ^ error
7      override val id: Id,
8      val fullName: String,
9      val bio: String?,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/entity/Session.kt:6:14
```
The constructor(dateTimeService: DateTimeService, id: Id, title: String, description: String?, startsAt: Instant, endsAt: Instant, isServiceSession: Boolean, room: Room.Id?, rsvp: RSVP, feedback: Feedback?) has too many parameters. The current threshold is set to 7.
```
```kotlin
3  import co.touchlab.droidcon.domain.service.DateTimeService
4  import kotlin.time.Instant
5  
6  class Session(
!               ^ error
7      private val dateTimeService: DateTimeService,
8      override val id: Id,
9      val title: String,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightConferenceRepository.kt:78:34
```
The function conferenceFactory(id: Long, conferenceName: String, conferenceTimeZone: kotlinx.datetime.TimeZone, projectId: String, collectionName: String, apiKey: String, scheduleId: String, selected: Boolean, active: Boolean, venueMap: String?) has too many parameters. The current threshold is set to 6.
```
```kotlin
75         return true
76     }
77 
78     private fun conferenceFactory(
!!                                  ^ error
79         id: Long,
80         conferenceName: String,
81         conferenceTimeZone: kotlinx.datetime.TimeZone,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightProfileRepository.kt:98:31
```
The function profileFactory(id: String, conferenceId: Long, fullName: String, bio: String?, tagLine: String?, profilePicture: String?, twitter: String?, linkedIn: String?, website: String?) has too many parameters. The current threshold is set to 6.
```
```kotlin
95      override fun contains(id: Profile.Id, conferenceId: Long): Boolean =
96          profileQueries.existsById(id.value, conferenceId).executeAsOne().toBoolean()
97  
98      private fun profileFactory(
!!                                ^ error
99          id: String,
100         conferenceId: Long,
101         fullName: String,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightSessionRepository.kt:83:31
```
The function sessionFactory(id: String, conferenceId: Long, title: String, description: String?, startsAt: Instant, endsAt: Instant, serviceSession: Long, rsvp: Long?, rsvpSent: Long, roomId: Long?, feedbackRating: Int?, feedbackComment: String?, feedbackSent: Long) has too many parameters. The current threshold is set to 6.
```
```kotlin
80     override fun contains(id: Session.Id, conferenceId: Long): Boolean =
81         sessionQueries.existsById(id.value, conferenceId).executeAsOne().toBoolean()
82 
83     private fun sessionFactory(
!!                               ^ error
84         id: String,
85         conferenceId: Long,
86         title: String,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightSponsorRepository.kt:53:31
```
The function sponsorFactory(name: String, groupName: String, conferenceId: Long, hasDetail: Boolean, description: String?, iconUrl: String, url: String) has too many parameters. The current threshold is set to 6.
```
```kotlin
50         sponsorQueries.deleteById(id.name, id.group, conferenceId)
51     }
52 
53     private fun sponsorFactory(
!!                               ^ error
54         name: String,
55         groupName: String,
56         conferenceId: Long,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:39:25
```
The constructor(log: Logger, dateTimeService: DateTimeService, profileRepository: ProfileRepository, sessionRepository: SessionRepository, roomRepository: RoomRepository, sponsorRepository: SponsorRepository, sponsorGroupRepository: SponsorGroupRepository, apiDataSource: DataSource, serverApi: ServerApi, db: DroidconDatabase, conferenceRepository: ConferenceRepository) has too many parameters. The current threshold is set to 7.
```
```kotlin
36 import kotlinx.datetime.minus
37 import kotlinx.datetime.plus
38 
39 class DefaultSyncService(
!!                         ^ error
40     private val log: Logger,
41     private val dateTimeService: DateTimeService,
42     private val profileRepository: ProfileRepository,

```

### complexity, NestedBlockDepth (1)

Excessive nesting leads to hidden complexity. Prefer extracting code to make it easier to understand.

[Documentation](https://detekt.dev/docs/rules/complexity#nestedblockdepth)

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:211:26
```
Function syncConferences is nested too deeply.
```
```kotlin
208     /**
209      * Synchronizes conference data from Firestore with the local database
210      */
211     override suspend fun syncConferences() {
!!!                          ^ error
212         log.d { "Syncing conferences from Firestore" }
213         try {
214             val apiDataSource = apiDataSource as? DefaultApiDataSource

```

### complexity, TooManyFunctions (8)

Too many functions inside a/an file/class/object/interface always indicate a violation of the single responsibility principle. Maybe the file/class/object/interface wants to manage too many things at once. Extract functionality which clearly belongs together.

[Documentation](https://detekt.dev/docs/rules/complexity#toomanyfunctions)

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:15:14
```
Class 'ConferenceQueries' with '15' functions detected. Defined threshold inside classes is set to '11'
```
```kotlin
12 import kotlin.String
13 import kotlinx.datetime.TimeZone
14 
15 public class ConferenceQueries(
!!              ^ error
16   driver: SqlDriver,
17   private val conferenceTableAdapter: ConferenceTable.Adapter,
18 ) : TransacterImpl(driver) {

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:12:14
```
Class 'ProfileQueries' with '11' functions detected. Defined threshold inside classes is set to '11'
```
```kotlin
9  import kotlin.Long
10 import kotlin.String
11 
12 public class ProfileQueries(
!!              ^ error
13   driver: SqlDriver,
14 ) : TransacterImpl(driver) {
15   public fun <T : Any> selectById(

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:14:14
```
Class 'SessionQueries' with '23' functions detected. Defined threshold inside classes is set to '11'
```
```kotlin
11 import kotlin.String
12 import kotlin.time.Instant
13 
14 public class SessionQueries(
!!              ^ error
15   driver: SqlDriver,
16   private val sessionTableAdapter: SessionTable.Adapter,
17 ) : TransacterImpl(driver) {

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/Repository.kt:6:11
```
Interface 'Repository' with '13' functions detected. Defined threshold inside interfaces is set to '11'
```
```kotlin
3  import co.touchlab.droidcon.domain.entity.DomainEntity
4  import kotlinx.coroutines.flow.Flow
5  
6  interface Repository<ID : Any, ENTITY : DomainEntity<ID>> {
!            ^ error
7      suspend fun get(id: ID, conferenceId: Long): ENTITY
8  
9      suspend fun find(id: ID, conferenceId: Long): ENTITY?

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/BaseRepository.kt:8:16
```
Class 'BaseRepository' with '13' functions detected. Defined threshold inside classes is set to '11'
```
```kotlin
5  import kotlinx.coroutines.flow.Flow
6  import kotlinx.coroutines.flow.first
7  
8  abstract class BaseRepository<ID : Any, ENTITY : DomainEntity<ID>> : Repository<ID, ENTITY> {
!                 ^ error
9      override suspend fun get(id: ID, conferenceId: Long): ENTITY = observe(id, conferenceId).first()
10 
11     override suspend fun find(id: ID, conferenceId: Long): ENTITY? = observeOrNull(id, conferenceId).first()

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightProfileRepository.kt:18:7
```
Class 'SqlDelightProfileRepository' with '12' functions detected. Defined threshold inside classes is set to '11'
```
```kotlin
15 import kotlinx.coroutines.Dispatchers
16 import kotlinx.coroutines.flow.Flow
17 
18 class SqlDelightProfileRepository(
!!       ^ error
19     private val profileQueries: ProfileQueries,
20     private val speakerQueries: SessionSpeakerQueries,
21     private val representativeQueries: SponsorRepresentativeQueries,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightSessionRepository.kt:17:7
```
Class 'SqlDelightSessionRepository' with '16' functions detected. Defined threshold inside classes is set to '11'
```
```kotlin
14 import kotlinx.coroutines.flow.Flow
15 import kotlinx.coroutines.flow.first
16 
17 class SqlDelightSessionRepository(private val dateTimeService: DateTimeService, private val sessionQueries: SessionQueries) :
!!       ^ error
18     BaseRepository<Session.Id, Session>(),
19     SessionRepository {
20     override fun observe(id: Session.Id, conferenceId: Long): Flow<Session> =

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:39:7
```
Class 'DefaultSyncService' with '11' functions detected. Defined threshold inside classes is set to '11'
```
```kotlin
36 import kotlinx.datetime.minus
37 import kotlinx.datetime.plus
38 
39 class DefaultSyncService(
!!       ^ error
40     private val log: Logger,
41     private val dateTimeService: DateTimeService,
42     private val profileRepository: ProfileRepository,

```

### exceptions, SwallowedException (1)

The caught exception is swallowed. The original exception could be lost.

[Documentation](https://detekt.dev/docs/rules/exceptions#swallowedexception)

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:86:38
```
The caught exception is swallowed. The original exception could be lost.
```
```kotlin
83                             try {
84                                 runApiDataSourcesSynchronization(conference)
85                                 lastSessionizeSyncThisLoop = dateTimeService.now()
86                             } catch (e: Exception) {
!!                                      ^ error
87                                 delay(SESSIONIZE_SYNC_POLL_DELAY)
88                                 continue
89                             }

```

### exceptions, TooGenericExceptionCaught (8)

The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.

[Documentation](https://detekt.dev/docs/rules/exceptions#toogenericexceptioncaught)

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightConferenceRepository.kt:30:18
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
27         try {
28             conferenceQueries.changeSelectedConference(conferenceId)
29             return true
30         } catch (e: Exception) {
!!                  ^ error
31             log.e(e) { "Error selecting conference" }
32             return false
33         }

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightConferenceRepository.kt:67:18
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
64                 venueMap = conference.venueMap,
65             )
66             return true
67         } catch (e: Exception) {
!!                  ^ error
68             log.e(e) { "Error updating conference" }
69             return false
70         }

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:86:38
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
83                             try {
84                                 runApiDataSourcesSynchronization(conference)
85                                 lastSessionizeSyncThisLoop = dateTimeService.now()
86                             } catch (e: Exception) {
!!                                      ^ error
87                                 delay(SESSIONIZE_SYNC_POLL_DELAY)
88                                 continue
89                             }

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:94:30
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
91                         } else {
92                             delay(SESSIONIZE_SYNC_POLL_DELAY)
93                         }
94                     } catch (e: Exception) {
!!                              ^ error
95                         log.w("DATASYNC runSynchronization exiting with $conference")
96                         throw e
97                     }

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:127:46
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
124                                             )
125                                         }
126                                         break
127                                     } catch (e: Exception) {
!!!                                              ^ error
128                                         log.w(e) { "Couldn't send RSVP." }
129                                         delay(RSVP_SYNC_DELAY)
130                                     }

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:161:46
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
158                                             )
159                                         }
160                                         break
161                                     } catch (e: Exception) {
!!!                                              ^ error
162                                         log.w(e) { "Couldn't send feedback." }
163                                         delay(FEEDBACK_SYNC_DELAY)
164                                     }

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:176:14
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
173         runApiDataSourcesSynchronization(conference)
174         syncConferences() // Also sync conferences when forced
175         true
176     } catch (e: Exception) {
!!!              ^ error
177         log.e(e) { "Failed to update repositories from API data source." }
178         false
179     }

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:311:18
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
308             }
309 
310             log.d { "Conference sync completed successfully" }
311         } catch (e: Exception) {
!!!                  ^ error
312             log.e(e) { "Error during conference sync" }
313             throw e
314         }

```

### naming, ConstructorParameterNaming (2)

Constructor parameter names should follow the naming convention set in the projects configuration.

[Documentation](https://detekt.dev/docs/rules/naming#constructorparameternaming)

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:594:5
```
Constructor parameter names should match the pattern: [a-z][A-Za-z0-9]*
```
```kotlin
591 
592   private inner class SessionWithRoomQuery<out T : Any>(
593     public val conferenceId: Long,
594     public val conferenceId_: Long,
!!!     ^ error
595     mapper: (SqlCursor) -> T,
596   ) : Query<T>(mapper) {
597     override fun addListener(listener: Query.Listener) {

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/entity/Conference.kt:6:5
```
Constructor private parameter names should match the pattern: [a-z][A-Za-z0-9]*
```
```kotlin
3  import kotlinx.datetime.TimeZone
4  
5  data class Conference(
6      private val _id: Long? = null,
!      ^ error
7      val name: String,
8      val timeZone: TimeZone,
9      val projectId: String,

```

### naming, FunctionParameterNaming (3)

Function parameter names should follow the naming convention set in the projects configuration.

[Documentation](https://detekt.dev/docs/rules/naming#functionparameternaming)

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:238:5
```
Function parameter names should match the pattern: [a-z][A-Za-z0-9]*
```
```kotlin
235 
236   public fun <T : Any> sessionWithRoom(
237     conferenceId: Long,
238     conferenceId_: Long,
!!!     ^ error
239     mapper: (
240       id: String,
241       title: String,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:266:50
```
Function parameter names should match the pattern: [a-z][A-Za-z0-9]*
```
```kotlin
263     )
264   }
265 
266   public fun sessionWithRoom(conferenceId: Long, conferenceId_: Long): Query<SessionWithRoom> = sessionWithRoom(conferenceId, conferenceId_, ::SessionWithRoom)
!!!                                                  ^ error
267 
268   /**
269    * @return The number of rows updated.

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:334:46
```
Function parameter names should match the pattern: [a-z][A-Za-z0-9]*
```
```kotlin
331     private fun dateFromString(dateTimeString: String): String = dateTimeString.split("T")[0]
332     private fun timeFromString(dateTimeString: String): String = dateTimeString.split("T")[1]
333 
334     private fun updateScheduleFromDataSource(_days: List<ScheduleDto.DayDto>, conference: Conference) {
!!!                                              ^ error
335         val originalToAdjustedDateMap = _days.flatMap { dayDto ->
336             dayDto.rooms.flatMap { roomDto -> roomDto.sessions }
337         }.map { sessionDto -> dateFromString(sessionDto.startsAt) }.toSet().toList().sorted().mapIndexed { index, date ->

```

### style, ForbiddenComment (3)

Flags a forbidden comment.

[Documentation](https://detekt.dev/docs/rules/style#forbiddencomment)

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/entity/Profile.kt:5:1
```
Forbidden TODO todo marker in comment, please do the changes.
```
```kotlin
2 
3 import co.touchlab.droidcon.composite.Url
4 
5 // TODO: Add sponsors if desired.
! ^ error
6 class Profile(
7     override val id: Id,
8     val fullName: String,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/BaseRepository.kt:21:13
```
Forbidden TODO todo marker in comment, please do the changes.
```
```kotlin
18         if (!contains(entity.id, conferenceId)) {
19             doUpsert(entity, conferenceId)
20         } else {
21             // TODO: Throw custom repository exception
!!             ^ error
22             error("Can't insert entity: $entity which already exist in the database.")
23         }
24     }

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/BaseRepository.kt:40:13
```
Forbidden TODO todo marker in comment, please do the changes.
```
```kotlin
37         if (contains(entity.id, conferenceId)) {
38             doUpsert(entity, conferenceId)
39         } else {
40             // TODO: Throw custom repository exception
!!             ^ error
41             error("Can't update entity: $entity which doesn't exist in the database.")
42         }
43     }

```

### style, MagicNumber (246)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence it's unclear what the purpose of this number is. It's better to declare such numbers as constants and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:30:30
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
27     selected: Boolean,
28     active: Boolean,
29     venueMap: String?,
30   ) -> T): Query<T> = Query(-1_395_907_319, arrayOf("conferenceTable"), driver, "Conference.sq", "selectAll", "SELECT conferenceTable.id, conferenceTable.conferenceName, conferenceTable.conferenceTimeZone, conferenceTable.projectId, conferenceTable.collectionName, conferenceTable.apiKey, conferenceTable.scheduleId, conferenceTable.selected, conferenceTable.active, conferenceTable.venueMap FROM conferenceTable") { cursor ->
!!                              ^ error
31     mapper(
32       cursor.getLong(0)!!,
33       cursor.getString(1)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:35:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
32       cursor.getLong(0)!!,
33       cursor.getString(1)!!,
34       conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
35       cursor.getString(3)!!,
!!                        ^ error
36       cursor.getString(4)!!,
37       cursor.getString(5)!!,
38       cursor.getString(6)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:36:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
33       cursor.getString(1)!!,
34       conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
35       cursor.getString(3)!!,
36       cursor.getString(4)!!,
!!                        ^ error
37       cursor.getString(5)!!,
38       cursor.getString(6)!!,
39       cursor.getBoolean(7)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:37:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
34       conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
35       cursor.getString(3)!!,
36       cursor.getString(4)!!,
37       cursor.getString(5)!!,
!!                        ^ error
38       cursor.getString(6)!!,
39       cursor.getBoolean(7)!!,
40       cursor.getBoolean(8)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:38:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
35       cursor.getString(3)!!,
36       cursor.getString(4)!!,
37       cursor.getString(5)!!,
38       cursor.getString(6)!!,
!!                        ^ error
39       cursor.getBoolean(7)!!,
40       cursor.getBoolean(8)!!,
41       cursor.getString(9)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:39:25
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
36       cursor.getString(4)!!,
37       cursor.getString(5)!!,
38       cursor.getString(6)!!,
39       cursor.getBoolean(7)!!,
!!                         ^ error
40       cursor.getBoolean(8)!!,
41       cursor.getString(9)
42     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:40:25
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
37       cursor.getString(5)!!,
38       cursor.getString(6)!!,
39       cursor.getBoolean(7)!!,
40       cursor.getBoolean(8)!!,
!!                         ^ error
41       cursor.getString(9)
42     )
43   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:41:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
38       cursor.getString(6)!!,
39       cursor.getBoolean(7)!!,
40       cursor.getBoolean(8)!!,
41       cursor.getString(9)
!!                        ^ error
42     )
43   }
44 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:58:29
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
55     selected: Boolean,
56     active: Boolean,
57     venueMap: String?,
58   ) -> T): Query<T> = Query(2_064_180_591, arrayOf("conferenceTable"), driver, "Conference.sq", "selectAllActive", "SELECT conferenceTable.id, conferenceTable.conferenceName, conferenceTable.conferenceTimeZone, conferenceTable.projectId, conferenceTable.collectionName, conferenceTable.apiKey, conferenceTable.scheduleId, conferenceTable.selected, conferenceTable.active, conferenceTable.venueMap FROM conferenceTable WHERE active = 1") { cursor ->
!!                             ^ error
59     mapper(
60       cursor.getLong(0)!!,
61       cursor.getString(1)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:63:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
60       cursor.getLong(0)!!,
61       cursor.getString(1)!!,
62       conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
63       cursor.getString(3)!!,
!!                        ^ error
64       cursor.getString(4)!!,
65       cursor.getString(5)!!,
66       cursor.getString(6)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:64:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
61       cursor.getString(1)!!,
62       conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
63       cursor.getString(3)!!,
64       cursor.getString(4)!!,
!!                        ^ error
65       cursor.getString(5)!!,
66       cursor.getString(6)!!,
67       cursor.getBoolean(7)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:65:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
62       conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
63       cursor.getString(3)!!,
64       cursor.getString(4)!!,
65       cursor.getString(5)!!,
!!                        ^ error
66       cursor.getString(6)!!,
67       cursor.getBoolean(7)!!,
68       cursor.getBoolean(8)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:66:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
63       cursor.getString(3)!!,
64       cursor.getString(4)!!,
65       cursor.getString(5)!!,
66       cursor.getString(6)!!,
!!                        ^ error
67       cursor.getBoolean(7)!!,
68       cursor.getBoolean(8)!!,
69       cursor.getString(9)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:67:25
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
64       cursor.getString(4)!!,
65       cursor.getString(5)!!,
66       cursor.getString(6)!!,
67       cursor.getBoolean(7)!!,
!!                         ^ error
68       cursor.getBoolean(8)!!,
69       cursor.getString(9)
70     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:68:25
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
65       cursor.getString(5)!!,
66       cursor.getString(6)!!,
67       cursor.getBoolean(7)!!,
68       cursor.getBoolean(8)!!,
!!                         ^ error
69       cursor.getString(9)
70     )
71   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:69:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
66       cursor.getString(6)!!,
67       cursor.getBoolean(7)!!,
68       cursor.getBoolean(8)!!,
69       cursor.getString(9)
!!                        ^ error
70     )
71   }
72 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:91:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
88       cursor.getLong(0)!!,
89       cursor.getString(1)!!,
90       conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
91       cursor.getString(3)!!,
!!                        ^ error
92       cursor.getString(4)!!,
93       cursor.getString(5)!!,
94       cursor.getString(6)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:92:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
89       cursor.getString(1)!!,
90       conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
91       cursor.getString(3)!!,
92       cursor.getString(4)!!,
!!                        ^ error
93       cursor.getString(5)!!,
94       cursor.getString(6)!!,
95       cursor.getBoolean(7)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:93:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
90       conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
91       cursor.getString(3)!!,
92       cursor.getString(4)!!,
93       cursor.getString(5)!!,
!!                        ^ error
94       cursor.getString(6)!!,
95       cursor.getBoolean(7)!!,
96       cursor.getBoolean(8)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:94:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
91       cursor.getString(3)!!,
92       cursor.getString(4)!!,
93       cursor.getString(5)!!,
94       cursor.getString(6)!!,
!!                        ^ error
95       cursor.getBoolean(7)!!,
96       cursor.getBoolean(8)!!,
97       cursor.getString(9)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:95:25
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
92       cursor.getString(4)!!,
93       cursor.getString(5)!!,
94       cursor.getString(6)!!,
95       cursor.getBoolean(7)!!,
!!                         ^ error
96       cursor.getBoolean(8)!!,
97       cursor.getString(9)
98     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:96:25
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
93        cursor.getString(5)!!,
94        cursor.getString(6)!!,
95        cursor.getBoolean(7)!!,
96        cursor.getBoolean(8)!!,
!!                          ^ error
97        cursor.getString(9)
98      )
99    }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:97:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
94        cursor.getString(6)!!,
95        cursor.getBoolean(7)!!,
96        cursor.getBoolean(8)!!,
97        cursor.getString(9)
!!                         ^ error
98      )
99    }
100 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:114:30
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
111     selected: Boolean,
112     active: Boolean,
113     venueMap: String?,
114   ) -> T): Query<T> = Query(-2_035_931_085, arrayOf("conferenceTable"), driver, "Conference.sq", "selectSelected", "SELECT conferenceTable.id, conferenceTable.conferenceName, conferenceTable.conferenceTimeZone, conferenceTable.projectId, conferenceTable.collectionName, conferenceTable.apiKey, conferenceTable.scheduleId, conferenceTable.selected, conferenceTable.active, conferenceTable.venueMap FROM conferenceTable WHERE selected = 1 LIMIT 1") { cursor ->
!!!                              ^ error
115     mapper(
116       cursor.getLong(0)!!,
117       cursor.getString(1)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:119:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
116       cursor.getLong(0)!!,
117       cursor.getString(1)!!,
118       conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
119       cursor.getString(3)!!,
!!!                        ^ error
120       cursor.getString(4)!!,
121       cursor.getString(5)!!,
122       cursor.getString(6)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:120:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
117       cursor.getString(1)!!,
118       conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
119       cursor.getString(3)!!,
120       cursor.getString(4)!!,
!!!                        ^ error
121       cursor.getString(5)!!,
122       cursor.getString(6)!!,
123       cursor.getBoolean(7)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:121:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
118       conferenceTableAdapter.conferenceTimeZoneAdapter.decode(cursor.getString(2)!!),
119       cursor.getString(3)!!,
120       cursor.getString(4)!!,
121       cursor.getString(5)!!,
!!!                        ^ error
122       cursor.getString(6)!!,
123       cursor.getBoolean(7)!!,
124       cursor.getBoolean(8)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:122:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
119       cursor.getString(3)!!,
120       cursor.getString(4)!!,
121       cursor.getString(5)!!,
122       cursor.getString(6)!!,
!!!                        ^ error
123       cursor.getBoolean(7)!!,
124       cursor.getBoolean(8)!!,
125       cursor.getString(9)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:123:25
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
120       cursor.getString(4)!!,
121       cursor.getString(5)!!,
122       cursor.getString(6)!!,
123       cursor.getBoolean(7)!!,
!!!                         ^ error
124       cursor.getBoolean(8)!!,
125       cursor.getString(9)
126     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:124:25
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
121       cursor.getString(5)!!,
122       cursor.getString(6)!!,
123       cursor.getBoolean(7)!!,
124       cursor.getBoolean(8)!!,
!!!                         ^ error
125       cursor.getString(9)
126     )
127   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:125:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
122       cursor.getString(6)!!,
123       cursor.getBoolean(7)!!,
124       cursor.getBoolean(8)!!,
125       cursor.getString(9)
!!!                        ^ error
126     )
127   }
128 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:131:63
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
128 
129   public fun selectSelected(): Query<ConferenceTable> = selectSelected(::ConferenceTable)
130 
131   public fun lastInsertRowId(): ExecutableQuery<Long> = Query(1_347_239_914, driver, "Conference.sq", "lastInsertRowId", "SELECT last_insert_rowid()") { cursor ->
!!!                                                               ^ error
132     cursor.getLong(0)!!
133   }
134 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:149:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
146     active: Boolean,
147     venueMap: String?,
148   ): QueryResult<Long> {
149     val result = driver.execute(435_967_797, """
!!!                                 ^ error
150         |INSERT INTO conferenceTable(conferenceName, conferenceTimeZone, projectId, collectionName, apiKey, scheduleId, selected, active, venueMap)
151         |VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
152         """.trimMargin(), 9) {

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:152:27
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
149     val result = driver.execute(435_967_797, """
150         |INSERT INTO conferenceTable(conferenceName, conferenceTimeZone, projectId, collectionName, apiKey, scheduleId, selected, active, venueMap)
151         |VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
152         """.trimMargin(), 9) {
!!!                           ^ error
153           var parameterIndex = 0
154           bindString(parameterIndex++, conferenceName)
155           bindString(parameterIndex++, conferenceTableAdapter.conferenceTimeZoneAdapter.encode(conferenceTimeZone))

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:164:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
161           bindBoolean(parameterIndex++, active)
162           bindString(parameterIndex++, venueMap)
163         }
164     notifyQueries(435_967_797) { emit ->
!!!                   ^ error
165       emit("conferenceTable")
166     }
167     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:185:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
182     venueMap: String?,
183     id: Long,
184   ): QueryResult<Long> {
185     val result = driver.execute(-1_547_379_647, """
!!!                                  ^ error
186         |UPDATE conferenceTable
187         |SET conferenceName = ?, conferenceTimeZone = ?, projectId = ?, collectionName = ?, apiKey = ?, scheduleId = ?, selected = ?, active = ?, venueMap = ?
188         |WHERE id = ?

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:189:27
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
186         |UPDATE conferenceTable
187         |SET conferenceName = ?, conferenceTimeZone = ?, projectId = ?, collectionName = ?, apiKey = ?, scheduleId = ?, selected = ?, active = ?, venueMap = ?
188         |WHERE id = ?
189         """.trimMargin(), 10) {
!!!                           ^ error
190           var parameterIndex = 0
191           bindString(parameterIndex++, conferenceName)
192           bindString(parameterIndex++, conferenceTableAdapter.conferenceTimeZoneAdapter.encode(conferenceTimeZone))

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:202:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
199           bindString(parameterIndex++, venueMap)
200           bindLong(parameterIndex++, id)
201         }
202     notifyQueries(-1_547_379_647) { emit ->
!!!                    ^ error
203       emit("conferenceTable")
204     }
205     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:212:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
209    * @return The number of rows updated.
210    */
211   public fun deleteById(id: Long): QueryResult<Long> {
212     val result = driver.execute(-1_197_834_599, """DELETE FROM conferenceTable WHERE id = ?""", 1) {
!!!                                  ^ error
213           var parameterIndex = 0
214           bindLong(parameterIndex++, id)
215         }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:216:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
213           var parameterIndex = 0
214           bindLong(parameterIndex++, id)
215         }
216     notifyQueries(-1_197_834_599) { emit ->
!!!                    ^ error
217       emit("conferenceTable")
218     }
219     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:226:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
223    * @return The number of rows updated.
224    */
225   public fun updateSelected(): QueryResult<Long> {
226     val result = driver.execute(-2_118_054_144, """
!!!                                  ^ error
227         |UPDATE conferenceTable
228         |SET selected = 0
229         |WHERE selected = 1

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:231:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
228         |SET selected = 0
229         |WHERE selected = 1
230         """.trimMargin(), 0)
231     notifyQueries(-2_118_054_144) { emit ->
!!!                    ^ error
232       emit("conferenceTable")
233     }
234     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:241:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
238    * @return The number of rows updated.
239    */
240   public fun setSelected(id: Long): QueryResult<Long> {
241     val result = driver.execute(1_556_245_025, """
!!!                                 ^ error
242         |UPDATE conferenceTable
243         |SET selected = 1
244         |WHERE id = ?

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:249:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
246           var parameterIndex = 0
247           bindLong(parameterIndex++, id)
248         }
249     notifyQueries(1_556_245_025) { emit ->
!!!                   ^ error
250       emit("conferenceTable")
251     }
252     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:259:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
256    * @return The number of rows updated.
257    */
258   public fun changeSelectedConference(conferenceId: Long): QueryResult<Long> = transactionWithResult {
259     driver.execute(687_586_900, """UPDATE conferenceTable SET selected = 0 WHERE selected = 1""", 0)
!!!                    ^ error
260     driver.execute(687_586_901, """UPDATE conferenceTable SET selected = 1 WHERE id = ?""", 1) {
261           var parameterIndex = 0
262           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:260:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
257    */
258   public fun changeSelectedConference(conferenceId: Long): QueryResult<Long> = transactionWithResult {
259     driver.execute(687_586_900, """UPDATE conferenceTable SET selected = 0 WHERE selected = 1""", 0)
260     driver.execute(687_586_901, """UPDATE conferenceTable SET selected = 1 WHERE id = ?""", 1) {
!!!                    ^ error
261           var parameterIndex = 0
262           bindLong(parameterIndex++, conferenceId)
263         }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:265:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
262           bindLong(parameterIndex++, conferenceId)
263         }
264   }.also {
265     notifyQueries(1_350_434_659) { emit ->
!!!                   ^ error
266       emit("conferenceTable")
267     }
268   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:282:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
279       driver.removeListener("conferenceTable", listener = listener)
280     }
281 
282     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-323_412_630, """SELECT conferenceTable.id, conferenceTable.conferenceName, conferenceTable.conferenceTimeZone, conferenceTable.projectId, conferenceTable.collectionName, conferenceTable.apiKey, conferenceTable.scheduleId, conferenceTable.selected, conferenceTable.active, conferenceTable.venueMap FROM conferenceTable WHERE id = ?""", mapper, 1) {
!!!                                                                                                            ^ error
283       var parameterIndex = 0
284       bindLong(parameterIndex++, id)
285     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:34:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
31       cursor.getString(0)!!,
32       cursor.getLong(1)!!,
33       cursor.getString(2)!!,
34       cursor.getString(3),
!!                        ^ error
35       cursor.getString(4),
36       cursor.getString(5),
37       cursor.getString(6),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:35:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
32       cursor.getLong(1)!!,
33       cursor.getString(2)!!,
34       cursor.getString(3),
35       cursor.getString(4),
!!                        ^ error
36       cursor.getString(5),
37       cursor.getString(6),
38       cursor.getString(7),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:36:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
33       cursor.getString(2)!!,
34       cursor.getString(3),
35       cursor.getString(4),
36       cursor.getString(5),
!!                        ^ error
37       cursor.getString(6),
38       cursor.getString(7),
39       cursor.getString(8)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:37:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
34       cursor.getString(3),
35       cursor.getString(4),
36       cursor.getString(5),
37       cursor.getString(6),
!!                        ^ error
38       cursor.getString(7),
39       cursor.getString(8)
40     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:38:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
35       cursor.getString(4),
36       cursor.getString(5),
37       cursor.getString(6),
38       cursor.getString(7),
!!                        ^ error
39       cursor.getString(8)
40     )
41   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:39:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
36       cursor.getString(5),
37       cursor.getString(6),
38       cursor.getString(7),
39       cursor.getString(8)
!!                        ^ error
40     )
41   }
42 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:68:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
65       cursor.getString(0)!!,
66       cursor.getLong(1)!!,
67       cursor.getString(2)!!,
68       cursor.getString(3),
!!                        ^ error
69       cursor.getString(4),
70       cursor.getString(5),
71       cursor.getString(6),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:69:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
66       cursor.getLong(1)!!,
67       cursor.getString(2)!!,
68       cursor.getString(3),
69       cursor.getString(4),
!!                        ^ error
70       cursor.getString(5),
71       cursor.getString(6),
72       cursor.getString(7),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:70:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
67       cursor.getString(2)!!,
68       cursor.getString(3),
69       cursor.getString(4),
70       cursor.getString(5),
!!                        ^ error
71       cursor.getString(6),
72       cursor.getString(7),
73       cursor.getString(8)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:71:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
68       cursor.getString(3),
69       cursor.getString(4),
70       cursor.getString(5),
71       cursor.getString(6),
!!                        ^ error
72       cursor.getString(7),
73       cursor.getString(8)
74     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:72:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
69       cursor.getString(4),
70       cursor.getString(5),
71       cursor.getString(6),
72       cursor.getString(7),
!!                        ^ error
73       cursor.getString(8)
74     )
75   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:73:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
70       cursor.getString(5),
71       cursor.getString(6),
72       cursor.getString(7),
73       cursor.getString(8)
!!                        ^ error
74     )
75   }
76 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:99:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
96        cursor.getString(0)!!,
97        cursor.getLong(1)!!,
98        cursor.getString(2)!!,
99        cursor.getString(3),
!!                         ^ error
100       cursor.getString(4),
101       cursor.getString(5),
102       cursor.getString(6),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:100:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
97        cursor.getLong(1)!!,
98        cursor.getString(2)!!,
99        cursor.getString(3),
100       cursor.getString(4),
!!!                        ^ error
101       cursor.getString(5),
102       cursor.getString(6),
103       cursor.getString(7),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:101:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
98        cursor.getString(2)!!,
99        cursor.getString(3),
100       cursor.getString(4),
101       cursor.getString(5),
!!!                        ^ error
102       cursor.getString(6),
103       cursor.getString(7),
104       cursor.getString(8)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:102:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
99        cursor.getString(3),
100       cursor.getString(4),
101       cursor.getString(5),
102       cursor.getString(6),
!!!                        ^ error
103       cursor.getString(7),
104       cursor.getString(8)
105     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:103:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
100       cursor.getString(4),
101       cursor.getString(5),
102       cursor.getString(6),
103       cursor.getString(7),
!!!                        ^ error
104       cursor.getString(8)
105     )
106   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:104:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
101       cursor.getString(5),
102       cursor.getString(6),
103       cursor.getString(7),
104       cursor.getString(8)
!!!                        ^ error
105     )
106   }
107 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:129:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
126       cursor.getString(0)!!,
127       cursor.getLong(1)!!,
128       cursor.getString(2)!!,
129       cursor.getString(3),
!!!                        ^ error
130       cursor.getString(4),
131       cursor.getString(5),
132       cursor.getString(6),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:130:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
127       cursor.getLong(1)!!,
128       cursor.getString(2)!!,
129       cursor.getString(3),
130       cursor.getString(4),
!!!                        ^ error
131       cursor.getString(5),
132       cursor.getString(6),
133       cursor.getString(7),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:131:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
128       cursor.getString(2)!!,
129       cursor.getString(3),
130       cursor.getString(4),
131       cursor.getString(5),
!!!                        ^ error
132       cursor.getString(6),
133       cursor.getString(7),
134       cursor.getString(8)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:132:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
129       cursor.getString(3),
130       cursor.getString(4),
131       cursor.getString(5),
132       cursor.getString(6),
!!!                        ^ error
133       cursor.getString(7),
134       cursor.getString(8)
135     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:133:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
130       cursor.getString(4),
131       cursor.getString(5),
132       cursor.getString(6),
133       cursor.getString(7),
!!!                        ^ error
134       cursor.getString(8)
135     )
136   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:134:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
131       cursor.getString(5),
132       cursor.getString(6),
133       cursor.getString(7),
134       cursor.getString(8)
!!!                        ^ error
135     )
136   }
137 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:154:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
151     linkedIn: String?,
152     website: String?,
153   ): QueryResult<Long> {
154     val result = driver.execute(340_997_844, """
!!!                                 ^ error
155         |INSERT OR REPLACE INTO profileTable(id, conferenceId, fullName, bio, tagLine, profilePicture, twitter, linkedIn, website)
156         |VALUES(?,?,?,?,?,?,?,?,?)
157         """.trimMargin(), 9) {

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:157:27
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
154     val result = driver.execute(340_997_844, """
155         |INSERT OR REPLACE INTO profileTable(id, conferenceId, fullName, bio, tagLine, profilePicture, twitter, linkedIn, website)
156         |VALUES(?,?,?,?,?,?,?,?,?)
157         """.trimMargin(), 9) {
!!!                           ^ error
158           var parameterIndex = 0
159           bindString(parameterIndex++, id)
160           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:169:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
166           bindString(parameterIndex++, linkedIn)
167           bindString(parameterIndex++, website)
168         }
169     notifyQueries(340_997_844) { emit ->
!!!                   ^ error
170       emit("profileTable")
171     }
172     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:179:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
176    * @return The number of rows updated.
177    */
178   public fun delete(speakerId: String, conferenceId: Long): QueryResult<Long> = transactionWithResult {
179     driver.execute(345_447_169, """DELETE FROM sessionSpeakerTable WHERE speakerId = ?""", 1) {
!!!                    ^ error
180           var parameterIndex = 0
181           bindString(parameterIndex++, speakerId)
182         }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:183:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
180           var parameterIndex = 0
181           bindString(parameterIndex++, speakerId)
182         }
183     driver.execute(345_447_170, """DELETE FROM profileTable WHERE id = ? AND conferenceId = ?""", 2) {
!!!                    ^ error
184           var parameterIndex = 0
185           bindString(parameterIndex++, speakerId)
186           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:189:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
186           bindLong(parameterIndex++, conferenceId)
187         }
188   }.also {
189     notifyQueries(-156_064_944) { emit ->
!!!                    ^ error
190       emit("profileTable")
191       emit("sessionSpeakerTable")
192     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:208:107
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
205       driver.removeListener("profileTable", listener = listener)
206     }
207 
208     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(2_135_878_163, """SELECT profileTable.id, profileTable.conferenceId, profileTable.fullName, profileTable.bio, profileTable.tagLine, profileTable.profilePicture, profileTable.twitter, profileTable.linkedIn, profileTable.website FROM profileTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
!!!                                                                                                           ^ error
209       var parameterIndex = 0
210       bindString(parameterIndex++, id)
211       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:230:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
227       driver.removeListener("profileTable", listener = listener)
228     }
229 
230     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-297_338_509, """SELECT count(1) FROM profileTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
!!!                                                                                                            ^ error
231       var parameterIndex = 0
232       bindString(parameterIndex++, id)
233       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:252:107
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
249       driver.removeListener("profileTable", "sessionSpeakerTable", listener = listener)
250     }
251 
252     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_763_508_382, """
!!!                                                                                                           ^ error
253     |SELECT profileTable.id, profileTable.conferenceId, profileTable.fullName, profileTable.bio, profileTable.tagLine, profileTable.profilePicture, profileTable.twitter, profileTable.linkedIn, profileTable.website
254     |FROM profileTable
255     |JOIN sessionSpeakerTable ON sessionSpeakerTable.speakerId = id AND sessionSpeakerTable.conferenceId = profileTable.conferenceId

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:281:107
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
278       driver.removeListener("profileTable", "sponsorRepresentativeTable", listener = listener)
279     }
280 
281     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(2_074_595_618, """
!!!                                                                                                           ^ error
282     |SELECT profileTable.id, profileTable.conferenceId, profileTable.fullName, profileTable.bio, profileTable.tagLine, profileTable.profilePicture, profileTable.twitter, profileTable.linkedIn, profileTable.website
283     |FROM profileTable
284     |JOIN sponsorRepresentativeTable ON sponsorRepresentativeTable.representativeId = id AND sponsorRepresentativeTable.conferenceId = profileTable.conferenceId

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:287:31
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
284     |JOIN sponsorRepresentativeTable ON sponsorRepresentativeTable.representativeId = id AND sponsorRepresentativeTable.conferenceId = profileTable.conferenceId
285     |WHERE sponsorRepresentativeTable.sponsorName = ? AND sponsorRepresentativeTable.sponsorGroupName = ? AND profileTable.conferenceId = ?
286     |ORDER BY sponsorRepresentativeTable.displayOrder
287     """.trimMargin(), mapper, 3) {
!!!                               ^ error
288       var parameterIndex = 0
289       bindString(parameterIndex++, sponsorName)
290       bindString(parameterIndex++, sponsorGroupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:309:107
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
306       driver.removeListener("profileTable", listener = listener)
307     }
308 
309     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(761_634_624, """
!!!                                                                                                           ^ error
310     |SELECT profileTable.id, profileTable.conferenceId, profileTable.fullName, profileTable.bio, profileTable.tagLine, profileTable.profilePicture, profileTable.twitter, profileTable.linkedIn, profileTable.website
311     |FROM profileTable
312     |WHERE conferenceId = ?

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/RoomQueries.kt:59:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
56     conferenceId: Long,
57     name: String,
58   ): QueryResult<Long> {
59     val result = driver.execute(-240_282_582, """INSERT OR REPLACE INTO roomTable(id, conferenceId, name) VALUES(?,?,?)""", 3) {
!!                                  ^ error
60           var parameterIndex = 0
61           bindLong(parameterIndex++, id)
62           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/RoomQueries.kt:59:125
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
56     conferenceId: Long,
57     name: String,
58   ): QueryResult<Long> {
59     val result = driver.execute(-240_282_582, """INSERT OR REPLACE INTO roomTable(id, conferenceId, name) VALUES(?,?,?)""", 3) {
!!                                                                                                                             ^ error
60           var parameterIndex = 0
61           bindLong(parameterIndex++, id)
62           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/RoomQueries.kt:65:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
62           bindLong(parameterIndex++, conferenceId)
63           bindString(parameterIndex++, name)
64         }
65     notifyQueries(-240_282_582) { emit ->
!!                    ^ error
66       emit("roomTable")
67     }
68     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/RoomQueries.kt:86:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
83           bindLong(parameterIndex++, conferenceId)
84         }
85   }.also {
86     notifyQueries(248_515_992) { emit ->
!!                   ^ error
87       emit("roomTable")
88       emit("sessionTable")
89     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/RoomQueries.kt:104:107
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
101       driver.removeListener("roomTable", listener = listener)
102     }
103 
104     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_144_601_130, """SELECT roomTable.id, roomTable.conferenceId, roomTable.name FROM roomTable WHERE conferenceId = ?""", mapper, 1) {
!!!                                                                                                           ^ error
105       var parameterIndex = 0
106       bindLong(parameterIndex++, conferenceId)
107     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/RoomQueries.kt:125:107
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
122       driver.removeListener("roomTable", listener = listener)
123     }
124 
125     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_122_937_961, """SELECT roomTable.id, roomTable.conferenceId, roomTable.name FROM roomTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
!!!                                                                                                           ^ error
126       var parameterIndex = 0
127       bindLong(parameterIndex++, id)
128       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/RoomQueries.kt:147:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
144       driver.removeListener("roomTable", listener = listener)
145     }
146 
147     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_310_278_711, """SELECT count(1) FROM roomTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
!!!                                                                                                            ^ error
148       var parameterIndex = 0
149       bindLong(parameterIndex++, id)
150       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:37:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
34       cursor.getString(0)!!,
35       cursor.getLong(1)!!,
36       cursor.getString(2)!!,
37       cursor.getString(3),
!!                        ^ error
38       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
39       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
40       cursor.getLong(6)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:38:65
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
35       cursor.getLong(1)!!,
36       cursor.getString(2)!!,
37       cursor.getString(3),
38       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
!!                                                                 ^ error
39       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
40       cursor.getLong(6)!!,
41       cursor.getLong(7),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:39:63
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
36       cursor.getString(2)!!,
37       cursor.getString(3),
38       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
39       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
!!                                                               ^ error
40       cursor.getLong(6)!!,
41       cursor.getLong(7),
42       cursor.getLong(8)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:40:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
37       cursor.getString(3),
38       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
39       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
40       cursor.getLong(6)!!,
!!                      ^ error
41       cursor.getLong(7),
42       cursor.getLong(8)!!,
43       cursor.getLong(9),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:41:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
38       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
39       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
40       cursor.getLong(6)!!,
41       cursor.getLong(7),
!!                      ^ error
42       cursor.getLong(8)!!,
43       cursor.getLong(9),
44       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:42:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
39       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
40       cursor.getLong(6)!!,
41       cursor.getLong(7),
42       cursor.getLong(8)!!,
!!                      ^ error
43       cursor.getLong(9),
44       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
45       cursor.getString(11),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:43:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
40       cursor.getLong(6)!!,
41       cursor.getLong(7),
42       cursor.getLong(8)!!,
43       cursor.getLong(9),
!!                      ^ error
44       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
45       cursor.getString(11),
46       cursor.getLong(12)!!

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:44:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
41       cursor.getLong(7),
42       cursor.getLong(8)!!,
43       cursor.getLong(9),
44       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
!!                      ^ error
45       cursor.getString(11),
46       cursor.getLong(12)!!
47     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:45:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
42       cursor.getLong(8)!!,
43       cursor.getLong(9),
44       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
45       cursor.getString(11),
!!                        ^ error
46       cursor.getLong(12)!!
47     )
48   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:46:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
43       cursor.getLong(9),
44       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
45       cursor.getString(11),
46       cursor.getLong(12)!!
!!                      ^ error
47     )
48   }
49 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:71:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
68       cursor.getString(0)!!,
69       cursor.getLong(1)!!,
70       cursor.getString(2)!!,
71       cursor.getString(3),
!!                        ^ error
72       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
73       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
74       cursor.getLong(6)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:72:65
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
69       cursor.getLong(1)!!,
70       cursor.getString(2)!!,
71       cursor.getString(3),
72       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
!!                                                                 ^ error
73       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
74       cursor.getLong(6)!!,
75       cursor.getLong(7),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:73:63
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
70       cursor.getString(2)!!,
71       cursor.getString(3),
72       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
73       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
!!                                                               ^ error
74       cursor.getLong(6)!!,
75       cursor.getLong(7),
76       cursor.getLong(8)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:74:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
71       cursor.getString(3),
72       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
73       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
74       cursor.getLong(6)!!,
!!                      ^ error
75       cursor.getLong(7),
76       cursor.getLong(8)!!,
77       cursor.getLong(9),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:75:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
72       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
73       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
74       cursor.getLong(6)!!,
75       cursor.getLong(7),
!!                      ^ error
76       cursor.getLong(8)!!,
77       cursor.getLong(9),
78       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:76:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
73       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
74       cursor.getLong(6)!!,
75       cursor.getLong(7),
76       cursor.getLong(8)!!,
!!                      ^ error
77       cursor.getLong(9),
78       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
79       cursor.getString(11),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:77:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
74       cursor.getLong(6)!!,
75       cursor.getLong(7),
76       cursor.getLong(8)!!,
77       cursor.getLong(9),
!!                      ^ error
78       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
79       cursor.getString(11),
80       cursor.getLong(12)!!

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:78:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
75       cursor.getLong(7),
76       cursor.getLong(8)!!,
77       cursor.getLong(9),
78       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
!!                      ^ error
79       cursor.getString(11),
80       cursor.getLong(12)!!
81     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:79:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
76       cursor.getLong(8)!!,
77       cursor.getLong(9),
78       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
79       cursor.getString(11),
!!                        ^ error
80       cursor.getLong(12)!!
81     )
82   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:80:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
77       cursor.getLong(9),
78       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
79       cursor.getString(11),
80       cursor.getLong(12)!!
!!                      ^ error
81     )
82   }
83 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:113:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
110       cursor.getString(0)!!,
111       cursor.getLong(1)!!,
112       cursor.getString(2)!!,
113       cursor.getString(3),
!!!                        ^ error
114       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
115       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
116       cursor.getLong(6)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:114:65
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
111       cursor.getLong(1)!!,
112       cursor.getString(2)!!,
113       cursor.getString(3),
114       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
!!!                                                                 ^ error
115       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
116       cursor.getLong(6)!!,
117       cursor.getLong(7),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:115:63
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
112       cursor.getString(2)!!,
113       cursor.getString(3),
114       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
115       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
!!!                                                               ^ error
116       cursor.getLong(6)!!,
117       cursor.getLong(7),
118       cursor.getLong(8)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:116:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
113       cursor.getString(3),
114       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
115       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
116       cursor.getLong(6)!!,
!!!                      ^ error
117       cursor.getLong(7),
118       cursor.getLong(8)!!,
119       cursor.getLong(9),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:117:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
114       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
115       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
116       cursor.getLong(6)!!,
117       cursor.getLong(7),
!!!                      ^ error
118       cursor.getLong(8)!!,
119       cursor.getLong(9),
120       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:118:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
115       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
116       cursor.getLong(6)!!,
117       cursor.getLong(7),
118       cursor.getLong(8)!!,
!!!                      ^ error
119       cursor.getLong(9),
120       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
121       cursor.getString(11),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:119:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
116       cursor.getLong(6)!!,
117       cursor.getLong(7),
118       cursor.getLong(8)!!,
119       cursor.getLong(9),
!!!                      ^ error
120       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
121       cursor.getString(11),
122       cursor.getLong(12)!!

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:120:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
117       cursor.getLong(7),
118       cursor.getLong(8)!!,
119       cursor.getLong(9),
120       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
!!!                      ^ error
121       cursor.getString(11),
122       cursor.getLong(12)!!
123     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:121:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
118       cursor.getLong(8)!!,
119       cursor.getLong(9),
120       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
121       cursor.getString(11),
!!!                        ^ error
122       cursor.getLong(12)!!
123     )
124   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:122:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
119       cursor.getLong(9),
120       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
121       cursor.getString(11),
122       cursor.getLong(12)!!
!!!                      ^ error
123     )
124   }
125 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:140:63
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
137       cursor.getString(0)!!,
138       cursor.getString(1)!!,
139       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(2)!!),
140       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(3)!!),
!!!                                                               ^ error
141       cursor.getLong(4)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
142       cursor.getString(5)!!
143     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:141:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
138       cursor.getString(1)!!,
139       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(2)!!),
140       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(3)!!),
141       cursor.getLong(4)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
!!!                      ^ error
142       cursor.getString(5)!!
143     )
144   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:142:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
139       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(2)!!),
140       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(3)!!),
141       cursor.getLong(4)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
142       cursor.getString(5)!!
!!!                        ^ error
143     )
144   }
145 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:158:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
155       cursor.getString(0)!!,
156       cursor.getString(1)!!,
157       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(2)!!),
158       cursor.getLong(3)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) }
!!!                      ^ error
159     )
160   }
161 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:187:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
184       cursor.getString(0)!!,
185       cursor.getLong(1)!!,
186       cursor.getString(2)!!,
187       cursor.getString(3),
!!!                        ^ error
188       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
189       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
190       cursor.getLong(6)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:188:65
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
185       cursor.getLong(1)!!,
186       cursor.getString(2)!!,
187       cursor.getString(3),
188       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
!!!                                                                 ^ error
189       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
190       cursor.getLong(6)!!,
191       cursor.getLong(7),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:189:63
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
186       cursor.getString(2)!!,
187       cursor.getString(3),
188       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
189       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
!!!                                                               ^ error
190       cursor.getLong(6)!!,
191       cursor.getLong(7),
192       cursor.getLong(8)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:190:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
187       cursor.getString(3),
188       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
189       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
190       cursor.getLong(6)!!,
!!!                      ^ error
191       cursor.getLong(7),
192       cursor.getLong(8)!!,
193       cursor.getLong(9),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:191:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
188       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
189       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
190       cursor.getLong(6)!!,
191       cursor.getLong(7),
!!!                      ^ error
192       cursor.getLong(8)!!,
193       cursor.getLong(9),
194       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:192:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
189       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
190       cursor.getLong(6)!!,
191       cursor.getLong(7),
192       cursor.getLong(8)!!,
!!!                      ^ error
193       cursor.getLong(9),
194       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
195       cursor.getString(11),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:193:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
190       cursor.getLong(6)!!,
191       cursor.getLong(7),
192       cursor.getLong(8)!!,
193       cursor.getLong(9),
!!!                      ^ error
194       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
195       cursor.getString(11),
196       cursor.getLong(12)!!

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:194:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
191       cursor.getLong(7),
192       cursor.getLong(8)!!,
193       cursor.getLong(9),
194       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
!!!                      ^ error
195       cursor.getString(11),
196       cursor.getLong(12)!!
197     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:195:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
192       cursor.getLong(8)!!,
193       cursor.getLong(9),
194       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
195       cursor.getString(11),
!!!                        ^ error
196       cursor.getLong(12)!!
197     )
198   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:196:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
193       cursor.getLong(9),
194       cursor.getLong(10)?.let { sessionTableAdapter.feedbackRatingAdapter.decode(it) },
195       cursor.getString(11),
196       cursor.getLong(12)!!
!!!                      ^ error
197     )
198   }
199 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:221:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
218       cursor.getString(0)!!,
219       cursor.getLong(1)!!,
220       cursor.getString(2)!!,
221       cursor.getString(3),
!!!                        ^ error
222       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
223       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
224       cursor.getLong(6)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:222:65
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
219       cursor.getLong(1)!!,
220       cursor.getString(2)!!,
221       cursor.getString(3),
222       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
!!!                                                                 ^ error
223       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
224       cursor.getLong(6)!!,
225       cursor.getLong(7),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:223:63
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
220       cursor.getString(2)!!,
221       cursor.getString(3),
222       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
223       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
!!!                                                               ^ error
224       cursor.getLong(6)!!,
225       cursor.getLong(7),
226       cursor.getLong(8)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:224:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
221       cursor.getString(3),
222       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
223       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
224       cursor.getLong(6)!!,
!!!                      ^ error
225       cursor.getLong(7),
226       cursor.getLong(8)!!,
227       cursor.getLong(9),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:225:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
222       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(4)!!),
223       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
224       cursor.getLong(6)!!,
225       cursor.getLong(7),
!!!                      ^ error
226       cursor.getLong(8)!!,
227       cursor.getLong(9),
228       sessionTableAdapter.feedbackRatingAdapter.decode(cursor.getLong(10)!!),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:226:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
223       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(5)!!),
224       cursor.getLong(6)!!,
225       cursor.getLong(7),
226       cursor.getLong(8)!!,
!!!                      ^ error
227       cursor.getLong(9),
228       sessionTableAdapter.feedbackRatingAdapter.decode(cursor.getLong(10)!!),
229       cursor.getString(11),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:227:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
224       cursor.getLong(6)!!,
225       cursor.getLong(7),
226       cursor.getLong(8)!!,
227       cursor.getLong(9),
!!!                      ^ error
228       sessionTableAdapter.feedbackRatingAdapter.decode(cursor.getLong(10)!!),
229       cursor.getString(11),
230       cursor.getLong(12)!!

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:228:71
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
225       cursor.getLong(7),
226       cursor.getLong(8)!!,
227       cursor.getLong(9),
228       sessionTableAdapter.feedbackRatingAdapter.decode(cursor.getLong(10)!!),
!!!                                                                       ^ error
229       cursor.getString(11),
230       cursor.getLong(12)!!
231     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:229:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
226       cursor.getLong(8)!!,
227       cursor.getLong(9),
228       sessionTableAdapter.feedbackRatingAdapter.decode(cursor.getLong(10)!!),
229       cursor.getString(11),
!!!                        ^ error
230       cursor.getLong(12)!!
231     )
232   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:230:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
227       cursor.getLong(9),
228       sessionTableAdapter.feedbackRatingAdapter.decode(cursor.getLong(10)!!),
229       cursor.getString(11),
230       cursor.getLong(12)!!
!!!                      ^ error
231     )
232   }
233 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:256:65
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
253       cursor.getString(0)!!,
254       cursor.getString(1)!!,
255       cursor.getString(2),
256       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(3)!!),
!!!                                                                 ^ error
257       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(4)!!),
258       cursor.getLong(5)!!,
259       cursor.getLong(6),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:257:63
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
254       cursor.getString(1)!!,
255       cursor.getString(2),
256       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(3)!!),
257       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(4)!!),
!!!                                                               ^ error
258       cursor.getLong(5)!!,
259       cursor.getLong(6),
260       cursor.getLong(7),

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:258:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
255       cursor.getString(2),
256       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(3)!!),
257       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(4)!!),
258       cursor.getLong(5)!!,
!!!                      ^ error
259       cursor.getLong(6),
260       cursor.getLong(7),
261       cursor.getString(8)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:259:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
256       sessionTableAdapter.startsAtAdapter.decode(cursor.getLong(3)!!),
257       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(4)!!),
258       cursor.getLong(5)!!,
259       cursor.getLong(6),
!!!                      ^ error
260       cursor.getLong(7),
261       cursor.getString(8)!!,
262       cursor.getString(9)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:260:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
257       sessionTableAdapter.endsAtAdapter.decode(cursor.getLong(4)!!),
258       cursor.getLong(5)!!,
259       cursor.getLong(6),
260       cursor.getLong(7),
!!!                      ^ error
261       cursor.getString(8)!!,
262       cursor.getString(9)
263     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:261:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
258       cursor.getLong(5)!!,
259       cursor.getLong(6),
260       cursor.getLong(7),
261       cursor.getString(8)!!,
!!!                        ^ error
262       cursor.getString(9)
263     )
264   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:262:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
259       cursor.getLong(6),
260       cursor.getLong(7),
261       cursor.getString(8)!!,
262       cursor.getString(9)
!!!                        ^ error
263     )
264   }
265 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:286:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
283     feedbackComment: String?,
284     feedbackSent: Long,
285   ): QueryResult<Long> {
286     val result = driver.execute(-994_530_431, """
!!!                                  ^ error
287         |INSERT OR REPLACE INTO sessionTable(id, conferenceId, title, description, startsAt, endsAt, serviceSession, roomId, rsvp, rsvpSent, feedbackRating, feedbackComment, feedbackSent)
288         |VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)
289         """.trimMargin(), 13) {

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:289:27
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
286     val result = driver.execute(-994_530_431, """
287         |INSERT OR REPLACE INTO sessionTable(id, conferenceId, title, description, startsAt, endsAt, serviceSession, roomId, rsvp, rsvpSent, feedbackRating, feedbackComment, feedbackSent)
288         |VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)
289         """.trimMargin(), 13) {
!!!                           ^ error
290           var parameterIndex = 0
291           bindString(parameterIndex++, id)
292           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:305:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
302           bindString(parameterIndex++, feedbackComment)
303           bindLong(parameterIndex++, feedbackSent)
304         }
305     notifyQueries(-994_530_431) { emit ->
!!!                    ^ error
306       emit("sessionTable")
307     }
308     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:319:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
316     id: String,
317     conferenceId: Long,
318   ): QueryResult<Long> {
319     val result = driver.execute(846_711_414, """UPDATE sessionTable SET rsvp = ? WHERE id = ? AND conferenceId = ?""", 3) {
!!!                                 ^ error
320           var parameterIndex = 0
321           bindLong(parameterIndex++, rsvp)
322           bindString(parameterIndex++, id)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:319:120
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
316     id: String,
317     conferenceId: Long,
318   ): QueryResult<Long> {
319     val result = driver.execute(846_711_414, """UPDATE sessionTable SET rsvp = ? WHERE id = ? AND conferenceId = ?""", 3) {
!!!                                                                                                                        ^ error
320           var parameterIndex = 0
321           bindLong(parameterIndex++, rsvp)
322           bindString(parameterIndex++, id)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:325:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
322           bindString(parameterIndex++, id)
323           bindLong(parameterIndex++, conferenceId)
324         }
325     notifyQueries(846_711_414) { emit ->
!!!                   ^ error
326       emit("sessionTable")
327     }
328     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:339:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
336     sessionId: String,
337     conferenceId: Long,
338   ): QueryResult<Long> {
339     val result = driver.execute(1_143_530_286, """UPDATE sessionTable SET rsvpSent = ? WHERE id = ? AND conferenceId = ?""", 3) {
!!!                                 ^ error
340           var parameterIndex = 0
341           bindLong(parameterIndex++, rsvpSent)
342           bindString(parameterIndex++, sessionId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:339:126
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
336     sessionId: String,
337     conferenceId: Long,
338   ): QueryResult<Long> {
339     val result = driver.execute(1_143_530_286, """UPDATE sessionTable SET rsvpSent = ? WHERE id = ? AND conferenceId = ?""", 3) {
!!!                                                                                                                              ^ error
340           var parameterIndex = 0
341           bindLong(parameterIndex++, rsvpSent)
342           bindString(parameterIndex++, sessionId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:345:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
342           bindString(parameterIndex++, sessionId)
343           bindLong(parameterIndex++, conferenceId)
344         }
345     notifyQueries(1_143_530_286) { emit ->
!!!                   ^ error
346       emit("sessionTable")
347     }
348     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:360:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
357     sessionId: String,
358     conferenceId: Long,
359   ): QueryResult<Long> {
360     val result = driver.execute(1_666_204_640, """UPDATE sessionTable SET feedbackRating = ?, feedbackComment = ?, feedbackSent = 0 WHERE id = ? AND conferenceId = ?""", 4) {
!!!                                 ^ error
361           var parameterIndex = 0
362           bindLong(parameterIndex++, feedbackRating?.let { sessionTableAdapter.feedbackRatingAdapter.encode(it) })
363           bindString(parameterIndex++, feedbackComment)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:360:171
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
357     sessionId: String,
358     conferenceId: Long,
359   ): QueryResult<Long> {
360     val result = driver.execute(1_666_204_640, """UPDATE sessionTable SET feedbackRating = ?, feedbackComment = ?, feedbackSent = 0 WHERE id = ? AND conferenceId = ?""", 4) {
!!!                                                                                                                                                                           ^ error
361           var parameterIndex = 0
362           bindLong(parameterIndex++, feedbackRating?.let { sessionTableAdapter.feedbackRatingAdapter.encode(it) })
363           bindString(parameterIndex++, feedbackComment)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:367:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
364           bindString(parameterIndex++, sessionId)
365           bindLong(parameterIndex++, conferenceId)
366         }
367     notifyQueries(1_666_204_640) { emit ->
!!!                   ^ error
368       emit("sessionTable")
369     }
370     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:381:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
378     sessionId: String,
379     conferenceId: Long,
380   ): QueryResult<Long> {
381     val result = driver.execute(-135_096_424, """UPDATE sessionTable SET feedbackSent = ? WHERE id = ? AND conferenceId = ?""", 3) {
!!!                                  ^ error
382           var parameterIndex = 0
383           bindLong(parameterIndex++, feedbackSent)
384           bindString(parameterIndex++, sessionId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:381:129
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
378     sessionId: String,
379     conferenceId: Long,
380   ): QueryResult<Long> {
381     val result = driver.execute(-135_096_424, """UPDATE sessionTable SET feedbackSent = ? WHERE id = ? AND conferenceId = ?""", 3) {
!!!                                                                                                                                 ^ error
382           var parameterIndex = 0
383           bindLong(parameterIndex++, feedbackSent)
384           bindString(parameterIndex++, sessionId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:387:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
384           bindString(parameterIndex++, sessionId)
385           bindLong(parameterIndex++, conferenceId)
386         }
387     notifyQueries(-135_096_424) { emit ->
!!!                    ^ error
388       emit("sessionTable")
389     }
390     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:397:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
394    * @return The number of rows updated.
395    */
396   public fun deleteById(sessionId: String, conferenceId: Long): QueryResult<Long> = transactionWithResult {
397     driver.execute(1_667_173_728, """DELETE FROM sessionSpeakerTable WHERE sessionId = ?""", 1) {
!!!                    ^ error
398           var parameterIndex = 0
399           bindString(parameterIndex++, sessionId)
400         }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:401:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
398           var parameterIndex = 0
399           bindString(parameterIndex++, sessionId)
400         }
401     driver.execute(1_667_173_729, """DELETE FROM sessionTable WHERE id = ? AND conferenceId = ?""", 2) {
!!!                    ^ error
402           var parameterIndex = 0
403           bindString(parameterIndex++, sessionId)
404           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:407:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
404           bindLong(parameterIndex++, conferenceId)
405         }
406   }.also {
407     notifyQueries(-1_388_207_761) { emit ->
!!!                    ^ error
408       emit("sessionSpeakerTable")
409       emit("sessionTable")
410     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:425:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
422       driver.removeListener("sessionTable", listener = listener)
423     }
424 
425     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_652_322_740, """SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable WHERE conferenceId = ? ORDER BY sessionTable.startsAt ASC""", mapper, 1) {
!!!                                                                                                            ^ error
426       var parameterIndex = 0
427       bindLong(parameterIndex++, conferenceId)
428     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:445:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
442       driver.removeListener("sessionTable", listener = listener)
443     }
444 
445     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-2_005_357_005, """SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable WHERE rsvp != 0 AND conferenceId = ? ORDER BY sessionTable.startsAt ASC""", mapper, 1) {
!!!                                                                                                            ^ error
446       var parameterIndex = 0
447       bindLong(parameterIndex++, conferenceId)
448     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:466:107
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
463       driver.removeListener("sessionTable", listener = listener)
464     }
465 
466     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_347_964_832, """SELECT count(1) FROM sessionTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
!!!                                                                                                           ^ error
467       var parameterIndex = 0
468       bindString(parameterIndex++, id)
469       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:488:107
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
485       driver.removeListener("sessionTable", listener = listener)
486     }
487 
488     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_040_722_038, """SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
!!!                                                                                                           ^ error
489       var parameterIndex = 0
490       bindString(parameterIndex++, id)
491       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:509:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
506       driver.removeListener("sessionTable", "roomTable", listener = listener)
507     }
508 
509     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_286_344_773, """
!!!                                                                                                            ^ error
510     |SELECT sessionTable.id, sessionTable.title, sessionTable.startsAt, sessionTable.endsAt, sessionTable.feedbackRating, roomTable.name AS roomName
511     |FROM sessionTable
512     |JOIN roomTable ON sessionTable.roomId = roomTable.id AND roomTable.conferenceId = sessionTable.conferenceId

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:534:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
531       driver.removeListener("sessionTable", listener = listener)
532     }
533 
534     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-800_947_642, """
!!!                                                                                                            ^ error
535     |SELECT sessionTable.id, sessionTable.title, sessionTable.endsAt, sessionTable.feedbackRating
536     |FROM sessionTable
537     |WHERE rsvp != 0 AND sessionTable.feedbackRating IS NULL AND conferenceId = ?

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:559:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
556       driver.removeListener("sessionTable", "sessionSpeakerTable", listener = listener)
557     }
558 
559     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-747_294_118, """
!!!                                                                                                            ^ error
560     |SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable
561     |JOIN sessionSpeakerTable ON sessionTable.id = sessionSpeakerTable.sessionId AND sessionTable.conferenceId = sessionSpeakerTable.conferenceId
562     |WHERE sessionSpeakerTable.speakerId = ? AND sessionTable.conferenceId = ?

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:584:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
581       driver.removeListener("sessionTable", listener = listener)
582     }
583 
584     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-33_666_004, """SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable WHERE feedbackRating IS NOT NULL AND feedbackSent = 0 AND conferenceId = ?""", mapper, 1) {
!!!                                                                                                            ^ error
585       var parameterIndex = 0
586       bindLong(parameterIndex++, conferenceId)
587     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:605:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
602       driver.removeListener("sessionTable", "roomTable", "sessionSpeakerTable", "profileTable", listener = listener)
603     }
604 
605     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_257_788_059, """
!!!                                                                                                            ^ error
606     |SELECT
607     |    sessionTable.id, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt,
608     |    sessionTable.serviceSession, sessionTable.rsvp, sessionTable.roomId, roomTable.name AS roomName,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:29:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
26       cursor.getString(0)!!,
27       cursor.getString(1)!!,
28       cursor.getLong(2)!!,
29       cursor.getLong(3)!!
!!                      ^ error
30     )
31   }
32 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:49:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
46       cursor.getString(0)!!,
47       cursor.getString(1)!!,
48       cursor.getLong(2)!!,
49       cursor.getLong(3)!!
!!                      ^ error
50     )
51   }
52 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:64:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
61     conferenceId: Long,
62     displayOrder: Long,
63   ): QueryResult<Long> {
64     val result = driver.execute(552_573_131, """
!!                                 ^ error
65         |INSERT OR REPLACE INTO sessionSpeakerTable(sessionId, speakerId, conferenceId, displayOrder)
66         |VALUES (?,?,?,?)
67         """.trimMargin(), 4) {

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:67:27
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
64     val result = driver.execute(552_573_131, """
65         |INSERT OR REPLACE INTO sessionSpeakerTable(sessionId, speakerId, conferenceId, displayOrder)
66         |VALUES (?,?,?,?)
67         """.trimMargin(), 4) {
!!                           ^ error
68           var parameterIndex = 0
69           bindString(parameterIndex++, sessionId)
70           bindString(parameterIndex++, speakerId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:74:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
71           bindLong(parameterIndex++, conferenceId)
72           bindLong(parameterIndex++, displayOrder)
73         }
74     notifyQueries(552_573_131) { emit ->
!!                   ^ error
75       emit("sessionSpeakerTable")
76     }
77     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:84:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
81    * @return The number of rows updated.
82    */
83   public fun deleteBySessionId(sessionId: String, conferenceId: Long): QueryResult<Long> {
84     val result = driver.execute(-2_077_169_978, """DELETE FROM sessionSpeakerTable WHERE sessionId = ? AND conferenceId = ?""", 2) {
!!                                  ^ error
85           var parameterIndex = 0
86           bindString(parameterIndex++, sessionId)
87           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:89:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
86           bindString(parameterIndex++, sessionId)
87           bindLong(parameterIndex++, conferenceId)
88         }
89     notifyQueries(-2_077_169_978) { emit ->
!!                    ^ error
90       emit("sessionSpeakerTable")
91     }
92     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:99:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
96     * @return The number of rows updated.
97     */
98    public fun deleteBySpeakerId(speakerId: String, conferenceId: Long): QueryResult<Long> {
99      val result = driver.execute(-140_046_865, """DELETE FROM sessionSpeakerTable WHERE speakerId = ? AND conferenceId = ?""", 2) {
!!                                   ^ error
100           var parameterIndex = 0
101           bindString(parameterIndex++, speakerId)
102           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:104:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
101           bindString(parameterIndex++, speakerId)
102           bindLong(parameterIndex++, conferenceId)
103         }
104     notifyQueries(-140_046_865) { emit ->
!!!                    ^ error
105       emit("sessionSpeakerTable")
106     }
107     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:114:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
111    * @return The number of rows updated.
112    */
113   public fun deleteAll(conferenceId: Long): QueryResult<Long> {
114     val result = driver.execute(-303_241_043, """DELETE FROM sessionSpeakerTable WHERE conferenceId = ?""", 1) {
!!!                                  ^ error
115           var parameterIndex = 0
116           bindLong(parameterIndex++, conferenceId)
117         }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:118:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
115           var parameterIndex = 0
116           bindLong(parameterIndex++, conferenceId)
117         }
118     notifyQueries(-303_241_043) { emit ->
!!!                    ^ error
119       emit("sessionSpeakerTable")
120     }
121     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:137:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
134       driver.removeListener("sessionSpeakerTable", listener = listener)
135     }
136 
137     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-623_236_395, """SELECT sessionSpeakerTable.sessionId, sessionSpeakerTable.speakerId, sessionSpeakerTable.conferenceId, sessionSpeakerTable.displayOrder FROM sessionSpeakerTable WHERE sessionId = ? AND conferenceId = ?""", mapper, 2) {
!!!                                                                                                            ^ error
138       var parameterIndex = 0
139       bindString(parameterIndex++, sessionId)
140       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:159:107
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
156       driver.removeListener("sessionSpeakerTable", listener = listener)
157     }
158 
159     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_313_886_718, """SELECT sessionSpeakerTable.sessionId, sessionSpeakerTable.speakerId, sessionSpeakerTable.conferenceId, sessionSpeakerTable.displayOrder FROM sessionSpeakerTable WHERE speakerId = ? AND conferenceId = ?""", mapper, 2) {
!!!                                                                                                           ^ error
160       var parameterIndex = 0
161       bindString(parameterIndex++, speakerId)
162       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:28:25
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
25       cursor.getString(0)!!,
26       cursor.getLong(1)!!,
27       sponsorGroupTableAdapter.displayPriorityAdapter.decode(cursor.getLong(2)!!),
28       cursor.getBoolean(3)!!
!!                         ^ error
29     )
30   }
31 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:48:25
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
45       cursor.getString(0)!!,
46       cursor.getLong(1)!!,
47       sponsorGroupTableAdapter.displayPriorityAdapter.decode(cursor.getLong(2)!!),
48       cursor.getBoolean(3)!!
!!                         ^ error
49     )
50   }
51 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:67:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
64     displayPriority: Int,
65     prominent: Boolean,
66   ): QueryResult<Long> {
67     val result = driver.execute(1_898_383_444, """
!!                                 ^ error
68         |INSERT OR REPLACE INTO sponsorGroupTable(name, conferenceId, displayPriority, prominent)
69         |VALUES (?, ?, ?, ?)
70         """.trimMargin(), 4) {

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:70:27
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
67     val result = driver.execute(1_898_383_444, """
68         |INSERT OR REPLACE INTO sponsorGroupTable(name, conferenceId, displayPriority, prominent)
69         |VALUES (?, ?, ?, ?)
70         """.trimMargin(), 4) {
!!                           ^ error
71           var parameterIndex = 0
72           bindString(parameterIndex++, name)
73           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:77:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
74           bindLong(parameterIndex++, sponsorGroupTableAdapter.displayPriorityAdapter.encode(displayPriority))
75           bindBoolean(parameterIndex++, prominent)
76         }
77     notifyQueries(1_898_383_444) { emit ->
!!                   ^ error
78       emit("sponsorGroupTable")
79     }
80     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:87:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
84    * @return The number of rows updated.
85    */
86   public fun deleteAll(conferenceId: Long): QueryResult<Long> {
87     val result = driver.execute(-338_388_303, """DELETE FROM sponsorGroupTable WHERE conferenceId = ?""", 1) {
!!                                  ^ error
88           var parameterIndex = 0
89           bindLong(parameterIndex++, conferenceId)
90         }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:91:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
88           var parameterIndex = 0
89           bindLong(parameterIndex++, conferenceId)
90         }
91     notifyQueries(-338_388_303) { emit ->
!!                    ^ error
92       emit("sponsorGroupTable")
93     }
94     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:101:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
98     * @return The number of rows updated.
99     */
100   public fun deleteByName(name: String, conferenceId: Long): QueryResult<Long> {
101     val result = driver.execute(-597_853_070, """DELETE FROM sponsorGroupTable WHERE name = ? AND conferenceId = ?""", 2) {
!!!                                  ^ error
102           var parameterIndex = 0
103           bindString(parameterIndex++, name)
104           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:106:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
103           bindString(parameterIndex++, name)
104           bindLong(parameterIndex++, conferenceId)
105         }
106     notifyQueries(-597_853_070) { emit ->
!!!                    ^ error
107       emit("sponsorGroupTable")
108     }
109     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:124:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
121       driver.removeListener("sponsorGroupTable", listener = listener)
122     }
123 
124     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_695_654_464, """SELECT sponsorGroupTable.name, sponsorGroupTable.conferenceId, sponsorGroupTable.displayPriority, sponsorGroupTable.prominent FROM sponsorGroupTable WHERE conferenceId = ?""", mapper, 1) {
!!!                                                                                                            ^ error
125       var parameterIndex = 0
126       bindLong(parameterIndex++, conferenceId)
127     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:145:107
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
142       driver.removeListener("sponsorGroupTable", listener = listener)
143     }
144 
145     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(2_104_385_292, """SELECT sponsorGroupTable.name, sponsorGroupTable.conferenceId, sponsorGroupTable.displayPriority, sponsorGroupTable.prominent FROM sponsorGroupTable WHERE name = ? AND conferenceId = ? LIMIT 1""", mapper, 2) {
!!!                                                                                                           ^ error
146       var parameterIndex = 0
147       bindString(parameterIndex++, name)
148       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:167:107
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
164       driver.removeListener("sponsorGroupTable", listener = listener)
165     }
166 
167     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(344_023_651, """SELECT count(1) FROM sponsorGroupTable WHERE name = ? AND conferenceId = ? LIMIT 1""", mapper, 2) {
!!!                                                                                                           ^ error
168       var parameterIndex = 0
169       bindString(parameterIndex++, name)
170       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:29:25
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
26       cursor.getString(0)!!,
27       cursor.getString(1)!!,
28       cursor.getLong(2)!!,
29       cursor.getBoolean(3)!!,
!!                         ^ error
30       cursor.getString(4),
31       cursor.getString(5)!!,
32       cursor.getString(6)!!

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:30:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
27       cursor.getString(1)!!,
28       cursor.getLong(2)!!,
29       cursor.getBoolean(3)!!,
30       cursor.getString(4),
!!                        ^ error
31       cursor.getString(5)!!,
32       cursor.getString(6)!!
33     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:31:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
28       cursor.getLong(2)!!,
29       cursor.getBoolean(3)!!,
30       cursor.getString(4),
31       cursor.getString(5)!!,
!!                        ^ error
32       cursor.getString(6)!!
33     )
34   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:32:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
29       cursor.getBoolean(3)!!,
30       cursor.getString(4),
31       cursor.getString(5)!!,
32       cursor.getString(6)!!
!!                        ^ error
33     )
34   }
35 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:55:25
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
52       cursor.getString(0)!!,
53       cursor.getString(1)!!,
54       cursor.getLong(2)!!,
55       cursor.getBoolean(3)!!,
!!                         ^ error
56       cursor.getString(4),
57       cursor.getString(5)!!,
58       cursor.getString(6)!!

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:56:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
53       cursor.getString(1)!!,
54       cursor.getLong(2)!!,
55       cursor.getBoolean(3)!!,
56       cursor.getString(4),
!!                        ^ error
57       cursor.getString(5)!!,
58       cursor.getString(6)!!
59     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:57:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
54       cursor.getLong(2)!!,
55       cursor.getBoolean(3)!!,
56       cursor.getString(4),
57       cursor.getString(5)!!,
!!                        ^ error
58       cursor.getString(6)!!
59     )
60   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:58:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
55       cursor.getBoolean(3)!!,
56       cursor.getString(4),
57       cursor.getString(5)!!,
58       cursor.getString(6)!!
!!                        ^ error
59     )
60   }
61 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:82:25
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
79       cursor.getString(0)!!,
80       cursor.getString(1)!!,
81       cursor.getLong(2)!!,
82       cursor.getBoolean(3)!!,
!!                         ^ error
83       cursor.getString(4),
84       cursor.getString(5)!!,
85       cursor.getString(6)!!

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:83:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
80       cursor.getString(1)!!,
81       cursor.getLong(2)!!,
82       cursor.getBoolean(3)!!,
83       cursor.getString(4),
!!                        ^ error
84       cursor.getString(5)!!,
85       cursor.getString(6)!!
86     )

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:84:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
81       cursor.getLong(2)!!,
82       cursor.getBoolean(3)!!,
83       cursor.getString(4),
84       cursor.getString(5)!!,
!!                        ^ error
85       cursor.getString(6)!!
86     )
87   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:85:24
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
82       cursor.getBoolean(3)!!,
83       cursor.getString(4),
84       cursor.getString(5)!!,
85       cursor.getString(6)!!
!!                        ^ error
86     )
87   }
88 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:115:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
112     iconUrl: String,
113     url: String,
114   ): QueryResult<Long> {
115     val result = driver.execute(1_240_180_485, """
!!!                                 ^ error
116         |INSERT OR REPLACE INTO sponsorTable(name, groupName, conferenceId, hasDetail, description, iconUrl, url)
117         |VALUES (?, ?, ?, ?, ?, ?, ?)
118         """.trimMargin(), 7) {

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:118:27
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
115     val result = driver.execute(1_240_180_485, """
116         |INSERT OR REPLACE INTO sponsorTable(name, groupName, conferenceId, hasDetail, description, iconUrl, url)
117         |VALUES (?, ?, ?, ?, ?, ?, ?)
118         """.trimMargin(), 7) {
!!!                           ^ error
119           var parameterIndex = 0
120           bindString(parameterIndex++, name)
121           bindString(parameterIndex++, groupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:128:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
125           bindString(parameterIndex++, iconUrl)
126           bindString(parameterIndex++, url)
127         }
128     notifyQueries(1_240_180_485) { emit ->
!!!                   ^ error
129       emit("sponsorTable")
130     }
131     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:142:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
139     groupName: String,
140     conferenceId: Long,
141   ): QueryResult<Long> {
142     val result = driver.execute(566_442_739, """DELETE FROM sponsorTable WHERE name = ? AND groupName = ? AND conferenceId = ?""", 3) {
!!!                                 ^ error
143           var parameterIndex = 0
144           bindString(parameterIndex++, name)
145           bindString(parameterIndex++, groupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:142:132
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
139     groupName: String,
140     conferenceId: Long,
141   ): QueryResult<Long> {
142     val result = driver.execute(566_442_739, """DELETE FROM sponsorTable WHERE name = ? AND groupName = ? AND conferenceId = ?""", 3) {
!!!                                                                                                                                    ^ error
143           var parameterIndex = 0
144           bindString(parameterIndex++, name)
145           bindString(parameterIndex++, groupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:148:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
145           bindString(parameterIndex++, groupName)
146           bindLong(parameterIndex++, conferenceId)
147         }
148     notifyQueries(566_442_739) { emit ->
!!!                   ^ error
149       emit("sponsorTable")
150     }
151     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:158:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
155    * @return The number of rows updated.
156    */
157   public fun deleteAll(conferenceId: Long): QueryResult<Long> {
158     val result = driver.execute(1_957_933_664, """DELETE FROM sponsorTable WHERE conferenceId = ?""", 1) {
!!!                                 ^ error
159           var parameterIndex = 0
160           bindLong(parameterIndex++, conferenceId)
161         }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:162:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
159           var parameterIndex = 0
160           bindLong(parameterIndex++, conferenceId)
161         }
162     notifyQueries(1_957_933_664) { emit ->
!!!                   ^ error
163       emit("sponsorTable")
164     }
165     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:180:107
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
177       driver.removeListener("sponsorTable", listener = listener)
178     }
179 
180     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(600_667_503, """SELECT sponsorTable.name, sponsorTable.groupName, sponsorTable.conferenceId, sponsorTable.hasDetail, sponsorTable.description, sponsorTable.iconUrl, sponsorTable.url FROM sponsorTable WHERE conferenceId = ?""", mapper, 1) {
!!!                                                                                                           ^ error
181       var parameterIndex = 0
182       bindLong(parameterIndex++, conferenceId)
183     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:201:107
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
198       driver.removeListener("sponsorTable", listener = listener)
199     }
200 
201     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(708_121_721, """SELECT sponsorTable.name, sponsorTable.groupName, sponsorTable.conferenceId, sponsorTable.hasDetail, sponsorTable.description, sponsorTable.iconUrl, sponsorTable.url FROM sponsorTable WHERE groupName = ? AND conferenceId = ?""", mapper, 2) {
!!!                                                                                                           ^ error
202       var parameterIndex = 0
203       bindString(parameterIndex++, groupName)
204       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:224:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
221       driver.removeListener("sponsorTable", listener = listener)
222     }
223 
224     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_851_740_682, """SELECT sponsorTable.name, sponsorTable.groupName, sponsorTable.conferenceId, sponsorTable.hasDetail, sponsorTable.description, sponsorTable.iconUrl, sponsorTable.url FROM sponsorTable WHERE name = ? AND groupName = ? AND conferenceId = ? LIMIT 1""", mapper, 3) {
!!!                                                                                                            ^ error
225       var parameterIndex = 0
226       bindString(parameterIndex++, name)
227       bindString(parameterIndex++, groupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:224:384
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
221       driver.removeListener("sponsorTable", listener = listener)
222     }
223 
224     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_851_740_682, """SELECT sponsorTable.name, sponsorTable.groupName, sponsorTable.conferenceId, sponsorTable.hasDetail, sponsorTable.description, sponsorTable.iconUrl, sponsorTable.url FROM sponsorTable WHERE name = ? AND groupName = ? AND conferenceId = ? LIMIT 1""", mapper, 3) {
!!!                                                                                                                                                                                                                                                                                                                                                                                                ^ error
225       var parameterIndex = 0
226       bindString(parameterIndex++, name)
227       bindString(parameterIndex++, groupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:248:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
245       driver.removeListener("sponsorTable", listener = listener)
246     }
247 
248     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-992_351_964, """SELECT count(1) FROM sponsorTable WHERE name = ? AND groupName = ? AND conferenceId = ? LIMIT 1""", mapper, 3) {
!!!                                                                                                            ^ error
249       var parameterIndex = 0
250       bindString(parameterIndex++, name)
251       bindString(parameterIndex++, groupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:248:232
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
245       driver.removeListener("sponsorTable", listener = listener)
246     }
247 
248     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-992_351_964, """SELECT count(1) FROM sponsorTable WHERE name = ? AND groupName = ? AND conferenceId = ? LIMIT 1""", mapper, 3) {
!!!                                                                                                                                                                                                                                        ^ error
249       var parameterIndex = 0
250       bindString(parameterIndex++, name)
251       bindString(parameterIndex++, groupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:31:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
28       cursor.getString(0)!!,
29       cursor.getString(1)!!,
30       cursor.getString(2)!!,
31       cursor.getLong(3)!!,
!!                      ^ error
32       cursor.getLong(4)!!
33     )
34   }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:32:22
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
29       cursor.getString(1)!!,
30       cursor.getString(2)!!,
31       cursor.getLong(3)!!,
32       cursor.getLong(4)!!
!!                      ^ error
33     )
34   }
35 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:52:34
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
49     conferenceId: Long,
50     displayOrder: Long,
51   ): QueryResult<Long> {
52     val result = driver.execute(-1_918_102_539, """
!!                                  ^ error
53         |INSERT OR REPLACE INTO sponsorRepresentativeTable(sponsorName, sponsorGroupName, representativeId, conferenceId, displayOrder)
54         |VALUES (?,?,?,?,?)
55         """.trimMargin(), 5) {

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:55:27
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
52     val result = driver.execute(-1_918_102_539, """
53         |INSERT OR REPLACE INTO sponsorRepresentativeTable(sponsorName, sponsorGroupName, representativeId, conferenceId, displayOrder)
54         |VALUES (?,?,?,?,?)
55         """.trimMargin(), 5) {
!!                           ^ error
56           var parameterIndex = 0
57           bindString(parameterIndex++, sponsorName)
58           bindString(parameterIndex++, sponsorGroupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:63:20
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
60           bindLong(parameterIndex++, conferenceId)
61           bindLong(parameterIndex++, displayOrder)
62         }
63     notifyQueries(-1_918_102_539) { emit ->
!!                    ^ error
64       emit("sponsorRepresentativeTable")
65     }
66     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:77:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
74     sponsorGroupName: String,
75     conferenceId: Long,
76   ): QueryResult<Long> {
77     val result = driver.execute(1_942_852_960, """DELETE FROM sponsorRepresentativeTable WHERE sponsorName = ? AND sponsorGroupName = ? AND conferenceId = ?""", 3) {
!!                                 ^ error
78           var parameterIndex = 0
79           bindString(parameterIndex++, sponsorName)
80           bindString(parameterIndex++, sponsorGroupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:77:162
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
74     sponsorGroupName: String,
75     conferenceId: Long,
76   ): QueryResult<Long> {
77     val result = driver.execute(1_942_852_960, """DELETE FROM sponsorRepresentativeTable WHERE sponsorName = ? AND sponsorGroupName = ? AND conferenceId = ?""", 3) {
!!                                                                                                                                                                  ^ error
78           var parameterIndex = 0
79           bindString(parameterIndex++, sponsorName)
80           bindString(parameterIndex++, sponsorGroupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:83:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
80           bindString(parameterIndex++, sponsorGroupName)
81           bindLong(parameterIndex++, conferenceId)
82         }
83     notifyQueries(1_942_852_960) { emit ->
!!                   ^ error
84       emit("sponsorRepresentativeTable")
85     }
86     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:93:33
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
90    * @return The number of rows updated.
91    */
92   public fun deleteAll(conferenceId: Long): QueryResult<Long> {
93     val result = driver.execute(1_271_156_163, """DELETE FROM sponsorRepresentativeTable WHERE conferenceId = ?""", 1) {
!!                                 ^ error
94           var parameterIndex = 0
95           bindLong(parameterIndex++, conferenceId)
96         }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:97:19
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
94            var parameterIndex = 0
95            bindLong(parameterIndex++, conferenceId)
96          }
97      notifyQueries(1_271_156_163) { emit ->
!!                    ^ error
98        emit("sponsorRepresentativeTable")
99      }
100     return result

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:117:108
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
114       driver.removeListener("sponsorRepresentativeTable", listener = listener)
115     }
116 
117     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-898_180_753, """SELECT sponsorRepresentativeTable.sponsorName, sponsorRepresentativeTable.sponsorGroupName, sponsorRepresentativeTable.representativeId, sponsorRepresentativeTable.conferenceId, sponsorRepresentativeTable.displayOrder FROM sponsorRepresentativeTable WHERE sponsorName = ? AND sponsorGroupName = ? AND conferenceId = ?""", mapper, 3) {
!!!                                                                                                            ^ error
118       var parameterIndex = 0
119       bindString(parameterIndex++, sponsorName)
120       bindString(parameterIndex++, sponsorGroupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:117:454
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
114       driver.removeListener("sponsorRepresentativeTable", listener = listener)
115     }
116 
117     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-898_180_753, """SELECT sponsorRepresentativeTable.sponsorName, sponsorRepresentativeTable.sponsorGroupName, sponsorRepresentativeTable.representativeId, sponsorRepresentativeTable.conferenceId, sponsorRepresentativeTable.displayOrder FROM sponsorRepresentativeTable WHERE sponsorName = ? AND sponsorGroupName = ? AND conferenceId = ?""", mapper, 3) {
!!!                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ^ error
118       var parameterIndex = 0
119       bindString(parameterIndex++, sponsorName)
120       bindString(parameterIndex++, sponsorGroupName)

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/Koin.kt:117:40
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
114     single {
115         HttpClient(engine = get()) {
116             install(HttpTimeout) {
117                 requestTimeoutMillis = 5000
!!!                                        ^ error
118             }
119         }
120     }

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/application/service/impl/DefaultNotificationSchedulingService.kt:116:55
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
113                         if (isFeedbackEnabled) {
114                             val feedbackDelivery =
115                                 session.endsAt.plus(NotificationSchedulingService.FEEDBACK_DISMISS_END_OFFSET, DateTimeUnit.MINUTE)
116                             if (feedbackDelivery.plus(24, DateTimeUnit.HOUR) >= dateTimeService.now() && session.feedback == null) {
!!!                                                       ^ error
117                                 notificationService.schedule(
118                                     notification = Notification.Local.Feedback(
119                                         sessionId = session.id,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:73:87
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
70     override suspend fun runSynchronization(conference: Conference) {
71         coroutineScope {
72             launch {
73                 var lastSessionizeSyncThisLoop: Instant = dateTimeService.now().minus(3, DateTimeUnit.HOUR)
!!                                                                                       ^ error
74                 while (isActive) {
75                     val lastSessionizeSync = lastSessionizeSyncThisLoop
76 

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:338:70
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
335         val originalToAdjustedDateMap = _days.flatMap { dayDto ->
336             dayDto.rooms.flatMap { roomDto -> roomDto.sessions }
337         }.map { sessionDto -> dateFromString(sessionDto.startsAt) }.toSet().toList().sorted().mapIndexed { index, date ->
338             val adjustedInstant = dateTimeService.now().plus(index * 24, DateTimeUnit.HOUR)
!!!                                                                      ^ error
339             Pair(date, dateFromString(adjustedInstant.toString()))
340         }.toMap()
341 

```

### style, MaxLineLength (87)

Line detected, which is longer than the defined maximum line length in the code style.

[Documentation](https://detekt.dev/docs/rules/style#maxlinelength)

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:30:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
27     selected: Boolean,
28     active: Boolean,
29     venueMap: String?,
30   ) -> T): Query<T> = Query(-1_395_907_319, arrayOf("conferenceTable"), driver, "Conference.sq", "selectAll", "SELECT conferenceTable.id, conferenceTable.conferenceName, conferenceTable.conferenceTimeZone, conferenceTable.projectId, conferenceTable.collectionName, conferenceTable.apiKey, conferenceTable.scheduleId, conferenceTable.selected, conferenceTable.active, conferenceTable.venueMap FROM conferenceTable") { cursor ->
!! ^ error
31     mapper(
32       cursor.getLong(0)!!,
33       cursor.getString(1)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:58:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
55     selected: Boolean,
56     active: Boolean,
57     venueMap: String?,
58   ) -> T): Query<T> = Query(2_064_180_591, arrayOf("conferenceTable"), driver, "Conference.sq", "selectAllActive", "SELECT conferenceTable.id, conferenceTable.conferenceName, conferenceTable.conferenceTimeZone, conferenceTable.projectId, conferenceTable.collectionName, conferenceTable.apiKey, conferenceTable.scheduleId, conferenceTable.selected, conferenceTable.active, conferenceTable.venueMap FROM conferenceTable WHERE active = 1") { cursor ->
!! ^ error
59     mapper(
60       cursor.getLong(0)!!,
61       cursor.getString(1)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:114:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
111     selected: Boolean,
112     active: Boolean,
113     venueMap: String?,
114   ) -> T): Query<T> = Query(-2_035_931_085, arrayOf("conferenceTable"), driver, "Conference.sq", "selectSelected", "SELECT conferenceTable.id, conferenceTable.conferenceName, conferenceTable.conferenceTimeZone, conferenceTable.projectId, conferenceTable.collectionName, conferenceTable.apiKey, conferenceTable.scheduleId, conferenceTable.selected, conferenceTable.active, conferenceTable.venueMap FROM conferenceTable WHERE selected = 1 LIMIT 1") { cursor ->
!!! ^ error
115     mapper(
116       cursor.getLong(0)!!,
117       cursor.getString(1)!!,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:131:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
128 
129   public fun selectSelected(): Query<ConferenceTable> = selectSelected(::ConferenceTable)
130 
131   public fun lastInsertRowId(): ExecutableQuery<Long> = Query(1_347_239_914, driver, "Conference.sq", "lastInsertRowId", "SELECT last_insert_rowid()") { cursor ->
!!! ^ error
132     cursor.getLong(0)!!
133   }
134 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ConferenceQueries.kt:282:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
279       driver.removeListener("conferenceTable", listener = listener)
280     }
281 
282     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-323_412_630, """SELECT conferenceTable.id, conferenceTable.conferenceName, conferenceTable.conferenceTimeZone, conferenceTable.projectId, conferenceTable.collectionName, conferenceTable.apiKey, conferenceTable.scheduleId, conferenceTable.selected, conferenceTable.active, conferenceTable.venueMap FROM conferenceTable WHERE id = ?""", mapper, 1) {
!!! ^ error
283       var parameterIndex = 0
284       bindLong(parameterIndex++, id)
285     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/DroidconDatabase.kt:37:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
34       conferenceTableAdapter: ConferenceTable.Adapter,
35       sessionTableAdapter: SessionTable.Adapter,
36       sponsorGroupTableAdapter: SponsorGroupTable.Adapter,
37     ): DroidconDatabase = DroidconDatabase::class.newInstance(driver, conferenceTableAdapter, sessionTableAdapter, sponsorGroupTableAdapter)
!! ^ error
38   }
39 }
40 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:43:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
40     )
41   }
42 
43   public fun selectById(id: String, conferenceId: Long): Query<ProfileTable> = selectById(id, conferenceId, ::ProfileTable)
!! ^ error
44 
45   public fun existsById(id: String, conferenceId: Long): Query<Long> = ExistsByIdQuery(id, conferenceId) { cursor ->
46     cursor.getLong(0)!!

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:77:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
74     )
75   }
76 
77   public fun selectBySession(sessionId: String, conferenceId: Long): Query<ProfileTable> = selectBySession(sessionId, conferenceId, ::ProfileTable)
!! ^ error
78 
79   public fun <T : Any> selectBySponsor(
80     sponsorName: String,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:208:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
205       driver.removeListener("profileTable", listener = listener)
206     }
207 
208     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(2_135_878_163, """SELECT profileTable.id, profileTable.conferenceId, profileTable.fullName, profileTable.bio, profileTable.tagLine, profileTable.profilePicture, profileTable.twitter, profileTable.linkedIn, profileTable.website FROM profileTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
!!! ^ error
209       var parameterIndex = 0
210       bindString(parameterIndex++, id)
211       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/ProfileQueries.kt:230:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
227       driver.removeListener("profileTable", listener = listener)
228     }
229 
230     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-297_338_509, """SELECT count(1) FROM profileTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
!!! ^ error
231       var parameterIndex = 0
232       bindString(parameterIndex++, id)
233       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/RoomQueries.kt:59:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
56     conferenceId: Long,
57     name: String,
58   ): QueryResult<Long> {
59     val result = driver.execute(-240_282_582, """INSERT OR REPLACE INTO roomTable(id, conferenceId, name) VALUES(?,?,?)""", 3) {
!! ^ error
60           var parameterIndex = 0
61           bindLong(parameterIndex++, id)
62           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/RoomQueries.kt:75:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
72    * @return The number of rows updated.
73    */
74   public fun deleteById(roomId: Long?, conferenceId: Long): QueryResult<Long> = transactionWithResult {
75     driver.execute(null, """UPDATE sessionTable SET roomId = NULL WHERE roomId ${ if (roomId == null) "IS" else "=" } ? AND conferenceId = ?""", 2) {
!! ^ error
76           var parameterIndex = 0
77           bindLong(parameterIndex++, roomId)
78           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/RoomQueries.kt:80:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
77           bindLong(parameterIndex++, roomId)
78           bindLong(parameterIndex++, conferenceId)
79         }
80     driver.execute(null, """DELETE FROM roomTable WHERE id ${ if (roomId == null) "IS" else "=" } ? AND conferenceId = ?""", 2) {
!! ^ error
81           var parameterIndex = 0
82           bindLong(parameterIndex++, roomId)
83           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/RoomQueries.kt:104:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
101       driver.removeListener("roomTable", listener = listener)
102     }
103 
104     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_144_601_130, """SELECT roomTable.id, roomTable.conferenceId, roomTable.name FROM roomTable WHERE conferenceId = ?""", mapper, 1) {
!!! ^ error
105       var parameterIndex = 0
106       bindLong(parameterIndex++, conferenceId)
107     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/RoomQueries.kt:125:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
122       driver.removeListener("roomTable", listener = listener)
123     }
124 
125     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_122_937_961, """SELECT roomTable.id, roomTable.conferenceId, roomTable.name FROM roomTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
!!! ^ error
126       var parameterIndex = 0
127       bindLong(parameterIndex++, id)
128       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/RoomQueries.kt:147:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
144       driver.removeListener("roomTable", listener = listener)
145     }
146 
147     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_310_278_711, """SELECT count(1) FROM roomTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
!!! ^ error
148       var parameterIndex = 0
149       bindLong(parameterIndex++, id)
150       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:84:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
81     )
82   }
83 
84   public fun attendingSessions(conferenceId: Long): Query<SessionTable> = attendingSessions(conferenceId, ::SessionTable)
!! ^ error
85 
86   public fun existsById(id: String, conferenceId: Long): Query<Long> = ExistsByIdQuery(id, conferenceId) { cursor ->
87     cursor.getLong(0)!!

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:126:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
123     )
124   }
125 
126   public fun sessionById(id: String, conferenceId: Long): Query<SessionTable> = sessionById(id, conferenceId, ::SessionTable)
!!! ^ error
127 
128   public fun <T : Any> mySessions(conferenceId: Long, mapper: (
129     id: String,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:200:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
197     )
198   }
199 
200   public fun userSessions(speakerId: String, conferenceId: Long): Query<SessionTable> = userSessions(speakerId, conferenceId, ::SessionTable)
!!! ^ error
201 
202   public fun <T : Any> sessionFeedbackToSend(conferenceId: Long, mapper: (
203     id: String,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:234:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
231     )
232   }
233 
234   public fun sessionFeedbackToSend(conferenceId: Long): Query<SessionFeedbackToSend> = sessionFeedbackToSend(conferenceId, ::SessionFeedbackToSend)
!!! ^ error
235 
236   public fun <T : Any> sessionWithRoom(
237     conferenceId: Long,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:266:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
263     )
264   }
265 
266   public fun sessionWithRoom(conferenceId: Long, conferenceId_: Long): Query<SessionWithRoom> = sessionWithRoom(conferenceId, conferenceId_, ::SessionWithRoom)
!!! ^ error
267 
268   /**
269    * @return The number of rows updated.

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:319:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
316     id: String,
317     conferenceId: Long,
318   ): QueryResult<Long> {
319     val result = driver.execute(846_711_414, """UPDATE sessionTable SET rsvp = ? WHERE id = ? AND conferenceId = ?""", 3) {
!!! ^ error
320           var parameterIndex = 0
321           bindLong(parameterIndex++, rsvp)
322           bindString(parameterIndex++, id)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:339:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
336     sessionId: String,
337     conferenceId: Long,
338   ): QueryResult<Long> {
339     val result = driver.execute(1_143_530_286, """UPDATE sessionTable SET rsvpSent = ? WHERE id = ? AND conferenceId = ?""", 3) {
!!! ^ error
340           var parameterIndex = 0
341           bindLong(parameterIndex++, rsvpSent)
342           bindString(parameterIndex++, sessionId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:360:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
357     sessionId: String,
358     conferenceId: Long,
359   ): QueryResult<Long> {
360     val result = driver.execute(1_666_204_640, """UPDATE sessionTable SET feedbackRating = ?, feedbackComment = ?, feedbackSent = 0 WHERE id = ? AND conferenceId = ?""", 4) {
!!! ^ error
361           var parameterIndex = 0
362           bindLong(parameterIndex++, feedbackRating?.let { sessionTableAdapter.feedbackRatingAdapter.encode(it) })
363           bindString(parameterIndex++, feedbackComment)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:381:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
378     sessionId: String,
379     conferenceId: Long,
380   ): QueryResult<Long> {
381     val result = driver.execute(-135_096_424, """UPDATE sessionTable SET feedbackSent = ? WHERE id = ? AND conferenceId = ?""", 3) {
!!! ^ error
382           var parameterIndex = 0
383           bindLong(parameterIndex++, feedbackSent)
384           bindString(parameterIndex++, sessionId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:425:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
422       driver.removeListener("sessionTable", listener = listener)
423     }
424 
425     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_652_322_740, """SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable WHERE conferenceId = ? ORDER BY sessionTable.startsAt ASC""", mapper, 1) {
!!! ^ error
426       var parameterIndex = 0
427       bindLong(parameterIndex++, conferenceId)
428     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:445:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
442       driver.removeListener("sessionTable", listener = listener)
443     }
444 
445     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-2_005_357_005, """SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable WHERE rsvp != 0 AND conferenceId = ? ORDER BY sessionTable.startsAt ASC""", mapper, 1) {
!!! ^ error
446       var parameterIndex = 0
447       bindLong(parameterIndex++, conferenceId)
448     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:466:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
463       driver.removeListener("sessionTable", listener = listener)
464     }
465 
466     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_347_964_832, """SELECT count(1) FROM sessionTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
!!! ^ error
467       var parameterIndex = 0
468       bindString(parameterIndex++, id)
469       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:488:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
485       driver.removeListener("sessionTable", listener = listener)
486     }
487 
488     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_040_722_038, """SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable WHERE id = ? AND conferenceId = ?""", mapper, 2) {
!!! ^ error
489       var parameterIndex = 0
490       bindString(parameterIndex++, id)
491       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionQueries.kt:584:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
581       driver.removeListener("sessionTable", listener = listener)
582     }
583 
584     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-33_666_004, """SELECT sessionTable.id, sessionTable.conferenceId, sessionTable.title, sessionTable.description, sessionTable.startsAt, sessionTable.endsAt, sessionTable.serviceSession, sessionTable.rsvp, sessionTable.rsvpSent, sessionTable.roomId, sessionTable.feedbackRating, sessionTable.feedbackComment, sessionTable.feedbackSent FROM sessionTable WHERE feedbackRating IS NOT NULL AND feedbackSent = 0 AND conferenceId = ?""", mapper, 1) {
!!! ^ error
585       var parameterIndex = 0
586       bindLong(parameterIndex++, conferenceId)
587     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:33:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
30     )
31   }
32 
33   public fun selectBySessionId(sessionId: String, conferenceId: Long): Query<SessionSpeakerTable> = selectBySessionId(sessionId, conferenceId, ::SessionSpeakerTable)
!! ^ error
34 
35   public fun <T : Any> selectBySpeakerId(
36     speakerId: String,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:53:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
50     )
51   }
52 
53   public fun selectBySpeakerId(speakerId: String, conferenceId: Long): Query<SessionSpeakerTable> = selectBySpeakerId(speakerId, conferenceId, ::SessionSpeakerTable)
!! ^ error
54 
55   /**
56    * @return The number of rows updated.

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:84:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
81    * @return The number of rows updated.
82    */
83   public fun deleteBySessionId(sessionId: String, conferenceId: Long): QueryResult<Long> {
84     val result = driver.execute(-2_077_169_978, """DELETE FROM sessionSpeakerTable WHERE sessionId = ? AND conferenceId = ?""", 2) {
!! ^ error
85           var parameterIndex = 0
86           bindString(parameterIndex++, sessionId)
87           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:99:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
96     * @return The number of rows updated.
97     */
98    public fun deleteBySpeakerId(speakerId: String, conferenceId: Long): QueryResult<Long> {
99      val result = driver.execute(-140_046_865, """DELETE FROM sessionSpeakerTable WHERE speakerId = ? AND conferenceId = ?""", 2) {
!!  ^ error
100           var parameterIndex = 0
101           bindString(parameterIndex++, speakerId)
102           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:137:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
134       driver.removeListener("sessionSpeakerTable", listener = listener)
135     }
136 
137     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-623_236_395, """SELECT sessionSpeakerTable.sessionId, sessionSpeakerTable.speakerId, sessionSpeakerTable.conferenceId, sessionSpeakerTable.displayOrder FROM sessionSpeakerTable WHERE sessionId = ? AND conferenceId = ?""", mapper, 2) {
!!! ^ error
138       var parameterIndex = 0
139       bindString(parameterIndex++, sessionId)
140       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SessionSpeakerQueries.kt:159:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
156       driver.removeListener("sessionSpeakerTable", listener = listener)
157     }
158 
159     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(1_313_886_718, """SELECT sessionSpeakerTable.sessionId, sessionSpeakerTable.speakerId, sessionSpeakerTable.conferenceId, sessionSpeakerTable.displayOrder FROM sessionSpeakerTable WHERE speakerId = ? AND conferenceId = ?""", mapper, 2) {
!!! ^ error
160       var parameterIndex = 0
161       bindString(parameterIndex++, speakerId)
162       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:52:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
49     )
50   }
51 
52   public fun sponsorGroupByName(name: String, conferenceId: Long): Query<SponsorGroupTable> = sponsorGroupByName(name, conferenceId, ::SponsorGroupTable)
!! ^ error
53 
54   public fun existsByName(name: String, conferenceId: Long): Query<Long> = ExistsByNameQuery(name, conferenceId) { cursor ->
55     cursor.getLong(0)!!

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:54:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
51 
52   public fun sponsorGroupByName(name: String, conferenceId: Long): Query<SponsorGroupTable> = sponsorGroupByName(name, conferenceId, ::SponsorGroupTable)
53 
54   public fun existsByName(name: String, conferenceId: Long): Query<Long> = ExistsByNameQuery(name, conferenceId) { cursor ->
!! ^ error
55     cursor.getLong(0)!!
56   }
57 

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:101:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
98     * @return The number of rows updated.
99     */
100   public fun deleteByName(name: String, conferenceId: Long): QueryResult<Long> {
101     val result = driver.execute(-597_853_070, """DELETE FROM sponsorGroupTable WHERE name = ? AND conferenceId = ?""", 2) {
!!! ^ error
102           var parameterIndex = 0
103           bindString(parameterIndex++, name)
104           bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:124:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
121       driver.removeListener("sponsorGroupTable", listener = listener)
122     }
123 
124     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_695_654_464, """SELECT sponsorGroupTable.name, sponsorGroupTable.conferenceId, sponsorGroupTable.displayPriority, sponsorGroupTable.prominent FROM sponsorGroupTable WHERE conferenceId = ?""", mapper, 1) {
!!! ^ error
125       var parameterIndex = 0
126       bindLong(parameterIndex++, conferenceId)
127     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:145:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
142       driver.removeListener("sponsorGroupTable", listener = listener)
143     }
144 
145     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(2_104_385_292, """SELECT sponsorGroupTable.name, sponsorGroupTable.conferenceId, sponsorGroupTable.displayPriority, sponsorGroupTable.prominent FROM sponsorGroupTable WHERE name = ? AND conferenceId = ? LIMIT 1""", mapper, 2) {
!!! ^ error
146       var parameterIndex = 0
147       bindString(parameterIndex++, name)
148       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorGroupQueries.kt:167:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
164       driver.removeListener("sponsorGroupTable", listener = listener)
165     }
166 
167     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(344_023_651, """SELECT count(1) FROM sponsorGroupTable WHERE name = ? AND conferenceId = ? LIMIT 1""", mapper, 2) {
!!! ^ error
168       var parameterIndex = 0
169       bindString(parameterIndex++, name)
170       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:62:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
59     )
60   }
61 
62   public fun sponsorsByGroup(groupName: String, conferenceId: Long): Query<SponsorTable> = sponsorsByGroup(groupName, conferenceId, ::SponsorTable)
!! ^ error
63 
64   public fun <T : Any> sponsorById(
65     name: String,

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:142:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
139     groupName: String,
140     conferenceId: Long,
141   ): QueryResult<Long> {
142     val result = driver.execute(566_442_739, """DELETE FROM sponsorTable WHERE name = ? AND groupName = ? AND conferenceId = ?""", 3) {
!!! ^ error
143           var parameterIndex = 0
144           bindString(parameterIndex++, name)
145           bindString(parameterIndex++, groupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:180:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
177       driver.removeListener("sponsorTable", listener = listener)
178     }
179 
180     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(600_667_503, """SELECT sponsorTable.name, sponsorTable.groupName, sponsorTable.conferenceId, sponsorTable.hasDetail, sponsorTable.description, sponsorTable.iconUrl, sponsorTable.url FROM sponsorTable WHERE conferenceId = ?""", mapper, 1) {
!!! ^ error
181       var parameterIndex = 0
182       bindLong(parameterIndex++, conferenceId)
183     }

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:201:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
198       driver.removeListener("sponsorTable", listener = listener)
199     }
200 
201     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(708_121_721, """SELECT sponsorTable.name, sponsorTable.groupName, sponsorTable.conferenceId, sponsorTable.hasDetail, sponsorTable.description, sponsorTable.iconUrl, sponsorTable.url FROM sponsorTable WHERE groupName = ? AND conferenceId = ?""", mapper, 2) {
!!! ^ error
202       var parameterIndex = 0
203       bindString(parameterIndex++, groupName)
204       bindLong(parameterIndex++, conferenceId)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:224:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
221       driver.removeListener("sponsorTable", listener = listener)
222     }
223 
224     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_851_740_682, """SELECT sponsorTable.name, sponsorTable.groupName, sponsorTable.conferenceId, sponsorTable.hasDetail, sponsorTable.description, sponsorTable.iconUrl, sponsorTable.url FROM sponsorTable WHERE name = ? AND groupName = ? AND conferenceId = ? LIMIT 1""", mapper, 3) {
!!! ^ error
225       var parameterIndex = 0
226       bindString(parameterIndex++, name)
227       bindString(parameterIndex++, groupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorQueries.kt:248:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
245       driver.removeListener("sponsorTable", listener = listener)
246     }
247 
248     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-992_351_964, """SELECT count(1) FROM sponsorTable WHERE name = ? AND groupName = ? AND conferenceId = ? LIMIT 1""", mapper, 3) {
!!! ^ error
249       var parameterIndex = 0
250       bindString(parameterIndex++, name)
251       bindString(parameterIndex++, groupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:40:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
37     sponsorName: String,
38     sponsorGroupName: String,
39     conferenceId: Long,
40   ): Query<SponsorRepresentativeTable> = selectBySponsorId(sponsorName, sponsorGroupName, conferenceId, ::SponsorRepresentativeTable)
!! ^ error
41 
42   /**
43    * @return The number of rows updated.

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:77:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
74     sponsorGroupName: String,
75     conferenceId: Long,
76   ): QueryResult<Long> {
77     val result = driver.execute(1_942_852_960, """DELETE FROM sponsorRepresentativeTable WHERE sponsorName = ? AND sponsorGroupName = ? AND conferenceId = ?""", 3) {
!! ^ error
78           var parameterIndex = 0
79           bindString(parameterIndex++, sponsorName)
80           bindString(parameterIndex++, sponsorGroupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/SponsorRepresentativeQueries.kt:117:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
114       driver.removeListener("sponsorRepresentativeTable", listener = listener)
115     }
116 
117     override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-898_180_753, """SELECT sponsorRepresentativeTable.sponsorName, sponsorRepresentativeTable.sponsorGroupName, sponsorRepresentativeTable.representativeId, sponsorRepresentativeTable.conferenceId, sponsorRepresentativeTable.displayOrder FROM sponsorRepresentativeTable WHERE sponsorName = ? AND sponsorGroupName = ? AND conferenceId = ?""", mapper, 3) {
!!! ^ error
118       var parameterIndex = 0
119       bindString(parameterIndex++, sponsorName)
120       bindString(parameterIndex++, sponsorGroupName)

```

* /tmp/output/phase1/before/shared/build/generated/sqldelight/code/DroidconDatabase/commonMain/co/touchlab/droidcon/db/shared/DroidconDatabaseImpl.kt:32:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
29   conferenceTableAdapter: ConferenceTable.Adapter,
30   sessionTableAdapter: SessionTable.Adapter,
31   sponsorGroupTableAdapter: SponsorGroupTable.Adapter,
32 ): DroidconDatabase = DroidconDatabaseImpl(driver, conferenceTableAdapter, sessionTableAdapter, sponsorGroupTableAdapter)
!! ^ error
33 
34 private class DroidconDatabaseImpl(
35   driver: SqlDriver,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/application/service/NotificationService.kt:10:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
7  interface NotificationService {
8      suspend fun initialize(): Boolean
9  
10     suspend fun schedule(notification: Notification.Local, title: String, body: String, delivery: Instant, dismiss: Instant?)
!! ^ error
11 
12     suspend fun cancel(sessionIds: List<Session.Id>)
13 

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/application/service/impl/DefaultNotificationSchedulingService.kt:74:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
71         sessionFlow
72             .combine(
73                 settingsFlow,
74                 transform = { agenda, settings -> Triple(agenda, settings.isRemindersEnabled, settings.isFeedbackEnabled) },
!! ^ error
75             )
76             .distinctUntilChanged()
77             .collect { (agenda, isRemindersEnabled, isFeedbackEnabled) ->

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/application/service/impl/DefaultNotificationSchedulingService.kt:96:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
93                                  roomRepository.get(it, conferenceConfigProvider.getConferenceId()).name
94                              }
95                              val reminderDelivery =
96                                  session.startsAt.plus(NotificationSchedulingService.REMINDER_DELIVERY_START_OFFSET, DateTimeUnit.MINUTE)
!!  ^ error
97                              if (session.endsAt >= dateTimeService.now()) {
98                                  notificationService.schedule(
99                                      notification = Notification.Local.Reminder(

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/application/service/impl/DefaultNotificationSchedulingService.kt:115:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
112 
113                         if (isFeedbackEnabled) {
114                             val feedbackDelivery =
115                                 session.endsAt.plus(NotificationSchedulingService.FEEDBACK_DISMISS_END_OFFSET, DateTimeUnit.MINUTE)
!!! ^ error
116                             if (feedbackDelivery.plus(24, DateTimeUnit.HOUR) >= dateTimeService.now() && session.feedback == null) {
117                                 notificationService.schedule(
118                                     notification = Notification.Local.Feedback(

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/application/service/impl/DefaultNotificationSchedulingService.kt:116:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
113                         if (isFeedbackEnabled) {
114                             val feedbackDelivery =
115                                 session.endsAt.plus(NotificationSchedulingService.FEEDBACK_DISMISS_END_OFFSET, DateTimeUnit.MINUTE)
116                             if (feedbackDelivery.plus(24, DateTimeUnit.HOUR) >= dateTimeService.now() && session.feedback == null) {
!!! ^ error
117                                 notificationService.schedule(
118                                     notification = Notification.Local.Feedback(
119                                         sessionId = session.id,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/entity/SponsorGroup.kt:3:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
1 package co.touchlab.droidcon.domain.entity
2 
3 class SponsorGroup(override val id: Id, val displayPriority: Int, val isProminent: Boolean) : DomainEntity<SponsorGroup.Id>() {
! ^ error
4     val name: String
5         get() = id.value
6 

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/gateway/impl/DefaultSessionGateway.kt:25:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
22 
23     private val conferenceId get() = conferenceConfigProvider.getConferenceId()
24 
25     override fun observeSchedule(): Flow<List<ScheduleItem>> = conferenceConfigProvider.observeChanges().flatMapLatest { conf ->
!! ^ error
26         sessionRepository.observeAll(conf.id)
27     }.map { sessions ->
28         sessions.map { session ->

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/gateway/impl/DefaultSessionGateway.kt:33:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
30         }
31     }
32 
33     override fun observeAgenda(): Flow<List<ScheduleItem>> = conferenceConfigProvider.observeChanges().flatMapLatest { conf ->
!! ^ error
34         sessionRepository.observeAllAttending(conf.id)
35     }.map { sessions ->
36         sessions.map { session ->

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/gateway/impl/DefaultSessionGateway.kt:41:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
38         }
39     }
40 
41     override fun observeScheduleItem(id: Session.Id): Flow<ScheduleItem> = sessionRepository.observe(id, conferenceId).map { session ->
!! ^ error
42         scheduleItemForSession(session)
43     }
44 

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightConferenceRepository.kt:24:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
21     override fun observeSelected(): Flow<Conference> =
22         conferenceQueries.selectSelected(::conferenceFactory).asFlow().mapToOne(Dispatchers.Main)
23 
24     override suspend fun getSelected(): Conference = conferenceQueries.selectSelected(::conferenceFactory).executeAsOne()
!! ^ error
25 
26     override suspend fun select(conferenceId: Long): Boolean {
27         try {

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightRoomRepository.kt:17:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
14     BaseRepository<Room.Id, Room>(),
15     RoomRepository {
16 
17     override fun allSync(conferenceId: Long): List<Room> = roomQueries.selectAll(conferenceId, ::roomFactory).executeAsList()
!! ^ error
18 
19     override fun observe(id: Room.Id, conferenceId: Long): Flow<Room> =
20         roomQueries.selectById(id.value, conferenceId, ::roomFactory).asFlow().mapToOne(Dispatchers.Main)

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightRoomRepository.kt:40:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
37         roomQueries.deleteById(id.value, conferenceId)
38     }
39 
40     override fun contains(id: Room.Id, conferenceId: Long): Boolean = roomQueries.existsById(id.value, conferenceId).executeAsOne() != 0L
!! ^ error
41 
42     private fun roomFactory(id: Long, conferenceId: Long, name: String) = Room(id = Room.Id(id), name = name)
43 }

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightSessionRepository.kt:17:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
14 import kotlinx.coroutines.flow.Flow
15 import kotlinx.coroutines.flow.first
16 
17 class SqlDelightSessionRepository(private val dateTimeService: DateTimeService, private val sessionQueries: SessionQueries) :
!! ^ error
18     BaseRepository<Session.Id, Session>(),
19     SessionRepository {
20     override fun observe(id: Session.Id, conferenceId: Long): Flow<Session> =

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightSessionRepository.kt:50:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
47         sessionQueries.updateFeedBackSent(if (isSent) 1 else 0, sessionId.value, conferenceId)
48     }
49 
50     override fun allSync(conferenceId: Long): List<Session> = sessionQueries.allSessions(conferenceId, ::sessionFactory).executeAsList()
!! ^ error
51 
52     override fun findSync(id: Session.Id, conferenceId: Long): Session? =
53         sessionQueries.sessionById(id.value, conferenceId, mapper = ::sessionFactory).executeAsOneOrNull()

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightSponsorGroupRepository.kt:48:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
45         sponsorGroupQueries.deleteByName(id.value, conferenceId)
46     }
47 
48     private fun sponsorGroupFactory(name: String, conferenceId: Long, displayPriority: Int, isProminent: Boolean) = SponsorGroup(
!! ^ error
49         id = SponsorGroup.Id(name),
50         displayPriority = displayPriority,
51         isProminent = isProminent,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightSponsorRepository.kt:35:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
32     override suspend fun allByGroupName(group: String, conferenceId: Long): List<Sponsor> =
33         sponsorQueries.sponsorsByGroup(group, conferenceId, ::sponsorFactory).executeAsList()
34 
35     override fun allSync(conferenceId: Long): List<Sponsor> = sponsorQueries.selectAll(conferenceId, ::sponsorFactory).executeAsList()
!! ^ error
36 
37     override fun doUpsert(entity: Sponsor, conferenceId: Long) {
38         sponsorQueries.upsert(

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/DateTimeService.kt:17:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
14     fun LocalDateTime.fromConferenceDateTime(conferenceTimeZone: TimeZone): Instant
15 }
16 
17 fun Instant.toConferenceDateTime(dateTimeService: DateTimeService, conferenceTimeZone: TimeZone): LocalDateTime = with(dateTimeService) {
!! ^ error
18     toConferenceDateTime(conferenceTimeZone)
19 }
20 

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/DateTimeService.kt:21:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
18     toConferenceDateTime(conferenceTimeZone)
19 }
20 
21 fun LocalDateTime.fromConferenceDateTime(dateTimeService: DateTimeService, conferenceTimeZone: TimeZone): Instant = with(dateTimeService) {
!! ^ error
22     fromConferenceDateTime(conferenceTimeZone)
23 }
24 

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultConferenceConfigProvider.kt:12:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
9  import kotlinx.coroutines.flow.StateFlow
10 import kotlinx.datetime.TimeZone
11 
12 class DefaultConferenceConfigProvider(private val conferenceRepository: ConferenceRepository, initialConference: Conference) :
!! ^ error
13     ConferenceConfigProvider {
14     private val log = Logger.withTag("DefaultConferenceConfigProvider")
15     private val _currentConferenceState = MutableStateFlow(initialConference)

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultDateTimeService.kt:17:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
14 
15     override fun conferenceNow(timeZone: TimeZone): LocalDateTime = now().toConferenceDateTime(timeZone)
16 
17     override fun Instant.toConferenceDateTime(conferenceTimeZone: TimeZone): LocalDateTime = toLocalDateTime(conferenceTimeZone)
!! ^ error
18 
19     override fun LocalDateTime.fromConferenceDateTime(conferenceTimeZone: TimeZone): Instant = toInstant(conferenceTimeZone)
20 }

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultDateTimeService.kt:19:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
16 
17     override fun Instant.toConferenceDateTime(conferenceTimeZone: TimeZone): LocalDateTime = toLocalDateTime(conferenceTimeZone)
18 
19     override fun LocalDateTime.fromConferenceDateTime(conferenceTimeZone: TimeZone): Instant = toInstant(conferenceTimeZone)
!! ^ error
20 }
21 

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultServerApi.kt:16:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
13 import io.ktor.http.takeFrom
14 import kotlinx.serialization.json.Json
15 
16 class DefaultServerApi(private val userIdProvider: UserIdProvider, private val client: HttpClient, private val json: Json) : ServerApi {
!! ^ error
17     override suspend fun setRsvp(sessionId: Session.Id, isAttending: Boolean): Boolean {
18         val methodName = if (isAttending) {
19             "sessionizeRsvpEvent"

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:78:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
75                     val lastSessionizeSync = lastSessionizeSyncThisLoop
76 
77                     val timeToSync =
78                         lastSessionizeSync <= dateTimeService.now().minus(SESSIONIZE_SYNC_SINCE_LAST_MINUTES, DateTimeUnit.MINUTE)
!! ^ error
79 
80                     log.w("DATASYNC runSynchronization called with $conference")
81                     try { // Run sync if either condition is true

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:152:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
149                             .forEach { (sessionId, feedback) ->
150                                 while (isActive) {
151                                     try {
152                                         val isFeedbackSent = serverApi.setFeedback(sessionId, feedback.rating, feedback.comment)
!!! ^ error
153                                         if (isFeedbackSent) {
154                                             sessionRepository.setFeedbackSent(
155                                                 sessionId,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:194:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
191         val days = dataSource.getSchedule()
192         val sponsorSessionsGroups = dataSource.getSponsorSessions()
193 
194         // DB Transactions for db mods are ridiculously faster than non-trans changes. Also, if something fails, thd db will roll back.
!!! ^ error
195         // The repo architecture will likely need to change. Everything is suspend and unconcerned with thread, but that's not good practice.
196         db.transaction {
197             updateSpeakersFromDataSource(speakerDtos, conference)

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:195:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
192         val sponsorSessionsGroups = dataSource.getSponsorSessions()
193 
194         // DB Transactions for db mods are ridiculously faster than non-trans changes. Also, if something fails, thd db will roll back.
195         // The repo architecture will likely need to change. Everything is suspend and unconcerned with thread, but that's not good practice.
!!! ^ error
196         db.transaction {
197             updateSpeakersFromDataSource(speakerDtos, conference)
198             updateScheduleFromDataSource(days, conference)

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:337:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
334     private fun updateScheduleFromDataSource(_days: List<ScheduleDto.DayDto>, conference: Conference) {
335         val originalToAdjustedDateMap = _days.flatMap { dayDto ->
336             dayDto.rooms.flatMap { roomDto -> roomDto.sessions }
337         }.map { sessionDto -> dateFromString(sessionDto.startsAt) }.toSet().toList().sorted().mapIndexed { index, date ->
!!! ^ error
338             val adjustedInstant = dateTimeService.now().plus(index * 24, DateTimeUnit.HOUR)
339             Pair(date, dateFromString(adjustedInstant.toString()))
340         }.toMap()

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:397:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
394                     id = Session.Id(dto.id),
395                     title = dto.title,
396                     description = dto.description,
397                     startsAt = LocalDateTime.parse(dto.startsAt).fromConferenceDateTime(dateTimeService, conference.timeZone),
!!! ^ error
398                     endsAt = LocalDateTime.parse(dto.endsAt).fromConferenceDateTime(dateTimeService, conference.timeZone),
399                     isServiceSession = dto.isServiceSession,
400                     room = Room.Id(dto.roomID),

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:398:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
395                     title = dto.title,
396                     description = dto.description,
397                     startsAt = LocalDateTime.parse(dto.startsAt).fromConferenceDateTime(dateTimeService, conference.timeZone),
398                     endsAt = LocalDateTime.parse(dto.endsAt).fromConferenceDateTime(dateTimeService, conference.timeZone),
!!! ^ error
399                     isServiceSession = dto.isServiceSession,
400                     room = Room.Id(dto.roomID),
401                     rsvp = Session.RSVP(

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/dto/ConferencesDto.kt:15:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
12     )
13 
14     @Serializable
15     data class ConferenceDocumentDto(val name: String, val fields: ConferenceFields, val createTime: String, val updateTime: String)
!! ^ error
16 
17     @Serializable
18     data class ConferenceFields(

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/dto/SpeakersDto.kt:52:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
49 
50             override val descriptor: SerialDescriptor
51                 get() {
52                     return PrimitiveSerialDescriptor("co.touchlab.droidcon.domain.service.impl.dto.LinkType", PrimitiveKind.STRING)
!! ^ error
53                 }
54 
55             override fun deserialize(decoder: Decoder): LinkType = decoder.decodeString().let {

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/dto/SponsorSessionsDto.kt:11:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
8      data class SessionGroupDto(val sessions: List<SessionDto>)
9  
10     @Serializable
11     data class SessionDto(val id: String, val title: String, val description: String?, val speakers: List<SpeakerReferenceDto>)
!! ^ error
12 
13     @Serializable
14     data class SpeakerReferenceDto(val id: String, val name: String)

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/dto/SponsorsDto.kt:15:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
12     )
13 
14     @Serializable
15     data class SponsorGroupDto(val name: String, val fields: DocumentFields, val createTime: String, val updateTime: String)
!! ^ error
16 
17     @Serializable
18     data class DocumentFields(val displayOrder: DisplayOrder, val sponsors: Sponsors, val prominent: BooleanValue? = null)

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/dto/SponsorsDto.kt:18:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
15     data class SponsorGroupDto(val name: String, val fields: DocumentFields, val createTime: String, val updateTime: String)
16 
17     @Serializable
18     data class DocumentFields(val displayOrder: DisplayOrder, val sponsors: Sponsors, val prominent: BooleanValue? = null)
!! ^ error
19 
20     @Serializable
21     data class DisplayOrder(val integerValue: String)

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/dto/SponsorsDto.kt:36:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
33     data class MapValue(val fields: MapValueFields)
34 
35     @Serializable
36     data class MapValueFields(val sponsorId: StringValue? = null, val name: StringValue, val icon: StringValue, val url: StringValue)
!! ^ error
37 
38     @Serializable
39     data class StringValue(val stringValue: String)

```

### style, UnusedParameter (5)

Function parameter is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedparameter)

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightProfileRepository.kt:100:9
```
Function parameter `conferenceId` is unused.
```
```kotlin
97  
98      private fun profileFactory(
99          id: String,
100         conferenceId: Long,
!!!         ^ error
101         fullName: String,
102         bio: String?,
103         tagLine: String?,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightRoomRepository.kt:42:39
```
Function parameter `conferenceId` is unused.
```
```kotlin
39 
40     override fun contains(id: Room.Id, conferenceId: Long): Boolean = roomQueries.existsById(id.value, conferenceId).executeAsOne() != 0L
41 
42     private fun roomFactory(id: Long, conferenceId: Long, name: String) = Room(id = Room.Id(id), name = name)
!!                                       ^ error
43 }
44 

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightSessionRepository.kt:85:9
```
Function parameter `conferenceId` is unused.
```
```kotlin
82 
83     private fun sessionFactory(
84         id: String,
85         conferenceId: Long,
!!         ^ error
86         title: String,
87         description: String?,
88         startsAt: Instant,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightSponsorGroupRepository.kt:48:51
```
Function parameter `conferenceId` is unused.
```
```kotlin
45         sponsorGroupQueries.deleteByName(id.value, conferenceId)
46     }
47 
48     private fun sponsorGroupFactory(name: String, conferenceId: Long, displayPriority: Int, isProminent: Boolean) = SponsorGroup(
!!                                                   ^ error
49         id = SponsorGroup.Id(name),
50         displayPriority = displayPriority,
51         isProminent = isProminent,

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightSponsorRepository.kt:56:9
```
Function parameter `conferenceId` is unused.
```
```kotlin
53     private fun sponsorFactory(
54         name: String,
55         groupName: String,
56         conferenceId: Long,
!!         ^ error
57         hasDetail: Boolean,
58         description: String?,
59         iconUrl: String,

```

### style, UnusedPrivateProperty (3)

Property is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedprivateproperty)

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultConferenceConfigProvider.kt:14:17
```
Private property `log` is unused.
```
```kotlin
11 
12 class DefaultConferenceConfigProvider(private val conferenceRepository: ConferenceRepository, initialConference: Conference) :
13     ConferenceConfigProvider {
14     private val log = Logger.withTag("DefaultConferenceConfigProvider")
!!                 ^ error
15     private val _currentConferenceState = MutableStateFlow(initialConference)
16     val currentConferenceState: StateFlow<Conference> = _currentConferenceState
17 

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultServerApi.kt:16:112
```
Private property `json` is unused.
```
```kotlin
13 import io.ktor.http.takeFrom
14 import kotlinx.serialization.json.Json
15 
16 class DefaultServerApi(private val userIdProvider: UserIdProvider, private val client: HttpClient, private val json: Json) : ServerApi {
!!                                                                                                                ^ error
17     override suspend fun setRsvp(sessionId: Session.Id, isAttending: Boolean): Boolean {
18         val methodName = if (isAttending) {
19             "sessionizeRsvpEvent"

```

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/util/AppChecker.kt:10:30
```
Private property `conferenceConfigProvider` is unused.
```
```kotlin
7   * Previously contained time zone hash checking, which has been removed.
8   * Keeping the class for potential future app verification checks.
9   */
10 class AppChecker(private val conferenceConfigProvider: ConferenceConfigProvider)
!!                              ^ error
11 

```

### style, UseCheckOrError (1)

Use check() or error() instead of throwing an IllegalStateException.

[Documentation](https://detekt.dev/docs/rules/style#usecheckorerror)

* /tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt:215:20
```
Use check() or error() instead of throwing an IllegalStateException.
```
```kotlin
212         log.d { "Syncing conferences from Firestore" }
213         try {
214             val apiDataSource = apiDataSource as? DefaultApiDataSource
215                 ?: throw IllegalStateException("apiDataSource is not DefaultApiDataSource")
!!!                    ^ error
216 
217             // Get conferences from Firestore
218             val conferencesFromFirestore = apiDataSource.getConferences()

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2026-05-22 22:43:05 UTC
