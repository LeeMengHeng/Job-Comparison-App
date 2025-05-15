# Design Description
## Requirements
1. >When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).  

**To realize this requirement, I added a Job class, and two classes that inherit the Job class: the JobOffer class and CurrentJob class. The JobOffer class has an AddJobOffer() method that satisfies the requirement to enter job offers. The CurrentJob class has two methods: AddCurrentJob() and EditCurrentJob() to satisfy the first requirement. A class called ComparisonSetting allows the user to set weights for the Job attributes they prioritize over others and is stored as an attribute of the User class. The Job class has a CompareJobs() method to satisfy the fourth requirement.**

2. >When choosing to enter current job details, a user will:
    a. Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of:
        i. Title
        ii. Company
        iii. Location (entered as city and state)
        iv. Cost of living in the location (expressed as an index)
        v. Yearly salary 
        vi. Yearly bonus 
        vii. Gym Membership
        viii. Leave time (in days)
        ix. 401K Match (0-20 inclusive, expressed as a whole percent)
        x. Pet Insurance ($0 to $5,000 inclusive annually)
    b. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

**This requirement is satisfied through the attributes of the parent Job class's attributes: title, company, location, costOfLiving, annualSalary, annualBonus, gymMembership, leaveTime, 401kMatch, and petInsurance**

3. >When choosing to enter job offers, a user will:
    a. Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.
    b. Be able to either save the job offer details or cancel.
    c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

**This requirement contains UI elements that are only realized in my UML diagram through the following: the AddJobOffer() method on the JobOffer class, ability to compare jobs through the CompareJobs() method on the Job class.**

4. >When adjusting the comparison settings, the user can assign integer weights to:
    a. Yearly salary
    b. Yearly bonus
    c. Gym Membership
    d. Leave time
    e. 401K Match
    f. Pet Insurance
If no weights are assigned, all factors are considered equal.

**The ComparisonSetting class allows the user to assign the weights for the each category above. The class contains the following attributes corresponding to the requirement: annualSalaryWeight, annualBonusWeight, gymMembershipWeight, leaveTimeWeight, 401kMatchWeight, petInsuranceWeight. The weights have default value of 1 to satisfy the equal consideration requirement if no weights are assigned by the user.**

5. >When choosing to compare job offers, a user will:
    a. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
    b. Select two jobs to compare and trigger the comparison.
    c. Be shown a table comparing the two jobs, displaying, for each job:
        i. Title
        ii. Company
        iii. Location 
        iv. Yearly salary adjusted for cost of living
        v. Yearly bonus adjusted for cost of living
        vi. Gym Membership
        vii. Leave time
        viii. 401K 
        ix. Pet Insurance
    d. Be offered to perform another comparison or go back to the main menu.

**This requirement contains UI elements not captured by the UML diagram for displaying an ordered list. However, the requirement is made possible through a list of Job offers stored as an attribute on the User class, jobOfferIds. Each JobOffer has a jobScore associated with it and can be sorted from best to worst using this criteria. Part b is satisfied through the method, CompareJobs(). The user can be shown the attributes listed through the attributes of the Job class.**

6. >When ranking jobs, a job’s score is computed as the weighted average of:
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

**The jobScore attribute on the Job class is calculated using the above formula by using the user-entered values in the ComparisonSetting class.**

7. >The user interface must be intuitive and responsive.
For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

**This is a UI requirement and not shown in my design, but the UML diagram does imply a single system running the app as there are no external systems represented in the diagram.**