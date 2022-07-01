// 미완성

function solution(name) {
  let answer = 0;

  // false: 방문할 필요 없음, true: 방문 필요
  const point = name.split('').map((n, index) => (n === 'A' || index === 0 ? false : true));
  console.log(point);

  const mid = Math.floor(point.length / 2);
  const lCount = point.filter((p, index) => p && index > mid).length;
  const rCount = point.filter((p, index) => p && index <= mid).length;

  console.log(lCount, rCount);

  if (lCount > rCount) {
    // right에 포함된 index 수가 적을 때
    const rMid = mid / 2;
    const isGE = point.filter((p, index) => p && index >= rMid && index <= mid).length > 0;
    const isLT = point.filter((p, index) => p && index < rMid && index <= mid).length > 0;
    if (isGE) {
      // >= rMid 인 index가 있으면 left의 max index를 start, right의 min index를 end로 탐색 (역)
      answer += point.length - point.indexOf(true);
      console.log(1);
    } else if (isLT) {
      // < rMid 인 index만 있으면 right의 max index를 start, left의 min index를 end로 탐색 (전환-역)
      answer += point.lastIndexOf(true, mid) * 2 + point.length - point.indexOf(true, mid + 1);
      console.log(2, answer);
    } else {
      // right가 없으면 left의 min index만큼 이동
      answer += point.length - point.indexOf(true, mid);
      console.log(3, answer);
    }
  } else {
    // left에 포함된 index 수가 적거나 같을 때
    const lMid = (mid + point.length) / 2;
    const isLE = point.filter((p, index) => p && index <= lMid && index > mid).length > 0;
    const isGT = point.filter((p, index) => p && index > lMid && index > mid).length > 0;
    if (isLE) {
      // <= lMid 인 index가 있으면 right의 min index를 start, left의 max index를 end로 (순)
      answer += point.lastIndexOf(true);
      console.log(4, answer);
    } else if (isGT) {
      // > lMid 인 index만 있으면 left의 min index를 start, right의 max index를 end로 (전환-순)
      answer += (point.length - point.indexOf(true, mid + 1)) * 2 + point.lastIndexOf(true, mid);
      console.log(5, answer);
    } else {
      // left가 없으면 right의 max index만큼 이동
      answer += point.lastIndexOf(true, mid);
      console.log(6, answer);
    }
  }

  // 알파벳 변경
  for (let i = 0; i < point.length; i++) {
    answer += countCharChanges(name[i]);
  }

  return answer;
}

function ascii(char) {
  return char.charCodeAt(0);
}

function countCharChanges(char) {
  return ascii(char) > ascii('N') ? ascii('Z') - ascii(char) + 1 : ascii(char) - ascii('A');
}
