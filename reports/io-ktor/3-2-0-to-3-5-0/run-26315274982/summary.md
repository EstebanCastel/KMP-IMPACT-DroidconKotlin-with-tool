### Dependabot impact companion

- **Dependency:** `io.ktor`
- **Version change:** `3.2.0` → `3.5.0`
- **Risk:** **HIGH**
- **Recommendation:** Hold merge until impacted files are reviewed and targeted regression checks pass.
- **Static impact:** 57 files (7 direct / 50 transitive-or-expect-actual)
- **UI impact:** 16 screens
- **Dynamic analysis:** skipped
- **Full report:** generated as static artifact/site in `output/report/`

### Top impacted files

| File | Relation | Source set | RLOC | MCC |
|------|----------|------------|------|-----|
| `/tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/Koin.ios.kt` | direct | ios | 77 | 11 |
| `/tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/Koin.kt` | direct | commonMain | 265 | 5 |
| `/tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultApiDataSource.kt` | direct | commonMain | 71 | 3 |
| `/tmp/output/phase1/before/shared/src/androidMain/kotlin/co/touchlab/droidcon/Koin.android.kt` | direct | androidMain | 48 | 3 |
| `/tmp/output/phase1/before/shared/src/commonMain/kotlin/co/touchlab/droidcon/domain/service/impl/DefaultServerApi.kt` | direct | commonMain | 40 | 3 |
| `/tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/sponsor/SponsorGroupItemViewModel.kt` | direct | commonMain | 18 | 2 |
| `/tmp/output/phase1/before/tools/kmp-impact-analyzer/tests/fixtures/sample_kotlin/CommonModule.kt` | direct | common | 8 | 1 |
| `/tmp/output/phase1/before/shared/src/androidMain/kotlin/co/touchlab/droidcon/service/AndroidNotificationService.kt` | transitive | androidMain | 229 | 20 |
| `/tmp/output/phase1/before/shared-ui/src/commonMain/kotlin/co.touchlab.droidcon/viewmodel/ApplicationViewModel.kt` | transitive | commonMain | 198 | 15 |
| `/tmp/output/phase1/before/shared/src/iosMain/kotlin/co/touchlab/droidcon/service/IOSNotificationService.kt` | transitive | ios | 162 | 15 |
