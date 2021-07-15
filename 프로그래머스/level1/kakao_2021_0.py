import re

def solution(new_id):

    answer = new_id

    # step 1
    answer = answer.lower()

    # step 2
    answer = re.sub("[^0-9a-z-_.]", "", answer)

    # step 3
    answer = re.sub("[.]{2,}", ".", answer)

    # step 4
    answer = re.sub("^[.]|[.]$", "", answer)

    # step 5, 6
    answer = "a" if answer == "" else answer[:15]
    answer = re.sub("[.]$", "", answer)

    # step 7
    answer = answer if len(answer) > 2 else answer + "".join([answer[-1] for i in range(3 - len(answer))])
    
    return answer

print(solution("...!@BaT#*..y.abcdefghijklm.."))
print(solution("z-+.^."))
print(solution("=.="))
print(solution("123_.def"))
print(solution("abcdefghijklmn.p"))