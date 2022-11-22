package src.test_data.utils;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataObjectBuilder {
    public static  <T> T buildDataObject(String fileLocation, Class<T> dataType){
        T returnData = null;

        String absoluteFilePath = System.getProperty("user.dir").concat(fileLocation);
        try (
                Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath));){
            Gson gson = new Gson();
            returnData = gson.fromJson(reader,dataType );
        }
        catch (NoSuchFileException noSuchFileException){
            throw new RuntimeException("[ERR] Could not found the file" .concat(absoluteFilePath));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if (returnData == null){
            throw new RuntimeException("[ERR] Return Data is null");
        }

        return returnData;
    }
}
