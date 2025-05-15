package edu.gatech.seclass.jobcompare6300;

import junit.framework.TestCase;
import edu.gatech.seclass.jobcompare6300.MainActivity;

public class MainActivityTest extends TestCase {

    Job joba;
    Job jobb;

    ComparisonSettings comparisonSettings;

    double jobScore1 = 21980.76923624674;
    double jobScore2 = 20832.051289876297;

    double jobScore3 = 36226.92308349609;

    double jobScore4 = 34768.46154785156;

    public void testScoreJob() {
        this.comparisonSettings = new ComparisonSettings(1,1,1,1,1,1);
        this.joba = new Job("test job 1", "rayCo", "Boston", 181, 100000, 25000, 500, 14, 5, 1000);
        assertEquals(jobScore1, MainActivity.scoreJob(this.joba, this.comparisonSettings));
    }

    public void testScoreJob2() {
        this.comparisonSettings = new ComparisonSettings(1,1,1,1,1,1);
        this.jobb = new Job("test job 2", "rayCo", "Boston", 181, 100000, 15000, 300, 20, 7, 2000);
        assertEquals(jobScore2, MainActivity.scoreJob(this.jobb, this.comparisonSettings));
    }

    public void testScoreJob3() {
        this.comparisonSettings = new ComparisonSettings(3,2,1,1,2,1);
        this.jobb = new Job("test job 3", "rayCo", "Boston", 181, 100000, 25000, 500, 14, 5, 1000);
        assertEquals(jobScore3, MainActivity.scoreJob(this.jobb, this.comparisonSettings));
    }

    public void testScoreJob4() {
        this.comparisonSettings = new ComparisonSettings(3,2,1,1,2,1);
        this.jobb = new Job("test job 4", "rayCo", "Boston", 181, 100000, 15000, 300, 20, 7, 2000);
        assertEquals(jobScore4, MainActivity.scoreJob(this.jobb, this.comparisonSettings));
    }

}