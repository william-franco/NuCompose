# Changelog

All notable changes to this project are documented in this file.

## 2026-11-02

- Commit: Updated project architecture under src/common.
  - Moved dependency injection, navigation, design theme and shared UI or services into `src/common/` (`dependency_injectors`, `routes`, `design`, and related folders).
  - Kept feature code under `features/` and local persistence under `data/` where the app uses it.
  - Updated packages, imports, AndroidManifest where needed, and README architecture documentation.

## 2026-11-01

- Commit: Updated Android Gradle Plugin to 9.5.0 and CI actions.
  - Refreshed dependency versions and related build configuration to keep the project current.
  - Updated CI to actions/checkout v7 and actions/setup-java v6.

## 2026-09-19

- Commit: Updated Android build configuration.
  - Updated the affected project files and kept the implementation aligned with the current requirements.

## 2026-09-12

- Commit: Standardized README License section.
  - Improved the project documentation and clarified how the project is used or maintained.
- Commit: Updated project documentation.
  - Improved the project documentation and clarified how the project is used or maintained.

## 2026-09-07

- Commit: Updated CI build system and project documentation.
  - Improved the project documentation and clarified how the project is used or maintained.

## 2026-09-06

- Commit: Migrated NuCompose to MVVM architecture with Resonance pattern, updated dependencies, UX fixes and CI.
  - Refreshed dependency versions and related build configuration to keep the project current.

## 2024-03-02

- Commit: Updating libraries and SDKs to newer versions.
  - Refreshed dependency versions and related build configuration to keep the project current.

## 2023-12-16

- Commit: Initial commit.
  - Established the initial project structure and baseline implementation.
