package lab9Package;

import java.io.FileNotFoundException;

public class FileFormatException extends Exception {
	private static final long serialVersionUID = 1L;
	protected int lineNumber;
	protected String info;
	protected String fileName;

	public FileFormatException(String fileName, int lineNumber, String info) {
		this.fileName = fileName;
		this.info = info;
		this.lineNumber = lineNumber;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public String getInfo() {
		return info;
	}
	public String getFileName() {
		return fileName;
	}

	public static void main(String[] args) throws Exception {
        CovidData covidData = new CovidData();

        try {
            covidData.readFromFile("src\\lab9Package\\ecdc_covid19_cases.csv");
        } 
        catch (FileFormatException e) {
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
        System.out.println("Total number of Covid cases: "+covidData.getTotalCases());
        System.out.println("Total number of Covid cases in Europe: "+covidData.getTotalCases("Europe"));
        System.out.println("Total number of Covid cases in Africa: "+covidData.getTotalCases("Africa"));
        System.out.println("Total number of Covid cases in Europe in 3rd week: "+covidData.getTotalCases("Europe",3));
        System.out.println("Total number of Covid cases in 7th week: "+covidData.getTotalCases(7));
        
        System.out.println("Total number of Deaths: "+covidData.getTotalDeaths());
        System.out.println("Total number of Deaths in 4th week: "+covidData.getTotalDeaths(4));
        System.out.println("Total number of Deaths in Europe: "+covidData.getTotalDeaths("Europe"));
        System.out.println("Total number of Deaths in Europe in 3rd week: "+covidData.getTotalDeaths("Europe",3));
        System.out.println(covidData.getCounter());
    }
}