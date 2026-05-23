# detekt

## Metrics

* 10 number of properties

* 0 number of functions

* 0 number of classes

* 1 number of packages

* 1 number of kt files

## Complexity Report

* 39 lines of code (loc)

* 31 source lines of code (sloc)

* 17 logical lines of code (lloc)

* 0 comment lines of code (cloc)

* 0 cyclomatic complexity (mcc)

* 0 cognitive complexity

* 1 number of total code smells

* 0% comment source ratio

* 0 mcc per 1,000 lloc

* 58 code smells per 1,000 lloc

## Findings (1)

### naming, PackageNaming (1)

Package names should match the naming convention set in the configuration.

[Documentation](https://detekt.dev/docs/rules/naming#packagenaming)

* /tmp/output/phase1/before/shared-ui/build/generated/compose/resourceGenerator/kotlin/iosArm64MainResourceCollectors/droidcon/shared_ui/generated/resources/ActualResourceCollectors.kt:3:1
```
Package name should match the pattern: [a-z]+(\.[a-z][A-Za-z0-9]*)*
```
```kotlin
1 @file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)
2 
3 package droidcon.shared_ui.generated.resources
! ^ error
4 
5 import kotlin.OptIn
6 import kotlin.String

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2026-05-22 22:34:48 UTC
