package edu.gatech.seclass.jobcompare6300;

import static org.junit.Assert.assertThrows;

import junit.framework.TestCase;

public class ComparisonSettingsTest extends TestCase {

    ComparisonSettings comparisonSettings = new ComparisonSettings(1,1,1,1,1,1);
    ;

    public void testSetYearlySalaryWeight() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            comparisonSettings.setYearlySalaryWeight(-2);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }

    public void testSetYearlyBonusWeight() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            comparisonSettings.setYearlyBonusWeight(-2);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }

    public void testSetGymMembershipWeight() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            comparisonSettings.setGymMembershipWeight(-2);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }

    public void testSetRetirementMatchWeight() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            comparisonSettings.setRetirementMatchWeight(-2);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }

    public void testSetLeaveTimeWeight() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            comparisonSettings.setLeaveTimeWeight(-2);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }

    public void testSetPetInsuranceWeight() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            comparisonSettings.setPetInsuranceWeight(-2);
        });

        assertTrue(exception.getMessage().contains("Range Error"));
    }
}