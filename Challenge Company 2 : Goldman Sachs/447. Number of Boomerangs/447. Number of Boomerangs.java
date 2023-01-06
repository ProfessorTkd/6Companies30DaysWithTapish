class Solution {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> distances = new HashMap<>();
        int boomerangs = 0;
        for(int i = 0; i < points.length; i++){
             for(int j = 0; j < points.length; j++){
                    if(i == j) continue;

                    int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);

                    distances.put(dis, distances.getOrDefault(dis, 0) + 1);
             }
             for(Integer dis : distances.values()){
                 boomerangs += dis * (dis - 1); 
             }
             distances.clear();
        }
        return boomerangs;
    }
}
