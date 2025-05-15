# Test Plan V2

**Author**: \<6300Fall23Team144\>

## 1 Testing Strategy

### 1.1 Overall strategy
Testing will include Unit tests where applicable, automated espresso testing for integration testing, and manual testing for final verification.

#### 1.1.1 Unit Testing
Unit test will be used to validate input constraints and validate algorithm correctness.

#### 1.1.2 Integration Testing
Integration testing will consist of espresso testing to ensure interface --> class interactions are correct.

#### 1.1.3 Acceptance Testing
Acceptance testing will consist of manual testing to ensure all application functional and behaviorial requirements are met.

#### 1.1.4 Regression Testing
Regression testing will be performed by re-running all unit tests, integration tests, and manual tests after each iteration of the application is ready for deployment.

### 1.2 Test Selection
White-Box testing will be accomplished via unit tests and some testing involving data persistence.
Black-box testing will be requirements based and performed at the system level used for validation of the applications performance.

### 1.3 Adequacy Criterion

#### 1.3.1 Test Case Tracking and Coverage
Test cases will be tracked back to requirements and verified via a tracability matrix that will express the tracking info via source code comments in unit tests, and via the testing procedure for the manual tests.
Coverage will be validated via the same tracability matrix to ensure all the application requirmeents are met and tested.

### 1.4 Bug Tracking
Due to the small size of our application bugs and enhancements will be tracked via spreadsheet.

### 1.5 Technology

#### 1.5.1 Unit Testing
Unit testing will be performed using JUnit and run in Android Studio.

#### 1.5.2 System Testing
System testing will be performed by running the application in emulators in the Android Studio environment and on physical target devices.

#### 1.5.3 System Testing
System testing will be performed by running the application in emulators in the Android Studio environment and on physical target devices.

#### 1.5.4 Regression Testing
Regression testing will be performed using JUnit for unit tests and using emulators in the Android Studio environment and on physical target devices.

## 2 Test Cases


### 2.1 Additional Test Information
<table border=0 cellpadding=0 cellspacing=0 width=849 style='border-collapse:
 collapse;table-layout:fixed;width:637pt'>
 <col width=64 style='width:48pt'>
 <col width=167 style='mso-width-source:userset;mso-width-alt:5818;width:125pt'>
 <col width=172 style='mso-width-source:userset;mso-width-alt:6004;width:129pt'>
 <col width=132 style='mso-width-source:userset;mso-width-alt:4608;width:99pt'>
 <col width=151 style='mso-width-source:userset;mso-width-alt:5282;width:114pt'>
 <col width=99 style='mso-width-source:userset;mso-width-alt:3444;width:74pt'>
 <col width=64 style='width:48pt'>
 <tr height=19 style='height:14.5pt'>
  <td height=19 width=64 style='height:14.5pt;width:48pt'>Id</td>
  <td width=167 style='width:125pt'>Case Name</td>
  <td width=172 style='width:129pt'>Purpose</td>
  <td width=132 style='width:99pt'>Realization</td>
  <td width=151 style='width:114pt'>Expected<span
  style='mso-spacerun:yes'> </span></td>
  <td width=99 style='width:74pt'>Actual</td>
  <td width=64 style='width:48pt'>Pass/Fail</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>1</td>
  <td>Title is empty</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>2</td>
  <td>Company is empty</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>3</td>
  <td>Location is empty</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>4</td>
  <td>COL is negative</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>5</td>
  <td>Salary is negative</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>6</td>
  <td>Bonus is Negative</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>7</td>
  <td>Gym is negative</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>8</td>
  <td>Leave time is negative</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>9</td>
  <td>401kis negative</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>10</td>
  <td>401k greater than 20</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>11</td>
  <td>Pet Ins is negative</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>12</td>
  <td>Pet ins is greater than 5000</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>13</td>
  <td>Salary weight is negative</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>14</td>
  <td>Bonus weight is negative</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>15</td>
  <td>Gym weight is negative</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>16</td>
  <td>Leave weight is negative</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>17</td>
  <td>401k weight is negative</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>18</td>
  <td>Pet weight is negative</td>
  <td>InputValidation</td>
  <td>UnitTest</td>
  <td>Exception</td>
  <td>Exception</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>19</td>
  <td>score job</td>
  <td>Algorithm Validation</td>
  <td>UnitTest</td>
  <td>See criteria 1</td>
  <td align=right>21980.76924</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>20</td>
  <td>score job</td>
  <td>Algorithm Validation</td>
  <td>UnitTest</td>
  <td>See criteria 1</td>
  <td align=right>20832.05129</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>21</td>
  <td>score job</td>
  <td>Algorithm Validation</td>
  <td>UnitTest</td>
  <td>See criteria 2</td>
  <td align=right>36226.92308</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>22</td>
  <td>score job</td>
  <td>Algorithm Validation</td>
  <td>UnitTest</td>
  <td>See criteria 2</td>
  <td align=right>34768.46155</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>23</td>
  <td>add and save current</td>
  <td>Functional Validation</td>
  <td>Manual Testing</td>
  <td>Job saved</td>
  <td>Saved</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>24</td>
  <td>add and cancel current</td>
  <td>Functional Validation</td>
  <td>Manual Testing</td>
  <td>Job not saved</td>
  <td>Not Saved</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>25</td>
  <td>add and save job offer</td>
  <td>Functional Validation</td>
  <td>Manual Testing</td>
  <td>job added to offers</td>
  <td>Saved</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>26</td>
  <td>add and cancel job offer</td>
  <td>Functional Validation</td>
  <td>Manual Testing</td>
  <td>job not saved to offers</td>
  <td>not saved</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>27</td>
  <td>add second offer</td>
  <td>Functional Validation</td>
  <td>Manual Testing</td>
  <td>job added to offers</td>
  <td>Saved</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>28</td>
  <td>compare offers</td>
  <td>Functional Validation</td>
  <td>Manual Testing</td>
  <td>show offer comparisons</td>
  <td>Compared</td>
  <td>Pass</td>
 </tr>
 <tr height=19 style='height:14.5pt'>
  <td height=19 align=right style='height:14.5pt'>29</td>
  <td>compare to current</td>
  <td>Functional Validation</td>
  <td>Manual Testing</td>
  <td>show comparison</td>
  <td>Compared</td>
  <td>Pass</td>
 </tr>
</table>

#### 2.1.1 Criteria 1
given the following data:

joba = {
	AYS: 100000,
	AYB: 25000,
	GYM: 500,
	LT: 14,
	F01K: 5,
	PET: 1000	
}

jobb = {
	AYS: 100000,
	AYB: 15000,
	GYM: 300,
	LT: 20,
	F01K: 7,
	PET: 2000	
}

and the following weights:

YSW = 1;
YBW = 1;
GYW = 1;
LTW = 1;
F01W = 1;
PIW = 1;

Job scoring should be: 
Joba = 21980.76923624674
Jobb = 20832.051289876297

#### 2.1.2 Criteria 2

given the following data:

joba = {
	AYS: 100000,
	AYB: 25000,
	GYM: 500,
	LT: 14,
	F01K: 5,
	PET: 1000	
}

jobb = {
	AYS: 100000,
	AYB: 15000,
	GYM: 300,
	LT: 20,
	F01K: 7,
	PET: 2000	
}

with the following weights:

YSW = 3;
YBW = 2;
GYW = 1;
LTW = 1;
F01W = 2;
PIW = 1;

Job scoring should be: 
Joba = 36226.92308349609
Jobb = 34768.46154785156

#### 2.1.3 Preconditions for 
Current Job has no data
No othe job offers have been entered

#### 2.1.4 Preconditions for 
Current Job has data
At least one job offer has data

### 3 Current Buglist Fixes Needed
No Current Issues Noted