# 📱 Postly Android App

Postly is a modular Android application built with **Jetpack Compose**, following **MVVM** combined with **MVI** for state management. It leverages modern Android development libraries, ensuring clean architecture and maintainability.

---

## 🛠️ Tech Stack

* **Jetpack Compose** — Modern UI Toolkit
* **MVVM + MVI** — Architecture & State Management
* **Kotlin Coroutines** — Asynchronous Programming
* **StateFlow** — Reactive UI State Handling
* **Hilt** — Dependency Injection
* **Room** — Local Database for Offline Mode
* **Custom Pagination** — Full Control over Pagination Logic
* **Modularization** — Clean Project Separation (Features, Data, Domain, Core, etc.)

---

## ✅ Unit Tests Coverage

* **Repository Layer** — Tests with mocked API, DAO, and ConnectivityManager.
* **Room Database** — Tests using in-memory Room database and Robolectric.
* **ViewModel** — Tests with fake UseCases and mocked dependencies.
* **Use Cases** — Unit tested with mocked Repository.
* **Tech Stack Components** — Verified with isolated unit tests.

---

## 🗂️ Project Modules

* `app` — Main application module
* `designsystem` — Jetpack Compose component and theme
* `navigation` — Handle app navigation through the App
* `utils` — Contains utilities that can be used throughout the App (e.g., internetmanager)
* `features` — Feature-based modules (e.g., posts)
  * `common` — Common utilities, network, and UI components
  * `data` — Data layer, repositories, API calls, DAOs
  * `domain` — Business logic and use cases

---

## 🚀 How to Run the Project

1. **Clone the Repository**

   ```bash
   git clone [https://github.com/your-org/postly-android.git](https://github.com/gomaa92/Postly.git)
   ```

2. **Open in Android Studio**

   * Android Studio Hedgehog or newer is recommended.

3. **Configure Local Properties**

   * In your **`~/.gradle/gradle.properties`** (or project level `gradle.properties`):

   ```properties
   API_KEY=your_actual_api_key_here
   ```

4. **Build & Run**

   * Sync Gradle and run the app on an emulator or device.

---

## 📝 Notes

* The app uses **Room** for offline caching.
* Pagination is manually handled to give full control over the logic.
* Network key is loaded from **Gradle properties** — make sure you add it before building.

