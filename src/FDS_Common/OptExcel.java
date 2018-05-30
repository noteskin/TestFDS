import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;

public class OptExcel {

    /**
     *
     * @param fileUrl,文件路径
     * @param column,取列数
     */
    protected String[][] readExcel(String fileUrl,int column){
        String[][] arrExcel = null;
        try {
            Workbook workbook = Workbook.getWorkbook(new File(fileUrl));
            Sheet sheet = workbook.getSheet(0); //获得的一个sheet
            int rows = sheet.getRows();
            arrExcel = new  String[column][rows];

            for(int row=1;row<rows;row++){
                for(int col=0;col<column;col++){
                    Cell cell1 = sheet.getCell(col,row );//获得第一行第一列的单元格，从2行，第一列到i列，开始计数
                    String rs = cell1.getContents();
                    if(rs.equals("")){
                        rs=" ";
                        System.out.println("rsrsrs="+rs);
                    }
                    arrExcel[col][row] =rs;
                }
            }

            workbook.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return arrExcel;

    }

    public static void main(String[] args) {
        String s ="D:\\item.xls";

        OptExcel op = new OptExcel();
        String[][] arrS= op.readExcel(s,6);
        System.out.println("yyyyy"+arrS[0].length);
        for(int r=1;r< arrS[0].length;r++){
            System.out.println("r===="+r);
            for(int c=0;c<6;c++){
                System.out.println("c====="+c);
                System.out.println(arrS[c][r]);
            }
        }


    }


}
