
#include<stdio.h>
#include<stdlib.h>

#define MAX 50

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* root = NULL;

struct Node *createNode(int value) {
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

struct Node* insertNode(struct Node* root, int value) {
    if(root == NULL) return createNode(value);
    if(value < root->data) root->left = insertNode(root->left, value);
    else root->right = insertNode(root->right, value);
    return root;
}

struct Node* queue[MAX];
int front = 0, rear = -1;
void push(struct Node* root) { queue[++rear] = root; }
struct Node* pop() { return queue[front++]; }

void levelOrder(struct Node* root) {
    if(root == NULL) return;
    push(root);
    while(front <= rear) {
        struct Node* current = pop();
        if(current->left != NULL) push(current->left);
        if(current->right != NULL) push(current->right);
        printf("%d ", current->data);
    }
}

int main(){
    root = insertNode(root, 45);
    root = insertNode(root, 55);
    root = insertNode(root, 65);
    root = insertNode(root, 15);
    root = insertNode(root, 75);
    root = insertNode(root, 4);
    root = insertNode(root, 60);
    levelOrder(root);

    return 0;
}

