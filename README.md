# Plant Guide - Android app

## Table of contents
* [General info](#general-info)
* [Technical information](#technical-information)
* [Features](#features)
* [Setup](#setup)



## General info
An Android application for storing locations and information about plant species native to Hungary.


## Technical information
SDK
* Target SDK version: 33
* Minimum SDK version: 24

Gradle
* Gradle version: 8.0

Dependencies
* appCompat version: 1.6.1
* constraintLayout version: 2.1.4
* coreTesting version: 2.2.0
* lifecycle version: 2.3.1
* material version: 1.9.0
* Room version: 2.5.2


## Features
List the ready features here:
- List plant species by geographic region
- Add new plant to the database


## Setup
First, clone the repo:

git clone git@github.com:danieldudas91/plant-guide1.git

Android Studio

(These instructions were tested with Android Studio version 2022.2.1 Patch 2)

    Open Android Studio and select File->Open... or from the Android Launcher select Import project (Eclipse ADT, Gradle, etc.) and navigate to the root directory of your project.
    Select the directory and select the file build.gradle in the cloned repo.
    Click 'OK' to open the project in Android Studio.
    A Gradle sync should start, but you can force a sync and build the 'app' module as needed.
