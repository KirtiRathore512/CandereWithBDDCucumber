@ui @Candere

Feature: Candere by Kalyan Jewellers is the most trusted online jewellery store.
@Requirement1
Scenario: User is able to open the Application and validate the title of landing page
Given User Navigate to the Landing page of an Application
Then User validate the title of Landing page

@Requirement2
Scenario: User is able to open the Application and search the product 
Given User Navigate to the Landing page of an Application
When User search for the product in searchBox that is "majestic solitaire diamond ring"
Then search result is Displyaed

@Requirement3
Scenario: User is able to open the Application after that click on search product,and select the size of ring
Given User Navigate to the Landing page of an Application
When User search for the product in searchBox that is "majestic solitaire diamond ring"
Then User click on the product 
And User validate the search product Title
Then User select the size of ring throgh drop down icon
And notificaton is Displayed with some Text

@Requirement4
Scenario: User is able to open the Application 
Given User Navigate to the Landing page of an Application
And user scroldown to the botton of the landing page of the application
Then under these Footer user validate the About Us section following options are available
							|  About Our Company  |
							| Terms and Conditions|
							|  Privacy Policy     |
							|	FAQ									|
							| Offers T&Cs					|
							|Customer Reviews			|
			
@IconsHadle
Scenario Outline: User is able to open the Application and Validate the redirection for social media handles
Given User Navigate to the Landing page of an Application	
And user scroldown to the botton of the landing page of the application
Then Validate the Follow Us section with social media handles for Facebook, Instagram and Twitter.
When First click on Social Media Handle Icon"<Social Media Name>",URL Contain and validate Media Text

    Examples: 
      | Social Media Name| URL Contain      |
      | Facebook         | canderejewellery |
      | Instagram        | canderejewellery |
      | Twitter          | canderebyKalyan  |


				