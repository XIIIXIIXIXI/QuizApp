# QuizApp Introduction
We all know the classic TV shows like “Who wants to be a millionaire” or have tried playing games like “Trivial Pursuit”. This app is a so-called trivia app that aims to practice your knowledge in different areas.
There are a total of 17 categories in which you can decide how many questions you want to answer. 

# Technologies used:
* Jetpack Compose.
* Model-View-ViewModel(MVVM).
* Retrofit: Retrofit is used to make network requests to the database API and fetch data in JSON format.
* Dependency Injection: Dagger-Hilt is used for dependency injection, enabling the injection of dependencies, such as the repository, into classes.
* Gestalt Principles: The UX design of the app takes into consideration the Gestalt Principles of perception, which are principles that describe how himans perceive and organize visual elements.
* Saved State Handle: Oass and retain important data between different screens and view models during configuartion changes.
* Coroutine: Used to perform asynchronous operation, when making network requests and updating the UI.
* Compose Destinations: A custom navigation library used for navigation between differen screens and passing arguments between them.
  
# Features
* Select from multiple categories
* In case of a wrong answer, the user must be able to see the correct answer.
* Sufficient variety of questions (over 2000).
* Selection of difficulty ranging from easy to hard.
* Choose number of questions (max 50).
* View history of correct/incorrect answers during session.

# App flow system sequence diagram
The activity diagram seen below, shopws the simple flow of the application.
![image](https://github.com/martinkoch1/QuizApp/assets/71707790/4823cdf2-3ae7-43cc-9041-f955bc32f462)

* Category selection:
<img src="https://github.com/martinkoch1/QuizApp/assets/71707790/3a34c09c-01a1-45fb-a8f5-8287bf5c6c39" max-width="350" height="700">




* Difficulty and number of questions selection:

<img src="https://github.com/martinkoch1/QuizApp/assets/71707790/a8394873-908c-4088-b559-dd6042944686" width="350" height="700"> <img src="https://github.com/martinkoch1/QuizApp/assets/71707790/9331ce04-557e-4e8f-a51e-eb1c43b2bef8" width="350" height="700">

* Game screen
<img src="https://github.com/martinkoch1/QuizApp/assets/71707790/cbcc5c05-830b-4178-9927-afaedc612d91" width="350" height="700">
<img src="https://github.com/martinkoch1/QuizApp/assets/71707790/01fb7588-d1c9-410f-b333-ff9e2822c416" width="350" height="700">



 

