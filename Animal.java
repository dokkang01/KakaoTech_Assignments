public class Animal {
    String name;
    int hunger;
    int sleepiness;
    int stress;

    public boolean isAlive(){
        // 반려동물이 살아있으면 참
        return this.hunger > 0 && this.sleepiness > 0 && this.stress > 0;
    }

}
