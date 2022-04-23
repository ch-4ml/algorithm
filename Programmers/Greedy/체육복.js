function solution(n, lost, reserve) {
  let answer = 0;

  const lst = lost.filter((l) => !reserve.includes(l)).sort((a, b) => a - b);
  const rsv = reserve.filter((r) => !lost.includes(r)).sort((a, b) => a - b);

  answer = n - lst.length;

  for (const l of lst) {
    if (rsv.includes(l - 1)) {
      rsv.splice(rsv.indexOf(l - 1), 1);
      answer++;
    } else if (rsv.includes(l + 1)) {
      rsv.splice(rsv.indexOf(l + 1), 1);
      answer++;
    }
  }

  return answer;
}
