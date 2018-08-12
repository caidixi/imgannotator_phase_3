package wnderful.imgannotator.dataService;

import wnderful.imgannotator.vo.baseVo.TagsVo;

public interface TagDataService {
    boolean tagExist(String tag);

    boolean addTag(String tag);

    boolean deleteTag(String tag);

    TagsVo findAllTags();
}
