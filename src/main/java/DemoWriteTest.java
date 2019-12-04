import com.excel.utils.ExcelDataVO;
import com.excel.utils.ExcelWriter;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author shkstart
 * @create 2019-12-02 23:00
 */
public class DemoWriteTest {
    private static Logger logger = Logger.getLogger(DemoWriteTest.class.getName());

    public static void main(String[] args) {
        // 创建需要写入的数据列表
        List<ExcelDataVO> dataVOList = new ArrayList<ExcelDataVO>(2);
        ExcelDataVO dataVO = new ExcelDataVO();
        dataVO.setName("小明");
        dataVO.setAge(18);
        dataVO.setLocation("广州");
        dataVO.setJob("大学生");
        ExcelDataVO dataVO2 = new ExcelDataVO();
        dataVO2.setName("小花");
        dataVO2.setAge(19);
        dataVO2.setLocation("深圳");
        dataVO2.setJob("大学生");
        dataVOList.add(dataVO);
        dataVOList.add(dataVO2);

        // 写入数据到工作簿对象内
        Workbook workbook = ExcelWriter.exportData(dataVOList);

        // 以文件的形式输出工作簿对象
        FileOutputStream fileOut = null;
        try {
            String exportFilePath = "/Users/Dreamer-1/Desktop/myBlog/java解析Excel/writeExample.xlsx";
            File exportFile = new File(exportFilePath);
            if (!exportFile.exists()) {
                exportFile.createNewFile();
            }

            fileOut = new FileOutputStream(exportFilePath);
            workbook.write(fileOut);
            fileOut.flush();
        } catch (Exception e) {
            logger.warning("输出Excel时发生错误，错误原因：" + e.getMessage());
        } finally {
            try {
                if (null != fileOut) {
                    fileOut.close();
                }
                if (null != workbook) {
                    workbook.close();
                }
            } catch (IOException e) {
                logger.warning("关闭输出流时发生错误，错误原因：" + e.getMessage());
            }
        }
    }
}
