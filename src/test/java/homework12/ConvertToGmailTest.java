package homework12;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.SortableDataTablesPage;

import java.util.List;

public class ConvertToGmailTest extends BaseTest {

    @Test
    public void getAndConvertEmailsTest() {
        SortableDataTablesPage tablesPage = new SortableDataTablesPage();
        List<String> emails = tablesPage.getTableEmailsData(1);
        System.out.println(emails);
        List<String> gmail = tablesPage.convertToGmail(1);
        System.out.println(gmail);
    }
}
