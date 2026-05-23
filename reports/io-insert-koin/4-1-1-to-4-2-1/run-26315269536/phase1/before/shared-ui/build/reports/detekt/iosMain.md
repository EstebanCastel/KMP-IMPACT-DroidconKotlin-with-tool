# detekt

## Metrics

* 15 number of properties

* 7 number of functions

* 0 number of classes

* 4 number of packages

* 7 number of kt files

## Complexity Report

* 237 lines of code (loc)

* 204 source lines of code (sloc)

* 97 logical lines of code (lloc)

* 2 comment lines of code (cloc)

* 14 cyclomatic complexity (mcc)

* 6 cognitive complexity

* 10 number of total code smells

* 0% comment source ratio

* 144 mcc per 1,000 lloc

* 103 code smells per 1,000 lloc

## Findings (10)

### naming, FunctionNaming (4)

Function names should follow the naming convention set in the configuration.

[Documentation](https://detekt.dev/docs/rules/naming#functionnaming)

* /tmp/output/phase1/before/shared-ui/src/iosMain/kotlin/co/touchlab/droidcon/ui/settings/PlatformSpecificSettings.kt:7:21
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
4  import co.touchlab.droidcon.viewmodel.settings.SettingsViewModel
5  
6  @Composable
7  internal actual fun PlatformSpecificSettingsView(viewModel: SettingsViewModel) {
!                      ^ error
8      // No platform-specific settings needed for iOS
9  }
10 

```

* /tmp/output/phase1/before/shared-ui/src/iosMain/kotlin/co/touchlab/droidcon/ui/util/Dialog.kt:14:21
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
11 import androidx.compose.ui.graphics.Color
12 
13 @Composable
14 internal actual fun Dialog(dismiss: () -> Unit, content: @Composable () -> Unit) {
!!                     ^ error
15     Box(
16         modifier = Modifier
17             .fillMaxSize()

```

* /tmp/output/phase1/before/shared-ui/src/iosMain/kotlin/co/touchlab/droidcon/ui/util/LocalImage.kt:26:21
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
23 
24 @OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)
25 @Composable
26 internal actual fun __LocalImage(imageResourceName: String, modifier: Modifier, contentDescription: String?) {
!!                     ^ error
27     val painter = remember { UIImage.imageNamed(imageResourceName)?.toSkiaImage()?.toComposeImageBitmap()?.let(::BitmapPainter) }
28     if (painter != null) {
29         androidx.compose.foundation.Image(

```

* /tmp/output/phase1/before/shared-ui/src/iosMain/kotlin/co/touchlab/droidcon/ui/util/NavigationBackPressWrapper.kt:30:21
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
27 import kotlin.math.min
28 
29 @Composable
30 internal actual fun NavigationBackPressWrapper(content: @Composable () -> Unit) {
!!                     ^ error
31     val triggerBackPressDragDistance = 40f
32 
33     Box(contentAlignment = Alignment.CenterStart) {

```

### style, ForbiddenComment (1)

Flags a forbidden comment.

[Documentation](https://detekt.dev/docs/rules/style#forbiddencomment)

* /tmp/output/phase1/before/shared-ui/src/iosMain/kotlin/co/touchlab/droidcon/ui/util/ToSkiaImage.kt:23:1
```
Forbidden TODO todo marker in comment, please do the changes.
```
```kotlin
20 import platform.CoreGraphics.CGImageGetWidth
21 import platform.UIKit.UIImage
22 
23 // TODO: Add support for remaining color spaces when the Skia library supports them.
!! ^ error
24 @ExperimentalForeignApi
25 internal fun UIImage.toSkiaImage(): Image? {
26     val imageRef = CGImageCreateCopyWithColorSpace(this.CGImage, CGColorSpaceCreateDeviceRGB()) ?: return null

```

### style, MagicNumber (1)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence it's unclear what the purpose of this number is. It's better to declare such numbers as constants and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* /tmp/output/phase1/before/shared-ui/src/iosMain/kotlin/co/touchlab/droidcon/ui/util/NavigationBackPressWrapper.kt:31:40
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
28 
29 @Composable
30 internal actual fun NavigationBackPressWrapper(content: @Composable () -> Unit) {
31     val triggerBackPressDragDistance = 40f
!!                                        ^ error
32 
33     Box(contentAlignment = Alignment.CenterStart) {
34         content()

```

### style, MaxLineLength (4)

Line detected, which is longer than the defined maximum line length in the code style.

[Documentation](https://detekt.dev/docs/rules/style#maxlinelength)

* /tmp/output/phase1/before/shared-ui/src/iosMain/kotlin/co/touchlab/droidcon/ui/util/LocalImage.kt:27:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
24 @OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)
25 @Composable
26 internal actual fun __LocalImage(imageResourceName: String, modifier: Modifier, contentDescription: String?) {
27     val painter = remember { UIImage.imageNamed(imageResourceName)?.toSkiaImage()?.toComposeImageBitmap()?.let(::BitmapPainter) }
!! ^ error
28     if (painter != null) {
29         androidx.compose.foundation.Image(
30             modifier = modifier,

```

* /tmp/output/phase1/before/shared-ui/src/iosMain/kotlin/co/touchlab/droidcon/ui/util/LocalImage.kt:37:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
34         )
35     } else {
36         Row(
37             modifier = modifier.background(MaterialTheme.colorScheme.primary, RoundedCornerShape(Dimensions.Padding.half)),
!! ^ error
38             verticalAlignment = Alignment.CenterVertically,
39         ) {
40             Spacer(modifier = Modifier.weight(1f))

```

* /tmp/output/phase1/before/shared-ui/src/iosMain/kotlin/co/touchlab/droidcon/ui/util/ToSkiaImage.kt:38:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
35     val alphaInfo = CGImageGetAlphaInfo(imageRef)
36 
37     val alphaType = when (alphaInfo) {
38         CGImageAlphaInfo.kCGImageAlphaPremultipliedFirst, CGImageAlphaInfo.kCGImageAlphaPremultipliedLast -> ColorAlphaType.PREMUL
!! ^ error
39         CGImageAlphaInfo.kCGImageAlphaFirst, CGImageAlphaInfo.kCGImageAlphaLast -> ColorAlphaType.UNPREMUL
40         CGImageAlphaInfo.kCGImageAlphaNone, CGImageAlphaInfo.kCGImageAlphaNoneSkipFirst, CGImageAlphaInfo.kCGImageAlphaNoneSkipLast,
41         -> ColorAlphaType.OPAQUE

```

* /tmp/output/phase1/before/shared-ui/src/iosMain/kotlin/co/touchlab/droidcon/ui/util/ToSkiaImage.kt:40:1
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
37     val alphaType = when (alphaInfo) {
38         CGImageAlphaInfo.kCGImageAlphaPremultipliedFirst, CGImageAlphaInfo.kCGImageAlphaPremultipliedLast -> ColorAlphaType.PREMUL
39         CGImageAlphaInfo.kCGImageAlphaFirst, CGImageAlphaInfo.kCGImageAlphaLast -> ColorAlphaType.UNPREMUL
40         CGImageAlphaInfo.kCGImageAlphaNone, CGImageAlphaInfo.kCGImageAlphaNoneSkipFirst, CGImageAlphaInfo.kCGImageAlphaNoneSkipLast,
!! ^ error
41         -> ColorAlphaType.OPAQUE
42 
43         else -> ColorAlphaType.UNKNOWN

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2026-05-22 22:42:55 UTC
