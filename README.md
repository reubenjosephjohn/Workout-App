# My Personal Project - Exercise Manager Application

## Project Details

#### *What will the application do?*
- This is a desktop application that will help its users to record and manage their fitness sessions.
It will make exercising easier for its users by giving them a platform to store their favorite exercises
and organize them into various categories with valuable information such as the number of sets,
reps, duration and calories burnt by performing the exercise.


#### *Who will use it?*
- This application can be used by fitness enthusiasts and all those who are looking
  to have a healthy lifestyle by exercising. It will help them to keep track of their exercise sessions
and it will motivate them to exercise regularly and remain fit.


#### *Why is this project of interest to me?*
- I chose this project because I love exercising and to live a healthy lifestyle.
Sometimes, I find it hard to organize and manage my fitness sessions,
and I believe this application will help those like me in managing their
routines. By doing this, it will help me to be motivated and stay on the right track
  to meet my fitness aspirations.


## **User Stories**
- As a user, I want to be able to select the sets, reps, duration, and calories burnt for each exercise.
- As a user, I want to be able to create an exercise session and
    add exercises to it.
- As a user, I want to be able to view a list of the exercise sessions that I have created.
- As a user, I want to be able to view all the details of the exercises in a selected session.

### **Phase 2**
- As a user, I want to be able to save my exercise sessions to file.
- As a user, I want to be able to load my exercise sessions from file.

### **Phase 4: Task 2**
Thu Mar 31 20:42:01 PDT 2022
Chest has been added to the List of Sessions.


Thu Mar 31 20:42:46 PDT 2022
Barbell Bench Press has been added to Chest.


Thu Mar 31 20:43:18 PDT 2022
Pushups has been added to Chest.


Thu Mar 31 20:43:43 PDT 2022
Chest fly has been added to Chest.


Thu Mar 31 20:43:54 PDT 2022
Back has been added to the List of Sessions.


Thu Mar 31 20:44:37 PDT 2022
Deadlift has been added to Back.


Thu Mar 31 20:45:27 PDT 2022
Pullups has been added to Back.


Thu Mar 31 20:45:53 PDT 2022
Inverted Row has been added to Back.



### **Phase 4: Task 3**

There are a few things I would like to refactor if I had more time.

1. I could improve cohesion in the ExerciseManagerApp class since it doesn't follow the Single Responsibility Principle where it made the JPanel as well as added elements to them as well. Instead I could improve cohesion by only letting the ExerciseManagerApp focus on adding elements to the panels instead of creating new JPanels, setting their formatting and adding elements.


2. Looking at my UML diagram, I would reduce coupling between LoadSession, ExerciseManagerApp and the functions. It is unnecessary for ExerciseManagerApp to be associated with each function and it can be refactored in a better way.


3. I think the reliance of LoadSession on ExerciseManagerApp can be reduced by using the fields of the abstract Function class.