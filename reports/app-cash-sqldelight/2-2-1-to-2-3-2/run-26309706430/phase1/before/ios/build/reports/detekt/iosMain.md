# detekt

## Metrics

* 8 number of properties

* 13 number of functions

* 4 number of classes

* 4 number of packages

* 4 number of kt files

## Complexity Report

* 158 lines of code (loc)

* 121 source lines of code (sloc)

* 65 logical lines of code (lloc)

* 3 comment lines of code (cloc)

* 22 cyclomatic complexity (mcc)

* 0 cognitive complexity

* 3 number of total code smells

* 2% comment source ratio

* 338 mcc per 1,000 lloc

* 46 code smells per 1,000 lloc

## Findings (3)

### style, MaxLineLength (3)

Line detected, which is longer than the defined maximum line length in the code style.

[Documentation](https://detekt.dev/docs/rules/style#maxlinelength)

* /tmp/output/phase1/before/ios/src/iosMain/kotlin/co/touchlab/droidcon/ios/service/DefaultParseUrlViewService.kt:9:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
6  class DefaultParseUrlViewService : ParseUrlViewService {
7  
8      private val urlRegex =
9          "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)".toRegex()
!  ^ error
10 
11     override fun parse(text: String): List<WebLink> = urlRegex.findAll(text).map { WebLink(it.range, it.value) }.toList()
12 }

```

* /tmp/output/phase1/before/ios/src/iosMain/kotlin/co/touchlab/droidcon/ios/service/DefaultParseUrlViewService.kt:11:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
8      private val urlRegex =
9          "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)".toRegex()
10 
11     override fun parse(text: String): List<WebLink> = urlRegex.findAll(text).map { WebLink(it.range, it.value) }.toList()
!! ^ error
12 }
13 

```

* /tmp/output/phase1/before/ios/src/iosMain/kotlin/co/touchlab/droidcon/ios/util/NotificationLocalizedStringFactory.kt:10:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
7  import platform.Foundation.stringWithFormat
8  
9  @OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)
10 class NotificationLocalizedStringFactory(private val bundle: NSBundle) : NotificationSchedulingService.LocalizedStringFactory {
!! ^ error
11 
12     override fun reminderTitle(roomName: String?): String {
13         val ending = roomName?.let {

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2026-05-22 20:27:55 UTC
