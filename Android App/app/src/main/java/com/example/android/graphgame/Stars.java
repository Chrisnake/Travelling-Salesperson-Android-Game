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
    int usersScore;
    int bronzeScore;
    int ilverScore;
    int goldScore;
    int platinumScore;
    int diamondScore;

    public static int scoreSystem (int userScore)
    {

        return userScore;
    }

    public static int retrieveOptimumScore()
    {
        int optimalScore = 0;
        /*
        This method will be used to retrieve the score for each level from the database
         */
        return optimalScore;
    }

    public static int compareUserScore(int userScore, int optimalScore)
    {
        int reward = 0;
        return reward;
    }
} //End of class
