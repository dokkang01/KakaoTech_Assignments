# CLI 반려동물 키우기 시뮬레이터

터미널에서 고양이/강아지를 선택해 키우는 CLI 시뮬레이션 게임입니다.
배고픔·졸림·스트레스 게이지가 0 이하가 되면 반려동물이 사망합니다.

게이지가 높을수록 좋음 (0 = 최악/사망, 100 = 최고)



주요 기능
	•	고양이/강아지 중 선택하여 플레이
	•	행동 명령: 밥주기, 재우기, (고양이) 쓰다듬기 / (강아지) 산책
	•	주기적 상태 변화: 5초마다 tick()으로 스탯 감소
	•	상태 출력: 매 명령 입력 시 현재 스탯 바(막대) UI 출력
	•	사망 판정 및 사인 출력: 아사/과로사/스트레스사




프로젝트 구조

<img width="729" height="149" alt="image" src="https://github.com/user-attachments/assets/7fea3df3-cebb-4b8e-9f94-785d2cb6292d" />




# 실행
java Main에서 실행 (Main.java)

플레이 방법
	1.실행 후 1(고양이) / 2(강아지) 선택
 
	2.이름을 입력
 
	3.메뉴에서 다음 명령 중 하나를 입력
 
	•1: 밥주기 (feed)
 
	•2: 재우기 (lullaby)
 
	•3: 쓰다듬기/산책 (고양이=groom, 강아지=walk)
 
	•0: 종료
 

 현재 상태가 다음과 같이 표시됩니다:

<img width="1006" height="132" alt="image" src="https://github.com/user-attachments/assets/c30b8a3e-cbb8-4e8b-875c-13421d5ab999" />


게임 내부 로직상 게이지가 0 이하가 되면 사망합니다.
---

스탯 규칙 (현재 버전)
	•	상태 범위: 0 ~ 100
 
	•	tick() (5초마다 실행, Game.start() 내부 스케줄러)
 
	•	hunger -= 10
 
	•	sleepiness -= 5
 
	•	stress -= 3
 
	•	행동 효과 (요약)
 
	•	feed(): 배고픔 회복, 졸림·스트레스 소폭 변화
 
	•	lullaby(): 졸림 회복, 배고픔·스트레스 변화
 
	•	Cat.groom(): 스트레스 회복, 100 도달 시 골골송 출력
 
	•	Dog.walk(): 스트레스 회복, 배고픔·졸림 변화, 100 도달 시 짖음 출력


## 게임 오버 조건
Animal.isAlive()에서 다음 조건 중 하나라도 만족하면 사망:

hunger <= 0 || sleepiness <= 0 || stress <= 0

Game.checkGameOver()에서 사망 시 원인을 출력:
	•	sleepiness <= 0 → 과로사
	•	hunger <= 0 → 아사
	•	stress <= 0 → 스트레스사


