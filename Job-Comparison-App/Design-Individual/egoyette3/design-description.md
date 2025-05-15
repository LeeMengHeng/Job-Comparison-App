# Design Description for The George P. Burdell Job Comparison Application.

------------

## Overall design considerations

As a first step I tried to approach the requirements from a more abstract viewpoint. This analysis yielded that the application itself is fairly simple and small and will only requires a few classes to realize a complete design. I represent the relationship to "User Interface" components as a package with general relationship to the main application.  The entry point for the Application is the "Application" class and that is the focal point relationship to other classes/packages/etc in the application.  One choice that I did make was to utilyze the "Strategy" pattern for the containing of the algorithm. It seemed a logical choice as I could imagine that the formula used to may not be a single formula but a series of formulas. This allows simply keeping it at a single formula or the addition of multiple forumale for the calculation of a job score.

Much of the requirements for this application concern User Interface concerns and could be further realized in use case diagrams, sequence diagrams, etc.

------------

## Requirements and thier realization in the design

------------

#### 1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).  

These requirements will be realized by the user interface components of the application.

------------

#### 2. When choosing to enter current job details, a user will:

#### 2.1 Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of: Title, Company, Location (entered as city and state), Cost of living in the location (expressed as an index), Yearly salary , Yearly bonus, Gym Membership, Leave time (in days), 401K Match (0-20 inclusive, expressed as a whole percent), Pet Insurance ($0 to $5,000 inclusive annually)

This requirement will also be realized by the uesr interface components, which will utilyze the getter/setter methods on the job class to save the data. There will be a single instance of this class for the "current job" which will either have values or be empty. An isEmpty() method will allow for determination of wether data exists or not.

#### 2.2 Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

This will also be realized by user interface components. Wether or not to write data into the current instance (using setter methods) happening upon save or not happening on exit.

------------

#### 3. When choosing to enter job offers, a user will:

#### 3.1 Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.

This requirement is realized by user interface components. 

#### 3.2 Be able to either save the job offer details or cancel.

This requirement is realized by user interface components. 

#### 3.3 Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

This requirement is realized by user interface components. 

------------

#### 4. When adjusting the comparison settings, the user can assign integer weights to: Yearly salary, Yearly bonus, Gym Membership, Leave time, 401K Match, Pet Insurance. If no weights are assigned, all factors are considered equal.

This requirement is realized by user interface components. 

------------

#### 5. When choosing to compare job offers, a user will:

#### 5.1 Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.

This requirement is realized by user interface components. 

#### 5.2 Select two jobs to compare and trigger the comparison.

This requirement is realized by user interface components. 

#### 5.3 Be shown a table comparing the two jobs, displaying, for each job: Title, Company, Location, Yearly salary adjusted for cost of living, Yearly bonus adjusted for cost of living, Gym Membership, Leave time, 401K, Pet Insurance.

This requirement is realized by user interface components. 

#### 5.4 Be offered to perform another comparison or go back to the main menu.

This requirement is realized by user interface components. 

------------

#### 6. When ranking jobs, a job’s score is computed as the weighted average of:

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

This requirement will be realized in the "ScoreStrategy" Class and "DefaultScoring" Class as the "Strategy" pattern. Weights are entered via user interface and then a method called score() is called and returns a value based on this formula.

------------

#### 7. The user interface must be intuitive and responsive.

This is a non-functional requiremnt and is not realized in the design.

------------

#### 8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

This is realized by the systems overall design not having communication to databases, other servers, etc.