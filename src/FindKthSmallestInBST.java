void find_kth_smallest(Node * root, int *n, int K){
    if(!root) return;
    find_kth_smallest(root->left, n, K);
    (*n)++;
    if(K == *n){
        printf("Kth smallest element is : %d", root->data);
        return;
    }
    find_kth_smallest(root->right, n, K);
}
