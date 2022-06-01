#include <stdio.h>
#include <stdlib.h>
#include "lista.h"

Lists s1;
int ntest[10] = {1,2,3,4,5,6,7,8,9,-1};
int ktest[10] = {5,3,1,54,23,1,2,4,56,10};
int ptest[10] = {-1,0,1,2,3,4,5,6,7,8};
int Ltest = 0;

int main(void) {

    s1 = createLinkedListKey(ktest);

    fillFree();

    showLists();
    showLinkedList();

    emptyList();
    removeKey(5);

    showLists();
    showLinkedList();

    return 0;

}