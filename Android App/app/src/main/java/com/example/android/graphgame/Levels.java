package com.example.android.graphgame;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class Levels
{
    private int weight;
    private int[][] levelsarray;
    private static int levelid;

    Levels(int lid)
    {
        levelid = lid;
    }

    public ArrayList<Edge> Readlevel() //This reads and inputs the 2D array that has been inputted into the instance. It then goes through the array and stores the edges connected and the weights they are connected at.
    {
        ArrayList<Edge> LevelEdges = new ArrayList<Edge>(); //Use the edges class to store the information on the edges of the level.
        for (int row = 0; row < levelsarray.length; row++)
        {
            for (int col = 0; col < levelsarray.length; col++)
            {
                weight = levelsarray[row][col]; //Find the weight of the edge that is connected in the matrix at position row, col.
                LevelEdges.add(new Edge(levelid, row, col, weight));
            }
        }

        return LevelEdges;
		/* EXAMPLE RETURN
		 * edges[0] = 0, 0, 0
		 * edges[1] = 0, 1, 4
		 * .....
		 * After it has stored the edges we now know that there is a connection at vertices 0 and 1 with weight 4.
		 */

        //method to get max x and max y(drawable area)
        //method call the code that populates arraylist of data
    }

    public static void readEdge()
    {
        try {
            Statement stmt;
            ResultSet rs; //Register the JDBC driver for MySQL

            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://172.31.82.94:3306/AppData";

            Connection con = DriverManager.getConnection( url,"root","my-secret-pw");
            Statement select = con.createStatement();

            // Execute a query

            rs = select.executeQuery("SELECT * FROM Edge;");

            while (rs.next())
            {
                // process results one row at a time
                String f1 = rs.getString(1);
                String f2 = rs.getString(2);
                String f3 = rs.getString(3);
                String f4 = rs.getString(4);
                Log.i(MainActivity.DEBUGTAG, "hey");
                Log.i("test","f1 + f2 + f3 + f4");
             }
        }
            catch (Exception e) {
                Log.i(MainActivity.DEBUGTAG,"e");
            }
        }
    }


