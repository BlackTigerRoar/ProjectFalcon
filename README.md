# Candidate Name: Shen-Yu Sun 
## Falcon - Takes Bird to Fly Higher and Further!
This is a comprehensive Automation Framework called "Project Falcon" that I built it from the gorund up.
It is very scalable, followed DRY principle, and ready to expand! It can supports one phone, or multiple phones at the same time. It will detect the devices that's connected to the system by adb command. The test is easy to ready, and it's very simple to control the UI object by code. I would love to continue to work on this project.

## The tools that I used:
- Development Environemnt: macOS. IDE: IntelliJ
- Phone Tested: Samsung note 8
- Android Version: 8.0.0 Oreo
- The language that I used: JAVA - Since I am going to build automation for Android, may as well use Java (version 8).
- Appium - It supports Android, and iOS, and it works like Selenium which I am familiar with. 
- Junit - For test case purpose - Organized the test cases into different classes. ( Need to build xml report in the future. )
- log4j - Record the logs.
- Tessdata - Optical Character Recognition

## Framework Layout
Packages/Classes: 
- FalconCore: This holds the core methods. The low-level methods that we need for framework to function.
- FalconCore.captains: Classes that are going to be making some major decisions. (Time stampe, Test Rules, Start framework server, etc)
- FalconCore.constants: To holds all the constants. //todo
- FalconAPI: This holds all the APIs that Falcon has for different Phones (Android, iPhone(//todo)), and Apps.
- FalconAPI.apps.bird: This package holds classes contains APIs for initial bird screen, rental agreement screen, rider screen, etc.
- Interface: Acitivity, Application. Those two interface give standard app methods.
- ADB class is implemented for controling device purpose.
- UiObject, and UiSelector classes are simply UI selector and follow DRY priciple.
- FalconRunner - Main - it kicks off junit core.
- Funtionality, Navigation, TestController - classes for test cases.

## Bugs that I found while testing
Issue 1: If email contains "@" sign, then invalid toast message will not show up.
- Bird version: 4.7.2.2
- Reproduce Steps: 
  1. Open Bird
  2. Click "ENTER EMAIL"
  3. Type something like: 123@ - no invalid email toast message.
  4. Get rid of "@" - invalid email toast message show up.
 - Priority: low. no funtional impact.
 - Suggestion fix: Dev team to implement rule for valindation.
 
Issue 2: Rental Agreement back arrow button is not work. User stuck there until they check two agreement check box, and click 'I agree'.
- Bird version: 4.7.2.2
- Reproduce Steps:
   1. Open Bird
   2. Click "ENTER EMAIL"
   3. Enter an valid email, and then click "RIDE"
   4. Click "ALLOW" on "Allow Bird to access this device's location?"
   5. At the Rental Agreement page. Hit Back arrow button on the top left. It would not take you back.
   6. Kill the app. Re-launch it. It directly takes you to agreement page. 
- Priority: low. no funtional impact, but may creates bad user interface feeling to the customers.
- Suggestion fix: Make sure the back button takes the user back to the initial screen.

--------------------

# Bird Engineering: Automation Exercise

Thank you for your continued interest in Bird!

This at-home infrastructure challenge is an opportunity for you to let your infra-fu shine through, and show us your creative solution to a couple of exercises using commonly used infrastructure management tools here at Bird.

We expect this challenge to you take about an hour or two, but we know you've got a busy schedule so we're giving you a week.

_**Please commit all code to this Github repo, and press the "Finish" button in the top-right corner in Py once you've completed the challenge to let us know you're done.**_


## Exercise: Automation framework for android devices

### Overview

You work on a team of QA engineers tasked with creating a mobile automation environment. You know from experience that this task is a big one therefore it needs some thought before implementing. The task will start out simple by setting up a minimalistic framework then completing a log in to Bird. 

You want to ensure that your team operates in a unified manner in terms of updating the code, readability and maintaining the supported functionalities, so the structure should allow for such. You are free to use any tools at your disposal in approaching the solution an meeting the objectives.

### Objective

- Create a minimalistic automation framework to log into Bird, that will emphasize on OOP. The framework should take into consideration the multiple resolutions android devices are built in, so preferably dimensions should not be used to interact. 

### Requirements:

1. The automation is to be ran on android devices (Emulation is allowed)
2. You must include the following checks:

  - App opens
  - Enter email and check validations
    - Close keyboard by using “Enter” key on virtual keyboard
    - No email
      - Error message validation
    - Correct email
      - Logs in
        - Interact with permissions > accept
        - Verify log in
        - Validate Birds on rider screen are available
3. Please specify the reasoning for the approach taken in organizing the framework 

### Bonus
_These are **not** requirements for successful completion of the exercise_.

Once the basic requirements have been met, feel free to embellish with the kinds of features that **you** would like to see added. For example:

- Add clean utility classes
- Improve the reliability of the test

You’re welcome to implement these examples or come up with your own. Think about the user experience around the process.
