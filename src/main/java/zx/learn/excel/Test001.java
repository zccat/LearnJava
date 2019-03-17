package zx.learn.excel;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @Auther: quxue
 * @Date: 2019/2/26 15:11
 * @Description:
 */
public class Test001 {

        public static void main(String[] args)throws IOException
        {
            String filePath="d:\\sample.xls";//文件路径
            HSSFWorkbook workbook =new HSSFWorkbook();//创建Excel文件(Workbook)
            HSSFSheet sheet = workbook.createSheet("Test");//创建工作表(Sheet)
            //sheet = workbook.createSheet("Test");// 创建工作表(Sheet)
            HSSFRow row = sheet.createRow(0);// 创建行,从0开始
            HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
            cell.setCellValue("CC");// 设置单元格内容
            row.createCell(1).setCellValue(false);// 设置单元格内容,重载

            cell = row.createCell(2);// 设置单元格内容,重载
            HSSFCellStyle style = workbook.createCellStyle();
            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
            cell.setCellStyle(style);
            cell.setCellValue(new Date());

            row.createCell(3).setCellValue(12.345);// 设置单元格内容,重载
            workbook.createInformationProperties();//创建文档信息
            DocumentSummaryInformation dsi= workbook.getDocumentSummaryInformation();//摘要信息
            dsi.setCategory("类别:Excel文件");//类别
            dsi.setManager("管理者:李志伟");//管理者
            dsi.setCompany("公司:--");//公司
            SummaryInformation si = workbook.getSummaryInformation();//摘要信息
            si.setSubject("主题:--");//主题
            si.setTitle("标题:测试文档");//标题
            si.setAuthor("作者:李志伟");//作者
            si.setComments("备注:POI测试文档");//备注
            FileOutputStream out =new FileOutputStream(filePath);
            workbook.write(out);//保存Excel文件
            out.close();//关闭文件流
            System.out.println("OK!");
        }


}
