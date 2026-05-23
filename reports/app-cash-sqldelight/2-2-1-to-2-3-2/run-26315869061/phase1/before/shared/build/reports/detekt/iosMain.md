# detekt

## Metrics

* 35 number of properties

* 24 number of functions

* 5 number of classes

* 4 number of packages

* 8 number of kt files

## Complexity Report

* 413 lines of code (loc)

* 343 source lines of code (sloc)

* 200 logical lines of code (lloc)

* 4 comment lines of code (cloc)

* 58 cyclomatic complexity (mcc)

* 15 cognitive complexity

* 15 number of total code smells

* 1% comment source ratio

* 290 mcc per 1,000 lloc

* 75 code smells per 1,000 lloc

## Findings (15)

### naming, MatchingDeclarationName (1)

If a source file contains only a single non-private top-level class or object, the file name should reflect the case-sensitive name plus the .kt extension.

[Documentation](https://detekt.dev/docs/rules/naming#matchingdeclarationname)

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/domain/repository/impl/SqlDelightDriverFactory.ios.kt:7:14
```
The file name 'SqlDelightDriverFactory.ios' does not match the name of the single top-level declaration 'SqlDelightDriverFactory'.
```
```kotlin
4  import app.cash.sqldelight.driver.native.NativeSqliteDriver
5  import co.touchlab.droidcon.db.DroidconDatabase
6  
7  actual class SqlDelightDriverFactory {
!               ^ error
8      actual fun createDriver(): SqlDriver = NativeSqliteDriver(DroidconDatabase.Schema, "droidcon.db")
9  }
10 

```

### style, ForbiddenComment (3)

Flags a forbidden comment.

[Documentation](https://detekt.dev/docs/rules/style#forbiddencomment)

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/MainScope.kt:21:5
```
Forbidden TODO todo marker in comment, please do the changes.
```
```kotlin
18         showError(throwable)
19     }
20 
21     // TODO: Some way of exposing this to the caller without trapping a reference and freezing it.
!!     ^ error
22     private fun showError(t: Throwable) {
23         log.e(throwable = t) { "Error in MainScope" }
24     }

```

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/util/BundleResourceReader.kt:22:9
```
Forbidden TODO todo marker in comment, please do the changes.
```
```kotlin
19 @BetaInteropApi
20 class BundleResourceReader(private val bundle: NSBundle = NSBundle.bundleForClass(BundleMarker)) : ResourceReader {
21     override fun readResource(name: String): String {
22         // TODO: Catch iOS-only exceptions and map them to common ones.
!!         ^ error
23         val (filename, type) = when (val lastPeriodIndex = name.lastIndexOf('.')) {
24             0 -> {
25                 null to name.drop(1)

```

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/util/BundleResourceReader.kt:44:17
```
Forbidden TODO todo marker in comment, please do the changes.
```
```kotlin
41             val errorPtr = alloc<ObjCObjectVar<NSError?>>()
42 
43             NSString.stringWithContentsOfFile(path, encoding = NSUTF8StringEncoding, error = errorPtr.ptr) ?: run {
44                 // TODO: Check the NSError and throw common exception.
!!                 ^ error
45                 error("Couldn't load resource: $name. Error: ${errorPtr.value?.localizedDescription} - ${errorPtr.value}")
46             }
47         }

```

### style, MaxLineLength (9)

Line detected, which is longer than the defined maximum line length in the code style.

[Documentation](https://detekt.dev/docs/rules/style#maxlinelength)

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/Koin.ios.kt:53:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
50 
51 @BetaInteropApi
52 fun Koin.get(objCClass: ObjCClass, qualifier: Qualifier?, parameter: Any): Any {
53     val kClazz = requireNotNull(getOriginalKotlinClass(objCClass)) { "Could not get original kotlin class for $objCClass." }
!! ^ error
54     return get(kClazz, qualifier) { parametersOf(parameter) }
55 }
56 

```

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/Koin.ios.kt:59:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
56 
57 @BetaInteropApi
58 fun Koin.get(objCClass: ObjCClass, parameter: Any): Any {
59     val kClazz = requireNotNull(getOriginalKotlinClass(objCClass)) { "Could not get original kotlin class for $objCClass." }
!! ^ error
60     return get(kClazz, null) { parametersOf(parameter) }
61 }
62 

```

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/Koin.ios.kt:65:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
62 
63 @BetaInteropApi
64 fun Koin.get(objCClass: ObjCClass, qualifier: Qualifier?): Any {
65     val kClazz = requireNotNull(getOriginalKotlinClass(objCClass)) { "Could not get original kotlin class for $objCClass." }
!! ^ error
66     return get(kClazz, qualifier, null)
67 }
68 

```

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/Koin.ios.kt:71:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
68 
69 @BetaInteropApi
70 fun Koin.get(objCClass: ObjCClass): Any {
71     val kClazz = requireNotNull(getOriginalKotlinClass(objCClass)) { "Could not get original kotlin class for $objCClass." }
!! ^ error
72     return get(kClazz, null)
73 }
74 

```

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/Koin.ios.kt:77:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
74 
75 @BetaInteropApi
76 fun Koin.get(objCProtocol: ObjCProtocol, qualifier: Qualifier?): Any {
77     val kClazz = requireNotNull(getOriginalKotlinClass(objCProtocol)) { "Could not get original kotlin class for $objCProtocol." }
!! ^ error
78     return get(kClazz, qualifier, null)
79 }
80 

```

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/service/IOSNotificationService.kt:47:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
44     override suspend fun initialize(): Boolean {
45         log.d { "Initializing." }
46 
47         val notificationSettings = wrapMultiThreadCallback(notificationCenter::getNotificationSettingsWithCompletionHandler)
!! ^ error
48         if (notificationSettings == null) {
49             log.i { "Failed to get current notification authorization." }
50             return false

```

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/service/IOSNotificationService.kt:78:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
75         }
76     }
77 
78     override suspend fun schedule(notification: Notification.Local, title: String, body: String, delivery: Instant, dismiss: Instant?) {
!! ^ error
79         log.v { "Scheduling local notification at ${delivery.toNSDate().description}." }
80         val deliveryDate = delivery.toNSDate()
81         val allUnits = NSCalendarUnitSecond or

```

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/service/IOSNotificationService.kt:151:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
148                 }
149             }
150 
151             Notification.Remote.RefreshData -> syncService.forceSynchronize(conferenceConfigProvider.getSelectedConference())
!!! ^ error
152         }
153     }
154 

```

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/util/BundleResourceReader.kt:45:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
42 
43             NSString.stringWithContentsOfFile(path, encoding = NSUTF8StringEncoding, error = errorPtr.ptr) ?: run {
44                 // TODO: Check the NSError and throw common exception.
45                 error("Couldn't load resource: $name. Error: ${errorPtr.value?.localizedDescription} - ${errorPtr.value}")
!! ^ error
46             }
47         }
48     }

```

### style, ReturnCount (1)

Restrict the number of return statements in methods.

[Documentation](https://detekt.dev/docs/rules/style#returncount)

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/service/IOSNotificationService.kt:44:26
```
Function initialize has 5 return statements which exceeds the limit of 2.
```
```kotlin
41         this.notificationHandler = notificationHandler
42     }
43 
44     override suspend fun initialize(): Boolean {
!!                          ^ error
45         log.d { "Initializing." }
46 
47         val notificationSettings = wrapMultiThreadCallback(notificationCenter::getNotificationSettingsWithCompletionHandler)

```

### style, UnusedPrivateClass (1)

Private class is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedprivateclass)

* /tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/util/BundleResourceReader.kt:50:5
```
Private class BundleMarker is unused.
```
```kotlin
47         }
48     }
49 
50     private class BundleMarker : NSObject() {
!!     ^ error
51         companion object : NSObjectMeta()
52     }
53 }

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2026-05-22 22:58:24 UTC
