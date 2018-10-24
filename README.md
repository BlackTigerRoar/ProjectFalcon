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
