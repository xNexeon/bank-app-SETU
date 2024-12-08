Setu Bank App is a kotlin based banking system that mimics basic functionalities of a bank.
It provides a friendly UI for customers and administrators to perform essential banking operations such as account managment, depositing, withdrawing. Administrators get their own dedicated panel which the can use to perform more admin functions.

Features:
Customer Features
Login/Register: Users can log in, or create a new account for themselves
Check balance: View current account balance
Deposit: Add money to their account
Withdraw: Take money out of their account
View Account Details: Show all your account info

Admin Features
List Users: Display all registered users (in users.xml)
Search users by name: Search for all users with a specific first and last name
Add Users: Add a new user through admin panel
Remove users: Remove accounts from users.xml
Update users: Modify current account details

How the app works
User interface: Everything is done using console inputs
Data Storage: User data is stored in an xml file (users.xml) which provides persistence
Roles: Users are assigned roles (Standard and Admin) which enables specific actions for different user types

Core Classes:
BankApp: Entry point for app, groups user interactions and banking features
AccountHandler: Manages user data, validation, registration, persistence etc
Screens: Manages user screens (Mainly to keep rest of the files clean)
User: Represents the user data model with variables such as age, balance and account type

Usage:
LOGIN
[1] Start the application
[2] press "1" to login
[3] enter your user ID and password to log in

REGISTER
[1] Start the application
[2] press "2" to register
[3] enter your details
[3] If valid info is entered, app will auto log in after registrationn

ADMIN PANEL
[1] Login with an account of level type "Admin" [Default admin userId is 3]
[2] You can now access admin-specific features such as the ability to add+remove users
