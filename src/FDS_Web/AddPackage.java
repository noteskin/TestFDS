public class AddPackage {

    public static void main(String[] args) {
        LoginAndOut loginAndOut = new LoginAndOut();
        loginAndOut.login("JY000","000000");

        String packageUrl = "http://172.19.103.123:28080/familyDoctor/page?path=bus/signconfig/packageMain";
        PackageService packageService =new PackageService();
        packageService.jumpPackageUrl(packageUrl);



        String itemFileUrl ="D:\\MyDocument\\FDS\\Package.xls";
        OptExcel op = new OptExcel();
        String[][] arrS= op.readExcel(itemFileUrl,8); //取的列数
        packageService.addPackage(arrS,arrS[0].length);
    }
}
