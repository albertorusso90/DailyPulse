# The Daily Pulse

The Daily Pulse is a cross-platform mobile application built using Kotlin Multiplatform Mobile (KMP) that provides users with up-to-date news articles. The app pulls data from [newsapi.org](https://newsapi.org/) and displays it in a user-friendly interface. It follows clean architecture and SOLID principles, providing a smooth experience on both Android and iOS.

## Features

### 1. Articles List
- Displays a list of articles retrieved from [newsapi.org](https://newsapi.org/).
- The list is fetched using the [Ktor](https://ktor.io/) library and is stored locally in a database using the [SQLDelight](https://cashapp.github.io/sqldelight/) library.
- Users can swipe to refresh the list, forcing a data refresh from the server.

### 2. Sources
- Displays a list of available news sources from [newsapi.org](https://newsapi.org/).
  
### 3. About Screen
- Shows information about the device including its name, version, and other relevant details.

## Architecture

The project follows **Clean Architecture** and adheres to **SOLID principles** to ensure maintainability, scalability, and testability:

- **Use Cases**: Handle the application's business logic.
- **Repositories**: Provide data from various sources (API, local database).
- **Entities**: Represent the core business models.
- **ViewModels**: Expose data and commands to the UI layer.
- **UI Layer**: Implemented with Jetpack Compose for Android and SwiftUI for iOS.

## Libraries Used

- **Ktor**: For making network requests to fetch articles and sources.
- **SQLDelight**: For managing the local database on both Android and iOS.
- **Coroutines**: For handling asynchronous tasks and multithreading.
- **Koin**: For dependency injection.
- **Jetpack Compose** (Android) and **SwiftUI** (iOS): For building user interfaces.
  
## Setup

### Android

1. Clone the repository.
2. Open the project in **Android Studio**.
3. Make sure to have the necessary dependencies in your `build.gradle` files.
4. Run the app on an Android emulator or device.

### iOS

1. Clone the repository.
2. Open the project in **Xcode**.
3. Make sure to have the necessary dependencies in your `Podfile`.
4. Run the app on an iOS simulator or device.

## API Key

The app fetches data from [newsapi.org](https://newsapi.org/), which requires an API key. Please obtain your API key and configure it in the appropriate place in the project.

## License

This project is licensed under the MIT License.
