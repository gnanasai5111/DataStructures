Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.

Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
Output
[null, 1.0, 5.5, 4.66667, 6.0]

Explanation
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3

First approach(Queue)

class MovingAverage {
    Queue<Integer> q;
    int size=0;
    double sum;

    public MovingAverage(int size) {
        q=new LinkedList<>();
        this.size=size;
        this.sum=0.0;

    }
    
    public double next(int val) {
        q.offer(val);
        while(q.size()>size){
            sum=sum-q.poll();

        }
        sum=sum+val;
        return sum/(q.size());
        
    }
}

1. Add the elements to queue.Remove the starting elements till the queue size becomes mentioned size.

Time complexity - o(N)
Space complexity - o(N)
