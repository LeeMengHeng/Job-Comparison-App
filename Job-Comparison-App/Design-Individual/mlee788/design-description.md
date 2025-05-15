1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet[1]). 


Description: To allow this, I have added a core class called “Main Compare App”, in which every other class circles around this core class. Inside the “Main Compare App” I have included each of the actions as methods. All of the methods indicate the possible action that can be taken by the user.
  
2. When choosing to enter current job details, a user will:
   1. Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consists of:
      1. Title
      2. Company
      3. Location (entered as city and state)
      4. Cost of living in the location (expressed as an index)
      5. Yearly salary 
      6. Yearly bonus 
      7. Gym Membership
      8. Leave time (in days)
      9. 401K Match (0-20 inclusive, expressed as a whole percent)
      10. Pet Insurance ($0 to $5,000 inclusive annually)
   2. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.


3. When choosing to enter job offers, a user will:
   1. Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.
   2. Be able to either save the job offer details or cancel.
   3. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).


Description: To satisfy both requirements 2 and 3, I created a class called “Job” and connected it with two subclasses called “Current Job” and “Job Offer”. Both of the subclass are considered as an inheritance of the general “Job” class. Moreover, I consider class “Job” to have a composition relationship to the “Main Compare App”, since, from my standpoint, the core class is closely tied to the “Job” class. In other words, when app instances are created, “Job” gets created too, and when the core class is destroyed, it will also get destroyed. The methods on “Job” allow the user to save the details and cancel it. 
   
4. When adjusting the comparison settings, the user can assign integer weights to:
   1. Yearly salary
   2. Yearly bonus
   3. Gym Membership
   4. Leave time
   5. 401K Match
   6. Pet Insurance
If no weights are assigned, all factors are considered equal.


Description: This is where I created a class named “Settings”, where when the user chooses to set up the weights of the application, it guides the user to this class. This class has an association relationship with the “Main Compare App” simply because the core class uses this class to save all the weights.
  
5. When choosing to compare job offers, a user will:
   1. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
   2. Select two jobs to compare and trigger the comparison.
   3. Be shown a table comparing the two jobs, displaying, for each job:
      1. Title
      2. Company
      3. Location 
      4. Yearly salary adjusted for cost of living
      5. Yearly bonus adjusted for cost of living
      6. Gym Membership
      7. Leave time
      8. 401K 
      9. Pet Insurance
   4. Be offered to perform another comparison or go back to the main menu.


Description: To realize this requirement, I added a “Rank” class where is computes the ranks of the saved current jobs and offers jobs. It does not require any attributes since It is only used to compute and return the rank list and pass it back to the main class. 
 
6. When ranking jobs, a job’s score is computed as the weighted average of:

AYS + AYB + GYM + (LT * AYS / 260) + (AYS * 401K / 100 ) + PET

where:
AYS = yearly salary adjusted for cost of living
AYB = yearly bonus adjusted for cost of living
GYM = Gym Membership Allowance ($0 to $500 annually)
LT = leave time
401K = % 401K Match 
PET = Pet Insurance 


For example, if the weights are 2 for the yearly salary, 2 for the yearly bonus, 2 for Pet Insurance, and 1 for all other factors, the score would be computed as:

2/9 * AYS + 2/9 * AYB + 1/9 * GYM + 1/9 * (LT * AYS / 260) + 1/9 * (AYS * 401K / 100) + 2/9 * PET


Description: The rank system was added as a method inside the “Rank” class since it is a part of the ranking class. 




________________
