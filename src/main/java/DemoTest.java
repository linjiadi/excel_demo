import com.excel.utils.ExcelDataVO;
import com.excel.utils.ExcelReader;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-12-02 22:49
 */
public class DemoTest {
    public static void main(String[] args) {
        // 设定Excel文件所在路径
        String excelFileName = "C:/Users/hasee/Desktop/11.xlsx";
        // 读取Excel文件内容
        List<ExcelDataVO> readResult = ExcelReader.readExcel(excelFileName);

        System.out.println(readResult);

        // todo 进行业务操作
    }
}
