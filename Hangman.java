import java.util.*;
import java.util.Scanner;

class Hangman{
    public boolean chex(char a, char b)
    {
        if(a == b)
        return true;
        else
        return false;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        char[] answer = new char[str.length()+1];
        char[] guess = new char[str.length()+1];
        int size = answer.length;
        
        String chance5 = "|---|\n|\n|\n|\n|\n_____";
        String chance4 = "|---|\n|   O\n|\n|\n|\n_____";
        String chance3 = "|---|\n|   O/\n|  /|\n|\n|\n_____";
        String chance2 = "|---|\n|   O/\n|  /|\n|   |\n|\n_____";
        String chance1 = "|---|\n|   O/\n|  /|\n|   |\n|    x\n_____";
        String chance0 = "|---|\n|   O/\n|  /|\n|   |\n|  x x\n_____";
        for(int i = 0; i < size-1; i++)
        {
            answer[i] = str.charAt(i);
        }
        for(int i = 0; i < size-1;i++)
        {
            guess[i] = '-';
        }
        
        int chance = 5;
        int right = 0;
        
        while(chance > 0 && right < size-1)
        {
            Scanner xd = new Scanner(System.in);
            System.out.print("\nEnter a guess: ");
            char gues = xd.next().charAt(0);
            boolean hehe = false;
            for(int i = 0; i < size; i++)
            {
                if(gues == answer[i])
                {
                    guess[i] = gues;
                    right++;
                    hehe = true;
                }
            }
            if(hehe)
            {
                 System.out.println("You Guessed Right!");
            }
            else
            {
                System.out.println("Wrong Guess!");
                chance--;
            }
            if(chance == 5)
                System.out.println(chance5);
            if(chance == 4)
                System.out.println(chance4);
            if(chance == 3)
                System.out.println(chance3);
            if(chance == 2)
                System.out.println(chance2);
            if(chance == 1)
                System.out.println(chance1);
            System.out.println("You have "+chance+" chances remaining");
            for(int z = 0; z < size; z++)
            {
                System.out.print(guess[z]);
            }
            System.out.println("\n\n******************************\n");
        }
        if(chance == 0)
        {
            System.out.println("\nYou Lose!");
            System.out.println(chance0);
        }
        if(right == size-1)
            System.out.println("\nYou Win!");
    }
}