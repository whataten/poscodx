package chapter03;

public class GoodsApp {
    public static void main(String[] args) {
        var camera = new Goods("nikon", 40000, 10, 20);
        // camera.setName("nikon");
        // camera.setPrice(40000);
        // camera.setCountSold(10);
        // camera.setCountStock(20);

        camera.showInfo();

        Goods goods2 = new Goods();
        Goods goods3 = new Goods();

        System.out.println(Goods.countofGoods);

        System.out.println(camera.calcDiscountPrice(0.5f));

        System.out.println(camera);
    }
}
