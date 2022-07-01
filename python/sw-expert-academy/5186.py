import sys
sys.stdin = open('input/5186_input.txt', 'r')

def dec2bin(dec_string):
    value = float(dec_string)
    criteria = 1
    bin_string = ""
    while value > 0:
        criteria /= 2
        if value >= criteria:
            bin_string += "1"
            value -= criteria
        else:
            bin_string += "0"
        
        if len(bin_string) > 12:
            return "overflow"    

    return bin_string

T = int(input());
for test_case in range(1, T + 1):
    print("#{} {}".format(test_case, dec2bin(input())))