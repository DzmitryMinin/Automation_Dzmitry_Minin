package homework12;

import lombok.extern.log4j.Log4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.HomePage;
import pageObjects.herokuapp.SortableDataTablesPage;

import java.util.List;

@Log4j
public class SortableDataTablesTest extends BaseTest {

    @Test
    public void getTableHeadersTest() {
        SortableDataTablesPage tablesPage = new SortableDataTablesPage();
        List<String> headers = tablesPage.getTableHeaders(1);
        log.info(headers);
        List<String> row = tablesPage.getTableRowData(1, 1);
        log.info(row);
    }
}
