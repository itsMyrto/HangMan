//hangman game

#include <stdio.h>
#include <string.h>


int main()
{

    char word[50],foundword=0,letter,said[26],again,contain[50],c,flag;
    int tries=5,i,k=0;

    printf("Player 1 -> Enter a word:\n");
    fgets(word,50,stdin);
    word[strcspn(word,"\n")]='\0';

    printf("Player 2 , you have to guess the word,you have 5 wrong guesses.\n");

    for(i=0;i<strlen(word);i++)
    {
        contain[i]='_';
        printf("%c ",contain[i]);
    }

    printf("\n");

    while(tries>0)
    {
        printf("Enter a letter:\n");

        do
        {
            scanf("%c",&letter);
            while ((c = getchar()) != '\n' && c != EOF) { }
            again=0;

            for(i=0;i<k;i++)
            {
                if(said[i]==letter)
                {
                    again=1;
                    printf("You have already said this one,try again\n");
                }
            }

        }while(again==1);

        said[k]=letter;
        k++;

        flag=0;

        for(i=0;i<strlen(word);i++)
        {
            if(word[i]==letter)
            {
                contain[i]=letter;
                flag=1;
            }
        }

        if(flag==0)
        {
            tries--;
        }

        for(i=0;i<strlen(word);i++)
        {
            printf("%c ",contain[i]);
        }

        if(memcmp(word,contain,strlen(word))==0)
        {
            foundword=1;
            break;
        }

        printf("\n");

    }

    if(foundword==1)
    {
        printf("\nWell Done! ");
    }
    else
    {
        printf("\nBetter next time! ");
    }

    return 0;

}


