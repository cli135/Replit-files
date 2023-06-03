import mpmath

def main():
    for i in range(50):
        # print(i, result(i))
        # print(int(result(i)),end=", ")
        pass
    print(int(result(30)),end=", ")


def result(n):
    return f(n, n, 1, True)

def f(n, r, t, first):

    if n == 0:
        return 1
    elif n < r:
        # reset count because new size
        return f(n, n, 1, True)

    sum = 0
    # on your first pick
    for num_picked in range(1, r + 1):
        num_remaining = n - num_picked
        if num_picked == r and not first:
            # same in continuing train
            sum += f(num_remaining, num_picked, t + 1, False) * mpmath.binomial(n, num_picked) / (t + 1)
        else:
            # first
            sum += f(num_remaining, num_picked, 1, False) * mpmath.binomial(n, num_picked)

    return sum

# def nCr(n, k):
#     return factorial(n) / (factorial(n - k) * factorial(k))

# def factorial(n):
#     if n <= 1:
#         return 1
#     else:
#         return n * factorial(n - 1)

main()