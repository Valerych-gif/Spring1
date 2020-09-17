import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelParser {
    public static final String COMPANY_INDICATORS_FILE = "CompanyIndicators.xlsx";
    public static final int COMPANY = 0;
    public static final int DO = 1;
    public static final int PROGNOZ = 2;
    public static final int FACT = 3;

    private static List<CompanyRow> companyRows;

    public static void main(String[] args) throws Exception {
        Workbook workbook = WorkbookFactory.create(new File(COMPANY_INDICATORS_FILE));

        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.rowIterator();
        companyRows = new ArrayList<>();
        String prevCompanyName = "";
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String companyName = row.getCell(COMPANY).getStringCellValue();
            String daughterCompanyName = row.getCell(DO).getStringCellValue();
            double daughterCompanyForecast = row.getCell(PROGNOZ).getNumericCellValue();
            double daughterCompanyResult = row.getCell(FACT).getNumericCellValue();
            if (companyName.equals("")){
                companyName = prevCompanyName;
            } else {
                prevCompanyName = companyName;
            }
            companyRows.add(new CompanyRow(companyName, daughterCompanyName, daughterCompanyForecast, daughterCompanyResult));
        }

        System.out.println("Среднее значение эффективности компаний, входящих в Oracle: " + getAverageEffectivityForMainCompany("Oracle") * 100 + "%");
        System.out.println("Среднее значение эффективности компаний, входящих в JB: " + getAverageEffectivityForMainCompany("JB") * 100 + "%");
        System.out.println("Эффективность компании IDEA: " + getAverageEffectivityForDaughterCompany("IDEA") * 100 + "%");
        System.out.println("Эффективность компании OpenJDK: " + getAverageEffectivityForDaughterCompany("OpenJdk") * 100 + "%");
    }

    private static double getAverageEffectivityForMainCompany(String companyName){
        Iterator<CompanyRow> iterator = companyRows.iterator();
        double companyEffectivity = 0;
        int companyCount = 0;
        while (iterator.hasNext()){
            CompanyRow companyRow = iterator.next();
            if (companyRow.getCompanyName().equals(companyName)){
                companyEffectivity += (companyRow.getDaughterCompanyResult()/companyRow.getDaughterCompanyForecast());
                companyCount++;
            }
        }
        return companyEffectivity /= companyCount;
    }

    private static double getAverageEffectivityForDaughterCompany(String companyName){
        Iterator<CompanyRow> iterator = companyRows.iterator();
        double companyEffectivity = 0;
        while (iterator.hasNext()){
            CompanyRow companyRow = iterator.next();
            if (companyRow.getDaughterCompanyName().equals(companyName)){
                companyEffectivity = (companyRow.getDaughterCompanyResult()/companyRow.getDaughterCompanyForecast());
            }
        }
        return companyEffectivity;
    }
}
