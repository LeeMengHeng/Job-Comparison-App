package edu.gatech.seclass.jobcompare6300;

import static org.junit.Assert.assertThrows;

import junit.framework.TestCase;

public class JobTest extends TestCase {

    Job job = new Job("test job 1", "rayCo", "Boston", 181, 100000, 25000, 500, 14, 5, 1000);

    public void testSetTitleEmpty() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            job.setTitle("");
        });

        assertTrue(exception.getMessage().contains("Empty String"));
    }

    public void testSetCompanyEmpty() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            job.setCompany("");
        });

        assertTrue(exception.getMessage().contains("Empty String"));
    }

    public void testSetLocation() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            job.setLocation("");
        });

        assertTrue(exception.getMessage().contains("Empty String"));
    }

    public void testSetCostOfLivingNegative() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            job.setCostOfLiving(-5);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }

    public void testSetYearlySalary() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            job.setYearlySalary( (float)-1000.0);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }

    public void testSetYearlyBonus() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            job.setYearlyBonus( (float)-1000.0);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }

    public void testSetGymMembership() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            job.setGymMembership( (float)-1000.0);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }

    public void testSetLeaveTime() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            job.setLeaveTime(-5);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }

    public void testSetF01kMatchLow() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            job.setF01kMatch(-2);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }

    public void testSetF01kMatchHign() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            job.setF01kMatch(21);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }

    public void testSetPetInsuranceLow() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            job.setPetInsurance(-150);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }
    public void testSetPetInsuranceHigh() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            job.setPetInsurance(5001);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }

}