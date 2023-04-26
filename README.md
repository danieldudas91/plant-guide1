# My Favorite Things

## Story

Finally your time has come when your enthusiasm and detailed knowledge about
any weirdly specific topic is highly appreciated! In this project you can
express all of that and channel it into an Android project. Maybe you love
all kinds of special cheese flavours and can talk about the different types
for hours? Maybe you know all the Star Wars characters and their personality
by heart? Or have an extensive amount of knowledge about tourist attractions
in Italy? This is your time to shine!

Create a list of your favorite things and pour all of that information into
detail pages like a library!

## What are you going to learn?

You'll have to:

- Create and manage a `RecyclerView`
- Load data from a separate layer
- Show a `Toast`
- Open an `Intent` with extras
- Use `Parcelable`
- Open an `Intent` that navigates outside of the app
- Send data between `Activities`

## Tasks

1. Implement a list of data and display it using a `RecyclerView`
    - The list is filled with content and at least an image and a title is displayed
    - The data creation is separated to another layer from the view
    - An icon is displayed on each item to indicate if it is added to the favorites
    - A `Toast` is displayed informing the user about the item's name when clicked
    - It is not required to store changes in the list after the app is closed

2. Create a detail page and open it when a listitem is clicked
    - The item data is sent to the new `Activity` in the `Intent` extras and it is `Parcelable`
    - More details of the item are displayed on the page
    - A "Share" button is displayed and the textual parts of the data can be sent to other applications
    - An "Open website" button is displayed and it opens the browser
    - And "Add to favorites" button is displayed and an icon indicates the current status
    - The changes in the item are sent back as a result to the main activity and is displayed in the original list
    - Optional task: If the data contains a location, a "Show on map" button is displayed and opens Google Maps with the give coordinates

3. The app needs to have a custom icon and handle device rotation.
    - The application has an icon other than the default
    - The application handles device rotation

## General requirements

None

## Hints

None

## Background materials

- <i class="far fa-exclamation"></i> [RecyclerView](https://codelabs.developers.google.com/codelabs/android-training-create-recycler-view)
- <i class="far fa-exclamation"></i> [Implicit intents](https://codelabs.developers.google.com/codelabs/android-training-activity-with-implicit-intent)
- [Parcelable](https://medium.com/@royanimesh2211/implementing-the-parcelable-interface-in-android-b404819ca441)
- [Toast](https://developer.android.com/guide/topics/ui/notifiers/toasts)
