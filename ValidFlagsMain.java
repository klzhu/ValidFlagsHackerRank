import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ValidFlagsMain {

    /*
     * This hacker rank challenge inputs the following:
     * n - num flags
     * m n - flag1s dimensions
     * 000 first rows colors
     * 111 second rows colors
     * 000 3rd rows colors
     * m n - flag 2s dimensions
     * ....
     * 
     * The goal is to ensure that for each flag, all colors in the same row are equal
     * and no adjacent rows have the same colors. Print YES if flag is valid, print NO otherwise
     */
    public static void main(String args[] ) throws Exception {
        BufferedInputStream buf = new BufferedInputStream(System.in);
        BufferedReader r = new BufferedReader(new InputStreamReader(buf, StandardCharsets.UTF_8));

        int t = Integer.parseInt(r.readLine()); //reads the first line, which is usually the num inputs
        while(t>0) {
            String[] dims = r.readLine().split(" ");
            
            int numRows = Integer.parseInt(dims[0]);
            int numCols = Integer.parseInt(dims[1]);
            char lastColor = ' ';
            boolean validFlag = true;
            
            //read in every row and validate the color
            while (numRows > 0)
            {
                char rowColors[] = r.readLine().toCharArray();
                boolean firstCol = true;
                int index = 0;
                
                while (index < numCols && validFlag)
                {
                    char currColor = rowColors[index];
                    
                    if (lastColor == ' ') //if first column and first row of a flag
                    {
                        lastColor = currColor;
                        firstCol = false;
                    }
                    else if (firstCol) //if first col but not first row of a flag, must not match previous color
                    {
                        if (currColor == lastColor)
                        {
                            validFlag = false;
                        }
                        else lastColor = currColor;
                        firstCol = false;
                    }
                    else //else if not first col, must match the previous color
                    {
                        if (currColor != lastColor)
                        {
                            validFlag = false;
                        }
                    }
                    
                    index++;
                    
                }
                
                numRows--;
            }
            
            if (validFlag) System.out.println("YES");
            else System.out.println("NO");
            
            t--;
        }
    }

}
