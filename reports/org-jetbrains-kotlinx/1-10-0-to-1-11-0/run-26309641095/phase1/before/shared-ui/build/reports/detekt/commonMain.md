# detekt

## Metrics

* 270 number of properties

* 110 number of functions

* 63 number of classes

* 13 number of packages

* 52 number of kt files

## Complexity Report

* 4,133 lines of code (loc)

* 3,634 source lines of code (sloc)

* 2,357 logical lines of code (lloc)

* 56 comment lines of code (cloc)

* 262 cyclomatic complexity (mcc)

* 219 cognitive complexity

* 171 number of total code smells

* 1% comment source ratio

* 111 mcc per 1,000 lloc

* 72 code smells per 1,000 lloc

## Findings (171)

### complexity, CyclomaticComplexMethod (1)

Prefer splitting up complex methods into smaller, easier to test methods.

[Documentation](https://detekt.dev/docs/rules/complexity#cyclomaticcomplexmethod)

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionDetailView.kt:61:14
```
The function SessionDetailView appears to be too complex based on Cyclomatic Complexity (complexity: 15). Defined complexity threshold for methods is set to '15'
```
```kotlin
58 
59 @OptIn(ExperimentalMaterial3Api::class)
60 @Composable
61 internal fun SessionDetailView(viewModel: SessionDetailViewModel) {
!!              ^ error
62     NavigationStack(
63         key = viewModel,
64         links = {

```

### complexity, LongMethod (7)

One method should have one responsibility. Long methods tend to handle many things at once. Prefer smaller methods to make them easier to understand.

[Documentation](https://detekt.dev/docs/rules/complexity#longmethod)

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/FeedbackDialog.kt:40:14
```
The function FeedbackDialog is too long (79). The maximum length is 60.
```
```kotlin
37 
38 @OptIn(ExperimentalMaterial3Api::class)
39 @Composable
40 internal fun FeedbackDialog(feedback: FeedbackDialogViewModel) {
!!              ^ error
41     Dialog(dismiss = feedback::skipTapped) {
42         Card(
43             modifier = Modifier.padding(Dimensions.Padding.double),

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionBlockView.kt:32:14
```
The function SessionBlockView is too long (63). The maximum length is 60.
```
```kotlin
29 
30 @OptIn(ExperimentalMaterial3Api::class)
31 @Composable
32 internal fun SessionBlockView(sessionsBlock: SessionBlockViewModel) {
!!              ^ error
33     Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopStart) {
34         Text(
35             text = sessionsBlock.time,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionDetailView.kt:61:14
```
The function SessionDetailView is too long (115). The maximum length is 60.
```
```kotlin
58 
59 @OptIn(ExperimentalMaterial3Api::class)
60 @Composable
61 internal fun SessionDetailView(viewModel: SessionDetailViewModel) {
!!              ^ error
62     NavigationStack(
63         key = viewModel,
64         links = {

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionListView.kt:63:14
```
The function SessionListView is too long (118). The maximum length is 60.
```
```kotlin
60 
61 @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
62 @Composable
63 internal fun SessionListView(viewModel: BaseSessionListViewModel, title: String, emptyText: String) {
!!              ^ error
64     NavigationStack(
65         key = viewModel,
66         links = {

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorDetailView.kt:180:13
```
The function RepresentativeInfoView is too long (61). The maximum length is 60.
```
```kotlin
177 }
178 
179 @Composable
180 private fun RepresentativeInfoView(profile: SpeakerListItemViewModel) {
!!!             ^ error
181     Column(
182         modifier = Modifier
183             .fillMaxWidth()

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorsView.kt:98:13
```
The function SponsorGroupView is too long (64). The maximum length is 60.
```
```kotlin
95  }
96  
97  @Composable
98  private fun SponsorGroupView(sponsorGroup: SponsorGroupViewModel) {
!!              ^ error
99      Card(
100         modifier = Modifier.padding(
101             vertical = Dimensions.Padding.quarter,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/WebLinkText.kt:31:14
```
The function WebLinkText is too long (68). The maximum length is 60.
```
```kotlin
28 import co.touchlab.droidcon.dto.WebLink
29 
30 @Composable
31 internal fun WebLinkText(
!!              ^ error
32     text: String,
33     links: List<WebLink>,
34     modifier: Modifier = Modifier,

```

### complexity, LongParameterList (7)

The more parameters a function has the more complex it is. Long parameter lists are often used to control complex algorithms and violate the Single Responsibility Principle. Prefer functions with short parameter lists.

[Documentation](https://detekt.dev/docs/rules/complexity#longparameterlist)

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/WebLinkText.kt:31:25
```
The function WebLinkText(text: String, links: List<WebLink>, modifier: Modifier, normalTextColor: Color, fontSize: TextUnit, fontStyle: FontStyle?, fontWeight: FontWeight?, fontFamily: FontFamily?, letterSpacing: TextUnit, normalTextDecoration: TextDecoration?, textAlign: TextAlign?, lineHeight: TextUnit, overflow: TextOverflow, softWrap: Boolean, maxLines: Int, onTextLayout: (TextLayoutResult) -> Unit, style: TextStyle) has too many parameters. The current threshold is set to 6.
```
```kotlin
28 import co.touchlab.droidcon.dto.WebLink
29 
30 @Composable
31 internal fun WebLinkText(
!!                         ^ error
32     text: String,
33     links: List<WebLink>,
34     modifier: Modifier = Modifier,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/ApplicationViewModel.kt:22:27
```
The constructor(scheduleFactory: ScheduleViewModel.Factory, agendaFactory: AgendaViewModel.Factory, sponsorsFactory: SponsorListViewModel.Factory, settingsFactory: SettingsViewModel.Factory, feedbackDialogFactory: FeedbackDialogViewModel.Factory, syncService: SyncService, notificationSchedulingService: NotificationSchedulingService, notificationService: NotificationService, feedbackService: FeedbackService, settingsGateway: SettingsGateway, conferenceRepository: ConferenceRepository) has too many parameters. The current threshold is set to 7.
```
```kotlin
19 import org.brightify.hyperdrive.multiplatformx.property.MutableObservableProperty
20 import org.brightify.hyperdrive.multiplatformx.property.ObservableProperty
21 
22 class ApplicationViewModel(
!!                           ^ error
23     scheduleFactory: ScheduleViewModel.Factory,
24     agendaFactory: AgendaViewModel.Factory,
25     sponsorsFactory: SponsorListViewModel.Factory,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/ApplicationViewModel.kt:37:18
```
The constructor(scheduleFactory: ScheduleViewModel.Factory, agendaFactory: AgendaViewModel.Factory, sponsorsFactory: SponsorListViewModel.Factory, settingsFactory: SettingsViewModel.Factory, feedbackDialogFactory: FeedbackDialogViewModel.Factory, syncService: SyncService, notificationSchedulingService: NotificationSchedulingService, notificationService: NotificationService, feedbackService: FeedbackService, settingsGateway: SettingsGateway, conferenceRepository: ConferenceRepository) has too many parameters. The current threshold is set to 7.
```
```kotlin
34 ) : BaseViewModel(),
35     DeepLinkNotificationHandler {
36 
37     class Factory(
!!                  ^ error
38         private val scheduleFactory: ScheduleViewModel.Factory,
39         private val agendaFactory: AgendaViewModel.Factory,
40         private val sponsorsFactory: SponsorListViewModel.Factory,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/BaseSessionListViewModel.kt:9:40
```
The constructor(sessionGateway: SessionGateway, sessionDayFactory: SessionDayViewModel.Factory, sessionDetailFactory: SessionDetailViewModel.Factory, sessionDetailScrollStateStorage: SessionDetailScrollStateStorage, dateTimeService: DateTimeService, conferenceConfigProvider: ConferenceConfigProvider, attendingOnly: Boolean) has too many parameters. The current threshold is set to 7.
```
```kotlin
6  import co.touchlab.droidcon.domain.service.toConferenceDateTime
7  import org.brightify.hyperdrive.multiplatformx.BaseViewModel
8  
9  abstract class BaseSessionListViewModel(
!                                         ^ error
10     private val sessionGateway: SessionGateway,
11     private val sessionDayFactory: SessionDayViewModel.Factory,
12     private val sessionDetailFactory: SessionDetailViewModel.Factory,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionDayViewModel.kt:12:26
```
The constructor(sessionBlockFactory: SessionBlockViewModel.Factory, dateFormatter: DateFormatter, dateTimeService: DateTimeService, conferenceConfigProvider: ConferenceConfigProvider, date: LocalDate, attendingOnly: Boolean, sessionDetailScrollStateStorage: SessionDetailScrollStateStorage, items: List<ScheduleItem>, onScheduleItemSelected: (ScheduleItem) -> Unit) has too many parameters. The current threshold is set to 7.
```
```kotlin
9  import kotlinx.datetime.LocalDate
10 import org.brightify.hyperdrive.multiplatformx.BaseViewModel
11 
12 class SessionDayViewModel(
!!                          ^ error
13     sessionBlockFactory: SessionBlockViewModel.Factory,
14     dateFormatter: DateFormatter,
15     dateTimeService: DateTimeService,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionDetailViewModel.kt:25:29
```
The constructor(sessionGateway: SessionGateway, settingsGateway: SettingsGateway, conferenceConfigProvider: ConferenceConfigProvider, speakerListItemFactory: SpeakerListItemViewModel.Factory, speakerDetailFactory: SpeakerDetailViewModel.Factory, feedbackDialogFactory: FeedbackDialogViewModel.Factory, dateFormatter: DateFormatter, dateTimeService: DateTimeService, parseUrlViewService: ParseUrlViewService, feedbackService: FeedbackService, notificationService: NotificationService, initialItem: ScheduleItem) has too many parameters. The current threshold is set to 7.
```
```kotlin
22 import org.brightify.hyperdrive.multiplatformx.property.identityEqualityPolicy
23 import org.brightify.hyperdrive.multiplatformx.property.map
24 
25 class SessionDetailViewModel(
!!                             ^ error
26     private val sessionGateway: SessionGateway,
27     private val settingsGateway: SettingsGateway,
28     private val conferenceConfigProvider: ConferenceConfigProvider,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionDetailViewModel.kt:155:18
```
The constructor(sessionGateway: SessionGateway, settingsGateway: SettingsGateway, conferenceConfigProvider: ConferenceConfigProvider, speakerListItemFactory: SpeakerListItemViewModel.Factory, speakerDetailFactory: SpeakerDetailViewModel.Factory, feedbackDialogFactory: FeedbackDialogViewModel.Factory, dateFormatter: DateFormatter, dateTimeService: DateTimeService, parseUrlViewService: ParseUrlViewService, feedbackService: FeedbackService, notificationService: NotificationService) has too many parameters. The current threshold is set to 7.
```
```kotlin
152         Ended,
153     }
154 
155     class Factory(
!!!                  ^ error
156         private val sessionGateway: SessionGateway,
157         private val settingsGateway: SettingsGateway,
158         private val conferenceConfigProvider: ConferenceConfigProvider,

```

### exceptions, SwallowedException (1)

The caught exception is swallowed. The original exception could be lost.

[Documentation](https://detekt.dev/docs/rules/exceptions#swallowedexception)

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/sponsor/SponsorGroupItemViewModel.kt:16:18
```
The caught exception is swallowed. The original exception could be lost.
```
```kotlin
13     val validImageUrl: String? =
14         try {
15             Url(sponsor.icon.string).toString()
16         } catch (e: URLParserException) {
!!                  ^ error
17             null
18         }
19 

```

### exceptions, TooGenericExceptionCaught (10)

The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.

[Documentation](https://detekt.dev/docs/rules/exceptions#toogenericexceptioncaught)

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/ApplicationViewModel.kt:107:22
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
104         lifecycle.whileAttached {
105             try {
106                 notificationSchedulingService.runScheduling()
107             } catch (e: Exception) {
!!!                      ^ error
108                 log.e(e) { "Error starting notification scheduling service" }
109             }
110         }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/ApplicationViewModel.kt:115:22
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
112         lifecycle.whileAttached {
113             try {
114                 syncService.runSynchronization(conference = conference)
115             } catch (e: Exception) {
!!!                      ^ error
116                 log.e(e) { "Error starting sync service" }
117             }
118         }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/ApplicationViewModel.kt:125:22
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
122                 if (feedbackEnabled) {
123                     presentNextFeedback()
124                 }
125             } catch (e: Exception) {
!!!                      ^ error
126                 log.e(e) { "Error in onAppear" }
127             }
128         }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/ApplicationViewModel.kt:141:22
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
138                 conferenceRepository.observeAll().collect { conferences ->
139                     _allConferences.value = conferences
140                 }
141             } catch (e: Exception) {
!!!                      ^ error
142                 log.e(e) { "Error initializing conferences" }
143             }
144         }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/ApplicationViewModel.kt:152:22
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
149                 settingsGateway.settings().collect { settings ->
150                     _isFirstRun.value = settings.isFirstRun
151                 }
152             } catch (e: Exception) {
!!!                      ^ error
153                 log.e(e) { "Error observing first run status" }
154             }
155         }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/ApplicationViewModel.kt:167:30
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
164                     // We're not checking whether feedback is enabled, because the user opened a feedback notification.
165                     try {
166                         presentNextFeedback()
167                     } catch (e: Exception) {
!!!                              ^ error
168                         log.e(e) { "Error processing feedback notification" }
169                     }
170                 }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/ApplicationViewModel.kt:187:22
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
184 
185                 // Mark first run complete after conference selection
186                 settingsGateway.setFirstRun(false)
187             } catch (e: Exception) {
!!!                      ^ error
188                 log.e(e) { "Error selecting conference" }
189             }
190         }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/ApplicationViewModel.kt:216:18
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
213             } else {
214                 presentedFeedback = null
215             }
216         } catch (e: Exception) {
!!!                  ^ error
217             log.e(e) { "Error presenting feedback" }
218             presentedFeedback = null
219         }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/WaitForLoadedContextModel.kt:42:26
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
39             withContext(Dispatchers.IO) {
40                 try {
41                     syncService.syncConferences()
42                 } catch (e: Exception) {
!!                          ^ error
43                     log.e(e) { "Failed to sync conferences" }
44                 }
45             }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/settings/SettingsViewModel.kt:77:26
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
74                     val selectedConf = conferenceRepository.getSelected()
75                     log.d { "Got updated conference: ${selectedConf.name} (ID: ${selectedConf.id})" }
76                     _selectedConference.value = selectedConf
77                 } catch (e: Exception) {
!!                          ^ error
78                     log.e(e) { "Error getting selected conference after selection" }
79                 }
80             }

```

### naming, FunctionNaming (50)

Function names should follow the naming convention set in the configuration.

[Documentation](https://detekt.dev/docs/rules/naming#functionnaming)

* /tmp/output/phase1/before/shared-ui/build/generated/compose/resourceGenerator/kotlin/commonMainResourceAccessors/droidcon/shared_ui/generated/resources/Drawable0.commonMain.kt:21:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
18     }
19 
20 @InternalResourceApi
21 internal fun _collectCommonMainDrawable0Resources(map: MutableMap<String, DrawableResource>) {
!!              ^ error
22   map.put("venue_map_1", Res.drawable.venue_map_1)
23 }
24 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/BottomNavigationView.kt:30:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
27 import co.touchlab.droidcon.viewmodel.ApplicationViewModel
28 
29 @Composable
30 internal fun BottomNavigationView(viewModel: ApplicationViewModel, currentConference: Conference, modifier: Modifier = Modifier) {
!!              ^ error
31     val selectedTab by viewModel.observeSelectedTab.observeAsState()
32 
33     Scaffold(

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/FeedbackDialog.kt:40:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
37 
38 @OptIn(ExperimentalMaterial3Api::class)
39 @Composable
40 internal fun FeedbackDialog(feedback: FeedbackDialogViewModel) {
!!              ^ error
41     Dialog(dismiss = feedback::skipTapped) {
42         Card(
43             modifier = Modifier.padding(Dimensions.Padding.double),

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/FirstRunConferenceSelector.kt:23:5
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
20 import co.touchlab.droidcon.domain.entity.Conference
21 
22 @Composable
23 fun FirstRunConferenceSelector(
!!     ^ error
24     conferences: List<Conference>,
25     onConferenceSelected: (Conference) -> Unit,
26     onDismiss: () -> Unit,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/MainComposeView.kt:28:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
25 
26 @OptIn(ExperimentalCoilApi::class)
27 @Composable
28 internal fun MainComposeView(waitForLoadedContextModel: WaitForLoadedContextModel, modifier: Modifier = Modifier) {
!!              ^ error
29     setSingletonImageLoaderFactory { context ->
30         dcImageLoader(context, true)
31     }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/MainComposeView.kt:52:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
49 }
50 
51 @Composable
52 private fun LoadingScreen() {
!!             ^ error
53     Box(
54         modifier = Modifier.fillMaxSize(),
55         contentAlignment = Alignment.Center,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/MainComposeView.kt:68:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
65 }
66 
67 @Composable
68 private fun MainAppBody(waitForLoadedContextModel: WaitForLoadedContextModel, selectedConference: Conference, modifier: Modifier) {
!!             ^ error
69     LaunchedEffect(selectedConference) {
70         waitForLoadedContextModel.applicationViewModel.runAllLiveTasks(selectedConference)
71     }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionBlockView.kt:32:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
29 
30 @OptIn(ExperimentalMaterial3Api::class)
31 @Composable
32 internal fun SessionBlockView(sessionsBlock: SessionBlockViewModel) {
!!              ^ error
33     Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopStart) {
34         Text(
35             text = sessionsBlock.time,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionDetailView.kt:61:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
58 
59 @OptIn(ExperimentalMaterial3Api::class)
60 @Composable
61 internal fun SessionDetailView(viewModel: SessionDetailViewModel) {
!!              ^ error
62     NavigationStack(
63         key = viewModel,
64         links = {

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionDetailView.kt:187:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
184 }
185 
186 @Composable
187 private fun HeaderView(title: String, locationInfo: String) {
!!!             ^ error
188     Column(
189         modifier = Modifier.fillMaxWidth(),
190         verticalArrangement = Arrangement.Center,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionDetailView.kt:215:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
212 }
213 
214 @Composable
215 private fun InfoView(status: String) {
!!!             ^ error
216     Row(
217         modifier = Modifier.fillMaxWidth().padding(top = Dimensions.Padding.default),
218         verticalAlignment = Alignment.CenterVertically,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionDetailView.kt:243:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
240 }
241 
242 @Composable
243 private fun DescriptionView(description: String, links: List<WebLink>) {
!!!             ^ error
244     Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
245         Icon(
246             imageVector = Icons.Default.Description,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionDetailView.kt:266:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
263 }
264 
265 @Composable
266 private fun SpeakerView(speaker: SpeakerListItemViewModel) {
!!!             ^ error
267     Column(
268         modifier = Modifier
269             .fillMaxWidth()

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionListView.kt:63:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
60 
61 @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
62 @Composable
63 internal fun SessionListView(viewModel: BaseSessionListViewModel, title: String, emptyText: String) {
!!              ^ error
64     NavigationStack(
65         key = viewModel,
66         links = {

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionListView.kt:188:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
185 }
186 
187 @Composable
188 private fun TabIndicator(modifier: Modifier = Modifier) {
!!!             ^ error
189     Box(
190         modifier
191             .fillMaxWidth()

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionListView.kt:200:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
197 }
198 
199 @Composable
200 private fun EmptyView(text: String) {
!!!             ^ error
201     Column(
202         modifier = Modifier.fillMaxSize(),
203         verticalArrangement = Arrangement.Center,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SpeakerDetailView.kt:48:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
45 
46 @OptIn(ExperimentalMaterial3Api::class)
47 @Composable
48 internal fun SpeakerDetailView(viewModel: SpeakerDetailViewModel) {
!!              ^ error
49     val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
50     Scaffold(
51         modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SpeakerDetailView.kt:93:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
90 }
91 
92 @Composable
93 private fun HeaderView(name: String, tagLine: String, imageUrl: Url?) {
!!             ^ error
94     Row(
95         modifier = Modifier.fillMaxWidth(),
96         verticalAlignment = Alignment.CenterVertically,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SpeakerDetailView.kt:136:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
133 }
134 
135 @Composable
136 private fun SocialView(url: WebLink, iconName: String) {
!!!             ^ error
137     Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
138         LocalImage(
139             imageResourceName = iconName,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SpeakerDetailView.kt:158:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
155 }
156 
157 @Composable
158 private fun SocialView(url: WebLink, icon: ImageVector) {
!!!             ^ error
159     Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
160         Icon(
161             imageVector = icon,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SpeakerDetailView.kt:180:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
177 }
178 
179 @Composable
180 private fun BioView(bio: String, webLinks: List<WebLink>) {
!!!             ^ error
181     Row(
182         modifier = Modifier.fillMaxWidth().padding(vertical = Dimensions.Padding.half),
183         verticalAlignment = Alignment.Top,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/settings/AboutView.kt:24:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
21 import co.touchlab.droidcon.viewmodel.settings.AboutViewModel
22 
23 @Composable
24 internal fun AboutView(viewModel: AboutViewModel) {
!!              ^ error
25     val items by viewModel.observeItemViewModels.observeAsState()
26     items.forEach { aboutItem ->
27         AboutItemView(aboutItem)

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/settings/AboutView.kt:32:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
29 }
30 
31 @Composable
32 private fun AboutItemView(viewModel: AboutItemViewModel) {
!!             ^ error
33     Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
34         Icon(
35             modifier = Modifier.padding(Dimensions.Padding.default),

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/settings/ConferenceSelector.kt:31:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
28 import co.touchlab.droidcon.viewmodel.settings.SettingsViewModel
29 
30 @Composable
31 internal fun ConferenceSelectorRow(viewModel: SettingsViewModel) {
!!              ^ error
32     var expanded by remember { mutableStateOf(false) }
33     val conferences by viewModel.allConferences.observeAsState()
34     val selectedConference by viewModel.selectedConference.observeAsState()

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/settings/ConferenceSelector.kt:86:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
83 }
84 
85 @Composable
86 private fun ConferenceDropdownMenu(
!!             ^ error
87     expanded: Boolean,
88     onDismissRequest: () -> Unit,
89     conferences: List<Conference>,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/settings/PlatformSpecificSettings.kt:7:21
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
4  import co.touchlab.droidcon.viewmodel.settings.SettingsViewModel
5  
6  @Composable
7  internal expect fun PlatformSpecificSettingsView(viewModel: SettingsViewModel)
!                      ^ error
8  

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/settings/SettingsView.kt:37:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
34 
35 @OptIn(ExperimentalMaterial3Api::class)
36 @Composable
37 internal fun SettingsView(viewModel: SettingsViewModel) {
!!              ^ error
38     val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
39     Scaffold(
40         modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/settings/SettingsView.kt:82:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
79 }
80 
81 @Composable
82 internal fun IconTextSwitchRow(text: String, image: ImageVector, checked: MutableObservableProperty<Boolean>) {
!!              ^ error
83     val isChecked by checked.observeAsState()
84     Row(
85         modifier = Modifier

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorDetailView.kt:50:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
47 
48 @OptIn(ExperimentalMaterial3Api::class)
49 @Composable
50 internal fun SponsorDetailView(viewModel: SponsorDetailViewModel) {
!!              ^ error
51     NavigationStack(
52         key = viewModel,
53         links = {

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorDetailView.kt:100:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
97  }
98  
99  @Composable
100 private fun HeaderView(name: String, groupTitle: String, imageUrl: Url?) {
!!!             ^ error
101     Row(
102         Modifier
103             .fillMaxWidth()

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorDetailView.kt:159:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
156 }
157 
158 @Composable
159 private fun DescriptionView(description: String) {
!!!             ^ error
160     Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
161         Icon(
162             imageVector = Icons.Default.Description,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorDetailView.kt:180:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
177 }
178 
179 @Composable
180 private fun RepresentativeInfoView(profile: SpeakerListItemViewModel) {
!!!             ^ error
181     Column(
182         modifier = Modifier
183             .fillMaxWidth()

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorsView.kt:54:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
51 
52 @OptIn(ExperimentalMaterial3Api::class)
53 @Composable
54 internal fun SponsorsView(viewModel: SponsorListViewModel) {
!!              ^ error
55     NavigationStack(
56         key = viewModel,
57         links = {

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorsView.kt:98:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
95  }
96  
97  @Composable
98  private fun SponsorGroupView(sponsorGroup: SponsorGroupViewModel) {
!!              ^ error
99      Card(
100         modifier = Modifier.padding(
101             vertical = Dimensions.Padding.quarter,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorsView.kt:166:13
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
163 }
164 
165 @Composable
166 private fun EmptyView() {
!!!             ^ error
167     Column(
168         modifier = Modifier.fillMaxSize(),
169         verticalArrangement = Arrangement.Center,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/theme/Theme.kt:18:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
15 )
16 
17 @Composable
18 internal fun DroidconTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
!!              ^ error
19     val colorScheme = if (darkTheme) {
20         DarkColorScheme
21     } else {

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/Dialog.kt:6:21
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
3  import androidx.compose.runtime.Composable
4  
5  @Composable
6  internal expect fun Dialog(dismiss: () -> Unit, content: @Composable () -> Unit)
!                      ^ error
7  

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/Image.kt:13:5
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
10 import coil3.util.DebugLogger
11 
12 @Composable
13 fun DcAsyncImage(logTag: String, model: Any?, contentDescription: String?, modifier: Modifier = Modifier) {
!!     ^ error
14     AsyncImage(
15         modifier = modifier,
16         model = model,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/LocalImage.kt:7:21
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
4  import androidx.compose.ui.Modifier
5  
6  @Composable
7  internal expect fun __LocalImage(imageResourceName: String, modifier: Modifier, contentDescription: String?)
!                      ^ error
8  
9  @Composable
10 internal fun LocalImage(imageResourceName: String, modifier: Modifier = Modifier, contentDescription: String? = null) {

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/LocalImage.kt:10:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
7  internal expect fun __LocalImage(imageResourceName: String, modifier: Modifier, contentDescription: String?)
8  
9  @Composable
10 internal fun LocalImage(imageResourceName: String, modifier: Modifier = Modifier, contentDescription: String? = null) {
!!              ^ error
11     __LocalImage(imageResourceName, modifier, contentDescription)
12 }
13 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/NavigationBackPressWrapper.kt:6:21
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
3  import androidx.compose.runtime.Composable
4  
5  @Composable
6  internal expect fun NavigationBackPressWrapper(content: @Composable () -> Unit)
!                      ^ error
7  

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/WebLinkText.kt:31:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
28 import co.touchlab.droidcon.dto.WebLink
29 
30 @Composable
31 internal fun WebLinkText(
!!              ^ error
32     text: String,
33     links: List<WebLink>,
34     modifier: Modifier = Modifier,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/venue/VenueView.kt:19:5
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
16 import com.github.panpf.zoomimage.ZoomImage
17 
18 @Composable
19 fun VenueView(venueMapUrl: String?) {
!!     ^ error
20     Scaffold { paddingValues ->
21         VenueBodyView(
22             modifier = Modifier.padding(paddingValues),

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/venue/VenueView.kt:29:5
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
26 }
27 
28 @Composable
29 fun VenueBodyView(modifier: Modifier = Modifier, venueMapUrl: String?) {
!!     ^ error
30     val painter = rememberAsyncImagePainter(venueMapUrl)
31     val state by painter.state.collectAsState()
32 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:117:18
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
114     }
115 
116     @Composable
117     internal fun PushedStack(itemModifier: Modifier = Modifier) {
!!!                  ^ error
118         val currentStack by observeStack.observeAsState()
119 
120         var i = 0

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:130:27
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
127     }
128 
129     @Composable
130     private fun <T : Any> PushedStackItem(item: NavigationStackItem.Push<T>, itemModifier: Modifier) {
!!!                           ^ error
131         println("$item")
132         val itemValue by item.item.observeAsState()
133 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:142:28
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
139     }
140 
141     @Composable
142     internal fun <T : Any> Pushed(item: MutableObservableProperty<T?>, content: @Composable (T) -> Unit) {
!!!                            ^ error
143         remember {
144             val stackItem = NavigationStackItem.Push(item, content).also {
145                 notifyingStackChange {

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:158:18
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
155     }
156 
157     @Composable
158     internal fun HandleBackPressEffect(onBackPressed: BackPressHandlerScope.() -> Unit) {
!!!                  ^ error
159         remember {
160             val stackItem = NavigationStackItem.BackPressHandler(onBackPressed).also {
161                 stack.add(it)

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:204:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
201 }
202 
203 @Composable
204 internal fun BackPressHandler(onBackPressed: NavigationController.BackPressHandlerScope.() -> Unit) {
!!!              ^ error
205     val navigationController = LocalNavigationController.current
206     navigationController.HandleBackPressEffect(onBackPressed)
207 }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:242:14
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
239 
240 @OptIn(ExperimentalAnimationApi::class)
241 @Composable
242 internal fun NavigationStack(key: Any?, links: NavigationStackScope.() -> Unit, content: @Composable () -> Unit) {
!!!              ^ error
243     val activeLinkComposables by remember(key) {
244         val constructedLinks = mutableListOf<ObservableProperty<NavigationLinkWrapper<*>>>()
245         val scope = object : NavigationStackScope {

```

### naming, InvalidPackageDeclaration (49)

Kotlin source files should be stored in the directory corresponding to its package statement.

[Documentation](https://detekt.dev/docs/rules/naming#invalidpackagedeclaration)

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/BottomNavigationView.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui
! ^ error
2 
3 import androidx.compose.foundation.layout.Box
4 import androidx.compose.foundation.layout.padding

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/FeedbackDialog.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui
! ^ error
2 
3 import androidx.compose.foundation.clickable
4 import androidx.compose.foundation.layout.Arrangement

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/FirstRunConferenceSelector.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui
! ^ error
2 
3 import androidx.compose.foundation.clickable
4 import androidx.compose.foundation.layout.Column

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/MainComposeView.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui
! ^ error
2 
3 import androidx.compose.foundation.layout.Box
4 import androidx.compose.foundation.layout.Column

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/UiModule.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui
! ^ error
2 
3 import co.touchlab.droidcon.viewmodel.ApplicationViewModel
4 import co.touchlab.droidcon.viewmodel.FeedbackDialogViewModel

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionBlockView.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.session
! ^ error
2 
3 import androidx.compose.foundation.background
4 import androidx.compose.foundation.layout.Arrangement

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionDetailView.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.session
! ^ error
2 
3 import androidx.compose.foundation.background
4 import androidx.compose.foundation.clickable

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionListView.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.session
! ^ error
2 
3 import androidx.compose.foundation.ExperimentalFoundationApi
4 import androidx.compose.foundation.background

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SpeakerDetailView.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.session
! ^ error
2 
3 import androidx.compose.foundation.layout.Column
4 import androidx.compose.foundation.layout.Row

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/settings/AboutView.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.settings
! ^ error
2 
3 import androidx.compose.foundation.layout.Column
4 import androidx.compose.foundation.layout.Row

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/settings/ConferenceSelector.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.settings
! ^ error
2 
3 import androidx.compose.foundation.clickable
4 import androidx.compose.foundation.layout.Column

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/settings/PlatformSpecificSettings.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.settings
! ^ error
2 
3 import androidx.compose.runtime.Composable
4 import co.touchlab.droidcon.viewmodel.settings.SettingsViewModel

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/settings/SettingsView.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.settings
! ^ error
2 
3 import androidx.compose.foundation.clickable
4 import androidx.compose.foundation.layout.Column

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorDetailView.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.sponsors
! ^ error
2 
3 import androidx.compose.foundation.Image
4 import androidx.compose.foundation.background

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorsView.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.sponsors
! ^ error
2 
3 import androidx.compose.foundation.background
4 import androidx.compose.foundation.clickable

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/theme/Colors.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.theme
! ^ error
2 
3 import androidx.compose.ui.graphics.Color
4 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/theme/Dimensions.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.theme
! ^ error
2 
3 import androidx.compose.ui.unit.dp
4 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/theme/Theme.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.theme
! ^ error
2 
3 import androidx.compose.foundation.isSystemInDarkTheme
4 import androidx.compose.material3.MaterialTheme

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/theme/Type.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.theme
! ^ error
2 
3 import androidx.compose.ui.text.font.FontFamily
4 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/theme/Typography.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.theme
! ^ error
2 
3 import androidx.compose.material3.Typography
4 import androidx.compose.ui.text.TextStyle

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/Dialog.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.util
! ^ error
2 
3 import androidx.compose.runtime.Composable
4 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/Image.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.util
! ^ error
2 
3 import androidx.compose.runtime.Composable
4 import androidx.compose.ui.Modifier

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/LocalImage.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.util
! ^ error
2 
3 import androidx.compose.runtime.Composable
4 import androidx.compose.ui.Modifier

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/NavigationBackPressWrapper.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.util
! ^ error
2 
3 import androidx.compose.runtime.Composable
4 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/ObserveAsState.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.util
! ^ error
2 
3 import androidx.compose.runtime.Composable
4 import androidx.compose.runtime.DisposableEffect

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/util/WebLinkText.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.util
! ^ error
2 
3 import androidx.compose.foundation.gestures.detectTapGestures
4 import androidx.compose.material3.LocalTextStyle

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/venue/VenueView.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.ui.venue
! ^ error
2 
3 import androidx.compose.foundation.layout.Box
4 import androidx.compose.foundation.layout.fillMaxSize

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/LocalDateTime+startOfMinute.kt:3:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 @file:Suppress("ktlint:standard:filename")
2 
3 package co.touchlab.droidcon.util
! ^ error
4 
5 import kotlinx.datetime.LocalDateTime
6 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.util
! ^ error
2 
3 import androidx.compose.animation.AnimatedContent
4 import androidx.compose.animation.ExperimentalAnimationApi

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/ApplicationViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel
! ^ error
2 
3 import co.touchlab.droidcon.application.gateway.SettingsGateway
4 import co.touchlab.droidcon.application.service.Notification

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/FeedbackDialogViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel
! ^ error
2 
3 import co.touchlab.droidcon.domain.entity.Session
4 import co.touchlab.droidcon.domain.gateway.SessionGateway

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/WaitForLoadedContextModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel
! ^ error
2 
3 import co.touchlab.droidcon.application.gateway.SettingsGateway
4 import co.touchlab.droidcon.domain.entity.Conference

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/AgendaViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.session
! ^ error
2 
3 import co.touchlab.droidcon.domain.gateway.SessionGateway
4 import co.touchlab.droidcon.domain.service.ConferenceConfigProvider

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/BaseSessionListViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.session
! ^ error
2 
3 import co.touchlab.droidcon.domain.gateway.SessionGateway
4 import co.touchlab.droidcon.domain.service.ConferenceConfigProvider

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/ScheduleViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.session
! ^ error
2 
3 import co.touchlab.droidcon.domain.entity.Session
4 import co.touchlab.droidcon.domain.gateway.SessionGateway

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionBlockViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.session
! ^ error
2 
3 import co.touchlab.droidcon.domain.composite.ScheduleItem
4 import co.touchlab.droidcon.util.formatter.DateFormatter

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionDayViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.session
! ^ error
2 
3 import co.touchlab.droidcon.domain.composite.ScheduleItem
4 import co.touchlab.droidcon.domain.service.ConferenceConfigProvider

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionDetailScrollStateStorage.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.session
! ^ error
2 
3 import kotlinx.datetime.LocalDate
4 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionDetailViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.session
! ^ error
2 
3 import co.touchlab.droidcon.application.gateway.SettingsGateway
4 import co.touchlab.droidcon.application.service.NotificationService

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionListItemViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.session
! ^ error
2 
3 import co.touchlab.droidcon.domain.composite.ScheduleItem
4 import co.touchlab.droidcon.domain.service.DateTimeService

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SpeakerDetailViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.session
! ^ error
2 
3 import co.touchlab.droidcon.composite.Url
4 import co.touchlab.droidcon.domain.entity.Profile

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SpeakerListItemViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.session
! ^ error
2 
3 import co.touchlab.droidcon.domain.entity.Profile
4 import org.brightify.hyperdrive.multiplatformx.BaseViewModel

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/settings/AboutItemViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.settings
! ^ error
2 
3 import co.touchlab.droidcon.dto.WebLink
4 import org.brightify.hyperdrive.multiplatformx.BaseViewModel

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/settings/AboutViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.settings
! ^ error
2 
3 import co.touchlab.droidcon.application.composite.AboutItem
4 import co.touchlab.droidcon.application.repository.AboutRepository

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/settings/SettingsViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.settings
! ^ error
2 
3 import co.touchlab.droidcon.application.gateway.SettingsGateway
4 import co.touchlab.droidcon.domain.entity.Conference

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/sponsor/SponsorDetailViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.sponsor
! ^ error
2 
3 import co.touchlab.droidcon.domain.entity.Sponsor
4 import co.touchlab.droidcon.domain.gateway.SponsorGateway

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/sponsor/SponsorGroupItemViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.sponsor
! ^ error
2 
3 import co.touchlab.droidcon.domain.entity.Sponsor
4 import io.ktor.http.URLParserException

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/sponsor/SponsorGroupViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.sponsor
! ^ error
2 
3 import co.touchlab.droidcon.domain.composite.SponsorGroupWithSponsors
4 import co.touchlab.droidcon.domain.entity.Sponsor

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/sponsor/SponsorListViewModel.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package co.touchlab.droidcon.viewmodel.sponsor
! ^ error
2 
3 import co.touchlab.droidcon.composite.Url
4 import co.touchlab.droidcon.domain.gateway.SponsorGateway

```

### naming, MemberNameEqualsClassName (1)

A member should not be given the same name as its parent class or object.

[Documentation](https://detekt.dev/docs/rules/naming#membernameequalsclassname)

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/theme/Typography.kt:9:5
```
A member is named after the object. This might result in confusion. Please rename the member.
```
```kotlin
6  import androidx.compose.ui.unit.sp
7  
8  internal object Typography {
9      val typography = Typography(
!      ^ error
10         headlineLarge = TextStyle(
11             fontFamily = montserratFontFamily,
12             fontWeight = FontWeight.Medium,

```

### naming, PackageNaming (3)

Package names should match the naming convention set in the configuration.

[Documentation](https://detekt.dev/docs/rules/naming#packagenaming)

* /tmp/output/phase1/before/shared-ui/build/generated/compose/resourceGenerator/kotlin/commonMainResourceAccessors/droidcon/shared_ui/generated/resources/Drawable0.commonMain.kt:3:1
```
Package name should match the pattern: [a-z]+(\.[a-z][A-Za-z0-9]*)*
```
```kotlin
1 @file:OptIn(InternalResourceApi::class)
2 
3 package droidcon.shared_ui.generated.resources
! ^ error
4 
5 import kotlin.OptIn
6 import kotlin.String

```

* /tmp/output/phase1/before/shared-ui/build/generated/compose/resourceGenerator/kotlin/commonMainResourceCollectors/droidcon/shared_ui/generated/resources/ExpectResourceCollectors.kt:1:1
```
Package name should match the pattern: [a-z]+(\.[a-z][A-Za-z0-9]*)*
```
```kotlin
1 package droidcon.shared_ui.generated.resources
! ^ error
2 
3 import kotlin.String
4 import kotlin.collections.Map

```

* /tmp/output/phase1/before/shared-ui/build/generated/compose/resourceGenerator/kotlin/commonResClass/droidcon/shared_ui/generated/resources/Res.kt:7:1
```
Package name should match the pattern: [a-z]+(\.[a-z][A-Za-z0-9]*)*
```
```kotlin
4    "REDUNDANT_VISIBILITY_MODIFIER",
5  )
6  
7  package droidcon.shared_ui.generated.resources
!  ^ error
8  
9  import kotlin.ByteArray
10 import kotlin.OptIn

```

### style, ForbiddenComment (3)

Flags a forbidden comment.

[Documentation](https://detekt.dev/docs/rules/style#forbiddencomment)

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/BottomNavigationView.kt:40:25
```
Forbidden FIXME todo marker in comment, please fix the problem.
```
```kotlin
37                 viewModel.listTabs(currentConference).forEach { tab ->
38                     val (title, icon) = when (tab) {
39                         ApplicationViewModel.Tab.Schedule -> "Schedule" to Icons.Filled.CalendarMonth
40                         // FIXME: Was originally "My agenda" but then it doesn't seem to fit.
!!                         ^ error
41                         ApplicationViewModel.Tab.MyAgenda -> "Agenda" to Icons.Filled.Schedule
42                         ApplicationViewModel.Tab.Venue -> "Venue" to Icons.Filled.Map
43                         ApplicationViewModel.Tab.Sponsors -> "Sponsors" to Icons.Filled.LocalFireDepartment

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/settings/SettingsViewModel.kt:23:13
```
Forbidden TODO todo marker in comment, please do the changes.
```
```kotlin
20         settingsGateway.settings(),
21         mapping = { it.isFeedbackEnabled },
22         set = { newValue ->
23             // TODO: Remove when `binding` supports suspend closures.
!!             ^ error
24             instanceLock.runExclusively {
25                 settingsGateway.setFeedbackEnabled(newValue)
26             }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/settings/SettingsViewModel.kt:35:13
```
Forbidden TODO todo marker in comment, please do the changes.
```
```kotlin
32         settingsGateway.settings(),
33         mapping = { it.isRemindersEnabled },
34         set = { newValue ->
35             // TODO: Remove when `binding` supports suspend closures.
!!             ^ error
36             instanceLock.runExclusively {
37                 settingsGateway.setRemindersEnabled(newValue)
38             }

```

### style, MagicNumber (11)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence it's unclear what the purpose of this number is. It's better to declare such numbers as constants and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/settings/ConferenceSelector.kt:96:42
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
93      DropdownMenu(
94          expanded = expanded,
95          onDismissRequest = onDismissRequest,
96          modifier = Modifier.fillMaxWidth(0.9f),
!!                                           ^ error
97      ) {
98          Text(
99              text = "Select Conference",

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorsView.kt:116:61
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
113                 ),
114                 style = MaterialTheme.typography.headlineLarge,
115             )
116             val columnCount = if (sponsorGroup.isProminent) 3 else 4
!!!                                                             ^ error
117 
118             val sponsors by sponsorGroup.observeSponsors.observeAsState()
119 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorsView.kt:116:68
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
113                 ),
114                 style = MaterialTheme.typography.headlineLarge,
115             )
116             val columnCount = if (sponsorGroup.isProminent) 3 else 4
!!!                                                                    ^ error
117 
118             val sponsors by sponsorGroup.observeSponsors.observeAsState()
119 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/theme/Colors.kt:6:31
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
3  import androidx.compose.ui.graphics.Color
4  
5  object Colors {
6      val droidconGreen = Color(0xFF4CE2C3)
!                                ^ error
7      val droidconBlue = Color(0xFF010DEB)
8      val droidconRed = Color(0xFFF66E4D)
9  

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/theme/Colors.kt:7:30
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
4  
5  object Colors {
6      val droidconGreen = Color(0xFF4CE2C3)
7      val droidconBlue = Color(0xFF010DEB)
!                               ^ error
8      val droidconRed = Color(0xFFF66E4D)
9  
10     val primary = droidconGreen

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/theme/Colors.kt:8:29
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
5  object Colors {
6      val droidconGreen = Color(0xFF4CE2C3)
7      val droidconBlue = Color(0xFF010DEB)
8      val droidconRed = Color(0xFFF66E4D)
!                              ^ error
9  
10     val primary = droidconGreen
11 }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:51:89
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
48     internal sealed class NavigationStackItem {
49         class BackPressHandler(val onBackPressed: BackPressHandlerScope.() -> Unit) : NavigationStackItem() {
50 
51             override fun toString(): String = "BackPress@${hashCode().toUInt().toString(16)}"
!!                                                                                         ^ error
52         }
53 
54         class Push<T : Any>(val item: MutableObservableProperty<T?>, val content: @Composable (T) -> Unit) : NavigationStackItem() {

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:57:73
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
54         class Push<T : Any>(val item: MutableObservableProperty<T?>, val content: @Composable (T) -> Unit) : NavigationStackItem() {
55 
56             override fun toString(): String =
57                 "Push(${item.value}@${item.hashCode().toUInt().toString(16)})@${hashCode().toUInt().toString(16)}"
!!                                                                         ^ error
58         }
59     }
60 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:57:110
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
54         class Push<T : Any>(val item: MutableObservableProperty<T?>, val content: @Composable (T) -> Unit) : NavigationStackItem() {
55 
56             override fun toString(): String =
57                 "Push(${item.value}@${item.hashCode().toUInt().toString(16)})@${hashCode().toUInt().toString(16)}"
!!                                                                                                              ^ error
58         }
59     }
60 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionDetailViewModel.kt:48:23
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
45         flow {
46             while (true) {
47                 emit(dateTimeService.now())
48                 delay(10_000)
!!                       ^ error
49             }
50         },
51     )

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionListItemViewModel.kt:23:23
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
20             while (true) {
21                 val isInPast = dateTimeService.now() > item.session.endsAt
22                 emit(isInPast)
23                 delay(10_000)
!!                       ^ error
24             }
25         },
26     )

```

### style, MaxLineLength (25)

Line detected, which is longer than the defined maximum line length in the code style.

[Documentation](https://detekt.dev/docs/rules/style#maxlinelength)

* /tmp/output/phase1/before/shared-ui/build/generated/compose/resourceGenerator/kotlin/commonResClass/droidcon/shared_ui/generated/resources/Res.kt:26:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
23    * @param path The path of the file to read in the compose resource's directory.
24    * @return The content of the file as a byte array.
25    */
26   public suspend fun readBytes(path: String): ByteArray = readResourceBytes("composeResources/droidcon.shared_ui.generated.resources/" + path)
!! ^ error
27 
28   /**
29    * Returns the URI string of the resource file at the specified path.

```

* /tmp/output/phase1/before/shared-ui/build/generated/compose/resourceGenerator/kotlin/commonResClass/droidcon/shared_ui/generated/resources/Res.kt:36:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
33    * @param path The path of the file in the compose resource's directory.
34    * @return The URI string of the file.
35    */
36   public fun getUri(path: String): String = getResourceUri("composeResources/droidcon.shared_ui.generated.resources/" + path)
!! ^ error
37 
38   public object drawable
39 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/BottomNavigationView.kt:30:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
27 import co.touchlab.droidcon.viewmodel.ApplicationViewModel
28 
29 @Composable
30 internal fun BottomNavigationView(viewModel: ApplicationViewModel, currentConference: Conference, modifier: Modifier = Modifier) {
!! ^ error
31     val selectedTab by viewModel.observeSelectedTab.observeAsState()
32 
33     Scaffold(

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/FeedbackDialog.kt:105:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
102                     TextButton(onClick = feedback::submitTapped, enabled = !isSubmitDisabled) {
103                         Text(
104                             text = "SUBMIT",
105                             color = if (isSubmitDisabled) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.primary,
!!! ^ error
106                         )
107                     }
108                     TextButton(onClick = feedback::closeAndDisableTapped) {

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/MainComposeView.kt:46:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
43     DroidconTheme {
44         when (val state = loadingState) {
45             WaitForLoadedContextModel.State.Loading -> LoadingScreen()
46             is WaitForLoadedContextModel.State.Ready -> MainAppBody(waitForLoadedContextModel, state.conference, modifier)
!! ^ error
47         }
48     }
49 }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/MainComposeView.kt:68:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
65 }
66 
67 @Composable
68 private fun MainAppBody(waitForLoadedContextModel: WaitForLoadedContextModel, selectedConference: Conference, modifier: Modifier) {
!! ^ error
69     LaunchedEffect(selectedConference) {
70         waitForLoadedContextModel.applicationViewModel.runAllLiveTasks(selectedConference)
71     }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/UiModule.kt:102:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
99  
100     single { SpeakerDetailViewModel.Factory(parseUrlViewService = get()) }
101 
102     single { SponsorListViewModel.Factory(sponsorGateway = get(), sponsorGroupFactory = get(), sponsorDetailFactory = get()) }
!!! ^ error
103     single { SponsorGroupViewModel.Factory(sponsorGroupItemFactory = get()) }
104     single { SponsorGroupItemViewModel.Factory() }
105     single { SponsorDetailViewModel.Factory(sponsorGateway = get(), speakerListItemFactory = get(), speakerDetailFactory = get()) }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/UiModule.kt:105:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
102     single { SponsorListViewModel.Factory(sponsorGateway = get(), sponsorGroupFactory = get(), sponsorDetailFactory = get()) }
103     single { SponsorGroupViewModel.Factory(sponsorGroupItemFactory = get()) }
104     single { SponsorGroupItemViewModel.Factory() }
105     single { SponsorDetailViewModel.Factory(sponsorGateway = get(), speakerListItemFactory = get(), speakerDetailFactory = get()) }
!!! ^ error
106 
107     single { SettingsViewModel.Factory(settingsGateway = get(), aboutFactory = get(), conferenceRepository = get()) }
108     single { AboutViewModel.Factory(aboutRepository = get(), parseUrlViewService = get()) }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/UiModule.kt:110:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
107     single { SettingsViewModel.Factory(settingsGateway = get(), aboutFactory = get(), conferenceRepository = get()) }
108     single { AboutViewModel.Factory(aboutRepository = get(), parseUrlViewService = get()) }
109 
110     single { FeedbackDialogViewModel.Factory(sessionGateway = get(), get(parameters = { parametersOf("FeedbackDialogViewModel") })) }
!!! ^ error
111 
112     single { SessionDetailScrollStateStorage() }
113 }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionBlockView.kt:42:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
39             textAlign = TextAlign.End,
40         )
41 
42         Column(modifier = Modifier.padding(start = 72.dp), verticalArrangement = Arrangement.spacedBy(Dimensions.Padding.quarter)) {
!! ^ error
43             sessionsBlock.sessions.forEach { session ->
44                 Row(verticalAlignment = Alignment.CenterVertically) {
45                     val isInPast by session.observeIsInPast.observeAsState()

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionBlockView.kt:52:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
49                         session.isInConflict -> MaterialTheme.colorScheme.error
50                         else -> MaterialTheme.colorScheme.primary
51                     }
52                     Box(modifier = Modifier.padding(Dimensions.Padding.default).size(8.dp).clip(CircleShape).background(badgeColor))
!! ^ error
53 
54                     val isClickable = !session.isServiceSession
55                     Card(

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionDetailView.kt:130:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
127                 }
128 
129                 val status = when (state) {
130                     SessionDetailViewModel.SessionState.InConflict -> "This session is in conflict with another session in your schedule."
!!! ^ error
131                     SessionDetailViewModel.SessionState.InProgress -> "This session is happening now."
132                     SessionDetailViewModel.SessionState.Ended -> "This session has already ended."
133                     null -> "This session hasn't started yet."

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:54:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
51             override fun toString(): String = "BackPress@${hashCode().toUInt().toString(16)}"
52         }
53 
54         class Push<T : Any>(val item: MutableObservableProperty<T?>, val content: @Composable (T) -> Unit) : NavigationStackItem() {
!! ^ error
55 
56             override fun toString(): String =
57                 "Push(${item.value}@${item.hashCode().toUInt().toString(16)})@${hashCode().toUInt().toString(16)}"

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:246:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
243     val activeLinkComposables by remember(key) {
244         val constructedLinks = mutableListOf<ObservableProperty<NavigationLinkWrapper<*>>>()
245         val scope = object : NavigationStackScope {
246             override fun <T : Any> navigationLink(item: MutableObservableProperty<T?>, content: @Composable (T) -> Unit) {
!!! ^ error
247                 constructedLinks.add(
248                     item.map {
249                         NavigationLinkWrapper(index = constructedLinks.size, value = it, reset = { item.value = null }, content)

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:249:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
246             override fun <T : Any> navigationLink(item: MutableObservableProperty<T?>, content: @Composable (T) -> Unit) {
247                 constructedLinks.add(
248                     item.map {
249                         NavigationLinkWrapper(index = constructedLinks.size, value = it, reset = { item.value = null }, content)
!!! ^ error
250                     },
251                 )
252             }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/BaseSessionListViewModel.kt:23:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
20         private set
21     val observeDays by observe(::days)
22 
23     var selectedDay: SessionDayViewModel? by managed(days?.firstOrNull { it.date == sessionDetailScrollStateStorage.selectedDay })
!! ^ error
24     val observeSelectedDay by observe(::selectedDay)
25 
26     var presentedSessionDetail: SessionDetailViewModel? by managed(null)

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionBlockViewModel.kt:28:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
25     )
26     val observeSessions by observe(::sessions)
27 
28     class Factory(private val sessionListItemFactory: SessionListItemViewModel.Factory, private val dateFormatter: DateFormatter) {
!! ^ error
29         fun create(startsAt: LocalDateTime, items: List<ScheduleItem>, onScheduleItemSelected: (ScheduleItem) -> Unit) =
30             SessionBlockViewModel(sessionListItemFactory, dateFormatter, startsAt, items, onScheduleItemSelected)
31     }

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionDayViewModel.kt:55:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
52         private val sessionDetailScrollStateStorage: SessionDetailScrollStateStorage,
53     ) {
54 
55         fun create(date: LocalDate, attendingOnly: Boolean, items: List<ScheduleItem>, onScheduleItemSelected: (ScheduleItem) -> Unit) =
!! ^ error
56             SessionDayViewModel(
57                 sessionBlockFactory,
58                 dateFormatter,

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionDetailViewModel.kt:40:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
37     initialItem: ScheduleItem,
38 ) : BaseViewModel() {
39 
40     private val item by collected(initialItem, sessionGateway.observeScheduleItem(initialItem.session.id), identityEqualityPolicy())
!! ^ error
41     private val observeItem by observe(::item)
42 
43     private val time: Instant by collected(

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionDetailViewModel.kt:82:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
79     val observeState by observe(::state)
80     val abstract by observeItem.map { it.session.description }
81     val observeAbstract by observe(::abstract)
82     val abstractLinks: List<WebLink> by observeItem.map { it.session.description?.let(parseUrlViewService::parse) ?: emptyList() }
!! ^ error
83     val observeAbstractLinks by observe(::abstractLinks)
84 
85     val speakers: List<SpeakerListItemViewModel> by managedList(

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionDetailViewModel.kt:145:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
142 
143     private fun parseUrl(text: String): List<WebLink> {
144         val urlRegex =
145             "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)".toRegex()
!!! ^ error
146         return urlRegex.findAll(text).map { WebLink(it.range, it.value) }.toList()
147     }
148 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionListItemViewModel.kt:9:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
6  import kotlinx.coroutines.flow.flow
7  import org.brightify.hyperdrive.multiplatformx.BaseViewModel
8  
9  class SessionListItemViewModel(dateTimeService: DateTimeService, item: ScheduleItem, val selected: () -> Unit) : BaseViewModel() {
!  ^ error
10     val title: String = item.session.title
11     val isServiceSession: Boolean = item.session.isServiceSession
12     val isAttending: Boolean = item.session.rsvp.isAttending

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/settings/AboutItemViewModel.kt:6:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
3  import co.touchlab.droidcon.dto.WebLink
4  import org.brightify.hyperdrive.multiplatformx.BaseViewModel
5  
6  class AboutItemViewModel(val title: String, val detail: String, val webLinks: List<WebLink>, val icon: String) : BaseViewModel()
!  ^ error
7  

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/settings/AboutViewModel.kt:8:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
5  import co.touchlab.droidcon.service.ParseUrlViewService
6  import org.brightify.hyperdrive.multiplatformx.BaseViewModel
7  
8  class AboutViewModel(private val aboutRepository: AboutRepository, private val parseUrlViewService: ParseUrlViewService) : BaseViewModel() {
!  ^ error
9  
10     var items: List<AboutItem> by published(emptyList())
11         private set

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/sponsor/SponsorListViewModel.kt:24:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
21                             sponsorGroup,
22                             onSponsorSelected = { sponsor ->
23                                 if (sponsor.hasDetail) {
24                                     presentedSponsorDetail = sponsorDetailFactory.create(sponsor, sponsorGroup.group.name)
!! ^ error
25                                 } else {
26                                     presentedUrl = sponsor.url
27                                 }

```

### style, UnusedPrivateMember (1)

Private function is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedprivatemember)

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/session/SessionDetailViewModel.kt:143:17
```
Private function `parseUrl` is unused.
```
```kotlin
140         )
141     }
142 
143     private fun parseUrl(text: String): List<WebLink> {
!!!                 ^ error
144         val urlRegex =
145             "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)".toRegex()
146         return urlRegex.findAll(text).map { WebLink(it.range, it.value) }.toList()

```

### style, UnusedPrivateProperty (2)

Property is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedprivateproperty)

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/util/NavigationController.kt:32:13
```
Private property `LocalNavigationViewDimensions` is unused.
```
```kotlin
29     NavigationController.root
30 }
31 
32 private val LocalNavigationViewDimensions = staticCompositionLocalOf<NavigationViewDimensions> {
!!             ^ error
33     error("NavigationView hasn't been used.")
34 }
35 

```

* /tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/WaitForLoadedContextModel.kt:20:17
```
Private property `settingsGateway` is unused.
```
```kotlin
17     private val conferenceConfigProvider: ConferenceConfigProvider,
18     applicationViewModelFactory: ApplicationViewModel.Factory,
19     private val syncService: SyncService,
20     private val settingsGateway: SettingsGateway,
!!                 ^ error
21 ) : BaseViewModel() {
22     sealed interface State {
23         data object Loading : State

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2026-05-22 20:19:27 UTC
