# Wubba - Rick and Morty Character Explorer

Welcome to Wubba, an Android application built with Jetpack Compose that lets you explore the wonderful world of Rick and Morty characters!


## Features
- Character List: Browse a comprehensive list of characters from the Rick and Morty universe.
- Character Details: View detailed information about each character, including their status, species, origin, and location.

## Prerequisites
- Android Studio: You need Android Studio (Arctic Fox or later) to build and run the project.
- Android Emulator or Device: You'll need an Android emulator or a physical device to run the app.

## Getting Started
- Clone the Repository: `git clone https://github.com/oluwadara-abijo/Wubba`
- Open in Android Studio:
Launch Android Studio and select "Open an existing Android Studio project."
Navigate to the cloned repository and select the Wubba directory.
- Build and Run:
Click the "Run" button (green triangle) in the toolbar.
Choose your preferred emulator or connect a physical device.
The app will build and install on your chosen device.

## Project Structure
- app: Contains the main application module, including UI components and view models for the application logic.
- core:network: Handles network communication to fetch character data from the Rick and Morty API.
- core:test: Contains test code for the logic layer.

## Dependencies
- Jetpack Compose: Modern UI toolkit for building native Android interfaces.
- Hilt: Dependency injection framework for managing dependencies.
- Retrofit: Type-safe HTTP client for network requests.
- Kotlin Coroutines: For asynchronous programming.
- Coil: Image loading library for displaying character images.

## Acknowledgements
The character data is sourced from the [Rick and Morty API](https://rickandmortyapi.com/documentation).
