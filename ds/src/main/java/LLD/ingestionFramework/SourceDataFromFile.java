package LLD.ingestionFramework;

public class SourceDataFromFile implements IngestToDatabase {

    @Override
    public void ingestData() {

        System.out.println("STORAGE: Read from file and ingest data");
    }
}
