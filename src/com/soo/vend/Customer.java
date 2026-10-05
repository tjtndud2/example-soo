package com.soo.vend;

/* comment. 프로그램 요구사항 작성
 *   주제 : 손님이 자판기에서 음료를 구매하는 프로그램
 *   1. 자판기는 처음에 잔액 0원, 음료 재고 3개인 상태로 대기한다. (음료 가격은 1,500원)
 *   2. 손님이 자판기에 돈을 넣으면 자판기의 잔액이 증가한다. 단, 0원 이하는 넣을 수 없다.
 *   3. 손님이 음료 버튼을 누르면, 잔액이 음료 가격 이상이고 재고가 있다면
 *      음료가 나오고 잔액에서 가격만큼 차감되며 재고가 1개 줄어든다.
 *   4. 음료 버튼을 누를 때 재고가 없다면 품절이라고 안내한다.
 *   5. 음료 버튼을 누를 때 잔액이 부족하다면 금액이 부족하다고 안내한다.
 *   6. 손님이 반환 버튼을 누르면 남은 잔액을 돌려주고 잔액은 0원이 된다.
 *   7. 반환할 잔액이 없다면 반환할 금액이 없다고 안내한다.
 *  */

/* comment. 은/는 , 이/가 <- 이 키워드 앞 단어가 대부분 클래스 후보이다.
 *   여기서 필요한 객체는 손님과 자판기 객체이다.
 *   손님이 수신할 수 있는 메세지는 손님이 해야 할 일과 동일하다.
 *   1. 돈을 넣어라
 *   2. 음료 버튼을 눌러라
 *   3. 반환 버튼을 눌러라
 *   자판기가 수신할 수 있는 메세지는 자판기가 해야 할 일과 동일하다.
 *   1. 돈을 받아라
 *   2. 음료를 내보내라
 *   3. 잔액을 반환해라
 *  */

public class Customer {

    private VendingMachine vend = new VendingMachine();

    public void money(int amount) {
        vend.money(amount);
    }

    public void showMenu() {
        vend.showMenu();
    }

    public void drink(int num) {   // Application이 보낸 번호를 받아서
        vend.drink(num);           // 그대로 자판기에게 넘긴다
    }

    public void returnChange() {
        vend.returnChange();
    }
}
