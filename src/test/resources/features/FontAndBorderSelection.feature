Feature: User is able to select the font and border details on preference page



  Scenario: Collect font, border details
Given User at preference selection page
When User selects font details
| courier  | red |bold|
When User selects border details
| dashed | orange | dark|
Then Confirm user selections


