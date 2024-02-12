package homework12;

import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.SortableDataTablesPage;

import java.util.List;

@Log4j
public class ConvertToGmailTest extends BaseTest {

    @Test
    public void getAndConvertEmailsTest() {
        SortableDataTablesPage tablesPage = new SortableDataTablesPage();
        List<String> emails = tablesPage.getTableEmailsData(1);
        log.info(emails);
        List<String> gmail = tablesPage.convertToGmail(1);
        log.info(gmail);
    }
}
