📱 Postly Android App

Postly is a modular Android application built with Jetpack Compose, following MVVM combined with MVI for state management.
It leverages modern Android development libraries, ensuring clean architecture and maintainability.

🛠️ Tech Stack

Jetpack Compose — Modern UI Toolkit

MVVM + MVI — Architecture & State Management

Kotlin Coroutines — Asynchronous Programming

StateFlow — Reactive UI State Handling

Hilt — Dependency Injection

Room — Local Database for Offline Mode

Custom Pagination — Full Control over Pagination Logic

Modularization — Clean Project Separation (Features, Utils, DesignSsystem, Navigation, etc.)


🗂️ Project Modules

app — Main application module

features — Feature-based modules (e.g., posts)
designsystem -Jetpack compsoe component and theme
navigation — Handle app navigation through the App
utils - contains utilities that can be used throughout the App (e.g., internetmanager)


🚀 How to Run the Project

Clone the Repository

git clone [https://github.com/your-org/postly-android.git](https://github.com/gomaa92/Postly.git)

Open in Android Studio

Android Studio Hedgehog or newer is recommended.

Configure Local Properties

In your ~/.gradle/gradle.properties (or project level gradle.properties):

API_KEY=your_actual_api_key_here

Build & Run

Sync Gradle and run the app on an emulator or device.


📝 Notes

The app uses Room for offline caching.

Pagination is manually handled to give full control over the logic.

Network key is loaded from Gradle properties — make sure you add it before building.
