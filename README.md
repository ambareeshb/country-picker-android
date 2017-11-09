# EasyPhonePicker
[![](https://img.shields.io/badge/API-9%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=9)

A simple library that displays a beautiful list of all the countries allowing the user to pick the country he wishes and provide details like country code, iso code name and flag. 

## But why?

- There are no stable working libraries for formatting phone number in Android.
- Uses [MichaelRocks/libphonenumber-android](https://github.com/MichaelRocks/libphonenumber-android), a fork of becoming de facto number formating standard [googlei18n/libphonenumber](https://github.com/googlei18n/libphonenumber) 
- Leeway for custom picker for selecting countries (Spinner,RecycleView Or No view :;):).

## Gradle

In project level gradle append,
```
allprojects {
    repositories {
        ...
        ...
        maven{
            url 'https://dl.bintray.com/ambareeshb/EasyPhonePicker'
        }
    }
}
```
In `app/build.gradle` append at bottom,
 
 ```
 ...
 ...
 
 compile 'com.ambareeshb:easy-phone-picker:0.9.0'
 
 ```
In your `Activity` or `Fragment` layout file,

```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_horizontal"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    tools:context="ambareesh.com.easyphonepicker.MainActivity">

    <ambareesh.com.easyphoneformat.EasyPhoneText
        android:id="@+id/easyPhoneText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:no_edit_text="false"
        app:selected_country="IN"
       />

</LinearLayout>

```
Done :+1:

## Usage
 ### XML tags
    - app:selected_country="IN" (value is a string ISO two letter country name).
    - app:no_edit_text="false"  (true if u want a country picker alone).
    - app:country_visible="false" if true no country chooser, by default (Indian phone number formater).
