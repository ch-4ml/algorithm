function solution(targets) {
    const sortedTargets = targets.sort((a, b) => a[1] - b[1]);
    
    let answer = 0;
    let criteria = 0;
    for (let i = 0; i < sortedTargets.length; i += 1) {
        if (sortedTargets[i][0] >= criteria) {
            answer += 1;
            criteria = sortedTargets[i][1];
        }
    }
    
    return answer;
}