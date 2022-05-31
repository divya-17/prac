package LLD.ingestionFramework;

public class SourceDataFromAPI implements IngestToDatabase {

    @Override
    public void ingestData() {
        System.out.println("STORAGE: read from API and ingest");
    }
}
