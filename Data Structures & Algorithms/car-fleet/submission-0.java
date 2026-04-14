class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for(int i=0;i<position.length;i++)
        {
            cars[i] = new Car(position[i],speed[i]);
        }
        Arrays.sort(cars,(car1,car2)->car1.dist-car2.dist);
        Stack<Double> st = new Stack<>();
        for(int i=cars.length-1;i>=0;i--){
            double time = (target-cars[i].dist)/(double)cars[i].speed;
            if(st.isEmpty() || st.peek() < time)
                st.push(time);
        }
        return st.size();
    }
}
class Car{
    int dist;
    int speed;

    public Car(int dist,int speed){
        this.dist = dist;
        this.speed = speed;
    }
}