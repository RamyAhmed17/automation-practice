package utilities;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

  public class ExcelManager {
    private static ExcelManager instance = null;
    private static final Set<String> loadedSheets = new HashSet<>();
    private final String filePath;
    private final String sheetName;
    private Sheet sheet;
    private ExcelManager(String filePath, String sheetName) {
        this.filePath = filePath;
        this.sheetName = sheetName;
        loadExcelSheet();
    }
    public static ExcelManager getInstance(String filePath, String sheetName) {
        if (instance == null || !loadedSheets.contains(filePath + sheetName)) {
            loadedSheets.add(filePath + sheetName);
            instance = new ExcelManager(filePath, sheetName);
        }
        return instance;
    }

    private void loadExcelSheet() {
        try (FileInputStream inputStream = new FileInputStream(
                filePath + ".xlsx");
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public Sheet getSheet() {
        return sheet;
    }}