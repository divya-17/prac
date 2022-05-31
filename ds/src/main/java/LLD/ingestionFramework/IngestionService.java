package LLD.ingestionFramework;

public abstract class IngestionService {

    public void ingestFromSource(String source){

        IngestToDatabase instanceOfSource = getInstanceOfSource(source);
        instanceOfSource.ingestData();

    }

    public abstract IngestToDatabase getInstanceOfSource(String source);

}
