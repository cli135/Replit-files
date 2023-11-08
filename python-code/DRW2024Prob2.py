# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # Implement your solution here
    max_sum = 0
    sorted_rows = []
    for row in A:
        # make sure that when you sort you
        # sort in the correct direction
        sorted_rows.append(sorted(row, reverse=True))
    for i in range(len(A)):
        for j in range(len(A[0])):
            pass
            # start at i, j
            candidates = []
            for k in range(len(A)):
                if k == i:
                    continue
                if sorted_rows[k][0] != A[k][j]:
                    candidates.append(sorted_rows[k][0])
                else:
                    candidates.append(sorted_rows[k][1])
            # candidates.sort(reverse=True)
            max_in_candidates = max(candidates)
            max_sum = max(max_sum, A[i][j] + max_in_candidates)
    return max_sum


if __name__ == "__main__":
    A = [[15, 1, 5],
         [16, 3, 8],
         [2 , 6, 4]]
    print(solution(A))