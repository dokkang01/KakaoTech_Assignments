public class Cat extends Pet{
    // play에서 pet으로 변경
    public void groom(){
        // 고양이 쓰다듬기, 고양이의 스트레스 지수를 높여준다
        this.stress += 20;
        if(this.stress > 100){
            this.stress = 100;
            purr();
        }
    }

    public void purr(){
        // 고양이의 효과음, 기분 좋을 때 출력 (스트레스 지수 MAX 찍을 때)
        System.out.println("그르릉 그르릉 그르릉 그르릉 그르릉 그르릉 그르릉 그르릉");
    }
}
