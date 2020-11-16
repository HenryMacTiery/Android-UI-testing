# Android Mockk With Espresso Introduction

We use a Fragment factory (Android X Fragment Factory) to provide some dependencies to the MovieDetail Fragment that its going to accepts through the constructor ("Constructor Injection").  

Typically, injection would be handled using Dagger but in this case we did not use it.  

The test classes are pretty similar and drive the point home with the added extra of handling of dependencies using the mockk library. 