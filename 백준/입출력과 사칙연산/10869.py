# 두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)
# 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오. 
s = input()
a, b = list(map(int, s.split(" ")))
print(a + b, a - b, a * b, a // b, a % b, sep = "\n")
