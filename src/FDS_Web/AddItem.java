public class AddItem {

    public static void main(String[] args) {
        LoginAndOut loginAndOut = new LoginAndOut();
        ItemService itemService = new ItemService();

        loginAndOut.login("JY000","000000");

        String itemUrl = "http://172.19.103.123:28080/familyDoctor/page?path=bus/signconfig/serviceItemManager";
        itemService.jumpItemUrl(itemUrl);

        String itemFileUrl ="D:\\MyDocument\\FDS\\item.xls";
        OptExcel op = new OptExcel();
        String[][] arrS= op.readExcel(itemFileUrl,6);   //取的列数
        itemService.addItem(arrS,arrS[0].length);
    }
}
