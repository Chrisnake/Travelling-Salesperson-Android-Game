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
    static int initialScore; //ADD THE SCORE USER GOT TO THIS VARIABLE
    static int optimalScore = 100; //Get the optimalscore from the database
    static int bronzeScore = 20; //Complete level
    static int silverScore = 40; //Within 40% of the optimal score
    static int goldScore = 60; //Within 60% of the optimal score
    static int platniumScore = 80; //Within 80% of the optimal score
    static int diamondScore = 100; // Exactly the same as the optimal score

    public static void main(String[] args)
    {

        System.out.println("BRONZE = " + completedLevel());
        initialScore = 40 ;
        System.out.println("SILVER = " + calculateUsersScore());
        initialScore = 60 ;
        System.out.println("GOLD = " + calculateUsersScore());
        initialScore = 80 ;
        System.out.println("PLAT = " + calculateUsersScore());
        initialScore = 100 ;
        System.out.println("DIAMOND = " + calculateUsersScore());
    }

    public static double calculateUsersScore()
    {
        System.out.print(initialScore + " ");
        int usersReward = 0;
        //LINE BELOW RETURNING 0 FOR ALL RESULTS EXCEPT 100, WORKOUT WHY AND FIX
        int accuracyScore = Efficiency(initialScore,optimalScore);
        System.out.print(accuracyScore + " ");
        if(accuracyScore == 1)
        {
            usersReward = diamondScore;
        }
        else if (80 <= accuracyScore && accuracyScore < 100)
        {
            usersReward = platniumScore;
        }
        else if (60 <= accuracyScore && accuracyScore < 80)
        {
            usersReward = goldScore;
        }
        else if (40 <= accuracyScore && accuracyScore < 60)
        {
            usersReward = silverScore;
        }
        return usersReward;
    }

    public static int Efficiency(int Score, int optimalScore)
    {
        int efficiency = ((Score/optimalScore) * 100);
        return efficiency;
    }

    public static int retrieveUsersScore()
    {

        //Method sed to retrieve the score user achieved
        // ADD COMMAND TO RETRIEVE THE RESULT
        //initialScore  = ;

        return initialScore;
    }

    public static int retrieveOptimalAnswer()
    {
        /*
         * int retrieveScore = ; ADD COMMAND HERE TO RETRIEVE OPTIMAL SCORE
         * CHANGE THE RETURN STATEMENT TO RETURN ABOVE VARIABLE
         */
        return optimalScore;
    }

    public static int completedLevel()
    {
        /*
         * FIRST USE THIS TO CHECK IF USER COMPLETED THE LEVEL SUCCESFULLY TO AWARD BRONZE
         * MAYBE USING AN IF STATEMENT?
         */
        initialScore = bronzeScore;
        return initialScore;
    }
} //End of class
