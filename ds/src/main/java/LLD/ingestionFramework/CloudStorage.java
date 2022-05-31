package LLD.ingestionFramework;

public class CloudStorage extends IngestionService {

    @Override
    public IngestToDatabase getInstanceOfSource(String source) {
        if(source.equals("API")) return new CloudSourceDataFromAPI();
        else if(source.equals("FILE")) return new CloudSourceDataFromFile();
        return null;
    }
}
