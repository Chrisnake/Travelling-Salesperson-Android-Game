package com.example.android.graphgame;

/**
 * Created by christianvillegas on 19/01/2018.
 */

//TODO: Be able to find out the amount of stars that the user has earned
//TODO: Be able to change the total amount of stars if the user has earned more
/*
    Following star based system could be used,
    - Complete level = 1 star
    - Complete level with at least 60% accuracy = 2 stars
    - Complete level with at least 85% accuracy = 3 stars
    3 STAR SYSTEM
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

    static double initialScore = 20; //ADD THE SCORE USER GOT TO THIS VARIABLE
    static double optimalScore ; //Get the optimalscore from the database//this class that calculates it
    static double star_1 = 1;
    static double star_2 = 2;
    static double star_3 = 3;
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
        if(accuracyScore >= 85) //85% or more then give 3 stars
        {
            usersReward = star_3;
        }
        else if (60 <= accuracyScore && accuracyScore < 85) //Less than 85 but greater than 60, give 2 stars
        {
            usersReward = star_2;
        }
        else //Give 1 star for completion
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
        optimalScore = ShortestPathCalculator.sum;
        return optimalScore;
    }

    public static double completedLevel()
    {
        /*
         * FIRST USE THIS TO CHECK IF USER COMPLETED THE LEVEL SUCCESFULLY TO AWARD BRONZE
         * MAYBE USING AN IF STATEMENT?
         */
        initialScore = star_1;
        return initialScore;
    }
} //End of class
