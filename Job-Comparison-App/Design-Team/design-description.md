# Design Description
## Requirements
1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet1).
- **Answer: This requirement is realized through the entry-point defined by the interface components package, and the Main Menu component within that package. The flow then goes to the Application object, allowing the user to edit and enter current job, add job offers, edit comparison settings, and compare job offers.**
2. When choosing to enter current job details, a user will:
    - Be shown a user interface to enter (if it's their first time) or edit all the details of their current job.
- **Answer: This requirement is realized through the Main Menu component within the interface components package. Although details are omitted since this design focuses on Classes, the user can still infer this from our design.**
    - Have the option to either save the job details or cancel. In both scenarios, they will return to the main menu.
- **Answer: This requirement contains UI elements that are only realized in our UML diagram through the following: the addJobOffer() method on the Job class. In addition, the attributes of the parent Job class's attributes: title, company, location, costOfLiving, yearlySalary, yearlyBonus, gymMembership, leaveTime, 401kMatch, and petInsurance help realize this requirement.**
3. When choosing to enter job offers, a user will:
    - Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.
    - Be able to either save the job offer details or cancel.
    - Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).
- **Answer: This requirement contains UI elements that are only realized in our UML diagram through the following: the addJobOffer() method on the Job class, ability to compare jobs through the compareJobs() method on the Job class.**
4. When adjusting the comparison settings, the user has the ability to assign integer weights to the following:
    - Yearly salary
    - Yearly bonus
    - Gym Membership
    - Leave time
    - 401K Match
    - Pet Insurance
    - Note: If no weights are assigned, all factors are considered equal.
- **Answer: This requirement is realized through both the ComparingSetting class and editComparisonSettings(...) method in the Application class. Users have the ability to call the method and edit the integer weights. If there are no inputs of the weights, we set all of the default weights to be 1.**
5. When choosing to compare job offers, a user will:
    - Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
    - Select two jobs to compare and trigger the comparison.
    - Be shown a table comparing the two jobs, displaying, for each job.(I will not list all below)
    - Be offered to perform another comparison or go back to the main menu.
- **Answer: In the 'Application' class, the showjobRankings() method will be invoked when the user selects "show job ranks" from the user interface (UI). This action will display a list of ranked job offers. Similarly, the comparejobs() method in the same class will be activated when the user chooses to compare two jobs via the UI. As for the display specifics, they fall under UI requirements, and detailed information will not be shown.**
6. When ranking jobs, a job’s score is computed as the weighted average of below. (I will not list here).
- **Answer: The jobScore attribute on the Job class is calculated using the formula by using the user-entered values in the ComparisonSettings class.**
7. The user interface must be intuitive and responsive. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).
- **Answer: This is a UI requirement and not shown in our design, but the UML diagram does imply a single system running the app as there are no external systems represented in the diagram.**