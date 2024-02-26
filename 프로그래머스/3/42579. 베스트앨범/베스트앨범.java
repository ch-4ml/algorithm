import java.util.*;

class Song {
    public int index;
    public int plays;
    public String genre;

    public Song(int index, int plays, String genre) {
        this.index = index;
        this.plays = plays;
        this.genre = genre;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 자료 구조 생성
        Map<String, Queue<Song>> songsByGenre = new HashMap<>();
        Map<String, Integer> totalPlaysByGenre = new HashMap<>();
        List<Integer> bestAlbum = new ArrayList<>();

        // 입력 값 할당
        for (int i = 0, size = plays.length; i < size; i += 1) {
            String genre = genres[i];
            if (!songsByGenre.containsKey(genre)) {
                songsByGenre.put(genre, new PriorityQueue<>(
                    (o1, o2) -> o1.plays == o2.plays ? o1.index - o2.index : o2.plays - o1.plays)
                );
                totalPlaysByGenre.put(genre, 0);
            }
            songsByGenre.get(genre).add(new Song(i, plays[i], genre));
            totalPlaysByGenre.put(genre, totalPlaysByGenre.get(genre) + plays[i]);
        }

        // 장르별 재생 수 기준 내림차순 정렬된 list
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(totalPlaysByGenre.entrySet());
        sortedGenres.sort((o1, o2) -> o2.getValue() - o1.getValue());

        // Best Album 만들기
        for (Map.Entry<String, Integer> sortedGenre : sortedGenres) {
            Queue<Song> queue = songsByGenre.get(sortedGenre.getKey());
            if (queue.isEmpty()) continue;
            bestAlbum.add(queue.poll().index);
            if (queue.isEmpty()) continue;
            bestAlbum.add(queue.poll().index);
        }

        // 정답 포맷으로 바꾸기
        int size = bestAlbum.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i += 1) {
            answer[i] = bestAlbum.get(i);
        }
        return answer;
    }
}