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

    private final String[] NAMES = {"콜라", "사이다", "하늘보리", "생수"}; // 음료 이름
    private final int[] PRICES = {2000, 1800, 1400, 1100};            // 가격
    private int[] stocks = {2, 3, 2, 1};                               // 재고
    // 같은 번호(인덱스)끼리 한 음료다. 예) 0번 = 콜라, 2000원, 2개

    public void money(int amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "원을 넣었습니다.😊 현재 잔액 : " + balance + "원");
        } else {
            System.out.println("0원 이하의 금액은 넣을 수 없습니다. 다시 입금 해주세요.....😢");
        }

    }

    /* 음료 메뉴를 보여줘라 */
    public void showMenu() {

        System.out.println("----------- 음료 메뉴 -----------");

        // 배열 길이만큼 반복하면서 한 줄씩 출력 (i는 0, 1, 2, 3)
        for (int i = 0; i < NAMES.length; i++) {
            if (stocks[i] == 0) {
                System.out.println((i + 1) + ". " + NAMES[i] + " " + PRICES[i] + "원 (품절)");
            } else {
                System.out.println((i + 1) + ". " + NAMES[i] + " " + PRICES[i] + "원");
            }
        }

        System.out.println("현재 잔액 : " + balance + "원");
        System.out.println("--------------------------------");
    }

    /* 선택한 음료를 내보내라 */
    public void drink(int num) {

        int i = num - 1; // 손님은 1번부터 고르지만 배열은 0번부터 시작하니까 1을 뺀다

        // 배열을 건드리기 전에 없는 번호부터 걸러낸다 (안 그러면 프로그램이 에러로 멈춤)
        if (i < 0 || i >= NAMES.length) {
            System.out.println("잘못된 선택입니다. 1~" + NAMES.length + "번 중에서 골라주세요.");
        } else if (stocks[i] == 0) {
            System.out.println(NAMES[i] + "은(는) 품절입니다.😭");
        } else if (balance < PRICES[i]) {
            System.out.println("금액이 부족합니다.😢 현재 잔액은 " + balance + "원 이고 " +
                    NAMES[i] + " 가격은 " + PRICES[i] + "원 입니다. 총 " + (PRICES[i] - balance) + "원이 부족합니다.");
        } else {
            balance -= PRICES[i];
            stocks[i]--;
            System.out.println(NAMES[i] + "이(가) 나왔습니다! 남은 잔액은 " + balance + "원 입니다.");
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
