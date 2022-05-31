package LLD.ingestionFramework;

public class SourceFromDatabase implements IngestToDatabase {

    @Override
    public void ingestData() {

        System.out.println("STORAGE: Read from other databases and ingest !");
    }
}
