// Q42. Write a program to count the total number of nodes, leaf nodes, and internal nodes in a Binary Tree.

#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node* leftChild;
    struct Node* rightChild;
};

struct Node* root;


struct Node *createNode(int value) {
    struct Node *newNode = (struct Node*) malloc(sizeof(struct Node));
    if(newNode == NULL) {
        printf("Memory not allocated.\n");
        exit(0);
    }
    newNode->data = value;
    newNode->leftChild = NULL;
    newNode->rightChild = NULL;
    return newNode;
}

struct Node* insertNode(struct Node* root, int value) {
    if(root == NULL) {
        return createNode(value);
    }
    int choice;
    printf("Enter %d to left(1) or right(2) to %d : ", value, root->data);
    scanf("%d", &choice);

    if(choice == 1) {
        root->leftChild = insertNode(root->leftChild, value);
    } else {
        root->rightChild = insertNode(root->rightChild, value);
    }
    return root;
}

int countLeafNodes(struct Node* root) {
    if(root != NULL) {
        if(root->leftChild == NULL && root->rightChild == NULL) {
            return 1;
        } else {
            return countLeafNodes(root->leftChild) + countLeafNodes(root->rightChild);
        }
    }
    return 0;
}

int countInternalNodes(struct Node* root) {
    if(root != NULL) {
        if(root->leftChild == NULL && root->rightChild == NULL) {
            return 0;
        } else {
            return (1 + countIntNodes(root->leftChild) + countIntNodes(root->rightChild));
        }
    }
    return 0;
}

int countTotalNodes(struct Node* root) {
    if(root == NULL) return 0;
    return 1 + countTotalNodes(root->leftChild) + countTotalNodes(root->rightChild);
//     return countLeafNodes(root) + countIntNodes(root);
}

int main(){
    root = insertNode(root, 45);
    root = insertNode(root, 55);
    root = insertNode(root, 55);
    root = insertNode(root, 55);
    root = insertNode(root, 65);
    root = insertNode(root, 4);

    int n = countLeafNodes(root);
    int n1 = countIntNodes(root);
    int n2 = countTotalNodes(root);
    printf("%d %d %d",n2, n1 , n);

    return 0;
}