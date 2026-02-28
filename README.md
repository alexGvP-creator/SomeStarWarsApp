# Star Wars API Demo App

This app created by Alexander Graefe von Pein showcases data from the [SWAPI](https://swapi.dev/) API using modern Android development techniques.

---

## Technical Features

- MVVM Architecture  
- Jetpack Compose for UI  
- Navigation 3  
- Retrofit 2 with Kotlin Serialization
- Repository Pattern  

---

## App Features

- Displaying people data in a `LazyList`
- Navigation to a detail screen (with animation)
- Displaying additional data in a bottom sheet
- Showing loading states
- Error handling with retry function

---

## Missing Features because I ran out of time

- NavigationViewModel to persist navigation state (state gets currently lost in onDestroy)
- Tests
- Composable Previews
- Fetching and displaying film, planet, and spaceship data
- Caching data in a local database

---

## AI Usage

- Used AI to figure out why the SVG in `ic_launcher` was not displaying correctly
- Used AI to format this documentation
