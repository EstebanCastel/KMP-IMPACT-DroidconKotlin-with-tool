# detekt

## Metrics

* 18 number of properties

* 14 number of functions

* 6 number of classes

* 3 number of packages

* 6 number of kt files

## Complexity Report

* 341 lines of code (loc)

* 271 source lines of code (sloc)

* 135 logical lines of code (lloc)

* 15 comment lines of code (cloc)

* 41 cyclomatic complexity (mcc)

* 17 cognitive complexity

* 11 number of total code smells

* 5% comment source ratio

* 303 mcc per 1,000 lloc

* 81 code smells per 1,000 lloc

## Findings (11)

### style, ForbiddenComment (1)

Flags a forbidden comment.

[Documentation](https://detekt.dev/docs/rules/style#forbiddencomment)

* /tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/MainActivity.kt:158:17
```
Forbidden TODO todo marker in comment, please do the changes.
```
```kotlin
155             if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
156                 // Permissions already granted, nothing to do
157             } else if (false && shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
158                 // TODO: Not implemented yet: display an educational UI explaining to the user the features that will be enabled
!!!                 ^ error
159                 //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
160                 //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
161                 //       If the user selects "No thanks," allow the user to continue without notifications.

```

### style, MagicNumber (1)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence it's unclear what the purpose of this number is. It's better to declare such numbers as constants and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* /tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/MainActivity.kt:86:31
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
83             Crossfade(targetState = showSplashScreen) { shouldShowSplashScreen ->
84                 if (shouldShowSplashScreen) {
85                     LaunchedEffect(Unit) {
86                         delay(1_000)
!!                               ^ error
87                         showSplashScreen = false
88                     }
89                     Box(

```

### style, MaxLineLength (6)

Line detected, which is longer than the defined maximum line length in the code style.

[Documentation](https://detekt.dev/docs/rules/style#maxlinelength)

* /tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/MainActivity.kt:155:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
152 
153     private fun askNotificationPermission() {
154         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
155             if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
!!! ^ error
156                 // Permissions already granted, nothing to do
157             } else if (false && shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
158                 // TODO: Not implemented yet: display an educational UI explaining to the user the features that will be enabled

```

* /tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/MainActivity.kt:158:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
155             if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
156                 // Permissions already granted, nothing to do
157             } else if (false && shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
158                 // TODO: Not implemented yet: display an educational UI explaining to the user the features that will be enabled
!!! ^ error
159                 //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
160                 //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
161                 //       If the user selects "No thanks," allow the user to continue without notifications.

```

* /tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/service/impl/DefaultFirebaseMessagingService.kt:24:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
21     override fun onMessageReceived(message: RemoteMessage) {
22         super.onMessageReceived(message)
23 
24         if (message.data.isNotEmpty() && message.data[Notification.Keys.NOTIFICATION_TYPE] == Notification.Values.REFRESH_DATA_TYPE) {
!! ^ error
25             MainScope().launch {
26                 notificationService.handleNotification(
27                     Notification.Remote.RefreshData,

```

* /tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/service/impl/DefaultParseUrlViewService.kt:11:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
8  
9      private val urlRegex = Patterns.WEB_URL.toRegex()
10 
11     override fun parse(text: String): List<WebLink> = urlRegex.findAll(text).map { WebLink(it.range, it.value) }.toList()
!! ^ error
12 }
13 

```

* /tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/util/NotificationLocalizedStringFactory.kt:7:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
4  import co.touchlab.droidcon.application.service.NotificationSchedulingService
5  import com.droidcon.app.R
6  
7  class NotificationLocalizedStringFactory(private val context: Context) : NotificationSchedulingService.LocalizedStringFactory {
!  ^ error
8  
9      override fun reminderTitle(roomName: String?): String {
10         val ending = roomName?.let { context.getString(R.string.notification_reminder_title_in_room, it) } ?: ""

```

* /tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/util/NotificationLocalizedStringFactory.kt:14:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
11         return context.getString(R.string.notification_reminder_title_base, ending)
12     }
13 
14     override fun reminderBody(sessionTitle: String): String = context.getString(R.string.notification_reminder_body, sessionTitle)
!! ^ error
15 
16     override fun feedbackTitle(): String = context.getString(R.string.notification_feedback_title)
17 

```

### style, UnusedPrivateProperty (2)

Property is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedprivateproperty)

* /tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/MainActivity.kt:49:17
```
Private property `notificationSchedulingService` is unused.
```
```kotlin
46     ComponentActivity(),
47     KoinComponent {
48 
49     private val notificationSchedulingService: NotificationSchedulingService by inject()
!!                 ^ error
50     private val analyticsService: AnalyticsService by inject()
51     private val notificationService: AndroidNotificationService by inject()
52 

```

* /tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/MainApp.kt:32:17
```
Private property `applicationScope` is unused.
```
```kotlin
29 class MainApp :
30     Application(),
31     KoinComponent {
32     private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
!!                 ^ error
33 
34     override fun onCreate() {
35         super.onCreate()

```

### style, UseOrEmpty (1)

Use `orEmpty()` call instead of `?:` with empty collection factory methods

[Documentation](https://detekt.dev/docs/rules/style#useorempty)

* /tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/service/impl/DefaultFirebaseMessagingService.kt:34:61
```
This '?: ""' can be replaced with 'orEmpty()' call
```
```kotlin
31 
32         // If we have notification, we're running in foreground and should show it ourselves.
33         val originalNotification = message.notification ?: return
34         val notification = NotificationCompat.Builder(this, message.notification?.channelId ?: "")
!!                                                             ^ error
35             .setContentTitle(originalNotification.title)
36             .setContentText(originalNotification.body)
37             .apply {

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2026-05-22 23:00:27 UTC
