package chapter03;

public class Goods {
    private String name;
    static int countofGoods = 0;
    private int price;
    private int countStock;
    private int countSold;

    public Goods() {
        // 클래스 이름 생략
        countofGoods++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            price = 0;
        }

        this.price = price;
    }

    public int getCountStock() {
        return countStock;
    }

    public void setCountStock(int countStock) {
        this.countStock = countStock;
    }

    public int getCountSold() {
        return countSold;
    }

    public void setCountSold(int countSold) {
        this.countSold = countSold;
    }

    public void showInfo() {
        System.out.println(
                "상품이름 : " + name + ", 가격 : " + Integer.toString(price) + ", 재고 개수 : " + Integer.toString(countStock)
                        + ", 팔린 개수 : " + Integer.toString(countSold));
    }

    public int calcDiscountPrice(float rate) {
        return price - (int) (price * rate);
    }
}
