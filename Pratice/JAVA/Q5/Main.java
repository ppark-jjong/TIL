public class Main {
    public static void main(String[] args) {
        Shopping shopping = new Shopping();

        while (true) {
            int shoppingmenu = shopping.shoppingMenu();

            if (shoppingmenu == 3) {
                break;
            }else if (shoppingmenu == 2) {
                shopping.returnCart();
            }
            else {
                Cart cart = shopping.rentCart();
                while (true) {
                    int cartmenu = shopping.cartMenu();

                    if (cartmenu == 5) {
                        break;
                    }

                    shopping.cartAction(cart, cartmenu);
                }
            }
        }
    }
}
