//  Q44. Write a program to find the smallest and largest node in a BST.
#include<stdio.h>
#include<stdlib.h>
#include<limits.h>

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int value) {
    struct Node *newNode = (struct Node*) malloc(sizeof(struct Node));
    if(newNode == NULL) {
        printf("Memory not allocated.\n");
        exit(0);
    }
    newNode->data = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

struct Node* insertNode(struct Node* root, int val) {
    if(root == NULL)
        return createNode(val);
    if(val < root->data)
        root->left = insertNode(root->left, val);
    else
        root->right = insertNode(root->right, val);

    return root;
}

int smallestNode(struct Node* root) {
    if(root == NULL) return INT_MIN;

    while(root->left != NULL)
        root = root->left;

    return root->data;
}

int largestNode(struct Node* root) {
    if(root == NULL) return INT_MAX;
    while(root->right != NULL)
        root = root->right;
    return root->data;
}

void inOrder(struct Node* root) {
    if(root == NULL) return;

    inOrder(root->left);
    printf("%d ", root->data);
    inOrder(root->right);
}

int main() {
    struct Node* root = NULL;

    root = insertNode(root, 12);
    root = insertNode(root, 5);
    root = insertNode(root, 4);
    root = insertNode(root, 47);
    root = insertNode(root, 6);

    printf("Inorder Traversal: ");
    inOrder(root);

    printf("\nSmallest Node: %d", smallestNode(root));
    printf("\nLargest Node: %d\n", largestNode(root));

    return 0;
}