### Dependabot impact companion

- **Dependency:** `org.jetbrains.kotlin.multiplatform`
- **Version change:** `2.2.21` → `2.3.21`
- **Risk:** **HIGH**
- **Recommendation:** Hold merge until impacted files are reviewed and targeted regression checks pass.
- **Static impact:** 122 files (68 direct / 54 transitive-or-expect-actual)
- **UI impact:** 24 screens
- **Dynamic analysis:** skipped
- **Full report:** generated as static artifact/site in `output/report/`

### Top impacted files

| File | Relation | Source set | RLOC | MCC |
|------|----------|------------|------|-----|
| `/tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultSyncService.kt` | direct | commonMain | 440 | 39 |
| `/tmp/output/phase1/before/shared/src/androidMain/kotlin/co/touchlab/droidcon/service/AndroidNotificationService.kt` | direct | androidMain | 229 | 20 |
| `/tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/ApplicationViewModel.kt` | direct | commonMain | 198 | 15 |
| `/tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/service/IOSNotificationService.kt` | direct | ios | 162 | 15 |
| `/tmp/output/phase1/before/android/src/main/java/co/touchlab/droidcon/android/MainActivity.kt` | direct | main | 131 | 12 |
| `/tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/Koin.ios.kt` | direct | ios | 77 | 11 |
| `/tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/sponsors/SponsorsView.kt` | direct | commonMain | 177 | 9 |
| `/tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/application/service/impl/DefaultNotificationSchedulingService.kt` | direct | commonMain | 124 | 8 |
| `/tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/repository/impl/BaseRepository.kt` | direct | commonMain | 42 | 8 |
| `/tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/ui/session/SessionListView.kt` | direct | commonMain | 211 | 7 |
