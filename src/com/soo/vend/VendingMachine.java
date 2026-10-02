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
 *   1. 돈을 넣어라 money
 *   2. 음료 버튼을 눌러라 drink
 *   3. 반환 버튼을 눌러라 return
 *   자판기가 수신할 수 있는 메세지는 자판기가 해야 할 일과 동일하다.
 *   1. 돈을 받아라
 *   2. 음료를 내보내라
 *   3. 잔액을 반환해라
 *  */

public class VendingMachine {

    private int balance = 0; // 잔액
    private int stock = 3; // 재고
    private final int PRICE = 2000; //가격

    private final String[] NAMES= {"콜라", "사이다", "하늘보리", "생수"}; // 음료 이름
    private final int[] PRICES = {2000,1800,1400,1100}; // 가격
    private int[] stocks = {2,3,2,1};


    public void money(int amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "원을 넣었습니다.😊 현재 잔액 : " + balance + "원");
        } else {
            System.out.println("0원 이하의 금액은 넣을 수 없습니다. 다시 입금 해주세요.....😢");
        }

    }

    public void drink() {

        if (stock == 0) {
            System.out.println("품절입니다.😭");
        } else if (balance < PRICE) {
            System.out.println("금액이 부족합니다.😢 현재 잔액은 " +balance+ "원 이고 " +
                    "가격은 " +PRICE+ "원 입니다. 총 " +(PRICE-balance)+ "원이 부족합니다.");
        } else {
            balance -= PRICE;
            stock -= 1;
            System.out.println("음료가 나왔습니다! 남은 잔액은 " +balance+"원 입니다.");
        }

    }

    public void returnChange() {

        if (balance == 0) {
            System.out.println("반환할 금액이 없습니다.");
        } else {
            System.out.println(balance + "원을 반환합니다! 이용해주셔서 감사합니다.😊");
            balance = 0;
        }
    }
}
