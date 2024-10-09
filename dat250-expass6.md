# dat250-expass6.md

## Technical Problems Encountered

### 1. Adapting Code from Last Week
I encountered challenges when trying to adapt the code from last week's assignment to this week's requirements. Last week's code included additional features like user registration, which this week's task did not need. To simplify things, I decided to comment out the unused functions from last week, focusing only on the essential parts required for poll creation and voting.

### 2. Tracking Votes for Each Option
Another challenge I faced was how to track the number of votes for each option within each poll. Initially, I struggled to integrate the votes into the existing data structure. I ended up resolving this issue by adding a new instance inside the `VoteOption.java` class to store vote information, which helped in keeping track of votes properly.

### 3. Other Issues
- I had some trouble structuring the frontend so that it communicated effectively with the backend using `fetch()`. While working on it, I learned how to properly handle the `POST` and `GET` requests for poll creation and voting, eventually making the integration smooth.
- I also spent some time learning how to configure CORS on the Spring Boot backend to allow communication between the frontend and backend, which was necessary for local development.

## Code Link
You can find the code for experiments 1-2 in the following GitHub repository:  
[https://github.com/CarlaMiquelBlasco/Lab3_Frontend.git](https://github.com/CarlaMiquelBlasco/Lab3_Frontend.git)

## Pending Issues
While I was able to integrate the frontend and backend for poll creation and voting, there are still some features that could be implemented in the future:

### 1. User Authentication
Although user authentication was not explicitly required for this task, it would be an essential next step for a fully functional poll application. I decided to omit it to focus on understanding the frontend-backend integration, but in the future, I would implement authentication using Spring Security and JWT (JSON Web Tokens). The process would involve:
- Adding authentication filters to the Spring Boot backend.
- Protecting the poll creation and voting routes with user login tokens.
- Storing user session tokens on the frontend, which would be passed with each `fetch` request to the backend to authenticate the user.

### 2. Additional Features
Some additional features that could enhance the application:
- **Vote Result Display**: Adding real-time vote count and percentages for each option.
- **User Poll History**: Allow users to see polls they've created or voted in previously.
- **Poll Expiry**: Using the ValidUntil feature to automatically disable voting for polls after a set expiry date. 

## Steps Followed

### Step 1: Set up Node Project
I started by setting up the frontend project using the Vite bundler. To ensure the environment was ready, I verified the versions of Node.js and npm:

```bash
node -v
npm -v
```

### Step 2: Create UI Components
I built two components:

- *CreatePollComponent*: A form for creating new polls with multiple options.
- *VoteComponent*: A UI for users to vote on existing polls. 
These components were developed following Svelte's best practices for handling forms and events.

### Step 3: Set Up CORS on Backend
To allow cross-origin communication, I enabled CORS in the Spring Boot backend by adding the @CrossOrigin annotation to the controller classes. This made it possible to perform API calls from the frontend running on a different port.

### Step 4: Connect Frontend and Backend
Using fetch(), I connected the frontend to the backend API:

- *POST* requests were used for creating new polls and casting votes. 
- *GET* requests retrieved the list of polls and their details.

### Step 5: Build and Deploy
After the frontend was working as expected, I ran the build process:
```bash
npm run build
```
I then copied the output files to the Spring Boot application’s `/src/main/resources/static` folder for deployment.