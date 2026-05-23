### Dependabot impact companion

- **Dependency:** `io.insert-koin`
- **Version change:** `4.1.1` → `4.2.1`
- **Risk:** **HIGH**
- **Recommendation:** Hold merge until impacted files are reviewed and targeted regression checks pass.
- **Static impact:** 46 files (9 direct / 37 transitive-or-expect-actual)
- **UI impact:** 14 screens
- **Dynamic analysis:** skipped
- **Full report:** generated as static artifact/site in `output/report/`

### Top impacted files

| File | Relation | Source set | RLOC | MCC |
|------|----------|------------|------|-----|
| `/tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/MainActivity.kt` | direct | main | 131 | 12 |
| `/tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/Koin.ios.kt` | direct | ios | 77 | 11 |
| `/tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/Koin.kt` | direct | commonMain | 265 | 5 |
| `/tmp/output/phase1/before/shared/src/androidMain/kotlin/co/touchlab/droidcon/Koin.android.kt` | direct | androidMain | 48 | 3 |
| `/tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/service/impl/DefaultFirebaseMessagingService.kt` | direct | main | 39 | 2 |
| `/tmp/output/phase1/before/ios/src/iosMain/kotlin/co/touchlab/droidcon/ios/DependencyInjection.kt` | direct | ios | 39 | 2 |
| `/tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/UiModule.kt` | direct | commonMain | 102 | 1 |
| `/tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/MainApp.kt` | direct | main | 56 | 1 |
| `/tmp/output/phase1/before/shared/src/androidMain/kotlin/co/touchlab/droidcon/service/NotificationRescheduler.kt` | direct | androidMain | 24 | 1 |
| `/tmp/output/phase1/before/shared/src/androidMain/kotlin/co/touchlab/droidcon/service/AndroidNotificationService.kt` | transitive | androidMain | 229 | 20 |
