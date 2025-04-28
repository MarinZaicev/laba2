import math

def pozition(N):
    pozition = -1
    number = 0
    pozitionCount = 0
    newN = N
    while newN > 0:
        pozition += 1
        number = newN % 10
        newN = newN // 10
        if pozition % 2 != 0 and number % 2 != 0:
            pozitionCount += 1
    if (pozitionCount == (pozition + 1) // 2) and (pozition > 0):
        return N
    else:
        return 0

def bags(tryNumber):
    if tryNumber < 0:
        print("вводите только положительное число")
        exit(0)

def main():
    print("сколько чисел вы планируете вводить?")
    numberCount = int(input())
    bags(numberCount)
    print("вводите числа")
    number = 0
    sum = 0
    for i in range(numberCount, 0, -1):
        number = int(input())
        bags(number)
        sum += pozition(number)
    print(sum)

if __name__ == "__main__":
    main()
