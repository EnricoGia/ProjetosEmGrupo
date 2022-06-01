#ifndef LISTA_H_DECLARED
#define LISTA_H_DECLARED

#include <stdio.h>


typedef struct
{
    int next[10];   // vetor de próximos índices
    int key[10];    // vetor de chaves (valores)
    int prev[10];   // vetor de últimos índices
    int free[10];   // vetor dos índices livres
    int L;          // índice do início da lista ligada


} Lists;

Lists createLinkedList();
Lists createLinkedListKey();
void showLists();
void showLinkedList();
void removeKey();
void emptyList();
void fillFree();
void insertKey();
void showArray();
void insertOnFree();

#endif