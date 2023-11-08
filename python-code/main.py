import mpmath

# starts accumulating errors around 25th number or so
# due to floating point precision?
# or due to some property of my algorithm??

def main():
    # print(int(mpmath.binomial(4, 2)))
    g = mpmath.memoize(mpmath.maxcalls(B, 50))
    for i in range(50):
        # print(i, int(result(i)))
        print(int(result(i)),end=", ")
        # print(i, int(g(i)))
        pass
    # print(int(result(30)),end=", ")
    # print(int(mpmath.binomial(4,2)))

def B(n):
    """https://mathworld.wolfram.com/BellNumber.html"""
    # sum = 0
    # for k in range(1, n + 1):
    #     for i in range(1, k + 1):
    #         sum += ((-1)**(k-i)) * (i**n) / mpmath.factorial(k)
    #
    # return sum
    if n == 0:
        return 1

    sum = 0
    for k in range(n):
        sum += B(k) * int(mpmath.binomial(n - 1, k))

    return sum



def result(n):
    return f(n, n, 1, True)
    # return f_readable(n, n, 1, True)


# doesn't work with mpmath yet
def f(n, r, t, first):
    if n == 3:
        pass

    if n == 0:
        return 1
    elif n < r:
        # reset count because new size
        return f(n, n, 1, True)

    sum = mpmath.fadd(0, 0)
    # on your first pick
    for num_picked in range(1, int(r) + 1):
        num_remaining = mpmath.fsub(n, num_picked)
        if num_picked == r and not first:
            # same in continuing train
            # I just need to parse the statement correctly into prefix instead of infix notation
            sum = mpmath.fadd(sum, mpmath.fdiv(mpmath.fmul(f(num_remaining, num_picked, t + 1, False), mpmath.binomial(n, num_picked)), (t + 1)))
        else:
            # first
            sum = mpmath.fadd(sum, mpmath.fdiv(mpmath.fmul(f(num_remaining, num_picked, 1, False), mpmath.binomial(n, num_picked)), (1)))

    return sum

def f_readable(n, r, t, first):

    if n == 0:
        return 1
    elif n < r:
        # reset count because new size
        return f_readable(n, n, 1, True)

    sum = 0
    # on your first pick
    for num_picked in range(1, r + 1):
        num_remaining = n - num_picked
        if num_picked == r and not first:
            # same in continuing train
            sum += f_readable(num_remaining, num_picked, t + 1, False) * mpmath.binomial(n, num_picked) / (t + 1)
        else:
            # first
            sum += f_readable(num_remaining, num_picked, 1, False) * mpmath.binomial(n, num_picked)

    return sum

# def nCr(n, k):
#     return factorial(n) / (factorial(n - k) * factorial(k))

# def factorial(n):
#     if n <= 1:
#         return 1
#     else:
#         return n * factorial(n - 1)

main()