#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void solveQueen(int n);
void queen(char **board, int row, int n);
bool isSafe(char **board, int row, int col, int n);
void printBoard(char **board, int n);

int solutionCount = 0;

int main() {
    int n;
    printf("Enter the value of n: ");
    scanf("%d", &n);

    solveQueen(n);

    printf("Total solutions: %d\n", solutionCount);
    return 0;
}

void solveQueen(int n) {
    char **board = (char **)malloc(n * sizeof(char *));
    for (int i = 0; i < n; i++) {
        board[i] = (char *)malloc(n * sizeof(char));
        for (int j = 0; j < n; j++)
            board[i][j] = '.';
    }

    queen(board, 0, n);

    for (int i = 0; i < n; i++)
        free(board[i]);
    free(board);
}

void queen(char **board, int row, int n) {
    if (row == n) {
        printBoard(board, n);
        solutionCount++;
        printf("\n");
        return;
    }
    for (int col = 0; col < n; col++) {
        if (isSafe(board, row, col, n)) {
            board[row][col] = 'Q';
            queen(board, row + 1, n);
            board[row][col] = '.';
        }
    }
}

bool isSafe(char **board, int row, int col, int n) {
    // Check same column
    for (int i = 0; i < row; i++) {
        if (board[i][col] == 'Q')
            return false;
    }
    // Check upper-left diagonal
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 'Q')
            return false;
    }
    // Check upper-right diagonal
    for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
        if (board[i][j] == 'Q')
            return false;
    }
    return true;
}

void printBoard(char **board, int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            printf("%c", board[i][j]);
        printf("\n");
    }
}
