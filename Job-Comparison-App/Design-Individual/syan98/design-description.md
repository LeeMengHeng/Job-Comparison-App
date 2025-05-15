## 1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet1).

Answer: I've designed a MainMenu class as the foundational entry point for our application. This class encompasses four unique attributes (or objects) and four associated methods. Each user action or click triggers one of these methods, leading to the creation of the corresponding object. Simultaneously, the user interface navigates to a new page. The methods are set with public visibility to ensure accessibility, while the attributes are protected. This design choice is made anticipating the potential use of these objects in other classes.


## 2. When choosing to enter current job details, a user will:
- a. Be shown a user interface to enter (if it's their first time) or edit all the details of their current job.
- b. Have the option to either save the job details or cancel. In both scenarios, they will return to the main menu.

Answer: The CurrentJobDetails object within the MainMenu class originates from the CurrentJobDetails class. Within CurrentJobDetails, we have various attributes (e.g., Title, Company, etc.) and three distinct methods. Each of these methods aligns with the requirements outlined in bullet point "b".

The attributes mentioned in bullet point "a" pertain to job details, which could potentially be relevant in other classes as well. To prevent redundancy, I've established a JobDetails class to consolidate this information. The relationship between CurrentJobDetails and JobDetails is one of aggregation. They share a one-to-one relationship. It's worth noting that JobDetails can exist independently of CurrentJobDetails. For instance, an employee might have a job offer that utilizes the JobDetails class, even if they don't currently hold a position.

The relationship between 'CurrentJobDetails' and 'MainMenu' class is composition. Because CurrentJobDetails belongs to MainMenu. Without 'MainMenu' class, the 'CurrentJobDetails' will not exist.


## 3. When choosing to enter job offers, a user will:
- a. Be shown a user interface to enter all the details of the offer, which are the same
ones listed above for the current job.
- b. Be able to either save the job offer details or cancel.
- c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the
offer (if they saved it) with the current job details (if present).

Answer: In a manner similar to requirement 2, I'll establish another class named JobOffers. The relationship between the JobOffers and MainMenu classes is one of composition. This is because JobOffers is inherently tied to MainMenu; without the MainMenu class, JobOffers cannot exist.

To cater to each requirement bullet point, we'll incorporate corresponding methods and attributes within JobOffers. It's important to highlight that users might have multiple job offers. To represent this, we'll utilize an attribute named jobOfferList, which will be a list. Each item in this list will be a JobDetails object, as every offer will possess its unique set of job details. Additionally, we'll include the currentJobs attribute to facilitate comparisons between jobs in the future.

The methods will be directly in line with the provided descriptions, making their implementation quite straightforward.


## 4. When adjusting the comparison settings, the user has the ability to assign integer weights to the following:

- **a.** Yearly salary
- **b.** Yearly bonus
- **c.** Gym Membership
- **d.** Leave time
- **e.** 401K Match
- **f.** Pet Insurance

> **Note:** If no weights are assigned, all factors are considered equal.

Answer: Within the MainMenu class, invoking the adjustComparisonSettings method results in the creation of a ComparisonSettings object, derived from the ComparisonSettings class. The ComparisonSettings class contains various attributes that correspond to the bullet points from the provided description, all of which are of integer type. Given that these settings can be adjusted or left as they are, we've also incorporated an adjustSettings attribute. The relationship between ComparisonSettings and MainMenu remains consistent with our previous design: it's one of composition.

## 5. When choosing to compare job offers, a user will:
- a. Be shown a list of job offers, displayed as Title and Company, ranked from best
to worst (see below for details), and including the current job (if present), clearly
indicated.
- b. Select two jobs to compare and trigger the comparison.
- c. Be shown a table comparing the two jobs, displaying, for each job.(I will not list all below)
- d. Be offered to perform another comparison or go back to the main menu.

Answer: To complement the methods and objects within the MainMenu class, I've introduced the JobOfferComparer class. This class is primarily designed to rank and display job offers. To begin with, it features a jobOfferList attribute, which captures all the current job offers, including the currentJob. A method named rankJobs is then employed to rank these jobs and offers, resulting in a rankedOfferList.

For the purpose of job comparison, it's essential to juxtapose two jobs and exhibit their comparative details. This necessitates the compareAndDisplayJobs() method, which takes specific inputs. Given that the displayed details include adjustments for the cost of living in both the yearly salary and bonus, there's a need for the calculateAYSandAYB() method to handle these calculations.

Furthermore, the compareAndDisplayJobs() method can be invoked again for repeated job comparisons. Alternatively, users can opt for the returnToMainMenu() method to navigate back to the main page.

The relationship between JobOfferComparer with 'Mainmenu' is composition again because JobOfferComparer cannot exist without the class JobOfferComparer.

## 6. When ranking jobs, a job’s score is computed as the weighted average of below. (I will not list here).

Answer: The job score plays a pivotal role in determining the ranking of offers. Consequently, I've incorporated the calculateJobScore() method within the JobOfferComparer class. To achieve this, the method leverages the calculateAYSandAYB function. This particular requirement leans more towards a functional description, and I've ensured its implementation within the JobOfferComparer class.


## 7. The user interface must be intuitive and responsive.

Answer: This is not represented in my design, as it will be handled entirely
within the GUI implementation.


## 8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

Answer: This is not represented in my design.
