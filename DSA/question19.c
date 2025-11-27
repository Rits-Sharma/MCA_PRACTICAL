/*Q19: Write a C program that performs the following operations:
1.Asks the user how many student names they want to store.
2.Dynamically allocates an array of character pointers (one for each name).
3.For each student, dynamically allocates memory for their name using malloc or calloc.
4.Reads the names from the user.
5.Prints all the stored names.
6.Resizes the array using realloc to add 2 more students, then takes their names and prints the updated list.
*/

#include <stdio.h> //For input/output functions like printf, scanf, fgets.
#include <stdlib.h> //For dynamic memory functions like malloc, realloc, free.
#include <string.h>  //For string functions like strlen, strcpy, strcspn

int main(){
    int size, i;
// 1.Asks the user how many student names they want to store.
    printf("Enter the number of Students : ");
    scanf("%d", &size);
    getchar();  // get new line after scanf

    char **names;
    char buffer[100];
// 2.Dynamically allocates an array of character pointers (one for each name).
    // allocate array of char pointers
    names = (char **)malloc(size * sizeof(char *)); //Allocates space for n char pointers
    if (names == NULL) {  //Checks if allocation failed (e.g., due to low memory);
        printf("Memory allocation failed!\n");
        return 1;
    }

    // input names
    for (i = 0; i < size; i++) {
// 4.Reads the names from the user.
        printf("Enter name of student %d: ", i + 1);
        fgets(buffer, sizeof(buffer), stdin); //Reads a line of input (up to 99 chars + null terminator) into buffer
        buffer[strcspn(buffer, "\n")] = '\0'; // remove newline character from the input
// 3.For each student, dynamically allocates memory for their name using malloc or calloc.
        names[i] = (char *)malloc((strlen(buffer) + 1) * sizeof(char)); 
        //Allocates exactly enough memory for the name plus null terminator
        if (names[i] == NULL) {
            printf("Memory allocation failed!\n");
            return 1;
        }
        strcpy(names[i], buffer); //Copies the string from buffer to the newly allocated memory.
    }

// 5.Prints all the stored names.
    printf("\nStored Student Names:\n");
    for (i = 0; i < size; i++)
    {
        printf("%s\n", names[i]);
    }
    
// 6.Resizes the array using realloc to add 2 more students, then takes their names and prints the updated list.
    int new_size = size + 2;
    char **temp = (char **)realloc(names, new_size * sizeof(char *));
    if (names == NULL) {  //Checks if allocation failed (e.g., due to low memory);
        printf("Memory allocation failed!\n");
        return 1;
    }
   
    printf("\nAdding 2 more students...\n");
    for (i = size; i < new_size; i++) {
        printf("Enter name of student %d : ", i + 1);
        fgets(buffer, sizeof(buffer), stdin);
        buffer[strcspn(buffer, "\n")] = '\0'; // remove newline character from the input

        names[i] = (char *)malloc((strlen(buffer) + 1) * sizeof(char));
        if (names[i] == NULL) {
            printf("Memory allocation failed!\n");
            return 1;
        }
        strcpy(names[i], buffer);
    }

// 6. Prints updated stored names.
    printf("\nUpdated Student Names:\n");
    for (i = size; i < new_size; i++)
    {
        printf("%s\n", names[i]);
    }

// free memory
    for (i = 0; i < new_size; i++) { 
        free(names[i]); //Frees each individual name string
    }
    free(names); //Frees the array of pointers itself

    return 0;
}