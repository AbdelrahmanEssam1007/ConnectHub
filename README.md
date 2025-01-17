# ConnectHub - Social Networking Platform

## Overview

ConnectHub is a fully functional social networking platform built from the ground up in Java, utilizing Swing for the frontend and core Java for the backend. The project aimed to create a platform where users can manage their accounts, share posts and stories, connect with friends, and maintain a profile. We prioritized security, usability, and the demonstration of good software engineering practices throughout the development.

This project was developed over three phases, with each phase building on the previous one to progressively add new and more complex functionality. This README provides a comprehensive summary of all the features we implemented.

## Completed Features

### Phase 1: Core Functionality

#### User Account Management
*   Users can sign up with a unique username, email, date of birth and password.
*   Users can log in using their credentials and log out to close their session.
*   User passwords are securely hashed before storage.
*   The system keeps track of the user's online status.

#### Profile Management
*   Users can customize their profiles by adding or updating a profile and cover picture.
*   Users can add a short bio and change their passwords.
*   Users can view their own posts and see their friends list, along with their online status.

#### Content Creation (Posts and Stories)
*   Users can create posts and stories that can contain text and images.
*   Stories are temporary, automatically disappearing after 24 hours.

#### Friend Management
*   Users can send and receive friend requests.
*   Users can accept or decline friend requests.
*   The system suggests new people to connect with and manages friend blocking and removing.

#### Newsfeed Page
*   A personalized newsfeed displaying posts and stories from their friends.
*   Users can see who of their friends are online.
*   The newsfeed shows friend suggestions and provides controls for content creation and updates.

### Phase 2: Interactivity and Group Management

#### Search Functionality
*   Users can search for other users using their username.
*   Users can search for groups by name.
*   Actionable search results include sending friend requests, joining and leaving groups, blocking users and viewing profiles.

#### Group Management
*   Users can create new groups with a name, description, and group picture.
*   Group permissions allow for promotion of admins, deletion of groups, addition of posts and removing members
*   Users can join or leave groups
*   Group activities are displayed on the newsfeed.

#### Notification System
*   Users are notified of new friend requests, group activities, and new posts in their groups.
*   Notifications require a manual refresh to be displayed.

#### Extended Newsfeed
*   The newsfeed displays group suggestions, interactive notifications and groups the user is already a member of.

### Phase 3: Real-time Interaction

#### Chatting
*   Users can chat with their friends via private one-to-one messages.
*   The chat window displays previous messages and provides a means for sending new ones.

#### Interacting with Posts
*   Users can add comments to posts
*   Users can like posts.
*   Users will receive notifications whenever another user adds a comment or like to their posts

#### Notification System
*    Users are notified of new messages they receive from friends.
*   Users are notified of new likes and comments on their posts.
*   These notifications are delivered by using a thread and webSocket

## Technical Details

### Technology Stack

*   **Language:** Java
*   **Frontend:** Swing UI library
*   **Database:** File-based JSON database

### Security Implementation

*   User passwords are never stored in plain text; we use SHA-256 hashing.
*   Input validation is performed to prevent common vulnerabilities.
*   Error handling is in place to manage failed login attempts.

### Database Design

*   Data is stored in a flexible JSON format which is easy to manipulate.
*   We designed the JSON file structures to minimize redundant data and optimize for efficient access.
*   Data structures were designed to manage relationships between users and content effectively.

### Design Patterns and Principles

*   The project follows SOLID principles for maintainable and scalable design.
*   Various design patterns were implemented including Factory, Singleton, Decorator, Observer and Strategy patterns.

## Project Members

*   Abdelrahman Essam
*   Ahmad Wael
*   Ahmad Zaki
*   Amr Attia

## Contributing
Contributions are welcome! Feel free to contribute by submitting a pull request. For major changes, please open an issue first to discuss what you would like to change.
