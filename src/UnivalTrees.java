Unival tree
=============================================================================================
int countUniVals(node* head, bool* unival) {
    if (!node) {
        *unival = true;
        return 0;
    }
    bool uniL,uniR;
    int sum = countUniVals(head->l, &uniL) + countUniVals(head->r, &uniR);
    if (uniL && uniR &&
        (!head->l || head->l->val == head->val) && 
        (!head->r || head->r->val == head->val)) {
        sum++;
        *unival = true;
    }
    return sum;
}
