#include <stdio.h>
#include <cstdlib>

using namespace std;

int main(int argc, char* argv[]) {
    int sum = 0;
    for (int i = 1; i < argc; i++) {
        int x = atoi(argv[i]);
        sum += x;
    }
    printf("%d\n", sum);

    return 0;
}