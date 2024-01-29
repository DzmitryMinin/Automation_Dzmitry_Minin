package homework12;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.HomePage;
import pageObjects.herokuapp.SortableDataTablesPage;

import java.util.List;

public class SortableDataTablesTest extends BaseTest {

    @Test
    public void getTableHeadersTest() {
        SortableDataTablesPage tablesPage = new SortableDataTablesPage();
        List<String> headers = tablesPage.getTableHeaders(1);
        System.out.println(headers);
        List<String> row = tablesPage.getTableRowData(1, 1);
        System.out.println(row);
    }
}
