# Android Login & Profile System

This project is a two-activity Android application designed to demonstrate the fundamentals of Activity navigation and data passing using Intents. It simulates a login process where user credentials and preferences are validated and then transferred to a profile screen.

## Project Overview

The application consists of two main screens:
1.  **Login Activity:** Accepts user email, password, account type (User/Admin), and a "Remember Me" preference.
2.  **Profile Activity:** Receives the data from the login screen and displays the user's details.

## Features

* **Credential Validation:** Checks user input against hardcoded credentials to simulate authentication.
* **Account Type Selection:** Uses a `RadioGroup` to allow users to select between "User" and "Admin" roles.
* **Data Passing:** Demonstrates the use of `Intent.putExtra()` to send String and Boolean data between activities.
* **Data Retrieval:** Demonstrates `getIntent().getStringExtra()` and `getBooleanExtra()` to populate the profile view.
* **Logout Mechanism:** Navigates back to the login screen and finishes the current activity.

## Test Credentials

To successfully log in and see the data passing in action, use the following hardcoded credentials defined in `MainActivity.java`:

* **Email:** `Niyatibansal626@gmail.com`
* **Password:** `123456`
* **Account Type:** Select either User or Admin

## Technical Implementation

### Activities
* **MainActivity:** Handles UI input, verifies the specific email/password combination, and constructs the Intent bundle.
* **MainActivity2:** Acts as the dashboard. It extracts the Intent extras (Email, Account Type, Remember Me status) and updates the `TextView` components.

### Key Methods Used
* `rg1.getCheckedRadioButtonId()`: To determine which account type was selected.
* `intent.putExtra(key, value)`: To package data for transport.
* `startActivity(intent)`: To launch the second screen.

## Setup and Execution

1.  Clone the repository or download the source code.
2.  Open the project in Android Studio.
3.  Sync the project with Gradle files.
4.  Run the application on an emulator or physical device.
5.  Enter the test credentials listed above to view the Profile Activity.

## Known Limitations

* **Hardcoded Credentials:** This project uses static strings for validation. In a production environment, this should be replaced with a database or API authentication.
* **Forgot Password:** Currently, the "Forgot Password" link navigates to the second activity without passing data, resulting in empty fields. This is a placeholder for future logic.

## License

This project is open-source.
