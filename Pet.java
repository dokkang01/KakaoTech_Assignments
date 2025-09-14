import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Pet extends Animal {
    int hungerRate;
    int sleepRate;
    int stressRate;

    public void feed(){
        // 반료동물에게 밥 주기, Hunger 수치를 올려준다
        System.out.println(this.name+": 챱 챱 챱 챱 챱 챱 챱");
        this.hunger += 20;
        if (this.hunger > 100){
            this.hunger = 100;
        }
        this.stress += 10;         // 밥 먹으면 스트레스 소폭 감소
        if (this.stress > 100){
            this.stress = 100;
        }
        this.sleepiness -= 5;      // 식곤증으로 졸림 수치 소폭 상승
    }
    public void lullaby(){
        // 반려동물 제우기, sleepiness 수치를 올려준다
        System.out.println(this.name + ": zzzzzzzzzzzzzzzz");
        this.sleepiness = 100;
        this.hunger -= 20;          // 자는 동안 배고파 져서 배고픔 수치 상승
        if (this.hunger > 100){
            this.hunger = 100;
        }
        this.stress += 10;          // 자는 동안 스트레스 소폭 감소
        if (this.stress > 100){
            this.stress = 100;
        }
    }

    public void tick(){
        this.hunger -= 10;
        this.stress -= 3;
        this.sleepiness -= 5;
    }
}
