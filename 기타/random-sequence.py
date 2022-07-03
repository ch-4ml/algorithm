import random

# 원하는 시퀀스 할당하기
str = "AGCT" * 250

def get_random_sub_sequence(sequence, length):
    start_index = random.randint(0, len(sequence)-length+1)
    return sequence[start_index:start_index+length]

print(get_random_sub_sequence(str, 10))