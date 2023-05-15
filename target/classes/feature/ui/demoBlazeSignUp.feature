Feature: DemoBlaze SignUp

  Scenario Outline: Verifying account sign up
    Given  user on the DemoBlaze application
    And    user clicks on sign up button
    When   user enters "<userName>"  and "<password>" and clicks sign up
    Then   user should see alert message "<message>"

    Examples:
      | userName    | password | message                                |
     # |             | test     | Please fill out Username and Password. |
      #| test        |          | Please fill out Username and Password. |
      #|             |          | Please fill out Username and Password. |
      #| test        | test     | This user already exist.               |
      | placeholder | test     | Sign up successful.                    |
