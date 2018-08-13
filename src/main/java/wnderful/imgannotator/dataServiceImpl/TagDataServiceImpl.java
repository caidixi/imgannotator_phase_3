package wnderful.imgannotator.dataServiceImpl;

import org.springframework.stereotype.Service;
import wnderful.imgannotator.dao.entity.Task;
import wnderful.imgannotator.dataService.TagDataService;
import wnderful.imgannotator.vo.baseVo.TagsVo;

@Service
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

    public void saveTaskTags(Task task,String[] tags){

    }

    public String[] findTaskTag(String taskname){
        return null;
    }

    public Task[] findTagTask(String tag){
        return null;
    };
}
