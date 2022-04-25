import sys
sys.stdin = open('input/5185_input.txt', 'r')

# def hex2bin(n, hex_string):
#   value = int(hex_string, 16);  # O(N)
#   bin_string = ""
#   while value >= 1:
#     bin_string += str(value % 2)
#     value //= 2
#   return bin_string[::-1].zfill(int(n) * 4)

def hex2bin(n, hex_string):
  return bin(int(hex_string, 16))[2:].zfill(int(n) * 4)

T = int(input());
for test_case in range(1, T + 1):
  n, string = map(str, input().split())
  print('#{} {}'.format(test_case, hex2bin(n, string)))
