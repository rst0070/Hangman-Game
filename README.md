# Hangman-Game
This is <a href="https://en.wikipedia.org/wiki/Hangman_(game)">Hangman Game</a> made by java.  
## 1. Rules
1. The program reads words and show it as problem.
2. The problem is word that is hiding some letters.
3. Number of Hidden letters is under 30% of the word length.
4. If user fails over 5 times at an word, program changes the word as a new problem.
5. If user user solves over 10 problems or fails over 3 problems, the game is over.
By changing 'words.txt'file on root directory, you can change words that used as problem.  
However, 'words.txt'file must classify words line by line.  

## 2. Tab: Game board
At the Game board Tab, you can solve problems by input your answers,and program will show you whether your answer is correct or not.  

## 3. Tab: History board
This tab shows previous game scores and present game score by computing 'score.csv'file.  
If you want to clear history, remove the 'score.csv'file.