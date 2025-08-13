// You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

// Your task is to find:

// The maximum number of jobs that can be completed within their deadlines.
// The total maximum profit earned by completing those jobs.



class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(0, 0));
        
        List<int[]> jobs = new ArrayList<>();
        for(int  i = 0; i < n; i++) {
            jobs.add(new int[]{deadline[i], profit[i]});
        }
        
        jobs.sort(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] job : jobs) {
            if(job[0] > pq.size()) {
                pq.add(job[1]);
            } else if(!pq.isEmpty() && pq.peek() < job[1]) {
                pq.poll();
                pq.add(job[1]);
            }
        }
        
        while(!pq.isEmpty()) {
            ans.set(1, ans.get(1) + pq.poll());
            ans.set(0, ans.get(0) + 1);
        }
        
        return ans;
    }
}