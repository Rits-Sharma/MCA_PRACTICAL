// Q41. Extend the above program (Q40) to include deletion operations in the Binary Tree.

#include<stdio.h>
#include<stdlib.h>

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
    if (root == NULL) return createNode(value);
    if (value < root->data)
        root->left = insertNode(root->left, value);
    else
        root->right = insertNode(root->right, value);
    return root;
}

void inOrder(struct Node* root) {
    if(root == NULL) {
        return;
    }
    inOrder(root->left);
    printf("%d ", root->data);
    inOrder(root->right);
}

struct Node* deleteNode(struct Node* root, int key) {
    if (root == NULL)
        return NULL;
    // If tree has only one node
    if (root->left == NULL && root->right == NULL) {
        if (root->data == key) {
            free(root);
            return NULL;
        }
        return root;
    }

    struct Node *keyNode = NULL, *temp;
    struct Node* queue[100];
    int front = 0, rear = 0;

    queue[rear++] = root;

    // Level order traversal
    while (front < rear) {
        temp = queue[front++];

        if (temp->data == key)
            keyNode = temp;
        if (temp->left)
            queue[rear++] = temp->left;
        if (temp->right)
            queue[rear++] = temp->right;
    }

    // If key found, replace and delete deepest
    if (keyNode != NULL) {
        keyNode->data = temp->data;

        front = 0;
        rear = 0;
        queue[rear++] = root;

        while (front < rear) {
            struct Node* curr = queue[front++];

            if (curr->left) {
                if (curr->left == temp) {
                    free(curr->left);
                    curr->left = NULL;
                    break;
                }
                queue[rear++] = curr->left;
            }

            if (curr->right) {
                if (curr->right == temp) {
                    free(curr->right);
                    curr->right = NULL;
                    break;
                }
                queue[rear++] = curr->right;
            }
        }
    }
    return root;
}

int main(){
    int n;
    root = insertNode(root, 15);
    root = insertNode(root, 10);
    root = insertNode(root, 16);
    root = insertNode(root, 25);
    root = insertNode(root, 63);
    root = insertNode(root, 1);
    root = insertNode(root, 11);

    deleteNode(root, 10);
    inOrder(root);

    return 0;
}