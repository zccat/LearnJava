//package zx.learn.pdf;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.PdfWriter;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//
///**
// * @Auther: 胡志新
// * @Date: 2019/3/11 11:29
// * @Description:
// */
//public class testPdf {
//
//    static final String FILE_DIR = "d:\\";
//
//    public static void main(String[] args) throws DocumentException, FileNotFoundException {
//
////        //Step 1—Create a Document.
////        Document document = new Document();
////        //Step 2—Get a PdfWriter instance.
////        PdfWriter.getInstance(document, new FileOutputStream(FILE_DIR + "createSamplePDF.pdf"));
////        //Step 3—Open the Document.
////        document.open();
////        //Step 4—Add content.
////        document.add(new Paragraph("Hello World"));
////        //Step 5—Close the Document.
////        document.close();
//        //页面大小
//        Rectangle rect = new Rectangle(PageSize.B5.rotate());
//        //页面背景色
//        rect.setBackgroundColor(BaseColor.ORANGE);
//
//        Document doc = new Document(rect);
//
//        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(FILE_DIR + "createSamplePDF.pdf"));
//
////PDF版本(默认1.4)
//        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);
//
////文档属性
//        doc.addTitle("Title@sample");
//        doc.addAuthor("Author@rensanning");
//        doc.addSubject("Subject@iText sample");
//        doc.addKeywords("Keywords@iText");
//        doc.addCreator("Creator@iText");
//
////页边空白
//        doc.setMargins(10, 20, 30, 40);
//
//        doc.open();
//        doc.add(new Paragraph("First page"));
//        doc.add(new Paragraph(doc.getPageSize().toString()));
//
//        doc.newPage();
//        writer.setPageEmpty(false);
//
//        doc.newPage();
//        doc.add(new Paragraph("New page"));
//        doc.add(new Paragraph("Hello World"));
//        doc.close();
//    }
//
//}
