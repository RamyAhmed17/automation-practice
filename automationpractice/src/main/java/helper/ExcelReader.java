package helper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import utilities.ExcelManager;
import java.util.*;
public class ExcelReader {
    private final Sheet sheet;
    private final int rowSize;
    private final int columnSize;
    private final Set<Integer> generatedIndexes = new HashSet<>();
    public ExcelReader(String fileName, String sheetName) {
        sheet = ExcelManager.getInstance("C:\\Users\\W10 21H2\\IdeaProjects\\automationpracticevois\\src\\test\\java\\data\\" + fileName, sheetName).getSheet();
        rowSize = sheet.getPhysicalNumberOfRows();
        columnSize = sheet.getRow(0).getLastCellNum();
    }

    public Object[][] getData() {
        var data = new Object[rowSize - 1][columnSize];
        for (int rowIndex = 1; rowIndex < rowSize; rowIndex++) {
            Row currentRow = sheet.getRow(rowIndex);
            for (int columnIndex = 0; columnIndex < columnSize; columnIndex++) {
                data[rowIndex - 1][columnIndex] = currentRow.getCell(columnIndex).toString();
            }
        }
        return data;
    }
    public Map<String, Object> getRow(int rowIndex) {
        if (rowIndex >= rowSize) {

        }
        var data = new HashMap<String, Object>();
        var headerRow = sheet.getRow(0);

        for (int columnIndex = 0; columnIndex < columnSize; columnIndex++) {
            data.put(headerRow.getCell(columnIndex).toString(), sheet.getRow(rowIndex).getCell(columnIndex).toString());
        }
        return data;
    }

    public Map<String, Object> getFirstRow() {
        return getRow(1);
    }
    public Map<String, Object> getRandomRow() {
        return getRow(generateRandomIndex());
    }
    private int generateRandomIndex() {
        var limit = rowSize - 1;
        var randomIndex = new Random().nextInt(limit) + 1;
        var isAdded = generatedIndexes.add(randomIndex);
        if (isAdded) {
            return randomIndex;
        } else {
            if (generatedIndexes.size() == limit) {

                generatedIndexes.clear();
            }
            return generateRandomIndex();
        }
    }
}