// Q43. Write a program to implement basic operations on a Binary Search Tree (BST).

#include<stdio.h>
#include<stdlib.h>

struct Node {
    int data;
    struct Node *lChild, *rChild;
};
struct Node *root = NULL;

struct Node *createNode(int value) {
    struct Node *newNode = (struct Node*) malloc (sizeof(struct Node));
    newNode->data = value;
    newNode->lChild = NULL;
    newNode->rChild = NULL;
    return newNode;
}

struct Node* insertNode(struct Node* root, int value) {
    if(root == NULL) {
        return createNode(value);
    }
    if(value < root->data) {
        root->lChild = insertNode(root->lChild, value);
    }
    else if(value > root->data) {
        root->rChild = insertNode(root->rChild, value);
    }
    else {
        printf("Value can't be equal.");
    }
    return root;
}

struct Node* searchNode(struct Node* root, int value) {
    if (root == NULL) 
        return NULL;
    if (value < root->data)
        return searchNode(root->lChild, value);
    else if (value > root->data)
        return searchNode(root->rChild, value);
    else
        return root;
}

struct Node* max(struct Node* root) {
    struct Node* max = root;
    if(root == NULL) {
        return NULL;
    }
    while(root->rChild != NULL) {
        max = root->rChild;
        root = root->rChild;
    }
    return max;
}

struct Node* min(struct Node* root) {
    struct Node* min = root;
    if(root == NULL) {
        return NULL;
    }
    while(root->lChild != NULL) {
        min = root->lChild;
        root = root->lChild;
    }
    return min;
}

void preOrder(struct Node* root) {
    if(root == NULL) return;
    printf("%d ", root->data);
    preOrder(root->lChild);
    preOrder(root->rChild);
}

void inOrder(struct Node* root) {
    if(root == NULL) return;
    inOrder(root->lChild);
    printf("%d ", root->data);
    inOrder(root->rChild);
}

void postOrder(struct Node* root) {
    if(root == NULL) return;
    postOrder(root->lChild);
    printf("%d ", root->data);
    postOrder(root->rChild);
}

int main(){
    root = insertNode(root, 12);
    root = insertNode(root, 8);
    root = insertNode(root, 5);
    root = insertNode(root, 2);
    root = insertNode(root, 4);
    root = insertNode(root, -9);
    printf("PreOrder : ");
    preOrder(root); printf("\n");
    printf("InOrder : ");
    inOrder(root); printf("\n");
    printf("PostOrder : ");
    postOrder(root); printf("\n");
    struct Node* result = searchNode(root, 2);
    if (result != NULL)
        printf("Found: %d\n", result->data);
    else
        printf("Not found.\n");
    printf("Max = %d, Min = %d", max(root)->data, min(root)->data);

    return 0;
}