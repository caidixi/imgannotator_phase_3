package wnderful.imgannotator.dataServiceImpl;

import org.springframework.stereotype.Service;
import wnderful.imgannotator.dataService.NormalDataService;
import wnderful.imgannotator.util.FileHelper;

@Service
public class NormalDataServiceImpl implements NormalDataService {
    private final FileHelper fileHelper = new FileHelper();

    @Override
    public  boolean deleteAll() {
        return true;
    }
}
