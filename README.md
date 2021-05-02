# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


## 기능 명세

* 자동차 이름을 입력 받는 다.
    * ','로 자동차 이름을 구분한다.
    * 자동차 이름이 5자 이하인지 확인한다.
* 시도할 횟수를 입력 받는 다.
    * 숫자인지 확인한다.
* 자동차
  * 4이상일 경우에 차를 전진한다.
  * 이동거리를 출력한다.
* 자동차 목록
  * 목록만큼 전진을 시도한다.
    * 0에서 9사이에 숫자를 랜덤으로 리턴한다.
    * 시도 후에 진행사항을 출력한다.
  * 종료되었을 때 우승자를 리턴한다.
    * 가장 많이 이동한 거리를 구한다.
    * 가장 많이 이동한 거리와 같은 자동차를 리턴한다.
* 게임 구현
  * 자동차 이름 입력
  * 전진 시도 횟수 입력
  * 시도 횟수 만큼 게임하기
  * 우승한 자동차를 출력한다.
