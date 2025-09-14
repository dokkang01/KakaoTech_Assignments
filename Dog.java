public class Dog extends Pet{
    public void walk(){
        // 강아지 산책 시켜주기, 강아지의 스트레스 지수 포인트를 추가한다
        this.stress += 40;
        this.hunger -= 25;      // 산책후에 살짝 배고픔
        if (this.stress > 100){
            this.stress = 100;
            bark();
        }
    }

    public void bark() {
        // 강아지의 효과음, 강아지가 행복하면 (stress 70이상) 나온다
        System.out.println("멍! 멍! 멍! 멍! 멍! 멍!");
    }
}
