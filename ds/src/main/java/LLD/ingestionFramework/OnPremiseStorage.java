package LLD.ingestionFramework;

public class OnPremiseStorage extends IngestionService {

    @Override
    public IngestToDatabase getInstanceOfSource(String source) {

        if(source.equals("API")) return new SourceDataFromAPI();
        else if(source.equals("FILE")) return new SourceDataFromFile();
        else if(source.equals("DATALAKE")) return new SourceDataFromDataLake();
        else if(source.equals("DATABASE")) return new SourceFromDatabase();
        return null;
    }
}
