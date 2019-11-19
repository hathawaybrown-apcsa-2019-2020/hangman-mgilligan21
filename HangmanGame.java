/**
 * This class represents a game of hangman including the secret word, the 
 * the progress made in discovering the secret word, and the letters that 
 * have been guessed
 *
 * @author Maxine Gilligan
 * @version 2019-11-18
 */
public class HangmanGame
{
    private String secretWord;
    private String gameStatus;
    private String guessedLetters;
    
    /**
     * Constructor for objects of class HangmanGame
     * @param word           The secret word in lowercase letters
     */
    public HangmanGame(String word)
    {
        this.secretWord = word.toLowerCase();
        this.gameStatus = "";
        for (int n = 0; n < word.length(); n++)
        {
            if (Character.isLetter(secretWord.charAt(n)))
            {
                gameStatus += "-";
            }
            else
            {
                gameStatus += " ";
            }
        }
        this.guessedLetters = "";
    }
    
    /**
     * Returns the letters that have already been guessed
     * @return      letters that have already been guessed
     */
    public String getTried()
    {
        return guessedLetters;
    }
    
    /**
     * Returns the progress made in discovering the secret word
     * @return      the progress made in discovering the secret word
     */
    public String getGuessed()
    {
        return gameStatus;
    }
    
    /**
     * Tries a character. 
     * If the character is a letter, it is in the secret word, and it hasn't 
     * already been guessed, updates game status with the tried character in 
     * the correct location.
     * @param a     The tried characther
     * @return      The status of the character:
     *         2  = Character is not a letter
     *         0  = Character has already been tried
     *         -1 = Character is not in the secret word
     *         1  = Character is in the secret word
     */
    public int tryLetter(char a)
    {
        a = Character.toLowerCase(a);
        int b = guessedLetters.indexOf(a);
        int c = secretWord.indexOf(a);
        if (Character.isLetter(a) == false)
        {
            return 2;
            /**
             * Added the following  to class Hangman, in the main method's 
             * switch statement:
                     case 2:
                     System.out.println("Not a letter");
                     break;
             */
        }
        else if (b != -1)
        {
            return 0;
        }
        else
        {
            guessedLetters = (guessedLetters + a + " ");
            if (c == -1)
            {
                return -1;
            }
            else
            {
                for (int n = 0; n < secretWord.length(); n++)
                {
                    if (secretWord.charAt(n) == a)
                    {
                        gameStatus = (gameStatus.substring(0,n) + a + gameStatus.substring(n + 1));
                    }
                }
                return 1;
            }
        }
    }
}
