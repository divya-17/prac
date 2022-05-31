package LLD.ingestionFramework;

public class CloudSourceDataFromFile implements IngestToDatabase {

    @Override
    public void ingestData() {

        System.out.println("CLOUD: pull data from file and ingest to cloud");
    }
}
