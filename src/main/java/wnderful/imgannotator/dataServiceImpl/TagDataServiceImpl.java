package wnderful.imgannotator.dataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wnderful.imgannotator.dao.entity.Tag;
import wnderful.imgannotator.dao.entity.Task;
import wnderful.imgannotator.dao.repository.TagRepository;
import wnderful.imgannotator.dao.repository.TaskRepository;
import wnderful.imgannotator.dataService.TagDataService;
import wnderful.imgannotator.vo.baseVo.TagsVo;

@Service
public class TagDataServiceImpl implements TagDataService {
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TaskRepository taskRepository;
    private String defaultTaksName = "default";

    @Override
    public boolean tagExist(String content) {
        return tagRepository.findTagByContentAndTaskName(content,defaultTaksName) != null;
    }

    @Override
    public boolean addTag(String content) {
        Task task = taskRepository.findTaskByNameAndIsDraft(defaultTaksName,1);
        assert (task == null);
        tagRepository.save(new Tag(content,task));
        return true;
    }

    @Override
    public boolean deleteTag(String content) {
        tagRepository.deleteTagByContent(content);
        return true;
    }

    @Override
    public TagsVo findAllTags() {
        Tag[] tags = tagRepository.findTagByTaskName(defaultTaksName);
        if (tags != null) {
            String[] contents = new String[tags.length];
            for(int i = 0;i < tags.length;i++){
                contents[i] = tags[i].getContent();
            }
            return new TagsVo(contents);
        }else {
            return null;
        }
    }

    void saveTaskTags(Task task, String[] contents) {
        if(task!=null){
            tagRepository.deleteTagByTaskName(task.getName());
            if(contents!=null&&contents.length>0){
                for(String content:contents){
                    if(tagExist(content)){
                        tagRepository.save(new Tag(content,task));
                    }
                }
            }
        }
    }

    String[] findTaskTag(String taskname) {
        Tag[] tags = tagRepository.findTagByTaskName(taskname);
        if (tags != null) {
            String[] contents = new String[tags.length];
            for(int i = 0;i < tags.length;i++){
                contents[i] = tags[i].getContent();
            }
            return contents;
        }else {
            return null;
        }
    }

    Task[] findTagTask(String content) {
        Tag[] tags = tagRepository.findTagByContent(content);
        if(tags!=null&&tags.length>1){
            Task[] tasks = new Task[tags.length-1];
            for(int i = 0;i < tags.length;i++){
                if(tags[i].getTask()!=null){
                    tasks[i] = tags[i].getTask();
                }
            }
            return tasks;
        }else {
            return null;
        }
    }
}
