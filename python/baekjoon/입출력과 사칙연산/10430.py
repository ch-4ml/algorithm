# (A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
# (A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
# 세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
# 첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)
s = input()
a, b, c = list(map(int, s.split(" ")))
print((a + b) % c, ((a % c) + (b % c)) % c, (a * b) % c, ((a % c) * (b % c)) % c, sep = "\n")
