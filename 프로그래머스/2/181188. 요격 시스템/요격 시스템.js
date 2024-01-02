function solution(targets) {
    let answer = 0;
    
    let trigger = false;
    const sortedTargets = targets.sort((a, b) => a[0] === b[0] ? a[1] - b[1] : a[0] - b[0]);
                                       
    // console.log(sortedTargets);

    let start = 0;
    let end = 0;
    for (let i = 0; i < sortedTargets.length; i += 1) {
        let length = end - start;
        
        const [s, e] = sortedTargets[i];
        if (e - s > length || end <= s) {
            answer += 1;
            start = s;
            end = e;
        }
    }
    
    return answer;
}