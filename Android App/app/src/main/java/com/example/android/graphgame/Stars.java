package com.example.android.graphgame;

/**
 * Created by christianvillegas on 19/01/2018.
 */

//TODO: Be able to find out the amount of stars that the user has earned
//TODO: Be able to change the total amount of stars if the user has earned more
/*
    Following star based system could be used,
    - Complete level = Bronze Medal
    - Complete level with 60 % accuracy = Silver
    - Complete level with 70 % accuracy = Gold
    - Complete level with 80 % accuracy = Platinum
    - Complete level with 90 % accuracy = Diamond
    5 STAR SYSTEM
    OR

    Another possible solution, a more advanced method
    Complete level = Bronze
    Workout how long the person has taken to complete level and compare this with a metadata containing,
    the average time to complete the level across all users = Silver
    Above the average time = Gold
    Even Higher than the average = Platinum
    Elite time = Diamond
 */
public class Stars
{

    static double initialScore = 40; //ADD THE SCORE USER GOT TO THIS VARIABLE
    static double optimalScore = 100; //Get the optimalscore from the database
    static int bronzeScore = 20; //Complete level
    static int silverScore = 40; //More than 40% correct
    static int goldScore = 60; //More than 60% correct
    static int platinumScore = 80; //More than 80% correct
    static int diamondScore = 100; // Exactly the same as the optimal score

    public Stars(int Level, double Score)
    {
        initialScore = Score ; // ENTER USES SCORE HERE

    }

    public static void main(String[] args)
    {
        System.out.println("YOU GOT = " + calculateUsersScore(initialScore));
    }

    public static double calculateUsersScore(double Score)
    {
        double usersReward;
        double accuracyScore = Efficiency(Score);
        if(accuracyScore == 100)
        {
            usersReward = diamondScore;
        }
        else if (80 <= accuracyScore && accuracyScore < 100)
        {
            usersReward = platinumScore;
        }
        else if (60 <= accuracyScore && accuracyScore < 80)
        {
            usersReward = goldScore;
        }
        else if (40 <= accuracyScore && accuracyScore < 60)
        {
            usersReward = silverScore;
        }
        else
        {
            usersReward = completedLevel();
        }
        return usersReward;
    }

    public static double Efficiency(double Score)
    {
        double efficiency = (Score/optimalScore) * 100 ;
        return efficiency;
    }

    public static double retrieveUsersScore()
    {

        //Method sed to retrieve the score user achieved
        // ADD COMMAND TO RETRIEVE THE RESULT
        //initialScore  = ;

        return initialScore;
    }

    public static double retrieveOptimalAnswer()
    {
        /*
         * int retrieveScore = ; ADD COMMAND HERE TO RETRIEVE OPTIMAL SCORE
         * CHANGE THE RETURN STATEMENT TO RETURN ABOVE VARIABLE
         */
        return optimalScore;
    }

    public static double completedLevel()
    {
        /*
         * FIRST USE THIS TO CHECK IF USER COMPLETED THE LEVEL SUCCESFULLY TO AWARD BRONZE
         * MAYBE USING AN IF STATEMENT?
         */
        initialScore = bronzeScore;
        return initialScore;
    }
} //End of class
