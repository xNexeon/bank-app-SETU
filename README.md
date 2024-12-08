# Setu Bank App

Setu Bank App is a Kotlin-based banking system that mimics basic functionalities of a bank. It provides a friendly UI for customers and administrators to perform essential banking operations such as account management, depositing, and withdrawing. Administrators have their own dedicated panel to perform additional admin functions.

## Features

### Customer Features
- **Login/Register**: Users can log in or create a new account for themselves.
- **Check Balance**: View current account balance.
- **Deposit**: Add money to their account.
- **Withdraw**: Take money out of their account.
- **View Account Details**: Show all your account info.

### Admin Features
- **List Users**: Display all registered users (stored in `users.xml`).
- **Search Users by Name**: Search for all users with a specific first and last name.
- **Add Users**: Add a new user through the admin panel.
- **Remove Users**: Remove accounts from `users.xml`.
- **Update Users**: Modify current account details.

## How the App Works

- **User  Interface**: Everything is done using console inputs.
- **Data Storage**: User data is stored in an XML file (`users.xml`), providing persistence.
- **Roles**: Users are assigned roles (Standard and Admin) which enable specific actions for different user types.

## Core Classes
- **BankApp**: Entry point for the app, groups user interactions and banking features.
- **AccountHandler**: Manages user data, validation, registration, persistence, etc.
- **Screens**: Manages user screens (mainly to keep the rest of the files clean).
- **User **: Represents the user data model with variables such as age, balance, and account type.

## Usage

### LOGIN
1. Start the application.
2. Press "1" to log in.
3. Enter your user ID and password to log in.

### REGISTER
1. Start the application.
2. Press "2" to register.
3. Enter your details.
4. If valid info is entered, the app will auto log in after registration.

### ADMIN PANEL
1. Log in with an account of level type "Admin" (Default admin user ID is `3`).
2. You can now access admin-specific features such as the ability to add or remove users.
