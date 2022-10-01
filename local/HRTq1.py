def solution(a, b):
    n = a[::-1] + "0"
    m = b[::-1] + "0"
    minLength = min(len(n), len(m))
    maxLength = max(len(n), len(m))
    result = ""
    carry = 0
    cur = 0
    # print(n)
    # print(m)
    
    for i in range(maxLength):
        # add digits
        if (len(n) > len(m)):
            cur += int(n[i])
            if i < len(m):
                cur += int(m[i])
        else: #len(m) > len(n):
            cur += int(m[i])
            if i < len(n):
                cur += int(n[i])
        cur += carry
        carry = 0
        # check for carry
        # and append the correct digit
        if cur >= 2:
            cur -= 2
            carry += 1
            result += str(cur)
            cur = 0
        elif cur == 1:
            result += "1"
            cur = 0
        else: # cur is 0
            result += "0"
            cur = 0
    
    return result[::-1].lstrip("0")
