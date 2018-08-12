package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dataService.TagDataService;
import wnderful.imgannotator.vo.baseVo.TagsVo;

public class TagDataServiceImpl implements TagDataService {
    @Override
    public boolean tagExist(String tag) {
        return false;
    }

    @Override
    public boolean addTag(String tag) {
        return false;
    }

    @Override
    public boolean deleteTag(String tag) {
        return false;
    }

    @Override
    public TagsVo findAllTags() {
        return null;
    }
}
