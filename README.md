# Recipe-mendix
Dear all,

This repository contains the backend of the recipe App that I created for the technical Mendix Assignment.
You can start the app using maven. Navigate to the folder with pom.xml and execute "mvn spring-boot:run".
I invited you to my Mendix project. The application will run on port 8081 after pressing the "run locally" button.

I was able to implement the following requirements:

The Solution does:
1. Shows the recipes on the left of the home screen and show corresponding recipes on the right.
2. Load the supplied recipes in memory and allows the retrieval of the name, categories and directions (no ingredients)
3. The RecipemlRepository has methods available that allow searching the recipes in the backend, although they are not wired up 
   to the Rest End points.

The solution does not:
1. Let you filter recipes based on the category that you select.
2. Let you retrieve all available categories (Though the backend has part of the implementation for it)
3. Show the directions in a pop-up window after clicking it in Mendix.
4. Allow the creation of new recipes.
5. Contain JUnit tests to test the backend fucntionality.

I used a JAXB project to convert the xml files to java classes, and used the spring framework to create REST endpoints.
The apache server running spring is located on localhost:8080, while the accompanying mendix front-end is running on port 8081.

I spent more time on the assignment than I was supposed to, about 8 hours. Mainly because I did not use a java framework to 
create a backend service before.

I decided to decouple the recipeml domain class and its RecipemlResource which can be retrieved upon request. This helps to
the spring controller with the right data, without having to deal with the auto-generated Recipeml class.

I feel confident that I could have fully implemented the requirements if I had spent more time on the assignement.
It however was a while ago that I worked with java.

Looking forward to your feedback!

Tijmen Winjtes
