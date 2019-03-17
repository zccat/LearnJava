//package zx.learn.excel;
//
//import com.lai.weekinvi.util.common.ExcelUtil;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//
//import java.io.ByteArrayOutputStream;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Auther: quxue
// * @Date: 2019/2/26 14:40
// * @Description:
// */
//public class a {
//
////    public ByteArrayOutputStream test() throws Exception
////    {
////        //组合标题
////        String[] rowName = new String[10 + theoryHours.length + experimentHours.length + 1];
////        rowName[0] = "序号";
////        List<Object[]> dataList = new ArrayList<Object[]>();
////        Object[] objs = null;
////        for(int i = 0; i < performances.size(); i++){
////            objs = new Object[rowName.length];
////            objs[0] = i;
////            objs[1] = object.getTeacherId();
////            objs[2] = object.getTeacherName();
////            objs[3] = object.getDepartmentName();
////            dataList.add(objs);
////        }
////
////        Map<Integer,int[]> rowMergeList = new HashMap<>();//横向合并的集合
////        Map<Integer,int[]> cellMergeList = new HashMap<>();//纵向合并的集合
////        int titleHeight = 2;
////        //第一行
////        int[] list0 = {4,theoryHours.length+3,theoryHours.length+5,theoryHours.length + experimentHours.length + 4};
////        int[] list1 = {5,theoryHours.length+3,theoryHours.length+5,theoryHours.length + experimentHours.length + 4};
////        int[] cell0 = {0,2};
////        int[] cell1 = {0,1};
////        List<String[]> mergeTitles = new ArrayList<>();
////        String[] mergeTitle0 = {"序号","工号","姓名","单位","理论(节)","","","","","","","学做一体","实验(节)","","课酬标准","课时费","月平均课时费","其他补贴","扣罚","实发金额"};
////        String[] mergeTitle1 = {"序号","工号","姓名","单位","单班","合班系数","","","","","","学做一体","实验系数","","课酬标准","课时费","月平均课时费","其他补贴","扣罚","实发金额"};
////
////        mergeTitles.add(mergeTitle0);
////        mergeTitles.add(mergeTitle1);
////        rowMergeList.put(0,list0);
////        rowMergeList.put(1,list1);
////        cellMergeList.put(0,cell0);
////        cellMergeList.put(1,cell0);
////        cellMergeList.put(2,cell0);
////        cellMergeList.put(3,cell0);
////        cellMergeList.put(theoryHours.length+4,cell1);
////        cellMergeList.put(theoryHours.length + experimentHours.length + 5,cell0);
////        cellMergeList.put(theoryHours.length + experimentHours.length + 6,cell0);
////        cellMergeList.put(theoryHours.length + experimentHours.length + 7,cell0);
////        cellMergeList.put(theoryHours.length + experimentHours.length + 8,cell0);
////        cellMergeList.put(theoryHours.length + experimentHours.length + 9,cell0);
////        cellMergeList.put(theoryHours.length + experimentHours.length + 10,cell0);
////        ExcelUtil excelUtil = new ExcelUtil("浮动绩效",rowName,dataList,rowMergeList,cellMergeList,titleHeight,mergeTitles);
////        HSSFWorkbook workbook = excelUtil.export();
////        OutputStream outputStream = new ByteArrayOutputStream();
////        workbook.write(outputStream);
////
////        //输出流到浏览器
////        baos = (ByteArrayOutputStream) outputStream;
////        this.close(outputStream);
////        return baos;
////
////    }
//
//    //private String title;//导出表的标题
//
////    private List<Object[]> dataList = new ArrayList<>();
////    private Map<Integer,int[]> rowMergeList;//横向合并的集合
////    private Map<Integer,int[]> cellMergeList;//纵向合并的集合
////    private List<String[]> mergeTitles;//合并后的标题
////    private int titleHeight;//标题栏高度(除了最底层标题)
//
//    public HSSFWorkbook testCreateExcel() throws Exception {
//        String title = "测试使用ExcelUtil";
//        String[] rowName = {"序号","系部","工号","姓名"};//导出表的列名
//        List<Object[]> dataList = new ArrayList<>();
//        for(int i =0;i<10;i++)
//        {
//            Object[] objectList = {i,"系部名称"+i,162500+i,"张"+i};
//            dataList.add(objectList);
//        }
//        Map<Integer,int[]> rowMergeList = new HashMap<>();
//        Map<Integer,int[]> cellMergeList = new HashMap<>();
//        List<String[]> mergeTitles = new ArrayList<>();
//        ExcelUtil excelUtil = new ExcelUtil(title,rowName,dataList,rowMergeList,cellMergeList,0,mergeTitles);
//        return  excelUtil.export();
//    }
//
//    public static void main(String[] args) throws Exception {
//        a aa = new a();
//        HSSFWorkbook workbook = aa.testCreateExcel();
//        String filePath="d:\\sample.xls";//文件路径
//        FileOutputStream out =new FileOutputStream(filePath);
//        workbook.write(out);//保存Excel文件
//        out.close();//关闭文件流
//        System.out.println("OK!");
//    }
//
//}
