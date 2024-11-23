# Project Name

A brief description of the project and its purpose.

---

## Project Structure

The project consists of two main folders:  
1. **Frontend**: Angular application for the user interface.  
2. **Backend**: Spring Boot application for the server-side logic.  

---

## Prerequisites

Before you start, ensure you have the following installed on your system:  
- **Node.js** and **Angular CLI** for the frontend.  
- **Java** (JDK 8 or above) and **Maven** for the backend.  
- **MySQL** for the database.

---

## Features

1. **User Authentication**:  
   - Users can register and log in securely.  

2. **Question and Answer Management**:  
   - Users can create questions and provide answers.  
   - Users can delete questions and answers they created.  

3. **Profile Management**:  
   - Users can view their own profile and other users' profiles.  
   - Profiles display user details, all questions created by the user, and answers given by the user.  

4. **Search Functionality**:  
   - Users can search for questions based on keywords.  

5. **Topic Section**:  
   - Users can view questions categorized by topics.  
   - Topics are dynamically sorted based on the number of questions under each topic.  
   - Clicking on a topic displays all questions related to it.  

6. **Home Page**:  
   - The latest questions are displayed at the top, ensuring users can easily view the most recent activity.  

---

## Setup Instructions

1. **Download the project** and unzip it.  
2. Inside the project folder, you'll find two subfolders:  
   - **frontend**: Contains the Angular code.  
   - **backend**: Contains the Spring Boot code.  

---

### Setting Up the Frontend  
1. Open the `frontend` folder.  
2. Install the required dependencies by running `npm install` in your terminal.  
3. Start the Angular development server by running `ng serve`.  
4. The frontend will be available at `http://localhost:4200`.

---

### Setting Up the Backend  
1. Open the `backend` folder.  
2. Update the database credentials in the `application.yml` file (located in `src/main/resources/`) with your MySQL details:  
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/<your_database_name>
       username: <your_username>
       password: <your_password>
3. Reload Maven dependencies to ensure everything is set up correctly.
4. Run the Spring Boot application using Maven (mvn spring-boot:run).
5. The backend will be available at http://localhost:8080.

Usage
Once both the frontend and backend are running:
1. Open your browser and navigate to http://localhost:4200 to access the frontend.
2. The frontend will communicate with the backend to perform operations.
