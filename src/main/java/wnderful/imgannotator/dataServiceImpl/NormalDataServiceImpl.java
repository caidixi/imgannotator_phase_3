package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dao.daoService.*;
import wnderful.imgannotator.dataService.NormalDataService;
import wnderful.imgannotator.util.FileHelper;

public class NormalDataServiceImpl implements NormalDataService {
    private final FileHelper fileHelper = new FileHelper();

    @Override
    public  boolean deleteAll() {
        return true;
    }
}
