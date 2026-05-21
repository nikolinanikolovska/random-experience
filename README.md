# 🎲 Random Experience

Random Experience is a full-stack web application built with **Spring Boot** and **Thymeleaf**, designed to help users discover and choose activities and experiences based on their preferences.

The application provides personalized recommendations based on category, budget, duration, and location type, along with a favorites system and user authentication.

---

##  Technologies Used

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- Thymeleaf
- Hibernate ORM
- H2 Database
- HTML5
- CSS3
- Gradle
- IntelliJ IDEA

---

##  Features

###  Home Page
- Hero section with main heading
- Recommendation form
- Filters for:
  - Category
  - Budget
  - Duration
  - Indoor / Outdoor type

---

###  Activities Page
- View all available activities
- Search by category
- View activity details
- Add activities to favorites

**Available categories:**
- Sport
- Relax
- Entertainment

---

###  Recommendation System
Users receive personalized activity suggestions based on:
- Category
- Maximum budget
- Maximum duration
- Location type (Indoor / Outdoor)

---

###  Favorites System
Authenticated users can:
- Add activities to favorites
- Remove activities from favorites
- View saved activities

Each user has a personalized favorites list.

---

###  Authentication
- User registration
- User login/logout
- Secure access to personalized features

---

##  Frontend Design

The frontend is built using a modern **glassmorphism design** approach:

- Dark gradient background
- Fully responsive layout
- Card-based interface
- Hover animations
- Modern typography (Inter font)
- Custom CSS (no external UI frameworks)

---

##  Backend Architecture

The project follows the **MVC architecture pattern**.

###  Controllers
- HomeController
- RecommendationController
- FavoriteController
- AuthController

###  Services
- RecommendationService
- FavoriteService
- UserService

###  Repositories
- ActivityRepository
- UserRepository
- FavoriteRepository

###  Entities
- Activity
- User
- Favorite

---

##  Database

The application uses an **H2 in-memory database**.

### Features:
- Automatic table creation via Hibernate
- Spring Data JPA integration
- Built-in H2 console for testing and inspection

###  Database Tables:
- activity
- app_user
- favorite

###  H2 Console: http://localhost:8080/h2-console

### JDBC URL:  jdbc:h2:mem:randomexperiencedb

Default settings (if not changed in `application.properties`):
- Username: `sa`
- Password: *(empty)*

---

##  Application Workflow

1. User opens the application
2. Browses available activities or requests recommendations
3. System filters activities based on preferences
4. User registers or logs in (if needed)
5. User adds activities to favorites
6. Favorites page displays saved activities

---

##  Challenges Faced

- CSS styling conflicts
- Thymeleaf rendering issues
- Favorite button functionality
- Responsive design implementation
- Authentication flow integration

---

##  Conclusion

Random Experience is a complete full-stack web application that combines a **Spring Boot backend** with a modern **Thymeleaf frontend**.

It demonstrates:
- MVC architecture
- Database integration with JPA
- User authentication
- Personalized recommendation system
- Modern UI/UX design principles

---

##  How to Run the Project

```bash
./gradlew bootRun
or directly from the run button.

